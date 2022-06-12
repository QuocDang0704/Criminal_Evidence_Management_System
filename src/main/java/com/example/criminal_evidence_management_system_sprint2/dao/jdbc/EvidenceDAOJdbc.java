package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.core.CriminalCase;
import com.example.criminal_evidence_management_system_sprint2.core.Evidence;
import com.example.criminal_evidence_management_system_sprint2.core.Storage;
import com.example.criminal_evidence_management_system_sprint2.dao.ICriminalCaseDAO;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IEvidenceDAO;
import com.example.criminal_evidence_management_system_sprint2.utlis.JdbcHelper;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EvidenceDAOJdbc implements IEvidenceDAO, ICrudBase<Evidence, Long> {
    private final static Logger logger = Logger.getLogger(EvidenceDAOJdbc.class);
    String INSERT = "insert  into evidence\n" +
            "(create_at, modified_at, version, archived, item_name, notes, number, case_fk, storage_fk) VALUES \n" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "update evidence\n" +
            "set modified_at = ?, version = ?, archived = ?, item_name = ?, notes = ?, number = ?, case_fk = ?, storage_fk = ?\n" +
            "where id = ?";
    String DELETE = "delete from evidence where  id = ?";
    String GET_ALL = "select * from evidence";
    String FIND_BY_ID = "select * from evidence where id = ?";
    @Override
    public List<Evidence> getAll() {
        try {
            return this.selectBySql(GET_ALL);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error getAll");
        }
    }

    @Override
    public Evidence getById(Long aLong) {
        try {
            return this.selectBySql(FIND_BY_ID, aLong).stream()
                    .findFirst()
                    .orElseThrow(()-> new RuntimeException("No Data"));
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error getById");
        }

    }

    @Override
    public Evidence insert(Evidence e) {
        try {
            JdbcHelper.update(INSERT,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    e.getVersion(),
                    e.getArchived(),
                    e.getItemName(),
                    e.getNotes(),
                    e.getNumber(),
                    e.getCriminalCase().getId(),
                    e.getStorage().getId());
            return e;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error insert");
        }
    }
    @Override
    public Evidence update(Evidence e, Long aLong) {
        try {
            JdbcHelper.update(UPDATE,
                    LocalDateTime.now(),
                    e.getVersion(),
                    e.getArchived(),
                    e.getItemName(),
                    e.getNotes(),
                    e.getNumber(),
                    e.getCriminalCase().getId(),
                    e.getStorage().getId());
            return e;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error update");
        }
    }

    @Override
    public void delete(Long aLong) {
        try {
            JdbcHelper.update(DELETE, aLong);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error delete");
        }
    }
    private List<Evidence> selectBySql(String sql, Object... args) {
        List<Evidence> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Evidence evidence = new Evidence();
                evidence.setId(rs.getLong(1));
                evidence.setCreateAt(LocalDateTime.from(rs.getDate(2).toInstant()));
                evidence.setModifiedAt(LocalDateTime.from(rs.getDate(3).toInstant()));
                evidence.setVersion(rs.getInt(4));
                evidence.setArchived(rs.getBoolean(5));
                evidence.setItemName(rs.getString(6));
                evidence.setNotes(rs.getString(7));
                evidence.setNumber(rs.getString(8));
                CriminalCase criminalCase = new CriminalCase();
                criminalCase.setId(rs.getLong(9));
                evidence.setCriminalCase(criminalCase);
                Storage storage = new Storage();
                storage.setId(rs.getLong(10));
                evidence.setStorage(storage);
                list.add(evidence);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return list;
    }
}
