package com.FIS.Quocdb.dao.jdbc;

import com.FIS.Quocdb.helper.JdbcHelper;
import com.FIS.Quocdb.dao.JdbcDAO;
import com.fis.quocdb.entities.*;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcEvidence extends JdbcDAO<Evidence, Long> {
    String INSERT = "insert  into evidence\n" +
            "(create_at, modified_at, version, archived, item_name, notes, number, case_fk, storage_fk) VALUES \n" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "update evidence\n" +
            "set modified_at = ?, version = ?, archived = ?, item_name = ?, notes = ?, number = ?, case_fk = ?, storage_fk = ?\n" +
            "where  id = ?";
    String DELETE = "delete from evidence where  id = ?";
    String SELECT_ALL = "select * from evidence";
    String SELECT_BY_ID = "select * from evidence where id = ?";

    @Override
    public void insert(Evidence e) {
        JdbcHelper.update(INSERT, LocalDateTime.now(), LocalDateTime.now(), e.getVersion(), e.getArchived(), e.getItemName(), e.getNotes(), e.getNumber(), e.getCriminalCase().getId(), e.getStorage().getId());
    }

    @Override
    public void update(Evidence e) {
        JdbcHelper.update(UPDATE, LocalDateTime.now(), e.getVersion(), e.getArchived(), e.getItemName(), e.getNotes(), e.getNumber(), e.getCriminalCase().getId(), e.getStorage().getId(), e.getId());
    }

    @Override
    public void delete(Long k) {
        JdbcHelper.update(DELETE, k);
    }

    @Override
    public List<Evidence> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public Evidence selectById(Long k) {
        List<Evidence> list = this.selectBySql(SELECT_BY_ID, k);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Evidence> selectBySql(String sql, Object... args) {
        List<Evidence> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Evidence evidence = new Evidence();
                evidence.setId(rs.getLong(1));
                evidence.setCreateAt(rs.getDate(2).toLocalDate().atStartOfDay());
                evidence.setModifiedAt(rs.getDate(3).toLocalDate().atStartOfDay());
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
            e.printStackTrace();
        }
        return list;
    }
}
