package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.User;
import edu.upc.eetac.dsa.util.ObjectHelper;
import edu.upc.eetac.dsa.util.QueryHelper;

import java.beans.IntrospectionException;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

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
                String columnName;
                Object valueRow=null;
                for(int v=1; v <= k; v++){
                    columnName = rsmd.getColumnName(v);
                    valueRow = rs.getObject(v);
                  //  ObjectHelper.setter(entity, pk, value);

                    ObjectHelper.setter(entity, columnName, valueRow);


                }


               /* System.out.println(rs.getObject(1));
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
*/
                return entity;


              //  ObjectHelper.setter(entity,rsmd.getColumnName(v),rs.getObject(v));
              //  ObjectHelper.setter(entity,"email" ,"a");
              // ObjectHelper.setter(entity,"password" ,"a");

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
        String insertQuery = QueryHelper.createQueryUPDATE(object);

        PreparedStatement pstm = null;


        try {
            pstm = conn.prepareStatement(insertQuery);


                String field;
                int i =1;
                while (i<ObjectHelper.getFields(object).length){
                    field = ObjectHelper.getFields(object)[i];
                    pstm.setObject(i++, ObjectHelper.getter(object, field));

                }
                pstm.setObject(i++, ObjectHelper.getter(object, ObjectHelper.getFields(object)[0]));
                pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public String getpassword(String p) {
        String insertQuery = QueryHelper.createPASSWORD();

        PreparedStatement pstm = null;
        ResultSet rs=null;
        String password=null;
       try {
            pstm = conn.prepareStatement(insertQuery);
//            pstm.setObject(3,value);
            pstm.setString(1, p);

           rs= pstm.executeQuery();
           if(rs.next())
          password=rs.getObject(1).toString();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;



    }

    public void delete(Object object, String pk) {
        /*String deleteQuery = QueryHelper.createQueryDELETE(object, pk);

        PreparedStatement pstm = null;
        ResultSet rs= null;

        try {
            pstm = conn.prepareStatement(deleteQuery);
            pstm.setObject(1, object);

            rs=pstm.executeQuery();
            ResultSetMetaData rsmd  = rs.getMetaData();

            if (rs.next()){

                int k= rsmd.getColumnCount();
                String columnName;
                Object valueRow=null;
                for(int v=1; v <= k; v++){
                    columnName = rsmd.getColumnName(v);
                    valueRow = rs.getObject(v);
                    //  ObjectHelper.setter(entity, pk, value);
                    ObjectHelper.setter(object, columnName, valueRow);


                }


                *//*System.out.println(rs.getObject(1));
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
                System.out.println(rsmd.getColumnType(4));*//*




                //  ObjectHelper.setter(entity,rsmd.getColumnName(v),rs.getObject(v));
                //  ObjectHelper.setter(entity,"email" ,"a");
                // ObjectHelper.setter(entity,"password" ,"a");

            }

        }  catch (SQLException | IntrospectionException   e) {
            e.printStackTrace();
        }*/



    }



    public List<Object> findAll(Class theClass) {

        List list= new LinkedList();
        try {
            Object entity = theClass.newInstance();
            String selectQuery = QueryHelper.createSELECT(entity);

            PreparedStatement pstm = null;
            ResultSet rs= null;


            pstm = conn.prepareStatement(selectQuery);

//            pstm.setObject(1, entity);

            rs=pstm.executeQuery();
            ResultSetMetaData rsmd  = rs.getMetaData();

            while (rs.next()){
                entity = theClass.newInstance();

                int k= rsmd.getColumnCount();
                String columnName;
                Object valueRow=null;
                for(int v=1; v <= k; v++) {
                    columnName = rsmd.getColumnName(v);
                    valueRow = rs.getObject(v);
                    //  ObjectHelpter.setter(entity, pk, value);
                    ObjectHelper.setter(entity, columnName, valueRow);
                }
                list.add(entity);


            }

            //return entity;

            //  ObjectHelper.setter(entity,rsmd.getColumnName(v),rs.getObject(v));
            //  ObjectHelper.setter(entity,"email" ,"a");
            // ObjectHelper.setter(entity,"password" ,"a");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }



        return list;
    }
    public List<Object> find(Class theClass, String pk) {

        List list= new LinkedList();
        try {
            Object entity = theClass.newInstance();
            String selectQuery = QueryHelper.createQuerySELECT(entity, pk);

            PreparedStatement pstm = null;
            ResultSet rs= null;


            pstm = conn.prepareStatement(selectQuery);

//            pstm.setObject(1, entity);

            rs=pstm.executeQuery();
            ResultSetMetaData rsmd  = rs.getMetaData();

            if (rs.next()){
                entity = theClass.newInstance();

                int k= rsmd.getColumnCount();
                String columnName;
                Object valueRow=null;
                for(int v=1; v <= k; v++) {
                    columnName = rsmd.getColumnName(v);
                    valueRow = rs.getObject(v);
                    //  ObjectHelpter.setter(entity, pk, value);
                    ObjectHelper.setter(entity, columnName, valueRow);
                }
                list.add(entity);


            }

            //return entity;

            //  ObjectHelper.setter(entity,rsmd.getColumnName(v),rs.getObject(v));
            //  ObjectHelper.setter(entity,"email" ,"a");
            // ObjectHelper.setter(entity,"password" ,"a");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }



        return list;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        List list= new LinkedList();
         try {
             int i=1;
             int b=2;
             /*String clave=null;
             String clave1=null;*/
            Object entity = theClass.newInstance();
            Iterator<String[]> iterator= params.keySet().iterator();
            String s= null;
            String password=null;
            int c=0;
            while(c< params.size()){
                if(params.containsKey("password")){
                s= params.get(iterator.next()).toString();
                password=getpassword(s);
                params.remove("password");
                params.put("password",password);
                c= params.size();
                }else {
                    c++;
                }
            }

             Iterator<String[]> iterator1= params.keySet().iterator();
             String selectQuery=QueryHelper.createQuerySELECT2(entity, params);

            PreparedStatement pstm = null;
            ResultSet rs= null;
            pstm = conn.prepareStatement(selectQuery);
          pstm.setObject(1, params.get(iterator1.next()));
          while(i<params.size()) {
              pstm.setObject(b, params.get(iterator1.next()));
              i++;
              b++;
          }


            rs=pstm.executeQuery();
            ResultSetMetaData rsmd  = rs.getMetaData();
            while (rs.next()){
                entity = theClass.newInstance();
                int k= rsmd.getColumnCount();
                String columnName;
                Object valueRow=null;
                for(int v=1; v <= k; v++) {
                    columnName = rsmd.getColumnName(v);
                    valueRow = rs.getObject(v);
                    //  ObjectHelpter.setter(entity, pk, value);
                    ObjectHelper.setter(entity, columnName, valueRow);
                }
                list.add(entity);


            }

            //return entity;

            //  ObjectHelper.setter(entity,rsmd.getColumnName(v),rs.getObject(v));
            //  ObjectHelper.setter(entity,"email" ,"a");
            // ObjectHelper.setter(entity,"password" ,"a");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }



         return list;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        List list= new LinkedList();
        try {
            String[]clave=null;
            Object entity = theClass.newInstance();
            Iterator<String[]> iterator= params.keySet().iterator();
            while(iterator.hasNext()) {
                clave=iterator.next();
            }
            String selectQuery=QueryHelper.createQuerySELECT2(entity, params);

            PreparedStatement pstm = null;
            ResultSet rs= null;
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, params.get(clave[0]));
            pstm.setObject(2, params.get(clave[1]));
            rs=pstm.executeQuery();
            ResultSetMetaData rsmd  = rs.getMetaData();
            while (rs.next()){
                entity = theClass.newInstance();
                int k= rsmd.getColumnCount();
                String columnName;
                Object valueRow=null;
                for(int v=1; v <= k; v++) {
                    columnName = rsmd.getColumnName(v);
                    valueRow = rs.getObject(v);
                    //  ObjectHelpter.setter(entity, pk, value);
                    ObjectHelper.setter(entity, columnName, valueRow);
                }
                list.add(entity);


            }

            //return entity;

            //  ObjectHelper.setter(entity,rsmd.getColumnName(v),rs.getObject(v));
            //  ObjectHelper.setter(entity,"email" ,"a");
            // ObjectHelper.setter(entity,"password" ,"a");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }



        return list;
    }
}
