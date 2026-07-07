package com.alphadragon.domain.model.project;

import com.alphadragon.domain.event.DomainEvent;
import com.alphadragon.domain.model.assembly.Assembly;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Aggregate root representing a top-level engineering project.
 */
public final class EngineeringProject {

    private final ProjectId id;
    private final ProjectMetadata metadata;
    private final List<Assembly> assemblies;
    private final List<Revision> revisions;
    private final List<AuditTrail> auditTrail;

    public EngineeringProject(ProjectId id, ProjectMetadata metadata) {
        this.id = Objects.requireNonNull(id, "id");
        this.metadata = Objects.requireNonNull(metadata, "metadata");
        this.assemblies = new ArrayList<>();
        this.revisions = new ArrayList<>();
        this.auditTrail = new ArrayList<>();
    }

    public ProjectId projectId() {
        return id;
    }

    public ProjectMetadata metadata() {
        return metadata;
    }

    public List<Assembly> assemblies() {
        return Collections.unmodifiableList(assemblies);
    }

    public void addAssembly(Assembly assembly) {
        Objects.requireNonNull(assembly, "assembly");
        this.assemblies.add(assembly);
    }

    public void recordRevision(Revision revision) {
        Objects.requireNonNull(revision, "revision");
        revisions.add(revision);
    }

    public void recordAudit(AuditTrail auditEntry) {
        Objects.requireNonNull(auditEntry, "auditEntry");
        auditTrail.add(auditEntry);
    }

    public void publishEvent(DomainEvent event) {
        // Domain event handling is delegated to a port implementation.
    }
}
