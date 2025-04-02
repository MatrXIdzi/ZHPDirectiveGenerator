package pl.idzi.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.idzi.app.model.scout.Scout;
import pl.idzi.app.repository.ScoutRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ScoutService {
    private final ScoutRepository scoutRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ScoutService(ScoutRepository scoutRepository, ModelMapper modelMapper) {
        this.scoutRepository = scoutRepository;
        this.modelMapper = modelMapper;
    }

    public List<Scout> findAllScouts() {
        return scoutRepository.findAll();
    }

    public Scout findScoutById(UUID id) {
        Scout scout = scoutRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Scout with ID " + id + " not found"));
        return modelMapper.map(scout, Scout.class);
    }

    public Scout createScout(Scout scout) {
        return scoutRepository.save(scout);
    }

    public Scout updateScout(Scout scout) {
        Scout foundScout = scoutRepository.findById(scout.getId()).orElseThrow(() -> new IllegalArgumentException("Scout with ID " + scout.getId() + " not found"));
        modelMapper.map(scout, foundScout);

        return scoutRepository.save(foundScout);
    }

    public void deleteScout(UUID id) {
        scoutRepository.deleteById(id);
    }

    public List<Scout> findScoutsByFirstname(String firstname) {
        return scoutRepository.findAllByFirstname(firstname);
    }

    public List<Scout> findScoutsBySurname(String surname) {
        return scoutRepository.findAllBySurname(surname);
    }
}
