package model;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long>{

	void save(ch.qos.logback.core.net.server.Client client);

	
}
