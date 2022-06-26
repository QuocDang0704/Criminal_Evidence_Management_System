package fis.quocdb3.service.impl;

import fis.quocdb3.domain.TrackEntry;
import fis.quocdb3.repository.TrackEntryRepository;
import fis.quocdb3.service.CrudBase;
import fis.quocdb3.service.ITrackEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrackEntryServiceImpl
        implements ITrackEntryService {

    @Autowired
    TrackEntryRepository trackEntryRepository;

    @Override
    public TrackEntry add(TrackEntry trackEntry) {
        return this.trackEntryRepository.save(trackEntry);
    }

    @Override
    public TrackEntry update(TrackEntry trackEntry) {
        return this.trackEntryRepository.save(trackEntry);
    }

    @Override
    public List<TrackEntry> getAll() {
        return this.trackEntryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public TrackEntry getById(Long id) {
        return this.trackEntryRepository.findById(id)
                .orElseThrow(() -> {throw new IllegalArgumentException(String.format("Not found with id: %s", id));});
    }

    @Override
    public void delete(Long id) {
        TrackEntry trackEntry = new TrackEntry();
        trackEntry.setId(id);
        this.trackEntryRepository.delete(trackEntry);
    }
}
