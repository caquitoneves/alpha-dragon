package com.alphadragon.domain.port;

import com.alphadragon.domain.event.DomainEvent;

/**
 * Port for publishing domain events externally.
 */
public interface DomainEventPublisher {

    void publish(DomainEvent event);
}
