package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.common.TrackAction;
import com.example.criminal_evidence_management_system_sprint2.core.Detective;
import com.example.criminal_evidence_management_system_sprint2.core.Evidence;
import com.example.criminal_evidence_management_system_sprint2.core.TrackEntry;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.ITrackEntryDAO;
import com.example.criminal_evidence_management_system_sprint2.utlis.JdbcHelper;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrackEntryDAOJdbc implements ITrackEntryDAO, ICrudBase<TrackEntry, Long> {
    private final static Logger logger = Logger.getLogger(TrackEntryDAOJdbc.class);
    String INSERT = "insert into track_entry\n" +
            "(create_at, modified_at, version, action, date, reason, detective_fk, evidence_fk) \n" +
            "values\n" +
            "(?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "update track_entry\n" +
            "set modified_at = ?, version = ?, action = ?, date = ?, reason = ?, detective_fk = ?, evidence_fk = ?\n" +
            "where  id = ?";
    String DELETE = "delete from track_entry where  id = ?";
    String GET_ALL = "select * from track_entry";
    String FIND_BY_ID = "select * from track_entry where id = ?";


    @Override
    public List<TrackEntry> getAll() {
        try {
            return this.selectBySql(GET_ALL);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error getAll");
        }
    }

    @Override
    public TrackEntry getById(Long aLong) {
        try {
            return this.selectBySql(FIND_BY_ID).stream()
                    .findFirst()
                    .orElseThrow(()-> new RuntimeException("No Data"));
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error getById");
        }

    }

    @Override
    public TrackEntry insert(TrackEntry e) {
        try {
            JdbcHelper.update(INSERT,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    e.getVersion(),
                    e.getAction()+"",
                    e.getDate(),
                    e.getReason(),
                    e.getDetective().getId(),
                    e.getEvidence().getId());
            return e;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error insert");
        }
    }

    @Override
    public TrackEntry update(TrackEntry e, Long aLong) {
        try {
            JdbcHelper.update(UPDATE,
                    LocalDateTime.now(),
                    e.getVersion(),
                    e.getAction() +"",
                    e.getDate(),
                    e.getReason(),
                    e.getDetective().getId(),
                    e.getEvidence().getId(),
                    aLong);
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
    private List<TrackEntry> selectBySql(String sql, Object... args) {
        List<TrackEntry> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                TrackEntry trackEntry = new TrackEntry();
                trackEntry.setId(rs.getLong(1));
                trackEntry.setCreateAt(LocalDateTime.from(rs.getDate(2).toInstant()));
                trackEntry.setModifiedAt(LocalDateTime.from(rs.getDate(3).toInstant()));
                trackEntry.setVersion(rs.getInt(4));
                trackEntry.setAction(TrackAction.valueOf(rs.getString(5)));
                trackEntry.setDate(LocalDateTime.from(rs.getDate(6).toInstant()));
                trackEntry.setReason(rs.getString(7));
                Detective detective = new Detective();
                detective.setId(rs.getLong(8));
                trackEntry.setDetective(detective);
                Evidence evidence = new Evidence();
                evidence.setId(rs.getLong(9));
                trackEntry.setEvidence(evidence);
                list.add(trackEntry);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return list;
    }
}
