package pl.idzi.app.model;


import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Version
    @Column(name = "version")
    private Long version;

    public AbstractEntity() { }

    public UUID getId() { return id; }

    public Long getVersion() { return version; }

}
