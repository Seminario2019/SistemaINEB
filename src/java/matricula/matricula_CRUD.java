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
      ResultSet rs = stmt.executeQuery("select\n" +
"    case when max(id_matricula) is null then 1\n" +
"        else max(id_matricula) +1   end as id\n" +
"from  matricula; ");
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
      ResultSet rs = stmt.executeQuery("select t0.id_matricula, t1.codigo_pago,t1.tipo_pago,t2.id_jornada,t2.descripcion,t3.correlativo, concat(t3.primer_nombre,' ',t3.segundo_nombre, ' ',t3.primer_apellido) as nombre, t4.codigo_grado,t4.nombre as grado,\n" +
"t0.fecha_matricula,t0.valor\n" +
"from matricula t0\n" +
"inner join pago t1 on t0.pago_codigo_pago = t1.codigo_pago\n" +
"inner join jornada t2 on t0.jornada_id_jornada = t2.id_jornada\n" +
"inner join alumno t3 on t0.alumno_correlativo = t3.correlativo\n" +
"inner join grado t4 on t0.grado_codigo_grado = t4.codigo_grado                   \n" +
"order by t0.id_matricula asc");
      while(rs.next()){
            JSONObject obj=new JSONObject();            
            obj.put("id", rs.getString("id_matricula"));
            obj.put("id_pago", rs.getString("codigo_pago"));
            obj.put("pago", rs.getString("tipo_pago"));
            obj.put("id_jornada", rs.getString("id_jornada"));
            obj.put("jornada", rs.getString("descripcion"));
            obj.put("id_alumno", rs.getString("correlativo"));
            obj.put("alumno", rs.getString("nombre"));
            obj.put("id_grado", rs.getString("codigo_grado"));
            obj.put("grado", rs.getString("grado"));
            obj.put("valor", rs.getString("valor"));
            obj.put("nfecha", rs.getString("fecha_matricula"));
            

                 
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
   
            ResultSet rs = stmt1.executeQuery("select\n" +
"     case when max(id_matricula) is null then 1\n" +
"        else max(id_matricula) +1   end as id\n" +
"from  matricula;");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id1=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "insert into matricula (id_matricula,pago_codigo_pago,jornada_id_jornada,alumno_correlativo,grado_codigo_grado,valor,fecha_matricula) \n" +
"                     values  (?,?,?,?,?,?,'"+nfecha+"')";
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
   String query = "update matricula                    \n" +
"               set pago_codigo_pago = ? \n" +
"               , jornada_id_jornada = ? \n" +
"               , alumno_correlativo = ? \n" +
"               , grado_codigo_grado = ? \n" +
"               , valor = ? \n" +
"               , fecha_matricula = '"+nfecha+"' \n" +
"                where  id_matricula = ?";
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
