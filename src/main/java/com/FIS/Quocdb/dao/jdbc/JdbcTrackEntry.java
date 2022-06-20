package com.FIS.Quocdb.dao.jdbc;

import com.FIS.Quocdb.entities.Evidence;
import com.FIS.Quocdb.entities.TrackEntry;
import com.FIS.Quocdb.helper.JdbcHelper;
import com.FIS.Quocdb.util.TrackAction;
import com.FIS.Quocdb.dao.JdbcDAO;
import com.FIS.Quocdb.entities.Detective;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcTrackEntry extends JdbcDAO<TrackEntry, Long> {
    String INSERT = "insert into track_entry\n" +
            "(create_at, modified_at, version, action, date, reason, detective_fk, evidence_fk) \n" +
            "values\n" +
            "(?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "update track_entry\n" +
            "set modified_at = ?, version = ?, action = ?, date = ?, reason = ?, detective_fk = ?, evidence_fk = ?\n" +
            "where  id = ?";
    String DELETE = "delete from track_entry where  id = ?";
    String SELECT_ALL = "select * from track_entry";
    String SELECT_BY_ID = "select * from track_entry where id = ?";

    @Override
    public void insert(TrackEntry e) {
        JdbcHelper.update(INSERT, LocalDateTime.now(), LocalDateTime.now(), e.getVersion(), e.getAction()+"", e.getDate(), e.getReason(), e.getDetective(), e.getEvidence());
    }

    @Override
    public void update(TrackEntry e) {
        JdbcHelper.update(UPDATE, LocalDateTime.now(), e.getVersion(), e.getAction() +"", e.getDate(), e.getReason(), e.getDetective(), e.getEvidence(), e.getId());
    }

    @Override
    public void delete(Long k) {
        JdbcHelper.update(DELETE, k);

    }

    @Override
    public List<TrackEntry> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public TrackEntry selectById(Long k) {
        List<TrackEntry> list = this.selectBySql(SELECT_BY_ID, k);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<TrackEntry> selectBySql(String sql, Object... args) {
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
            e.printStackTrace();
        }
        return list;
    }
}
