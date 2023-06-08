package edu.upc.eetac.dsa;

import java.util.HashMap;
import java.util.List;

public interface IShopDAO {
    public int addAim ( String name, String description, String password );
    public List<Object> inventario(HashMap params);


}
