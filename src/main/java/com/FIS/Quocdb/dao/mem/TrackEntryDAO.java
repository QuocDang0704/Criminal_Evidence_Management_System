package com.FIS.Quocdb.dao.mem;

import com.FIS.Quocdb.dao.DAO;
import com.FIS.Quocdb.entities.TrackEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrackEntryDAO implements DAO<TrackEntry> {
    private final List<TrackEntry> trackEntries = new ArrayList<>();

    @Override
    public List<TrackEntry> getAll() {
        return trackEntries;
    }

    @Override
    public Optional<TrackEntry> get(Long id) {
        return trackEntries.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public void save(TrackEntry trackEntry) {
        trackEntries.add(trackEntry);
    }

    @Override
    public void update(TrackEntry trackEntry) {
        get(trackEntry.getId()).ifPresent(e -> {
            e.setDate(e.getDate());
            e.setEvidence(e.getEvidence());
            e.setDetective(e.getDetective());
            e.setAction(e.getAction());
            e.setReason(e.getReason());
        });
    }

    @Override
    public void delete(TrackEntry trackEntry) {
        get(trackEntry.getId()).ifPresent(trackEntries::remove);
    }

    @Override
    public void deleteId(Long id) {

    }

}
