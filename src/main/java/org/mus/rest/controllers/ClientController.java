package org.mus.rest.controllers;

import org.mus.rest.dto.ClientDto;
import org.mus.rest.exception.del.ItemFKException;
import org.mus.rest.exception.not.found.ItemNotFoundException;
import org.mus.rest.models.Client;
import org.mus.rest.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@Valid @RequestBody final Client client) {
        clientService.addClient(client);
        LOGGER.info("Added new client");
        return new ResponseEntity<ClientDto>(new ClientDto(client), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientDto> updateClient(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Client client) {

        if (clientService.getClientById(id) == null) {
            LOGGER.error("Can't put(updateClient) an client with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateClient) an client with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated client with id: " + id);
        client.setId(id);
        clientService.updateClient(client);
        return new ResponseEntity<ClientDto>(new ClientDto(client), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        LOGGER.info("Gave away all Clients");
        List<Client> clients = clientService.getClients();
        List<ClientDto> clientsDto = new ArrayList<>();
        for (Client client:clients) {
            ClientDto clientDto = new ClientDto(client);
            clientsDto.add(clientDto);
        }
        return new ResponseEntity<List<ClientDto>>(clientsDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable(name = "id") final Integer id) {
        if (clientService.getClientById(id) == null) {
            LOGGER.error("Can't get(getClient) an client with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getClient) an client with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an client with id: " + id);
        Client client = clientService.getClientById(id);
        return new ResponseEntity<ClientDto>(new ClientDto(client), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Client> deleteClientById(@PathVariable("id") final Integer id) {
        if (clientService.getClientById(id) == null) {
            LOGGER.error("Can't delete(deleteClientById) an client with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteClientById) an client with non-existing id: " + id);
        }
        try {
            clientService.deleteClientById(id);
        } catch (Exception e){
            if (e.getClass().equals(DataIntegrityViolationException.class)){
                throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
            }
            System.out.println("Unknown error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        LOGGER.info("Successfully deleted client with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
