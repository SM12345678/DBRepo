package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;
 
 
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
 
/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class ContactDAO implements IContactDAO {
 
    private JdbcTemplate jdbcTemplate;
 
    public ContactDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
    @Override
    public void saveOrUpdate(contact contact) {
        // implementation details goes here...
    }
 
    @Override
    public void delete(int contactId) {
        // implementation details goes here...
    }
 
    @Override
    public List<contact> list() {
    	return jdbcTemplate.query( "select * from books",(rs, rowNum) ->
        new contact( rs.getString("name"),rs.getString("email"), rs.getString("country")));
    }
 
    @Override
    public contact get(int contactId) {
    	
        // implementation details goes here...
    	return null;
    }
 
}