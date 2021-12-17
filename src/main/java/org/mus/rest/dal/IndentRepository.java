package org.mus.rest.dal;

import org.mus.rest.models.Indent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndentRepository extends JpaRepository<Indent,Integer> {
}
