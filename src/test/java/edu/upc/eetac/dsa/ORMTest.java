package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.User;
import org.junit.Assert;
import org.junit.Test;

public class ORMTest {

    @Test
    public void getUserTest() {
        IUserDAO userDAO = new UserDAOImpl();
        User user5 = userDAO.getUser(61);
        Assert.assertEquals("Cristian", user5.getName());
    }

    public void getUserTest2() {
        IUserDAO userDAO = new UserDAOImpl();
        User user5 = userDAO.getUserByEmail("Borja@gmail.com");
        Assert.assertEquals("Cristian", user5.getName());
    }

    public void getGameObjectTest() {
        IUserDAO userDAO = new UserDAOImpl();
        //GameObject user5 = gameDAO.getGameObject(61);
        //Assert.assertEquals("Cristian", user5.getName());
    }
}
