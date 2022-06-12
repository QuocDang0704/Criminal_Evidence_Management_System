package com.example.criminal_evidence_management_system_sprint2.dao.jdbc;

import com.example.criminal_evidence_management_system_sprint2.core.Storage;
import com.example.criminal_evidence_management_system_sprint2.dao.ICrudBase;
import com.example.criminal_evidence_management_system_sprint2.dao.IStorageDAO;
import com.example.criminal_evidence_management_system_sprint2.utlis.JdbcHelper;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StorageDAOJdbc implements IStorageDAO, ICrudBase<Storage, Long> {
    private final static Logger logger = Logger.getLogger(StorageDAOJdbc.class);
    String INSERT = "insert into storage\n" +
            "(create_at, modified_at, version, location, name) VALUES \n" +
            "(?, ?, ?, ?, ?)";
    String UPDATE = "update storage\n" +
            "set modified_at = ?, version = ?, location = ?, name = ? where  id = ?";
    String DELETE = "delete from storage where  id = ?";
    String GET_ALL = "select * from storage";
    String FIND_BY_ID = "select * from storage where id = ?";
    @Override
    public List<Storage> getAll() {
        try {
            return this.selectBySql(GET_ALL);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error getAll");
        }
    }

    @Override
    public Storage getById(Long aLong) {
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
    public Storage insert(Storage e) {
        try {
            JdbcHelper.update(INSERT,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    e.getVersion(),
                    e.getLocation(),
                    e.getName());
            return e;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException("Error insert");
        }
    }

    @Override
    public Storage update(Storage e, Long aLong) {
        try {
            JdbcHelper.update(UPDATE,
                    LocalDateTime.now(),
                    e.getVersion(),
                    e.getLocation(),
                    e.getName(), aLong);
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
    private List<Storage> selectBySql(String sql, Object... args) {
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
            logger.error(e.getMessage());
        }
        return list;
    }
}
