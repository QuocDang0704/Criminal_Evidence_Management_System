package com.FIS.Quocdb.dao.jdbc;

import com.FIS.Quocdb.helper.JdbcHelper;
import com.FIS.Quocdb.dao.JdbcDAO;
import com.FIS.Quocdb.entities.Storage;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcStorage extends JdbcDAO<Storage, Long> {
    String INSERT = "insert into storage\n" +
            "(create_at, modified_at, version, location, name) VALUES \n" +
            "(?, ?, ?, ?, ?)";
    String UPDATE = "update storage\n" +
            "set modified_at = ?, version = ?, location = ?, name = ?\n" +
            "where  id = ?";
    String DELETE = "delete from storage where  id = ?";
    String SELECT_ALL = "select * from storage";
    String SELECT_BY_ID = "select * from storage where id = ?";

    @Override
    public void insert(Storage e) {
        JdbcHelper.update(INSERT, LocalDateTime.now(), LocalDateTime.now(), e.getVersion(), e.getLocation(), e.getName());
    }

    @Override
    public void update(Storage e) {
        JdbcHelper.update(UPDATE, LocalDateTime.now(), e.getVersion(), e.getLocation(), e.getName());
    }

    @Override
    public void delete(Long k) {
        JdbcHelper.update(DELETE, k);
    }

    @Override
    public List<Storage> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public Storage selectById(Long k) {
        List<Storage> list = this.selectBySql(SELECT_BY_ID, k);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Storage> selectBySql(String sql, Object... args) {
        List<Storage> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Storage storage = new Storage();
                storage.setId(rs.getLong(1));
                storage.setCreateAt(LocalDateTime.from(rs.getDate(2).toInstant()));
                storage.setModifiedAt(LocalDateTime.from(rs.getDate(3).toInstant()));
                storage.setVersion(rs.getInt(4));
                storage.setLocation(rs.getString(5));
                storage.setName(rs.getString(6));
                list.add(storage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
