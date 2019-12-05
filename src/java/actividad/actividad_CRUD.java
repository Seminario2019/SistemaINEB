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
      ResultSet rs = stmt.executeQuery("select\n" +
"     case when max(id_actividad) is null then 1\n" +
"        else max(id_actividad) +1   end as id\n" +
"from  actividad; ");
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
      ResultSet rs = stmt.executeQuery("select t0.id_actividad as id,t0.codigo_asignatura as id_signatura,t1.nombre_curso as asignatura, t0.id_tipo_actividad as id_tactividad,t2.nombre as tactividad \n" +
"from actividad t0\n" +
"inner join asignatura t1 on t1.codigo_asignatura = t0.codigo_asignatura\n" +
"inner join tipo_actividad t2 on t2.id_tipo_actividad = t0.id_tipo_actividad\n" +
"order by t0.id_actividad asc");
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
   
      ResultSet rs = stmt1.executeQuery("select\n" +
"    case when max(id_actividad) is null then 1\n" +
"        else max(id_actividad) +1   end as id\n" +
"from  actividad;");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "insert into actividad (id_actividad,codigo_asignatura,id_tipo_actividad) \n" +
"                     values  (?,?,?)";
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
   String query = "update actividad \n" +
"               set codigo_asignatura = ? \n" +
"               , id_tipo_actividad = ? \n" +
"                where  id_actividad= ?";
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
