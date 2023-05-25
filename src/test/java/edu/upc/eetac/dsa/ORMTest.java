package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ORMTest {

    IUserDAO userDAO = new UserDAOImpl();
    @Test
    public void getUserTest() {

       /* User user5 = userDAO.getUser(61);
        Assert.assertEquals("Cristian", user5.getEmail());*/
        User user2 = userDAO.getUser(76);
        Assert.assertEquals("Javi", user2.getEmail());
    }
    @Test
    public void getLoginTest(){
//      Assert.assertTrue(userDAO.login("Borja@gmail.com", "478356"));
        Assert.assertTrue(userDAO.login("Borja@gmail.com", "12345"));
        IUserDAO userDAO = new UserDAOImpl();
        User user5 = userDAO.getUser(1);
        Assert.assertEquals("jose@gmail.com", user5.getEmail());
        User user2 = userDAO.getUser(2);
        Assert.assertEquals("jose2@gmail.com", user2.getEmail());
    }

    @Test
    public void getUserTest2() {

        User user5 = userDAO.getUserByEmail("Borja@gmail.com");
        Assert.assertEquals("Cristian", user5.getName());
        IUserDAO userDAO = new UserDAOImpl();
        User user3 = userDAO.getUserByEmail("jose2@gmail.com");
        Assert.assertEquals("Jose", user3.getName());
    }

    public void getGameObjectTest() {
        IUserDAO userDAO = new UserDAOImpl();
        //GameObject user5 = gameDAO.getGameObject(61);
        //Assert.assertEquals("Cristian", user5.getName());
    }
    @Test
    public void getObjectsTest() {
        UserDAOImpl shopDAO = new UserDAOImpl ();
        List list = shopDAO.getAll();
        // select * from object

    }
   /* public void getObjectsTest() {
        IShopDAO shopDAO = new ShopDAOImpl();
        List<Object> list = shopDAO.getObject();
        // select * from object
    }*/

    /*
    public void getObjectsTest3() {
        IShopDAO shopDAO = new ShopDAOImpl();
        String category ="CAT1";
        boolean enabled = true;

        HashMap<String, Object> params = new HashMap<>();
        params.put("idUser", 60);


        List<Object> list = shopDAO.inventario(params);
        // Select * from object WHERE categoria = "CAT1" AND state = "true" AND x = b AND y=x AND
    }
*/
}
