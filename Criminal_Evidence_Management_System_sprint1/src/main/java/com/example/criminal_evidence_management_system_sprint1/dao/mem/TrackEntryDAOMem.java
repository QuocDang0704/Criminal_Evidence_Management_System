package com.example.criminal_evidence_management_system_sprint1.dao.mem;

import com.example.criminal_evidence_management_system_sprint1.core.TrackEntry;
import com.example.criminal_evidence_management_system_sprint1.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint1.dao.ITrackEntryDAO;

import java.util.List;

public class TrackEntryDAOMem implements ICrudBase<TrackEntry, Integer>, ITrackEntryDAO {
    private List<TrackEntry> lst;

    public TrackEntryDAOMem(List<TrackEntry> lst) {
        this.lst = lst;
    }

    @Override
    public List<TrackEntry> getAll() {
        return lst;
    }

    @Override
    public TrackEntry getById(Integer integer) {
        return lst.stream()
                .filter(i -> i.getTrackEntryId().equals(integer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public TrackEntry insert(TrackEntry trackEntry) {
        if (this.getById(trackEntry.getTrackEntryId())==null){
            lst.add(trackEntry);
            return trackEntry;
        }
        return null;
    }

    @Override
    public TrackEntry update(TrackEntry trackEntry, Integer integer) {
        if (this.getById(trackEntry.getTrackEntryId())!=null){
            lst.forEach(i -> {
                if (i.getTrackEntryId().equals(integer)){
                    trackEntry.setTrackEntryId(integer);
                    i = trackEntry;
                    return;
                }
            });
        }
        return trackEntry;
    }

    @Override
    public void delete(Integer integer) {
        lst.removeIf(i -> i.getTrackEntryId().equals(integer));
    }
}
