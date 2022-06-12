package com.example.criminal_evidence_management_system_sprint2.dao.mem;

import com.example.criminal_evidence_management_system_sprint2.core.Detective;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IDetectiveDAO;

import java.util.List;

public class DetectiveDAOMem implements ICrudBase<Detective, Long>, IDetectiveDAO {
    private List<Detective> lst;

    public DetectiveDAOMem(List<Detective> lst) {
        this.lst = lst;
    }

    @Override
    public List<Detective> getAll() {
        return lst;
    }

    @Override
    public Detective getById(Long along) {
        return lst.stream()
                .filter(i -> i.getId().equals(along))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Detective insert(Detective detective) {
        if (this.getById(detective.getId())==null){
            lst.add(detective);
            return detective;
        }
        return null;
    }

    @Override
    public Detective update(Detective detective, Long along) {
        if (this.getById(detective.getId())!=null){
            lst.forEach(i -> {
                if (i.getId().equals(along)){
                    detective.setId(along);
                    i = detective;
                    return;
                }
            });
        }
        return detective;
    }

    @Override
    public void delete(Long along) {
        lst.removeIf(i -> i.getId().equals(along));
    }
}
