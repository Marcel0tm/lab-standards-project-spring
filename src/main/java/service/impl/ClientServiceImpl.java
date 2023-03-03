package service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.core.net.server.Client;
import model.AddressRepository;
import model.ClientRepository;
import service.ClientService;
import service.ViaCepService;

public class ClientServiceImpl implements ClientService{

	@Autowired
	public ClientRepository clientRepository;
	
	@Autowired
	public AddressRepository addressRepository;
	@Autowired
	public ViaCepService viaCepService;
	
	@Override
	public Iterable<model.Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Long id) {
		java.util.Optional<model.Client> client = clientRepository.findById(id);
		return (Client) client.get();
	}

	@Override
	public void insert(Client client) {
		addressRepository.saveClientWithCep(this, client);
	}

	@Override
	public void update(Long id, Client client) {
		java.util.Optional<model.Client> clientBd = clientRepository.findById(id);
		if (clientBd.isPresent()) {
			addressRepository.saveClientWithCep(this, client);
		}
	}

	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
}
