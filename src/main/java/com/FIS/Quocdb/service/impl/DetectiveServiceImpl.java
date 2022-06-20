package com.FIS.Quocdb.service.impl;

import com.FIS.Quocdb.service.DetectiveService;
import com.FIS.Quocdb.entities.Detective;
import com.FIS.Quocdb.repository.DetectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DetectiveServiceImpl implements DetectiveService {
    @Autowired
    DetectiveRepository detectiveRepository;


    @Override
    public Detective addDetective(Detective detective) {
        return this.detectiveRepository.save(detective);
    }

    @Override
    public Detective updateDetective(Detective detective) {
        return this.detectiveRepository.save(detective);
    }

    @Override
    public Set<Detective> getDetectives() {
        return new HashSet<>(this.detectiveRepository.findAll());
    }

    @Override
    public Detective getDetective(Long id) {
        return this.detectiveRepository.findById(id).get();
    }

    @Override
    public void deleteDetective(Long id) {
        Detective detective = new Detective();
        detective.setId(id);
        this.detectiveRepository.delete(detective);
    }
}
