/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author usuario
 */
public class Grados_CRUD {
    
    Servlet.Conexion conn =  new Servlet.Conexion();
    
    public JSONArray Grados_lista() {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT CODIGO_GRADO as id,rtrim(NOMBRE) as nombre,rtrim(SECCION) as seccion FROM GRADO order by CODIGO_GRADO desc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("nombre", rs.getString("nombre"));
            obj.put("seccion", rs.getString("seccion"));
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(Grados_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    public JSONArray Grado_busca(String grado) {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT CODIGO_GRADO as id,rtrim(nombre) as nombre ,rtrim(SECCION) as seccion  FROM grado "
              + "where CODIGO_GRADO = '"+grado+"' order by CODIGO_GRADO desc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("nombre", rs.getString("nombre"));
            obj.put("seccion", rs.getString("seccion"));
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(Grados_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    public JSONArray nuevo(String nombre,String seccion) {
       JSONArray list = new JSONArray();   
     String list1 = "[{\"mensaje\":\"uno\"}]";
        int id1 = 0;
    try {
      Connection con = conn.DBConect();
      Statement stmt1 = con.createStatement();
   
      ResultSet rs = stmt1.executeQuery("select max(CODIGO_GRADO)+1 as id from grado; ");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "INSERT INTO GRADO (CODIGO_GRADO,NOMBRE,SECCION) \n" +
                     "VALUES  (?,?,?)";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,id1);
                                stmt.setString(2,nombre);
                                stmt.setString(3,seccion);
				stmt.executeUpdate();
      stmt.close(); 
      con.close();
      JSONObject obj=new JSONObject();
            obj.put("mensaje", "uno");
            
                 
            list.put(obj);
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", e.getMessage());
               list.put(obj);
           } catch (JSONException ex) {
               Logger.getLogger(Grados_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(Grados_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
 
  public JSONArray Grados_GuardaEdit(String id,String nombre,String seccion) {
       JSONArray list = new JSONArray();   
     
    try {
      Connection con = conn.DBConect();
      
       String query = "UPDATE grado \n" +
"               SET NOMBRE = ? \n" +
"               , SECCION = ? \n" +
"                WHERE  CODIGO_GRADO= ?";
      PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setString(1,nombre);
                                stmt.setString(2,seccion);
                                stmt.setString(3,id);
				stmt.executeUpdate();
      stmt.close();
      con.close();
      JSONObject obj=new JSONObject();
      
            obj.put("mensaje", "uno");
            
                 
            list.put(obj);
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", e.getMessage());
               list.put(obj);
           } catch (JSONException ex) {
               Logger.getLogger(Grados_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(Grados_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
}
