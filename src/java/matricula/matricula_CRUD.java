/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricula;

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
public class matricula_CRUD {
  
     Servlet.Conexion conn =  new Servlet.Conexion();
      
    public JSONArray correlativo() {
         JSONArray list = new JSONArray();
    
           try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT\n" +
"     case when MAX(ID_MATRICULA) IS NULL then 1\n" +
"        else MAX(ID_MATRICULA) +1   END AS id\n" +
"FROM  matricula; ");
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
              Logger.getLogger(matricula_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
    };
      
    public JSONArray lista() {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT t0.ID_MATRICULA, T1.CODIGO_PAGO,T1.TIPO_PAGO,T2.ID_JORNADA,T2.DESCRIPCION,T3.CORRELATIVO, CONCAT(T3.PRIMER_NOMBRE,\" \",T3.SEGUNDO_NOMBRE,\" \",T3.PRIMER_APELLIDO) AS NOMBRE, T4.CODIGO_GRADO,T4.NOMBRE AS GRADO,\n" +
"t0.FECHA_MATRICULA,t0.VALOR\n" +
"FROM matricula T0\n" +
"INNER JOIN pago T1 ON T0.PAGO_CODIGO_PAGO = T1.CODIGO_PAGO\n" +
"INNER JOIN jornada T2 ON T0.JORNADA_ID_JORNADA = t2.ID_JORNADA\n" +
"INNER JOIN alumno T3 ON T0.ALUMNO_CORRELATIVO = T3.CORRELATIVO\n" +
"INNER JOIN grado T4 ON T0.GRADO_CODIGO_GRADO = T4.CODIGO_GRADO                                             \n" +
"order by t0.ID_MATRICULA asc");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("ID_MATRICULA"));
            obj.put("id_pago", rs.getString("CODIGO_PAGO"));
            obj.put("pago", rs.getString("TIPO_PAGO"));
            obj.put("id_jornada", rs.getString("ID_JORNADA"));
            obj.put("jornada", rs.getString("DESCRIPCION"));
            obj.put("id_alumno", rs.getString("CORRELATIVO"));
            obj.put("alumno", rs.getString("NOMBRE"));
            obj.put("id_grado", rs.getString("CODIGO_GRADO"));
            obj.put("grado", rs.getString("GRADO"));
            obj.put("valor", rs.getString("VALOR"));
            obj.put("nfecha", rs.getString("FECHA_MATRICULA"));
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(matricula_CRUD.class.getName()).log(Level.SEVERE, null, ex);
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
              Logger.getLogger(matricula_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    public JSONArray nuevo(String id,String id_pago,String id_jornada,String id_alumno,String id_grado,String valor,String nfecha) {
       JSONArray list = new JSONArray();   
     String list1 = "[{\"id\":0}]";
       int id1 = 0;
    try {
      Connection con = conn.DBConect();
      Statement stmt1 = con.createStatement();
   
            ResultSet rs = stmt1.executeQuery("SELECT\n" +
"     case when MAX(ID_MATRICULA) IS NULL then 1\n" +
"        else MAX(ID_MATRICULA) +1   END AS id\n" +
"FROM  matricula; ");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "INSERT INTO matricula (ID_MATRICULA,PAGO_CODIGO_PAGO,JORNADA_ID_JORNADA,ALUMNO_CORRELATIVO,GRADO_CODIGO_GRADO,VALOR,FECHA_MATRICULA) \n" +
                     "VALUES  (?,?,?,?,?,?,'"+nfecha+"')";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,Integer.parseInt(id));
                                stmt.setInt(2,Integer.parseInt(id_pago));
                                stmt.setInt(3,Integer.parseInt(id_jornada));
                                stmt.setInt(4,Integer.parseInt(id_alumno));
                                stmt.setInt(5,Integer.parseInt(id_grado));
                                stmt.setDouble(6, Double.parseDouble(valor));
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
               Logger.getLogger(matricula_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(matricula_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
    
 
  public JSONArray GuardaEdit(String id,String id_pago,String id_jornada,String id_alumno,String id_grado,String valor,String nfecha) {
       JSONArray list = new JSONArray();   
     
    try {
      Connection con = conn.DBConect();  
   String query = "UPDATE matricula \n" +                   
"               SET PAGO_CODIGO_PAGO = ? \n" +
"               , JORNADA_ID_JORNADA = ? \n" +
"               , ALUMNO_CORRELATIVO = ? \n" +
"               , GRADO_CODIGO_GRADO = ? \n" +
"               , VALOR = ? \n" +
"               , FECHA_MATRICULA = '"+nfecha+"' \n" +
"                WHERE  ID_MATRICULA = ?";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,Integer.parseInt(id_pago));
                                stmt.setInt(2,Integer.parseInt(id_jornada));
                                stmt.setInt(3,Integer.parseInt(id_alumno));
                                stmt.setInt(4,Integer.parseInt(id_grado));
                                stmt.setDouble(5, Double.parseDouble(valor));
                                stmt.setInt(6,Integer.parseInt(id));
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
               Logger.getLogger(matricula_CRUD.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(matricula_CRUD.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
    
       
}
