/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notas;


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
public class notas_CRUD {
   
         Servlet.Conexion conn =  new Servlet.Conexion();
      
    public JSONArray correlativo() {
         JSONArray list = new JSONArray();
    
           try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select case when max(id_nota) is null then 1 else max(id_nota) +1 end as id from registro_nota;");
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
              Logger.getLogger(notas_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
    };
      
    public JSONArray lista() {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select t0.id_nota as id, t0.nota,t0.periodo, t1.id_actividad,t2.nombre, t3.correlativo,concat(t3.primer_nombre,\" \",t3.segundo_nombre,\" \", t3.primer_apellido) as nalumno\n" +
"from registro_nota t0\n" +
"inner join actividad t1 on t1.id_actividad = t0.actividad_id_actividad\n" +
"inner join tipo_actividad t2 on t2.id_tipo_actividad = t1.id_tipo_actividad\n" +
"inner join alumno t3 on t3.correlativo = t0.usuario_id_usuario\n" +
"order by t0.id_nota asc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("nota", rs.getString("nota"));
            obj.put("periodo", rs.getString("periodo"));
            obj.put("id_actividad", rs.getString("id_actividad"));
            obj.put("actividad", rs.getString("nombre"));
            obj.put("id_alumno", rs.getString("correlativo"));
            obj.put("alumno", rs.getString("nalumno"));
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(notas_CRUD.class.getName()).log(Level.SEVERE, null, ex);
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
              Logger.getLogger(notas_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    public JSONArray nuevo(String id,String id_actividad,String id_alumno,String nota,String periodo) {
       JSONArray list = new JSONArray();   
     String list1 = "[{\"id\":0}]";
       int id1 = 0;
    try {
      Connection con = conn.DBConect();
      Statement stmt1 = con.createStatement();
   ResultSet rs = stmt1.executeQuery("select case when max(id_nota) is null then 1 else max(id_nota) +1 end as id from registro_nota;");
     
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "insert into registro_nota (id_nota,usuario_id_usuario,actividad_id_actividad,nota,periodo) \n" +
"                     values  (?,?,?,?,?)";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,id1);
                                stmt.setInt(2,Integer.parseInt(id_alumno));
                                stmt.setInt(3,Integer.parseInt(id_actividad));
                                stmt.setInt(4,Integer.parseInt(nota));
                                stmt.setString(5,periodo);
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
               Logger.getLogger(notas_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(notas_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
 
  public JSONArray GuardaEdit(String id,String id_actividad,String id_alumno,String nota,String periodo) {
       JSONArray list = new JSONArray();   
     
    try {
      Connection con = conn.DBConect();
                        
   String query = "update registro_nota \n" +
"               set usuario_id_usuario = ? \n" +
"               , actividad_id_actividad = ? \n" +
"               , nota = ? \n" +
"               , periodo = ? \n" +
"                where  id_nota= ?";
      PreparedStatement stmt = con.prepareStatement(query);
                               
                                
                                stmt.setInt(1,Integer.parseInt(id_alumno));
                                stmt.setInt(2,Integer.parseInt(id_actividad));
                                stmt.setInt(3,Integer.parseInt(nota));
                                stmt.setString(4,periodo);
                                stmt.setInt(5,Integer.parseInt(id));
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
               Logger.getLogger(notas_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(notas_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }

    
    
}
