package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.common.CaseStatus;
import com.example.criminal_evidence_management_system_sprint2.common.CaseType;
import com.example.criminal_evidence_management_system_sprint2.core.CriminalCase;
import com.example.criminal_evidence_management_system_sprint2.core.Detective;
import com.example.criminal_evidence_management_system_sprint2.dao.ICriminalCaseDAO;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.utlis.JdbcHelper;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriminalCaseDAOJdbc implements ICriminalCaseDAO, ICrudBase<CriminalCase, Long> {
    private final static Logger logger = Logger.getLogger(CriminalCaseDAOJdbc.class);
    String INSERT = "insert  into criminal_case\n" +
            "(create_at, modified_at, version, detailed_description, notes, number, short_description, status, case_type, lead_investigator)\n" +
            "values\n" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "update criminal_case\n" +
            "set modified_at = ?, version = ?, detailed_description = ?, notes = ?, number = ?, short_description = ?,\n" +
            "    status = ?, case_type = ?, lead_investigator = ?\n" +
            "where  id = ?";
    String DELETE = "delete from criminal_case where  id = ?";
    String GET_ALL = "select * from criminal_case";
    String FIND_BY_ID = "select * from criminal_case where id = ?";
    @Override
    public List<CriminalCase> getAll() {
        try {
            return this.selectBySql(GET_ALL);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error getAll");
        }
    }

    @Override
    public CriminalCase getById(Long Long) {
        try {
            List<CriminalCase> list = this.selectBySql(FIND_BY_ID, Long);
            return list.stream()
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Error is null"));
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error getById");
        }

    }

    @Override
    public CriminalCase insert(CriminalCase criminalCase) {
        try {
            JdbcHelper.update(INSERT,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    criminalCase.getVersion(),
                    criminalCase.getDetailedDescription(),
                    criminalCase.getNotes(),
                    criminalCase.getNumber(),
                    criminalCase.getShortDescription(),
                    criminalCase.getStatus()+"",
                    criminalCase.getType()+"",
                    criminalCase.getLeadInvestigator().getId());
            return criminalCase;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error insert");
        }
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase, Long along) {
        try {
            JdbcHelper.update(UPDATE,
                    criminalCase.getModifiedAt(),
                    criminalCase.getVersion(),
                    criminalCase.getDetailedDescription(),
                    criminalCase.getNotes(),
                    criminalCase.getNumber(),
                    criminalCase.getShortDescription(),
                    criminalCase.getStatus(),
                    criminalCase.getType(),
                    criminalCase.getLeadInvestigator().getId(),
                    along);
            return criminalCase;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error update");
        }
    }

    @Override
    public void delete(Long k) {
        try {
            JdbcHelper.update(DELETE, k);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error delete");
        }
    }

    protected List<CriminalCase> selectBySql(String sql, Object... args) {
        List<CriminalCase> list  = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()){
                CriminalCase criminalCase = new CriminalCase();
                criminalCase.setId(rs.getLong(1));
                criminalCase.setCreateAt(LocalDateTime.from(rs.getDate(2).toInstant()));
                criminalCase.setModifiedAt(LocalDateTime.from(rs.getDate(3).toInstant()));
                criminalCase.setVersion(rs.getInt(4));
                criminalCase.setDetailedDescription(rs.getString(5));
                criminalCase.setNotes(rs.getString(6));
                criminalCase.setNumber(rs.getString(7));
                criminalCase.setShortDescription(rs.getString(8));
                criminalCase.setStatus(CaseStatus.valueOf(rs.getString(9)));
                criminalCase.setType(CaseType.valueOf(rs.getString(10)));
                Detective d = new Detective();
                d.setId(rs.getLong(11));
                criminalCase.setLeadInvestigator(d);
                list.add(criminalCase);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return list;
    }
}
