package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.User;
import edu.upc.eetac.dsa.util.ObjectHelper;
import edu.upc.eetac.dsa.util.QueryHelper;

import java.beans.IntrospectionException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {


        String insertQuery = QueryHelper.createQueryINSERT(entity);

        PreparedStatement pstm = null;


        try {
            pstm = conn.prepareStatement(insertQuery);
           pstm.setObject(1, 0);
            int i = 2;

            String[] fields=ObjectHelper.getFields(entity);
            for (String field: fields) {
                if(!field.equals("id")) {
                    pstm.setObject(i++, ObjectHelper.getter(entity, field));
                }
            }

            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close() {

    }
    public Object get(Class theClass, int ID) throws InstantiationException, IllegalAccessException {
        return get(theClass, "id", ID);
    }

    public Object get(Class theClass, String pk, Object value) throws InstantiationException, IllegalAccessException {

        Object entity = theClass.newInstance();
        String selectQuery = QueryHelper.createQuerySELECT(entity, pk);

        PreparedStatement pstm = null;
        ResultSet rs= null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, value);

            rs=pstm.executeQuery();
            ResultSetMetaData rsmd  = rs.getMetaData();

            if (rs.next()){

                int k= rsmd.getColumnCount();

                for(int v=1; v<=k; v++){

                        ObjectHelper.setter(entity, rsmd.getColumnName(v), rs.getObject(v) );


                }


                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
                System.out.println(rs.getObject(4));

                System.out.println(rsmd.getColumnCount());
                System.out.println(rsmd.getColumnName(1));
                System.out.println(rsmd.getColumnName(2));
                System.out.println(rsmd.getColumnName(3));
                System.out.println(rsmd.getColumnName(4));

                System.out.println(rsmd.getColumnType(1));
                System.out.println(rsmd.getColumnType(2));
                System.out.println(rsmd.getColumnType(3));
                System.out.println(rsmd.getColumnType(4));

                return entity;

                              // ObjectHelper.setter(entity,pk, value );
            }

      }  catch (SQLException | IntrospectionException   e) {
            e.printStackTrace();
        }

        return null;

    }

    public User getPorEmail(User user, String email) {
        return null;
    }

    public void update(Object object) {

    }

    public void delete(Object object) {

    }

    public List<Object> findAll(Class theClass) {
        return null;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }
}
