package com.FIS.Quocdb.dao.jdbc;

import com.FIS.Quocdb.entities.Person;
import com.FIS.Quocdb.helper.JdbcHelper;
import com.FIS.Quocdb.util.EmploymentStatus;
import com.FIS.Quocdb.util.Rank;
import com.FIS.Quocdb.dao.JdbcDAO;
import com.FIS.Quocdb.entities.Detective;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcDetective extends JdbcDAO<Detective, Long> {
    String INSERT_PERSON = "insert into person (create_at, modified_at, version, first_name, hiring_date, last_name, password, username)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?)\n" +
            "";
    String INSERT_DETECTIVE = "insert into detective (create_at, modified_at, version, armed, badge_number, `rank`, status, person_id)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, (SELECT person.id FROM person ORDER BY person.id DESC limit 1));";
    String UPDATE = "update detective\n" +
            "set modified_at = ?, version = ?, armed = ?, badge_number = ?" +
            "where id = ?";
    String DELETE = "delete from detective where  id = ?";
    String SELECT_ALL = "select * from detective join person p on detective.person_id = p.id";
    String SELECT_BY_ID = "select * from detective join person p on detective.person_id = p.id where detective.id = ?";

    @Override
    public void insert(Detective e) {
        JdbcHelper.update(INSERT_PERSON, e.getPerson().getCreateAt(), e.getPerson().getModifiedAt(), e.getPerson().getVersion(), e.getPerson().getFirstName(),
                e.getPerson().getHiringDate(), e.getPerson().getLastName(), e.getPerson().getPassword(), e.getPerson().getUsername());
        JdbcHelper.update(INSERT_DETECTIVE,
                LocalDateTime.now(), LocalDateTime.now(), e.getVersion(),
                e.getArmed(), e.getBadgeNumber(), e.getRank() + "", e.getStatus() + "");
    }

    @Override
    public void update(Detective e) {
        JdbcHelper.update(UPDATE, e.getModifiedAt(), e.getVersion(), e.getArmed(), e.getBadgeNumber(), e.getId());
    }

    @Override
    public void delete(Long k) {
        JdbcHelper.update(DELETE, k);
    }

    @Override
    public List<Detective> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public Detective selectById(Long k) {
        List<Detective> list = this.selectBySql(SELECT_BY_ID, k);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Detective> selectBySql(String sql, Object... args) {
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
            e.printStackTrace();
        }
        return list;
    }

//    @Override
//    protected void prepareSta(PreparedStatement sttm, Object... args) throws SQLException {
//        for (int i = 0; i < args.length; i++) {
//            sttm.setObject(i + 1, args[i]);
//        }
//    }
//
//    @Override
//    protected Detective mappingEntity(ResultSet rs) throws SQLException {
//        Detective detective = new Detective();
//        detective.setId(rs.getLong(1));
//        detective.setCreateAt(rs.getDate(2).toLocalDate().atStartOfDay());
//        detective.setModifiedAt(rs.getDate(3).toLocalDate().atStartOfDay());
//        detective.setVersion(rs.getInt(4));
//        detective.setArmed(rs.getBoolean(5));
//        detective.setBadgeNumber(rs.getString(6));
//        detective.setRank(Rank.valueOf(rs.getString(7)));
//        detective.setStatus(EmploymentStatus.valueOf(rs.getString(8)));
//        Person p = new Person();
//        p.setId(rs.getLong(9));
//        p.setUsername(rs.getString(18));
//        detective.setPerson(p);
//        return detective;
//    }
//
//    protected List<Detective> selectDetective(String sql, Object... args) throws SQLException {
//        return selectBase(sql, args);
//    }

}
