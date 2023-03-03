package model;

import org.springframework.data.repository.CrudRepository;

import ch.qos.logback.core.net.server.Client;
import service.impl.ClientServiceImpl;

public interface AddressRepository extends CrudRepository<Address, String> {

	default void saveClientWithCep(ClientServiceImpl clientServiceImpl, Client client) {
		String cep = ((model.Client) client).getAddress().getCep();
		Address address = findById(cep).orElseGet(() -> {
			Address newAddress = clientServiceImpl.viaCepService.consltCep(cep);
			save(newAddress);
			return newAddress;
		});
		((model.Client) client).setAddress(address);
		clientServiceImpl.clientRepository.save(client);
	}

}
