package pl.idzi.app.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.idzi.app.controller.dto.CreateScoutRequest;
import pl.idzi.app.controller.dto.ScoutResponse;
import pl.idzi.app.model.scout.Scout;
import pl.idzi.app.service.ScoutService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/scout")
public class ScoutController {
    private ScoutService scoutService;
    private ModelMapper modelMapper;

    @Autowired
    public ScoutController(ScoutService scoutService, ModelMapper modelMapper) {
        this.scoutService = scoutService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ScoutResponse>> getAllScouts() {
        List<Scout> scouts = scoutService.findAllScouts();
        List<ScoutResponse> scoutResponses = scouts.stream()
                .map(scout -> modelMapper.map(scout, ScoutResponse.class))
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(scoutResponses);
    }

    @PostMapping("/create")
    public ResponseEntity<ScoutResponse> createScout(@Valid @RequestBody CreateScoutRequest createScoutRequest) {
        Scout scout = modelMapper.map(createScoutRequest, Scout.class);
        Scout newScout = scoutService.createScout(scout);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(newScout, ScoutResponse.class));
    }
}
