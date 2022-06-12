package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.common.EmploymentStatus;
import com.example.criminal_evidence_management_system_sprint2.common.Rank;
import com.example.criminal_evidence_management_system_sprint2.core.CriminalCase;
import com.example.criminal_evidence_management_system_sprint2.core.Detective;
import com.example.criminal_evidence_management_system_sprint2.core.Person;
import com.example.criminal_evidence_management_system_sprint2.dao.ICriminalCaseDAO;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IDetectiveDAO;
import com.example.criminal_evidence_management_system_sprint2.utlis.JdbcHelper;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DetectiveDAOJdbc implements IDetectiveDAO, ICrudBase<Detective, Long> {
    private static Logger logger = Logger.getLogger(DetectiveDAOJdbc.class);
    String INSERT_PERSON = "insert into person (create_at, modified_at, version, first_name, hiring_date, last_name, password, username)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?)";
    String INSERT = "insert into detective (create_at, modified_at, version, armed, badge_number, `rank`, status, person_id)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, (SELECT person.id FROM person ORDER BY person.id DESC limit 1));";
    String UPDATE = "update detective\n" +
            "set modified_at = ?, version = ?, armed = ?, badge_number = ?" +
            "where id = ?";
    String DELETE = "delete from detective where id = ?";
    String GET_ALL = "select * from detective join person p on detective.person_id = p.id";
    String FIND_BY_ID = "select * from detective join person p on detective.person_id = p.id where detective.id = ?";
    @Override
    public List<Detective> getAll() {
        try {
            return this.selectBySql(GET_ALL);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error getAll");
        }
    }

    @Override
    public Detective getById(Long aLong) {
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
    public Detective insert(Detective e) {
        try {
            JdbcHelper.update(INSERT_PERSON, e.getPerson().getCreateAt(), e.getPerson().getModifiedAt(), e.getPerson().getVersion(), e.getPerson().getFirstName(),
                    e.getPerson().getHiringDate(), e.getPerson().getLastName(), e.getPerson().getPassword(), e.getPerson().getUsername());
            JdbcHelper.update(INSERT,
                    LocalDateTime.now(), LocalDateTime.now(), e.getVersion(),
                    e.getArmed(), e.getBadgeNumber(), e.getRank() + "", e.getStatus() + "");
            return e;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error insert");
        }
    }

    @Override
    public Detective update(Detective e, Long aLong) {
        try {
            JdbcHelper.update(UPDATE,
                    e.getModifiedAt(),
                    e.getVersion(),
                    e.getArmed(),
                    e.getBadgeNumber(),
                    aLong);
            e.setId(aLong);
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
            throw new RuntimeException("Error getAll");
        }
    }
    private List<Detective> selectBySql(String sql, Object... args) {
        List<Detective> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Detective detective = new Detective();
                detective.setId(rs.getLong(1));
                detective.setCreateAt(rs.getDate(2).toLocalDate().atStartOfDay());
                detective.setModifiedAt(rs.getDate(3).toLocalDate().atStartOfDay());
                detective.setVersion(rs.getInt(4));
                detective.setArmed(rs.getBoolean(5));
                detective.setBadgeNumber(rs.getString(6));
                detective.setRank(Rank.valueOf(rs.getString(7)));
                detective.setStatus(EmploymentStatus.valueOf(rs.getString(8)));
                Person p = new Person();
                p.setId(rs.getLong(9));
                p.setUsername(rs.getString(18));
                detective.setPerson(p);
                list.add(detective);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}
