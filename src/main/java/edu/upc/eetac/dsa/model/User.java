package edu.upc.eetac.dsa.model;


import java.util.Objects;

public class User {
    private int id;

  private  String name;

   private String email;

  private  String password;
   private Double dsaCoins=500.0;
   private String photo;

    public Double getDsaCoins() {
        return dsaCoins;
    }

    public void setDsaCoins(Double dsaCoins) {
        this.dsaCoins = dsaCoins;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(){}
    public User(int id, String name,String email, String password, double dsaCoins, String photo){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.dsaCoins=dsaCoins;
        this.photo=photo;



    }
    public User( String password){


        this.password=password;




    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User(String name, String email, String password, String photo) {
        /*IEmployeeDAO id = EmployeeDAOImpl.getInstance();
        this.id = id.addUser(name, email, password);*/
        this.name = name;
        this.email=email;
        this.password=password;
        this.photo=photo;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
