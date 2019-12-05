/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagos;


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
public class pagos_CRUD {
    
      Servlet.Conexion conn =  new Servlet.Conexion();
      
    public JSONArray correlativo() {
         JSONArray list = new JSONArray();
    
           try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select\n" +
"  case when max(codigo_pago) is null then 1\n" +
"else max(codigo_pago) +1   end as id\n" +
"from  pago");
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
              Logger.getLogger(pagos_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
    };
      
    public JSONArray lista() {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select t0.codigo_pago, t0.tipo_pago, t0.fecha_pago\n" +
"from pago t0\n" +
"order by t0.codigo_pago asc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("codigo", rs.getString("codigo_pago"));
            obj.put("pago", rs.getString("tipo_pago"));
            obj.put("nfecha", rs.getString("fecha_pago"));
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(pagos_CRUD.class.getName()).log(Level.SEVERE, null, ex);
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
              Logger.getLogger(pagos_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    public JSONArray nuevo(String codigo,String pago,String nfecha) {
       JSONArray list = new JSONArray();   
     String list1 = "[{\"id\":0}]";
       int id1 = 0;
    try {
      Connection con = conn.DBConect();
      Statement stmt1 = con.createStatement();
   
      ResultSet rs = stmt1.executeQuery("select\n" +
"  case when max(codigo_pago) is null then 1\n" +
"else max(codigo_pago) +1   end as id\n" +
"from  pago ");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      con = conn.DBConect();
      String query = "insert into pago (codigo_pago,tipo_pago,fecha_pago) \n" +
"                     values  (?,?,'"+nfecha+"')";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,Integer.parseInt(codigo));
                                stmt.setString(2,pago);
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
               Logger.getLogger(pagos_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(pagos_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
 
  public JSONArray GuardaEdit(String codigo,String pago,String nfecha) {
            JSONArray list = new JSONArray();   
     
    try {
      Connection con = conn.DBConect();    
   String query = "update pago                    \n" +
"               set tipo_pago = ? \n" +
"               , fecha_pago = '"+nfecha+"' \n" +
"                where  codigo_pago = ?";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setString(1,pago);
                                stmt.setInt(2,Integer.parseInt(codigo));
				stmt.executeUpdate();
      stmt.close();
      con.close();
      JSONObject obj=new JSONObject();
      
            obj.put("id", codigo);
            
                 
            list.put(obj);
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", e.getMessage());
               list.put(obj);
           } catch (JSONException ex) {
               Logger.getLogger(pagos_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(pagos_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
}
