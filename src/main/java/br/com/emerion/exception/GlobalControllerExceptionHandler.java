package br.com.emerion.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.emerion.model.StringResponse;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	private Log logger = LogFactory.getLog(GlobalControllerExceptionHandler.class);

	@ExceptionHandler({ ConversionFailedException.class })
	@ResponseBody
	public ResponseEntity<StringResponse> handleCustomException(ConversionFailedException ex) {
		logger.error(ex.getMessage());
		logger.error(ex);
		if (ex.getMessage().contains("No enum constant")) {
			return new ResponseEntity<>(
					new StringResponse("Valor informado para o parâmetro não compatível com o valor informado, por favor consulte a documentação para maiores detalhes."),
					HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(new StringResponse(ex.getCause().getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ValidationException.class)
	@ResponseBody
	public ResponseEntity<CustomExceptionDTO> handleCustomSimpleException(ValidationException validationException) {
		HttpStatus responseStatus = validationException.getHttpStatus();
		return new ResponseEntity<>(new CustomExceptionDTO(validationException.getDescription()), responseStatus);
	}

	@ExceptionHandler({ ServiceException.class })
	@ResponseBody
	public ResponseEntity<ServiceExceptionDTO> handleVersioningException(ServiceException ve) {
		logger.error(ve.getMessage());
		logger.error(ve);
		return new ResponseEntity<>(ve.getExceptionDTO(), ve.getHttpStatus());
	}
	
	@ExceptionHandler({ MissingServletRequestParameterException.class })
	@ResponseBody
	public ResponseEntity<?> handleMissingparameterException(MissingServletRequestParameterException ve) {
		logger.error(ve.getMessage());
		logger.error(ve);
		return new ResponseEntity<>(
				new StringResponse(String.format("O parametro '%s'(%s) não foi informado.", ve.getParameterName(), ve.getParameterType())),
				HttpStatus.BAD_REQUEST);
	}
}