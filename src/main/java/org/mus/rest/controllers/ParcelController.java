package org.mus.rest.controllers;

import org.mus.rest.dto.ParcelDto;
import org.mus.rest.exception.del.ItemFKException;
import org.mus.rest.exception.not.found.ItemNotFoundException;
import org.mus.rest.models.Parcel;
import org.mus.rest.service.ParcelService;
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
@RequestMapping(path = "/parcel")
public class ParcelController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParcelController.class);

    @Autowired
    private ParcelService parcelService;

    @PostMapping
    public ResponseEntity<ParcelDto> createParcel(@Valid @RequestBody final Parcel parcel) {
        LOGGER.info("Added new parcel");
        return new ResponseEntity<ParcelDto>(new ParcelDto(parcelService.addParcel(parcel)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ParcelDto> updateParcel(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Parcel parcel) {

        if (parcelService.getParcelById(id) == null) {
            LOGGER.error("Can't put(updateParcel) an Parcel with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateParcel) an Parcel with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Parcel with id: " + id);
        parcel.setId(id);
        return new ResponseEntity<ParcelDto>(new ParcelDto(parcelService.updateParcel(parcel)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<ParcelDto>> getParcels() {
        LOGGER.info("Gave away all Parcels");
        List<Parcel> parcels = parcelService.getParcels();
        List<ParcelDto> parcelDtos = new ArrayList<>();
        for (Parcel parcel:parcels) {
            parcelDtos.add(new ParcelDto(parcel));
        }
        return new ResponseEntity<List<ParcelDto>>(parcelDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ParcelDto> getParcel(@PathVariable(name = "id") final Integer id) {
        if (parcelService.getParcelById(id) == null) {
            LOGGER.error("Can't get(getParcel) an Parcel with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getParcel) an Parcel with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Parcel with id: " + id);
        return new ResponseEntity<ParcelDto>(new ParcelDto(parcelService.getParcelById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Parcel> deleteParcelById(@PathVariable("id") final Integer id) {
        if (parcelService.getParcelById(id) == null) {
            LOGGER.error("Can't delete(deleteParcelById) an Parcel with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteParcelById) an Parcel with non-existing id: " + id);
        }
        try {
            parcelService.deleteParcelById(id);
        } catch (Exception e){
            if (e.getClass().equals(DataIntegrityViolationException.class)){
                throw new ItemFKException("There is some fk that are pointing at that row error code 1451 for row with id:" + id);
            }
            System.out.println("Unknown error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        LOGGER.info("Successfully deleted Parcel with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
