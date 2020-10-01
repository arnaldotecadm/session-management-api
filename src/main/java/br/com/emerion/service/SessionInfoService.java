package br.com.emerion.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emerion.model.SessionInfo;
import br.com.emerion.repository.SessionInfoRepository;

@Service
public class SessionInfoService {

	@Autowired
	private SessionInfoRepository repository;

	@Autowired
	EntityManager manager;

	public List<SessionInfo> getAll() {
		return (List<SessionInfo>) repository.findAll();
	}

	public SessionInfo save(SessionInfo entity) {
		return this.repository.save(entity);
	}

	public void delete(SessionInfo entity) {
		this.repository.delete(entity);
	}

	public List<SessionInfo> getByUsuario(String usuario) {
		return this.repository.getByUsuario(usuario);
	}

	public List<SessionInfo> getByUuidJanela(UUID uuidJanela) {
		return this.repository.getByUuidJanela(uuidJanela);
	}

	public List<SessionInfo> getByIp(String ip) {
		return this.repository.getByIp(ip);
	}

}
