package com.freekash.springboot.database;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/*
This class is an instance of Java Persistence API (JPA)
-- @Autowired annotation. Allows Spring to resolve and inject collaborating beans into our bean.
-- Spring Data JPA will generate a proxy instance
-- Below are the CRUD methods that we can use with our database
*/
@Service
@Transactional
public class DatabaseSqlRepository {

    @Autowired
    private DatabaseJpaRepository jpa;

    public List<Row> listAll() {
        return jpa.findAll();
    }

    public void save(Row player) {
        jpa.save(player);
    }

    public Row get(long id) {
        return jpa.findById(id).get();
    }

    public void delete(long id) {
        jpa.deleteById(id);
    }
}