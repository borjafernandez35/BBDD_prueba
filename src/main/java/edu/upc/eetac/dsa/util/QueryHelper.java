package edu.upc.eetac.dsa.util;
import java.util.HashMap;
import java.util.Iterator;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String[] fields = ObjectHelper.getFields(entity);



        sb.append("id");
        for (String field : fields) {
            if (!field.contains("id")) {
                sb.append(", ").append(field);
           }
        }


        sb.append(") VALUES (?");

        for (String field : fields) {
          if (!field.contains("id")&!field.contains("password")) {
                sb.append(", ?");
           }else if(field.contains("password")){
              sb.append(", PASSWORD(?)");
          }
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Object entity, String pk) {
        String password="password";
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());

        sb.append(" WHERE " + pk + " = ?");


        return sb.toString();
    }
    public static String createQueryDELETE(Object entity, String pk) {
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE  FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE "+pk+" = ?");

        return sb.toString();
    }

    public static String createSELECT(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        return sb.toString();

    }
    public static String createPASSWORD() {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT PASSWORD (?)");
        return sb.toString();

    }

    public static String createQuerySELECT1(Object entity, String clave, String clave1) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE "+clave+" = ?");

            sb.append(" AND  " + clave1 + " = ?");


        return sb.toString();
    }
    public static String createQuerySELECT2(Object entity, HashMap params) {
        StringBuffer sb = new StringBuffer();
        Iterator<String>clave=params.keySet().iterator();
        if(params.isEmpty()==false) {
            sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
            sb.append(" WHERE " + clave.next() + " = ?");
            while (clave.hasNext() == true) {
                sb.append(" AND  " + clave.next() + " = ?");
            }
        }

        return sb.toString();
    }
    public static String createQueryUPDATE(Object entity) {

        String [] fields = ObjectHelper.getFields(entity);
        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("SET ");
        String field;
        int i =1;
        while (i<fields.length){
            field = fields[i];

            if (i>1&!field.contains("password")&!field.contains("dsaCoins")) {

                sb.append(" = ?, ");
                sb.append(field);
            }else if(field.contains("password")){
                sb.append(" = ?, ");
                sb.append(field);
                sb.append(" = PASSWORD(?), ");
            }else if(i==1||field.contains("dsaCoins")){
                sb.append(field);
            }

            i++;
        }
        sb.append(" = ?");
        sb.append(" WHERE id = ?");

        return sb.toString();
    }
    public static String createSELECT1(Object entity, HashMap params) {
        Iterator<String>clave=params.keySet().iterator();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE "+clave.next()+" = ?");
        while (clave.hasNext()==true){
            sb.append(" AND  " + clave.next() + " = ?");

        }




        return sb.toString();
    }
}
