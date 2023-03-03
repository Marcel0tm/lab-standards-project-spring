package service;

import ch.qos.logback.core.net.server.Client;

public interface ClientService {

	Iterable<model.Client> findAll();
	
	Client findById(Long id);
	
	void insert(Client client);
	
	void update(Long id, Client client);
	
	void delete(Long id);
}
