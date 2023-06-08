package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Employee;
import edu.upc.eetac.dsa.model.User;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class UserDAOImpl implements IUserDAO {

    private static IUserDAO instance;


    protected List<User> users;

    public static IUserDAO getInstance(){
        if (instance==null) instance = new UserDAOImpl();
        return instance;
    }

    public int addUser ( String name, String email, String password){

        Session session = null;
        int userID = 0;
        try {
            session = FactorySession.openSession();
            User u = new User(name, email, password);
            session.save(u);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return userID;

    }

    public boolean login (String email, String password){
        Session session = null;
        User usuario = null;
        try {
            session = FactorySession.openSession();
            usuario= getUserByEmail(email);
            if (usuario.getEmail().equals(email)&(usuario.getPassword().equals(password))){
                return true;
            }
            return false;
            /*User u = new User(email, password);
            session.save(u);*/
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return false;

    }
    public int size() {return 0;}

        /*try{
            String sql = "SELECT count(*) FROM ventas_clientes";
            pst =connect().prepareStatement(sql);
            rst = pst.executeQuery();
        }catch(Exception e){
            System.err.println("Error" + e);
        }
        if(rst == null){
            lblncomp.setText(num);
        }else{
            try{
                String sql = "SELECT ncomp FROM ventas_clientes";
                pst =connect().prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                    ncomp = rs.getString("ncomp");
                    entero = Integer.parseInt(ncomp);
                    total = entero +1;
                    total2 = Integer.toString(total);
                }
                lblncomp.setText(total2);
            }catch(Exception e){
                System.err.println("Error" + e);
            }
        }
    }
       *//* int ret = this.users.size();
       Log logger;
        logger.info("size " + ret);

        return ret;*//*
    }
*/



    public int addEmployee(String name, String surname, double salary) {
        Session session = null;
        int employeeID = 0;
        try {
            session = FactorySession.openSession();
            Employee employee = new Employee(name, surname, salary);
            session.save(employee);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return employeeID;
    }


    public Employee getEmployee(int employeeID) {
        Session session = null;
        Employee employee = null;
        try {
            session = FactorySession.openSession();
            employee = (Employee)session.get(Employee.class, employeeID);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return employee;
    }

    @Override
    public User getUser(int userID) {
        Session session = null;
        User user = null;
        try {
            session = FactorySession.openSession();
            user = (User) session.get(User.class, userID);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return user;
    }
    public List<Object> inventario(HashMap params){
        Session session = null;
        List listUser = new LinkedList();
        try {
            session = FactorySession.openSession();
            listUser =  session.findAll(User.class, params);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        System.out.println(listUser);


        return listUser;

    }

    public List<Object> getAll() {
        Session session = null;
        List listUser = new LinkedList();
        try {
            session = FactorySession.openSession();
            listUser =  session.findAll(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        System.out.println(listUser);


        return listUser;
    }
    public List<Object> findOut(String object) {
        Session session = null;
        List listUser = new LinkedList();
        try {
            session = FactorySession.openSession();
            listUser =  session.find(User.class, object);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        System.out.println(listUser);


        return listUser;
    }
    public void updateUser( String name, String email, String password, double dsaCoins){
        int id=0;
        User us = new User(id,name,email,password,dsaCoins);
        User u = null;

        Session session = null;
        try {
            session = FactorySession.openSession();
            u=getUserByEmail(email);
            if(u.getEmail().equals(email)) {
                us.setId(u.getId());
                session.update(us);
            }
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }


    public void updateEmployee(int employeeID, String name, String surname, double salary) {
        Employee employee = this.getEmployee(employeeID);
        employee.setName(name);
        employee.setSurname(surname);
        employee.setSalary(salary);

        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(Employee.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }


    public void deleteEmployee(int employeeID) {
        Employee employee = this.getEmployee(employeeID);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(Employee.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

    }


    public List<Employee> getEmployees() {
        Session session = null;
        List<Employee> employeeList=null;
        try {
            session = FactorySession.openSession();
            employeeList = session.findAll(Employee.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return employeeList;
    }


    public List<Employee> getEmployeeByDept(int deptID) {

        Session session = null;
        List<Employee> employeeList=null;
        try {
            session = FactorySession.openSession();

            HashMap<String, Integer> params = new HashMap<String, Integer>();
            params.put("deptID", deptID);

            employeeList = session.findAll(Employee.class, params);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return employeeList;
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = null;
        User user = null;
        try {
            session = FactorySession.openSession();
            user = (User) session.get(User.class, "email", email);

            // select * from user where email = ?
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return user;

    }






}
