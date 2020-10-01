package br.com.emerion.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.emerion.model.SessionInfo;

public interface SessionInfoRepository extends CrudRepository<SessionInfo, Integer> {

	List<SessionInfo> getByUsuario(String usuario);

	List<SessionInfo> getByUuidJanela(UUID uuidJanela);

	List<SessionInfo> getByIp(String ip);
}
