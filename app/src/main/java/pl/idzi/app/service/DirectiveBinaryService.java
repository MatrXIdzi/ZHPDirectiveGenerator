package pl.idzi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.idzi.app.model.directive.Directive;
import pl.idzi.app.model.directive.DirectiveBinary;
import pl.idzi.app.repository.DirectiveBinaryRepository;

import java.util.List;

@Service
public class DirectiveBinaryService {
    private DirectiveBinaryRepository directiveBinaryRepository;

    @Autowired
    public DirectiveBinaryService(DirectiveBinaryRepository directiveBinaryRepository) {
        this.directiveBinaryRepository = directiveBinaryRepository;
    }

    public DirectiveBinary createDirectiveBinary(DirectiveBinary directiveBinary) {
        return directiveBinaryRepository.save(directiveBinary);
    }

    public List<DirectiveBinary> getDirectiveBinaryByDirective(Directive directive) {
        return directiveBinaryRepository.findAllByDirective(directive);
    }

    public List<DirectiveBinary> getAllDirectiveBinaries() {
        return directiveBinaryRepository.findAll();
    }

    public void deleteDirectiveBinary(DirectiveBinary directiveBinary) {
        directiveBinaryRepository.delete(directiveBinary);
    }
}
