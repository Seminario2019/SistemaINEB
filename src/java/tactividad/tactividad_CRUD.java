/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tactividad;

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
public class tactividad_CRUD {
    
    
     Servlet.Conexion conn =  new Servlet.Conexion();
   
         
    public JSONArray lista() {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT ID_TIPO_ACTIVIDAD as id,rtrim(NOMBRE) as nombre FROM TIPO_ACTIVIDAD order by ID_TIPO_ACTIVIDAD desc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("nombre", rs.getString("nombre"));
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(tactividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    public JSONArray busca(String actividad) {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT ID_TIPO_ACTIVIDAD as id,rtrim(NOMBRE) as nombre FROM TIPO_ACTIVIDAD "
              + "where ID_TIPO_ACTIVIDAD = "+actividad+" order by ID_TIPO_ACTIVIDAD desc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("nombre", rs.getString("nombre"));
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(tactividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    public JSONArray nuevo(String nombre) {
       JSONArray list = new JSONArray();   
     String list1 = "[{\"mensaje\":\"uno\"}]";
       int id1 = 0;
    try {
      Connection con = conn.DBConect();
      Statement stmt1 = con.createStatement();
   
      ResultSet rs = stmt1.executeQuery("select max(ID_TIPO_ACTIVIDAD)+1 as id from TIPO_ACTIVIDAD; ");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "INSERT INTO TIPO_ACTIVIDAD (ID_TIPO_ACTIVIDAD,NOMBRE) \n" +
                     "VALUES  (?,?)";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,id1);
                                stmt.setString(2,nombre);
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
               Logger.getLogger(tactividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(tactividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
 
  public JSONArray GuardaEdit(String id,String nombre) {
       JSONArray list = new JSONArray();   
     
    try {
      Connection con = conn.DBConect();
      
   String query = "UPDATE tipo_actividad \n" +
"               SET NOMBRE = ? \n" +
"                WHERE  ID_TIPO_ACTIVIDAD= ?";
      PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setString(1,nombre);
                                stmt.setInt(2,Integer.parseInt(id));
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
               Logger.getLogger(tactividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(tactividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
}
