package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.User;

import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(Object entity);
    void close();
    Object get(Class theClass, int ID) throws InstantiationException, IllegalAccessException;
    Object get(Class theClass, String pk, Object value) throws InstantiationException, IllegalAccessException;
    User getPorEmail(User user, String email);
    void update(Object object);
    void delete(Object object);
    List<Object> findAll(Class theClass);
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);
    public List<Object> find(Class theClass, String pk);
}
