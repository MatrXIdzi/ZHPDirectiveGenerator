package pl.idzi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.idzi.app.model.directive.Directive;
import pl.idzi.app.model.directive.DirectiveBinary;

import java.util.List;
import java.util.UUID;

@Repository
public interface DirectiveBinaryRepository extends JpaRepository<DirectiveBinary, UUID> {
    List<DirectiveBinary> findAllByDirective(Directive directive);
}
