/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;

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
public class alumno_CRUD {
    
     Servlet.Conexion conn =  new Servlet.Conexion();
      
    public JSONArray correlativo() {
         JSONArray list = new JSONArray();
    
           try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT\n" +
"     case when MAX(CORRELATIVO) IS NULL then 1\n" +
"        else MAX(CORRELATIVO) +1   END AS id\n" +
"FROM  ALUMNO; ");
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
              Logger.getLogger(alumno_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
    };
      
    public JSONArray lista() {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT t0.CORRELATIVO, T0.CODIGO_ALUMNO, T0.PRIMER_NOMBRE, T0.SEGUNDO_NOMBRE,T0.PRIMER_APELLIDO,T0.SEGUNDO_APELLIDO, T0.FECHA_NACIMIENTO\n" +
"FROM alumno T0\n" +
"order by t0.CORRELATIVO asc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("correlativo", rs.getString("CORRELATIVO"));
            obj.put("codigo", rs.getString("CODIGO_ALUMNO"));
            obj.put("pnombre", rs.getString("PRIMER_NOMBRE"));
            obj.put("snombre", rs.getString("SEGUNDO_NOMBRE"));
            obj.put("papellido", rs.getString("PRIMER_APELLIDO"));
            obj.put("sapellido", rs.getString("SEGUNDO_APELLIDO"));
            obj.put("nfecha", rs.getString("FECHA_NACIMIENTO"));
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(alumno_CRUD.class.getName()).log(Level.SEVERE, null, ex);
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
              Logger.getLogger(alumno_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    public JSONArray nuevo(String correlativo,String codigo,String pnombre,String snombre,String papellido,String sapellido,String nfecha) {
       JSONArray list = new JSONArray();   
     String list1 = "[{\"id\":0}]";
       int id1 = 0;
    try {
      Connection con = conn.DBConect();
      Statement stmt1 = con.createStatement();
   
      ResultSet rs = stmt1.executeQuery("SELECT\n" +
"     case when MAX(CORRELATIVO) IS NULL then 1\n" +
"        else MAX(CORRELATIVO) +1   END AS id\n" +
"FROM  ALUMNO; ");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "INSERT INTO ALUMNO (CORRELATIVO,CODIGO_ALUMNO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,FECHA_NACIMIENTO) \n" +
                     "VALUES  (?,?,?,?,?,?,'"+nfecha+"')";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,Integer.parseInt(correlativo));
                                stmt.setInt(2,Integer.parseInt(codigo));
                                stmt.setString(3,pnombre);
                                stmt.setString(4,snombre);
                                stmt.setString(5,papellido);
                                stmt.setString(6,sapellido);
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
               Logger.getLogger(alumno_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(alumno_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
 
  public JSONArray GuardaEdit(String correlativo,String codigo,String pnombre,String snombre,String papellido,String sapellido,String nfecha) {
            JSONArray list = new JSONArray();   
     
    try {
      Connection con = conn.DBConect();
      
   String query = "UPDATE alumno \n" +                   
"               SET CODIGO_ALUMNO = ? \n" +
"               , PRIMER_NOMBRE = ? \n" +
"               , SEGUNDO_NOMBRE = ? \n" +
"               , PRIMER_APELLIDO = ? \n" +
"               , SEGUNDO_APELLIDO = ? \n" +
"               , FECHA_NACIMIENTO = '"+nfecha+"' \n" +
"                WHERE  CORRELATIVO = ?";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,Integer.parseInt(codigo));
                                stmt.setString(2,pnombre);
                                stmt.setString(3,snombre);
                                stmt.setString(4,papellido);
                                stmt.setString(5,sapellido);
                                stmt.setInt(6,Integer.parseInt(correlativo));
				stmt.executeUpdate();
      stmt.close();
      con.close();
      JSONObject obj=new JSONObject();
      
            obj.put("id", correlativo);
            
                 
            list.put(obj);
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", e.getMessage());
               list.put(obj);
           } catch (JSONException ex) {
               Logger.getLogger(alumno_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(alumno_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
}
