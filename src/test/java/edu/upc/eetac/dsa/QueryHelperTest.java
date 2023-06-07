package edu.upc.eetac.dsa;
import edu.upc.eetac.dsa.model.User;
import edu.upc.eetac.dsa.model.Deparment;
import edu.upc.eetac.dsa.model.Employee;
import edu.upc.eetac.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;


public class QueryHelperTest {

    IUserDAO em = UserDAOImpl.getInstance();
    Session session = null;


       @Test
     public void test1() {
            try {
                session = FactorySession.openSession();
            HashMap<String, Object> params = new HashMap();
                params.put("email", "borja@com.com");

                Object entity = User.class.newInstance();
                if(params.isEmpty()==false) {
                    String sql = QueryHelper.createSELECT1(entity, params);

                    Assert.assertEquals("SELECT * FROM User WHERE  = ? ", sql);
                }else {
                    System.out.println("rellena el HashMap");
                }

            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }

    @Test
    public void test2() {
            try {
                session = FactorySession.openSession();
                HashMap<String, Object> params = new HashMap();
                params.put("email", "borja@com.com");
                params.put("estado", true);
                params.put("nivel", "1");
                Object entity = User.class.newInstance();
                String sql = QueryHelper.createSELECT1(entity, params);

                Assert.assertEquals("SELECT * FROM User WHERE estado = ? AND nivel=? AND email=?", sql);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

}


    @Test
   public void test3() {
           try {
               session = FactorySession.openSession();

               HashMap<String, Object> params = new HashMap();
               params.put("email", "borja@com.com");
               params.put("estado", true);
               params.put("nivel", "1");
               params.put("rol", "ADMIN");
               Object entity = User.class.newInstance();
               String sql = QueryHelper.createSELECT1(entity, params);

               Assert.assertEquals("SELECT * FROM User WHERE email = ? AND estado=? AND nivel=? AND role=?", sql);
           }catch (InstantiationException e) {
               throw new RuntimeException(e);
           } catch (IllegalAccessException e) {
               throw new RuntimeException(e);
           }




        }
/*
    @Test
    public void testQueryINSERT() {
        Assert.assertEquals("INSERT INTO Employee (ID, name, surname, salary) VALUES (?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new Employee("Juan", "lopez", 333333)));
    }

    @Test
    public void testQueryINSERT2() {
        Assert.assertEquals("INSERT INTO Deparment (ID, name, description) VALUES (?, ?, ?)",
                QueryHelper.createQueryINSERT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA")));
    }

    @Test
    public void testQuerySELECT() {
        Assert.assertEquals("SELECT * FROM Employee WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Employee("Juan", "lopez", 333333), "id"));
    }

    @Test
    public void testQuerySELECT2() {
        Assert.assertEquals("SELECT * FROM Deparment WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA"), "id"));
    }

    @Test
    public void testusuario(){
        if(em.size()==0) {
            em.addUser("Juan", "Juan@gmail.com", "12345");
            em.addUser("Javi", "Javi@gmail.com", "56789");
            em.addUser("Nil", "Nil@gmail.com", "283445");
            em.addUser("Jose", "Jose@gmail.com", "109345");
            em.addUser("Cristian", "Cristian@gmail.com", "109456");
            em.addUser("Borja", "Borja@gmail.com", "478356");
        }

       /* Assert.assertEquals("SELECT * FROM User",
                QueryHelper.createSELECT(new User(12, "ENGINYERIA TELEMÀTICA")));
    }
*/
}
