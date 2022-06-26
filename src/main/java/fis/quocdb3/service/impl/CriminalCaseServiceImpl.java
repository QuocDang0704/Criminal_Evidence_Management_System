package fis.quocdb3.service.impl;

import fis.quocdb3.domain.CriminalCase;
import fis.quocdb3.repository.CriminalCaseRepository;
import fis.quocdb3.service.ICriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalCaseServiceImpl
        implements ICriminalCaseService
{
    @Autowired
    CriminalCaseRepository criminalCaseRepository;

    @Override
    public CriminalCase add(CriminalCase criminalCase) {
        return this.criminalCaseRepository.save(criminalCase);
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        return this.criminalCaseRepository.save(criminalCase);
    }

    @Override
    public List<CriminalCase> getAll() {
        return this.criminalCaseRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public CriminalCase getById(Long id) {
        return this.criminalCaseRepository.findById(id)
        .orElseThrow(() -> {throw new IllegalArgumentException(String.format("Not found with id: %s", id));});
    }

    @Override
    public void delete(Long id) {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(id);
        this.criminalCaseRepository.delete(criminalCase);
    }
}
