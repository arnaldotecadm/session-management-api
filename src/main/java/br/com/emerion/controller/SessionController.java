package br.com.emerion.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emerion.model.SessionInfo;
import br.com.emerion.model.StringResponse;
import br.com.emerion.service.SessionInfoService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping()
public class SessionController {

	@Autowired
	private SessionInfoService service;

	@ApiOperation(value = "Recuperar todas as excecoes cadastradas no sistema.")
	@GetMapping(path = "/all")
	public List<SessionInfo> getAll() {
		return service.getAll();
	}

	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Adicionar nova excecao no sistema")
	public ResponseEntity<StringResponse> addNew(@RequestBody SessionInfo sessionInfo) throws IOException {

		if (sessionInfo != null && sessionInfo.getUuidJanela() != null) {
			this.service.save(sessionInfo);
			return new ResponseEntity<StringResponse>(new StringResponse("Registro salvo com sucesso!"), HttpStatus.OK);
		} else {
			return new ResponseEntity<StringResponse>(new StringResponse("Favor informar um objeto válido!"),
					HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping(path = "/cancelar-acesso/ip")
	@ApiOperation(value = "Adicionar nova excecao no sistema")
	public ResponseEntity<StringResponse> cancelarAcessoByIp(@RequestBody String ip) throws IOException {

		List<SessionInfo> infoList = this.service.getByIp(ip);
		
		for(SessionInfo info : infoList) {
			info.setStatus("CANCELADO");
			this.service.save(info);
		}
		
		return new ResponseEntity<StringResponse>(new StringResponse("Sessao Cancelada com sucesso!"), HttpStatus.OK);
	}
	
	@PostMapping(path = "/cancelar-acesso/uuid")
	@ApiOperation(value = "Adicionar nova excecao no sistema")
	public ResponseEntity<StringResponse> cancelarAcessoByUUID(@RequestBody UUID uuid) throws IOException {

		List<SessionInfo> infoList = this.service.getByUuidJanela(uuid);
		
		for(SessionInfo info : infoList) {
			info.setStatus("CANCELADO");
			this.service.save(info);
		}
		
		return new ResponseEntity<StringResponse>(new StringResponse("Sessao Cancelada com sucesso!"), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/remove/uuid/{uuidJanela}")
	@ApiOperation(value = "Adicionar nova excecao no sistema")
	public ResponseEntity<StringResponse> removeSessionByUUID(@PathVariable UUID uuidJanela) throws IOException {

		List<SessionInfo> byUuidJanela = this.service.getByUuidJanela(uuidJanela);
		
		for(SessionInfo info : byUuidJanela) {
			this.service.delete(info);			
		}
		return new ResponseEntity<StringResponse>(new StringResponse("Sessao excluida com sucesso!"), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/remove/usuario/{usuario}")
	@ApiOperation(value = "Adicionar nova excecao no sistema")
	public ResponseEntity<StringResponse> removeSessionByUsuario(@PathVariable String usuario) throws IOException {

		List<SessionInfo> infoList = this.service.getByUsuario(usuario);
		
		for(SessionInfo info : infoList) {
			this.service.delete(info);			
		}
		
		return new ResponseEntity<StringResponse>(new StringResponse("Sessao excluida com sucesso!"), HttpStatus.OK);
	}

	@GetMapping(path = "/filter/usuario/{usuario}")
	public List<SessionInfo> getByUsuario(@PathVariable String usuario) {
		return this.service.getByUsuario(usuario);
	}

	@GetMapping(path = "/filter/uuid/{uuidJanela}")
	public List<SessionInfo> getByUuid(@PathVariable UUID uuidJanela) {
		return this.service.getByUuidJanela(uuidJanela);
	}

	@GetMapping(path = "/filter/ip/{ip}")
	public List<SessionInfo> getByIp(@PathVariable String ip) {
		return this.service.getByIp(ip);
	}

}
