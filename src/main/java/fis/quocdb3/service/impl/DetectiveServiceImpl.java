package fis.quocdb3.service.impl;

import fis.quocdb3.domain.Detective;
import fis.quocdb3.repository.DetectiveRepository;
import fis.quocdb3.service.CrudBase;
import fis.quocdb3.service.IDetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DetectiveServiceImpl
        implements IDetectiveService
{
    @Autowired
    DetectiveRepository detectiveRepository;

    @Override
    public Detective add(Detective detective) {
        return this.detectiveRepository.save(detective);
    }

    @Override
    public Detective update(Detective detective) {
        return this.detectiveRepository.save(detective);
    }

    @Override
    public Set<Detective> getAll() {
        return new HashSet<>(this.detectiveRepository.findAll());
    }

    @Override
    public Detective getById(Long id) {
        return this.detectiveRepository.findById(id)
                .orElseThrow(() -> {throw new IllegalArgumentException(String.format("Not found with id: %s", id));});
    }

    @Override
    public void delete(Long id) {
        Detective detective = new Detective();
        detective.setId(id);
        this.detectiveRepository.delete(detective);
    }
}
