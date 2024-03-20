package org.redeyefrog.persistence.dao;

import org.redeyefrog.persistence.entity.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> findAll();

}
