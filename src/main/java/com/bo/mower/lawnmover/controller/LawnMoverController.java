package com.bo.mower.lawnmover.controller;

import com.bo.mower.lawnmover.exceptions.BadFormatInputDataException;
import com.bo.mower.lawnmover.exceptions.EntityNotFoundException;
import com.bo.mower.lawnmover.exceptions.MissingDataException;
import com.bo.mower.lawnmover.services.DataService;
import com.bo.mower.lawnmover.services.InstructionService;
import com.bo.mower.lawnmover.services.MoverService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/mover")
@Api(value = "Lawn Mover Controller")
public class LawnMoverController {
    @Autowired
    private DataService dataService;

    @Autowired
    private MoverService moverService;

    @Autowired
    private InstructionService instructionService;


    @GetMapping("/launch")
    public ResponseEntity<String> launch() {
        try {
            String inputData = dataService.getDataFromFile("data.txt");
            return ResponseEntity.ok().body(moverService.launch(inputData));
        } catch (EntityNotFoundException | IOException | MissingDataException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed to launch movers", ex);
        }
    }

    @GetMapping("/moverNumbers")
    public ResponseEntity<Integer> getMoverNumber() {
        try {
            String inputData = dataService.getDataFromFile("data.txt");
            return ResponseEntity.ok().body(instructionService.getMoverNumber(inputData));
        } catch (EntityNotFoundException | IOException | BadFormatInputDataException | MissingDataException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mover numbers not found", ex);
        }
    }

    @GetMapping("/lawnInfo")
    public ResponseEntity<String> getLawnInfo() {
        try {
            String inputData = dataService.getDataFromFile("data.txt");
            return ResponseEntity.ok().body(instructionService.getLawnInfo(inputData));
        } catch (EntityNotFoundException | IOException | BadFormatInputDataException | MissingDataException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lawn info not found", ex);
        }
    }
}
