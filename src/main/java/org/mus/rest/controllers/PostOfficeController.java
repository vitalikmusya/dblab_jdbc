package org.mus.rest.controllers;

import org.mus.rest.dto.PostOfficeDto;
import org.mus.rest.exception.del.ItemFKException;
import org.mus.rest.exception.not.found.ItemNotFoundException;
import org.mus.rest.models.PostOffice;
import org.mus.rest.service.PostOfficeService;
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
@RequestMapping(path = "/postoffice")
public class PostOfficeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostOfficeController.class);

    @Autowired
    private PostOfficeService postOfficeService;

    @PostMapping
    public ResponseEntity<PostOfficeDto> createPostOffice(@Valid @RequestBody final PostOffice postOffice) {
        LOGGER.info("Added new postOffice");
        return new ResponseEntity<PostOfficeDto>(new PostOfficeDto(postOfficeService.addPostOffice(postOffice)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PostOfficeDto> updatePostOffice(
            @PathVariable("id") final int id,
            @Valid @RequestBody final PostOffice postOffice) {

        if (postOfficeService.getPostOfficeById(id) == null) {
            LOGGER.error("Can't put(updatePostOffice) an PostOffice with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updatePostOffice) an PostOffice with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated PostOffice with id: " + id);
        postOffice.setId(id);
        return new ResponseEntity<PostOfficeDto>(new PostOfficeDto(postOfficeService.updatePostOffice(postOffice)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostOfficeDto>> getPostOffices() {
        LOGGER.info("Gave away all PostOffice");
        List<PostOffice> postOffices = postOfficeService.getPostOffices();
        List<PostOfficeDto> postOfficeDtos = new ArrayList<>();
        for (PostOffice postOffice:postOffices) {
            postOfficeDtos.add(new PostOfficeDto(postOffice));
        }
        return new ResponseEntity<List<PostOfficeDto>>(postOfficeDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PostOfficeDto> getPostOffice(@PathVariable(name = "id") final Integer id) {
        if (postOfficeService.getPostOfficeById(id) == null) {
            LOGGER.error("Can't get(PostOffice) an PostOffice with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(PostOffice) an PostOffice with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an PostOffice with id: " + id);
        return new ResponseEntity<PostOfficeDto>(new PostOfficeDto(postOfficeService.getPostOfficeById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PostOffice> deletePostOfficeById(@PathVariable("id") final Integer id) {
        if (postOfficeService.getPostOfficeById(id) == null) {
            LOGGER.error("Can't delete(PostOffice) an PostOffice with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(PostOffice) an PostOffice with non-existing id: " + id);
        }
        try {
            postOfficeService.deletePostOfficeById(id);
        } catch (Exception e){
            if (e.getClass().equals(DataIntegrityViolationException.class)){
                throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
            }
            System.out.println("Unknown error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        LOGGER.info("Successfully deleted PostOffice with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
