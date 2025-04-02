package pl.idzi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.idzi.app.model.directive.Directive;
import pl.idzi.app.repository.DirectiveRepository;

import java.util.List;

@Service
public class DirectiveService {
    private DirectiveRepository directiveRepository;

    @Autowired
    public DirectiveService(DirectiveRepository directiveRepository) {
        this.directiveRepository = directiveRepository;
    }

    public Directive createDirective(Directive directive) {
        return directiveRepository.save(directive);
    }

    public List<Directive> getDirectiveBySerialNumber(String serialNumber) {
        return directiveRepository.findAllBySerialNumber(serialNumber);
    }

    public List<Directive> getDirectiveByCity(String city) {
        return directiveRepository.findAllByCity(city);
    }

    public List<Directive> getAllDirectives() {
        return directiveRepository.findAll();
    }

    public void deleteDirective(Directive directive) {
        directiveRepository.delete(directive);
    }
}
