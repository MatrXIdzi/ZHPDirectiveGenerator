package pl.idzi.app.model.directive;

import jakarta.persistence.*;
import pl.idzi.app.model.AbstractEntity;

import java.util.UUID;

@Entity
public class DirectiveBinary extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "directive_id", referencedColumnName = "id")
    private Directive directive;

    @Lob
    @Column(nullable = false, length = 1000000)
    private byte[] content;

    public DirectiveBinary() {
    }

    public DirectiveBinary(Directive directive, byte[] content) {
        this.directive = directive;
        this.content = content;
    }

    public Directive getDirective() {
        return directive;
    }

    public void setDirective(Directive directive) {
        this.directive = directive;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
