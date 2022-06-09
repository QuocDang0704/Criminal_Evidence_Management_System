package com.example.criminal_evidence_management_system_sprint1.dao.mem;

import com.example.criminal_evidence_management_system_sprint1.core.Detective;
import com.example.criminal_evidence_management_system_sprint1.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint1.dao.IDetectiveDAO;

import java.util.List;

public class DetectiveDAOMem implements ICrudBase<Detective, Integer>, IDetectiveDAO {
    private List<Detective> lst;

    public DetectiveDAOMem(List<Detective> lst) {
        this.lst = lst;
    }

    @Override
    public List<Detective> getAll() {
        return lst;
    }

    @Override
    public Detective getById(Integer integer) {
        return lst.stream()
                .filter(i -> i.getDetectiveId().equals(integer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Detective insert(Detective detective) {
        if (this.getById(detective.getDetectiveId())==null){
            lst.add(detective);
            return detective;
        }
        return null;
    }

    @Override
    public Detective update(Detective detective, Integer integer) {
        if (this.getById(detective.getDetectiveId())!=null){
            lst.forEach(i -> {
                if (i.getDetectiveId().equals(integer)){
                    detective.setDetectiveId(integer);
                    i = detective;
                    return;
                }
            });
        }
        return detective;
    }

    @Override
    public void delete(Integer integer) {
        lst.removeIf(i -> i.getDetectiveId().equals(integer));
    }
}
