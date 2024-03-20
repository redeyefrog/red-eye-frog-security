package org.redeyefrog.persistence.dao.impl;

import org.redeyefrog.persistence.dao.UserDao;
import org.redeyefrog.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<UserEntity> findAll() {
        StringBuilder sb = new StringBuilder("SELECT * FROM REFROG.USER");
        return namedParameterJdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<>(UserEntity.class));
    }

}
