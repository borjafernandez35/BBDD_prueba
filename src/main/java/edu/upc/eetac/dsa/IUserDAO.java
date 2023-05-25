package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Employee;
import edu.upc.eetac.dsa.model.User;

import java.util.List;

public interface IUserDAO {

    public int addUser ( String name, String email, String password );

    public boolean login (String email, String password);

    public int size();

    public int addEmployee(String name, String surname, double salary);
    public Employee getEmployee(int employeeID);
    public User getUser(int UserID);
    public void updateEmployee(int employeeID, String name, String surname, double salary);
    public void deleteEmployee(int employeeID);
    public List<Employee> getEmployees();
    public List <Employee> getEmployeeByDept(int deptId);
    public List<Object> getAll();

    User getUserByEmail(String s);
}
