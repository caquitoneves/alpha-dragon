package com.alphadragon.domain.history;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class HistorySnapshot {

    private final String snapshotId;
    private final List<String> eventIds;

    public HistorySnapshot(String snapshotId, List<String> eventIds) {
        this.snapshotId = Objects.requireNonNull(snapshotId, "snapshotId");
        this.eventIds = Collections.unmodifiableList(Objects.requireNonNull(eventIds, "eventIds"));
    }

    public String snapshotId() {
        return snapshotId;
    }

    public List<String> eventIds() {
        return eventIds;
    }
}
