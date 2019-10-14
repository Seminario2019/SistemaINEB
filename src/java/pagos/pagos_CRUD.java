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
      ResultSet rs = stmt.executeQuery("SELECT\n" +
"  case when MAX(codigo_pago) IS NULL then 1\n" +
"else MAX(codigo_pago) +1   END AS id\n" +
"FROM  pago ");
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
      ResultSet rs = stmt.executeQuery("SELECT t0.CODIGO_PAGO, T0.TIPO_PAGO, T0.FECHA_PAGO\n" +
"FROM pago T0\n" +
"order by t0.CODIGO_PAGO asc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("codigo", rs.getString("CODIGO_PAGO"));
            obj.put("pago", rs.getString("TIPO_PAGO"));
            obj.put("nfecha", rs.getString("FECHA_PAGO"));
            
                 
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
   
      ResultSet rs = stmt1.executeQuery("SELECT\n" +
"  case when MAX(codigo_pago) IS NULL then 1\n" +
"else MAX(codigo_pago) +1   END AS id\n" +
"FROM  pago ");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      con = conn.DBConect();
      String query = "INSERT INTO pago (CODIGO_PAGO,TIPO_PAGO,FECHA_PAGO) \n" +
                     "VALUES  (?,?,'"+nfecha+"')";
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
   String query = "UPDATE pago \n" +                   
"               SET TIPO_PAGO = ? \n" +
"               , FECHA_PAGO = '"+nfecha+"' \n" +
"                WHERE  CODIGO_PAGO = ?";
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
