package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Deparment;
import edu.upc.eetac.dsa.model.Employee;
import edu.upc.eetac.dsa.model.User;
import edu.upc.eetac.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Test;

public class QueryHelperTest {

    IEmployeeDAO em = EmployeeDAOImpl.getInstance();

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
                QueryHelper.createQuerySELECT(new Employee("Juan", "lopez", 333333)));
    }

    @Test
    public void testQuerySELECT2() {
        Assert.assertEquals("SELECT * FROM Deparment WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA")));
    }

    @Test
    public void testusuario(){
        em.addUser("Juan","Juan@gmail.com","12345");
//        Assert.assertTrue(em.login("email","12345"));
       /* Assert.assertEquals("SELECT * FROM User",
                QueryHelper.createSELECT(new User(12, "ENGINYERIA TELEMÀTICA")));*/
    }

}
