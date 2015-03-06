package com.ppsinfo.test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
 
    private String userName;
 
    public String getUserName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SQLException {
        return userName+" ici on peut ajouter des infos ";
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
     
}