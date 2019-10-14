/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad;

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
public class actividad_CRUD {
          Servlet.Conexion conn =  new Servlet.Conexion();
      
    public JSONArray correlativo() {
         JSONArray list = new JSONArray();
    
           try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT\n" +
"     case when MAX(ID_ACTIVIDAD) IS NULL then 1\n" +
"        else MAX(ID_ACTIVIDAD) +1   END AS id\n" +
"FROM  ACTIVIDAD; ");
       while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(actividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
    };
      
    public JSONArray lista() {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT T0.ID_ACTIVIDAD as id,t0.CODIGO_ASIGNATURA as id_signatura,t1.NOMBRE_CURSO as asignatura, t0.ID_TIPO_ACTIVIDAD as id_tactividad,t2.NOMBRE as tactividad \n" +
"FROM actividad t0\n" +
"INNER JOIN asignatura t1 on t1.CODIGO_ASIGNATURA = t0.CODIGO_ASIGNATURA\n" +
"INNER JOIN tipo_actividad t2 on t2.ID_TIPO_ACTIVIDAD = t0.ID_TIPO_ACTIVIDAD\n" +
"order by T0.ID_ACTIVIDAD asc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("id_asignatura", rs.getString("id_signatura"));
            obj.put("asignatura", rs.getString("asignatura"));
            obj.put("id_tactividad", rs.getString("id_tactividad"));
            obj.put("tactividad", rs.getString("tactividad"));
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(actividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
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
              Logger.getLogger(actividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    public JSONArray nuevo(String id,String id_tactividad,String id_asignatura) {
       JSONArray list = new JSONArray();   
     String list1 = "[{\"id\":0}]";
       int id1 = 0;
    try {
      Connection con = conn.DBConect();
      Statement stmt1 = con.createStatement();
   
      ResultSet rs = stmt1.executeQuery("SELECT\n" +
"     case when MAX(ID_ACTIVIDAD) IS NULL then 1\n" +
"        else MAX(ID_ACTIVIDAD) +1   END AS id\n" +
"FROM  ACTIVIDAD; ");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "INSERT INTO ACTIVIDAD (ID_ACTIVIDAD,CODIGO_ASIGNATURA,ID_TIPO_ACTIVIDAD) \n" +
                     "VALUES  (?,?,?)";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,id1);
                                stmt.setInt(2,Integer.parseInt(id_asignatura));
                                stmt.setInt(3,Integer.parseInt(id_tactividad));
				stmt.executeUpdate();
      stmt.close(); 
      con.close();
      JSONObject obj=new JSONObject();
            obj.put("id", id1);
            
                 
            list.put(obj);
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", e.getMessage());
               list.put(obj);
           } catch (JSONException ex) {
               Logger.getLogger(actividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(actividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
 
  public JSONArray GuardaEdit(String id,String id_tactividad,String id_asignatura) {
       JSONArray list = new JSONArray();   
     
    try {
      Connection con = conn.DBConect();
   String query = "UPDATE ACTIVIDAD \n" +
"               SET CODIGO_ASIGNATURA = ? \n" +
"               , ID_TIPO_ACTIVIDAD = ? \n" +
"                WHERE  ID_ACTIVIDAD= ?";
      PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,Integer.parseInt(id_asignatura));
                                stmt.setInt(2,Integer.parseInt(id_tactividad));
                                stmt.setInt(3,Integer.parseInt(id));
				stmt.executeUpdate();
      stmt.close();
      con.close();
      JSONObject obj=new JSONObject();
      
            obj.put("id", id);
            
                 
            list.put(obj);
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", e.getMessage());
               list.put(obj);
           } catch (JSONException ex) {
               Logger.getLogger(actividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(actividad_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
}
