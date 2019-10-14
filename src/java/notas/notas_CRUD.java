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
      ResultSet rs = stmt.executeQuery("SELECT case when MAX(ID_NOTA) IS NULL then 1 else MAX(ID_NOTA) +1 END AS id FROM registro_nota; ");
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
      ResultSet rs = stmt.executeQuery("SELECT t0.ID_NOTA as id, t0.NOTA,t0.PERIODO, t1.ID_ACTIVIDAD,t2.NOMBRE, t3.CORRELATIVO,CONCAT(t3.PRIMER_NOMBRE,\" \",T3.SEGUNDO_NOMBRE,\" \", t3.PRIMER_APELLIDO) as nalumno\n" +
"FROM registro_nota t0\n" +
"INNER JOIN actividad t1 on t1.ID_ACTIVIDAD = t0.ACTIVIDAD_ID_ACTIVIDAD\n" +
"INNER JOIN tipo_actividad t2 on t2.ID_TIPO_ACTIVIDAD = t1.ID_TIPO_ACTIVIDAD\n" +
"INNER JOIN alumno t3 on t3.CORRELATIVO = t0.USUARIO_ID_USUARIO\n" +
"order by t0.ID_NOTA asc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("nota", rs.getString("NOTA"));
            obj.put("periodo", rs.getString("PERIODO"));
            obj.put("id_actividad", rs.getString("ID_ACTIVIDAD"));
            obj.put("actividad", rs.getString("NOMBRE"));
            obj.put("id_alumno", rs.getString("CORRELATIVO"));
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
   ResultSet rs = stmt1.executeQuery("SELECT case when MAX(ID_NOTA) IS NULL then 1 else MAX(ID_NOTA) +1 END AS id FROM registro_nota; ");
     
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "INSERT INTO registro_nota (ID_NOTA,USUARIO_ID_USUARIO,ACTIVIDAD_ID_ACTIVIDAD,NOTA,PERIODO) \n" +
                     "VALUES  (?,?,?,?,?)";
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
                        
   String query = "UPDATE registro_nota \n" +
"               SET USUARIO_ID_USUARIO = ? \n" +
"               , ACTIVIDAD_ID_ACTIVIDAD = ? \n" +
"               , NOTA = ? \n" +
"               , PERIODO = ? \n" +
"                WHERE  ID_NOTA= ?";
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
