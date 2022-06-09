package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.TrackEntry;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.ITrackEntryDAO;

import java.util.List;

public class TrackEntryDAOMem implements ICrudBase<TrackEntry, Integer>, ITrackEntryDAO {
    private List<TrackEntry> lst;

    public TrackEntryDAOMem(List<TrackEntry> lst) {
        this.lst = lst;
    }

    @Override
    public List<TrackEntry> getAll() {
        return null;
    }

    @Override
    public TrackEntry getById(Integer integer) {
        return null;
    }

    @Override
    public TrackEntry insert(TrackEntry trackEntry) {
        return null;
    }

    @Override
    public TrackEntry update(TrackEntry trackEntry, Integer integer) {
        return null;
    }
}
