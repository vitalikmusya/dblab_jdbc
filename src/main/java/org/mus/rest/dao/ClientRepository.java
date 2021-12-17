package org.mus.rest.dao;

import org.mus.rest.models.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

}