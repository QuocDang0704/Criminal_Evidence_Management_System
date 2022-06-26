package fis.quocdb3.service.impl;

import fis.quocdb3.domain.Detective;
import fis.quocdb3.repository.DetectiveRepository;
import fis.quocdb3.service.CrudBase;
import fis.quocdb3.service.IDetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
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
    public List<Detective> getAll() {
        return this.detectiveRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
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
