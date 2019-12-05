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
      ResultSet rs = stmt.executeQuery("select\n" +
"     case when max(correlativo) is null then 1\n" +
"        else max(correlativo) +1   end as id\n" +
"from  alumno; ");
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
      ResultSet rs = stmt.executeQuery("select t0.correlativo, t0.codigo_alumno, t0.primer_nombre, t0.segundo_nombre,t0.primer_apellido,t0.segundo_apellido, t0.fecha_nacimiento\n" +
"from alumno t0\n" +
"order by t0.correlativo asc");
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
      ResultSet rs = stmt.executeQuery("select id_tipo_actividad as id,rtrim(nombre) as nombre from tipo_actividad \n" +
"              where id_tipo_actividad = "+actividad+" order by id_tipo_actividad desc");
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
   
      ResultSet rs = stmt1.executeQuery("select\n" +
"     case when max(correlativo) is null then 1\n" +
"        else max(correlativo) +1   end as id\n" +
"from  alumno;");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "insert into alumno (correlativo,codigo_alumno,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,fecha_nacimiento) \n" +
"                     values  (?,?,?,?,?,?,'"+nfecha+"')";
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
      
   String query = "update alumno                    \n" +
"               set codigo_alumno = ? \n" +
"               , primer_nombre = ? \n" +
"               , segundo_nombre = ? \n" +
"               , primer_apellido = ? \n" +
"               , segundo_apellido = ? \n" +
"               , fecha_nacimiento = '"+nfecha+"' \n" +
"                where  correlativo = ?";
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
