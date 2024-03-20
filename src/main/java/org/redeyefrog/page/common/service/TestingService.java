package org.redeyefrog.page.common.service;

import lombok.extern.slf4j.Slf4j;
import org.redeyefrog.persistence.dao.UserDao;
import org.redeyefrog.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    public void testing() {
        log.info("userRepository.findAll={}", userRepository.findAll());
        log.info("userDao.findAll={}", userDao.findAll());
    }

}
