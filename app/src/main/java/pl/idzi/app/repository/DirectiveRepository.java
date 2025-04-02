package pl.idzi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.idzi.app.model.directive.Directive;

import java.util.List;
import java.util.UUID;

@Repository
public interface DirectiveRepository extends JpaRepository<Directive, UUID> {
    List<Directive> findAllBySerialNumber(String serialNumber);
    List<Directive> findAllByCity(String city);
}
