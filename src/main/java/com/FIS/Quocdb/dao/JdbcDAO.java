package com.FIS.Quocdb.dao;

import java.util.List;

public abstract class JdbcDAO<Entity, Key> {

    abstract public void insert(Entity e);

    abstract public void update(Entity e);

    abstract public void delete(Key k);

    abstract public List<Entity> selectAll();

    abstract public Entity selectById(Key k);

    abstract protected List<Entity> selectBySql(String sql, Object... args);

}
