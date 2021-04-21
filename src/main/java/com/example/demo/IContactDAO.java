package com.example.demo;
 
import java.util.List;
 
 
/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface IContactDAO {
     
    public void saveOrUpdate(contact contact);
     
    public void delete(int contactId);
     
    public contact get(int contactId);
     
    public List<contact> list();
}