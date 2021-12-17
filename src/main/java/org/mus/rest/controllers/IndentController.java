package org.mus.rest.controllers;

import org.mus.rest.dto.IndentDto;
import org.mus.rest.exception.del.ItemFKException;
import org.mus.rest.exception.not.found.ItemNotFoundException;
import org.mus.rest.models.Indent;
import org.mus.rest.service.IndentService;
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
@RequestMapping(path = "/indent")
public class IndentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndentController.class);

    @Autowired
    private IndentService indentService;

    @PostMapping
    public ResponseEntity<IndentDto> createIndent(@Valid @RequestBody final Indent indent) {
        LOGGER.info("Added new indent");
        return new ResponseEntity<IndentDto>(new IndentDto(indentService.addIndent(indent)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<IndentDto> updateIndent(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Indent indent) {

        if (indentService.getIndentById(id) == null) {
            LOGGER.error("Can't put(updateIndent) an Indent with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateIndent) an Indent with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Indent with id: " + id);
        indent.setId(id);
        return new ResponseEntity<IndentDto>(new IndentDto(indentService.updateIndent(indent)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<IndentDto>> getIndents() {
        LOGGER.info("Gave away all Indents");
        List<Indent> indents = indentService.getIndents();
        List<IndentDto> indentDtos = new ArrayList<>();
        for (Indent indent:indents) {
            indentDtos.add(new IndentDto(indent));
        }
        return new ResponseEntity<List<IndentDto>>(indentDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<IndentDto> getIndent(@PathVariable(name = "id") final Integer id) {
        if (indentService.getIndentById(id) == null) {
            LOGGER.error("Can't get(getIndent) an Indent with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getIndent) an Indent with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an client with id: " + id);
        return new ResponseEntity<IndentDto>(new IndentDto(indentService.getIndentById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Indent> deleteIndentById(@PathVariable("id") final Integer id) {
        if (indentService.getIndentById(id) == null) {
            LOGGER.error("Can't delete(deleteIndentById) an Indent with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteIndentById) an Indent with non-existing id: " + id);
        }
        try {
            indentService.deleteIndentById(id);
        } catch (Exception e){
            if (e.getClass().equals(DataIntegrityViolationException.class)){
                throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
            }
            System.out.println("Unknown error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        LOGGER.info("Successfully deleted Indent with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
