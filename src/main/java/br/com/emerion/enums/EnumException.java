package br.com.emerion.enums;

import org.springframework.http.HttpStatus;

public enum EnumException {

	UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error found."),
	FORBIDDEN(HttpStatus.FORBIDDEN, "Operação não permitida."),
	ITEM_CREATED(HttpStatus.CREATED, "Item inserido com sucesso."),
	COMPANY_NOT_FOUND(HttpStatus.FORBIDDEN, "Instituição não informada."),
	
	VERSION_FIELD_NOT_INFORMED(HttpStatus.FORBIDDEN, "Versão não informada"),
	UUID_FIELD_NOT_INFORMED(HttpStatus.FORBIDDEN, "Campo \"application\" não informado"),
	UUID_MALFORMED(HttpStatus.FORBIDDEN, "Campo \"application\" informado incorretamente"),
	VERSION_TYPE_FIELD_NOT_INFORMED(HttpStatus.FORBIDDEN, "Campo \"tipo_versao\" não informado"),
	VERSION_TYPE_NOT_VALID(HttpStatus.FORBIDDEN, "Tipo de versão informada não é valido"),
	EXCEPTION_SEVERITY(HttpStatus.FORBIDDEN, "Gravidade da exceção informada não é valido"),
	STACKTRACE_FIELD_NOT_INFORMED(HttpStatus.FORBIDDEN, "Campo \"stack_trace\" não informado"),
	MESSAGE_FIELD_NOT_INFORMED(HttpStatus.FORBIDDEN, "Campo \"message\" não informado"),
	USER_NAME_FIELD_NOT_INFORMED(HttpStatus.FORBIDDEN, "Campo \"user_name\" não informado");

	private HttpStatus httpStatus;
	private String description;

	EnumException(HttpStatus httpStatus, String description) {
		this.httpStatus = httpStatus;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
