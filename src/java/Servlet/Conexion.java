package Servlet;


import java.sql.*;
import java.util.*;

public class Conexion {

  public Conexion(){
  }

    public synchronized Connection DBConect(){
    String driver = "com.mysql.jdbc.Driver";
    String connectString = "jdbc:mysql://localhost:3306/imnebpc_sistemained";
    String user = "imnebpc_sistemained";
    String password = "Nsm087152*";
    Connection con = null;
    try{
      Class.forName(driver);
      con = DriverManager.getConnection(connectString,user,password);
      System.out.println("Base de datos conectado");
    }catch(Exception e){
      System.out.println("error: "+e.getMessage());
    }
    return con;
  }


};
  