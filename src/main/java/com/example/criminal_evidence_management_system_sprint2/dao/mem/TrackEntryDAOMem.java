package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.TrackEntry;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.ITrackEntryDAO;

import java.util.List;

public class TrackEntryDAOMem implements ICrudBase<TrackEntry, Long>, ITrackEntryDAO {
    private List<TrackEntry> lst;

    public TrackEntryDAOMem(List<TrackEntry> lst) {
        this.lst = lst;
    }

    @Override
    public List<TrackEntry> getAll() {
        return lst;
    }

    @Override
    public TrackEntry getById(Long along) {
        return lst.stream()
                .filter(i -> i.getId().equals(along))
                .findFirst()
                .orElse(null);
    }

    @Override
    public TrackEntry insert(TrackEntry trackEntry) {
        if (this.getById(trackEntry.getId())==null){
            lst.add(trackEntry);
            return trackEntry;
        }
        return null;
    }

    @Override
    public TrackEntry update(TrackEntry trackEntry, Long along) {
        if (this.getById(trackEntry.getId())!=null){
            lst.forEach(i -> {
                if (i.getId().equals(along)){
                    trackEntry.setId(along);
                    i = trackEntry;
                    return;
                }
            });
        }
        return trackEntry;
    }

    @Override
    public void delete(Long along) {
        lst.removeIf(i -> i.getId().equals(along));
    }
}
