package com.FIS.Quocdb.service;

import com.FIS.Quocdb.entities.TrackEntry;

import java.util.Set;

public interface TrackEntryService {
    TrackEntry addTrackEntry(TrackEntry trackEntry);

    TrackEntry updateTrackEntry(TrackEntry trackEntry);

    Set<TrackEntry> getTrackEntries();

    TrackEntry getTrackEntry(Long id);

    void deleteTrackEntry(Long id);
}
