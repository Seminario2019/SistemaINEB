package perfiles;
import home.*;
import usuario.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class perfiles_crud {

      Servlet.Conexion conn =  new Servlet.Conexion();
  public perfiles_crud(){
  }
 

  public JSONArray usuarios(String usuario) {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select id_user as id, rtrim(usuario) as usuario,rtrim(nombre)+' '+rtrim(apellido) as nombre\n" +
"                 ,rtrim(imagen) as imagen  ,email,sexo,telefono,celular\n" +
"                 from usuarios where usuario  =  '"+usuario+"'");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("usuario", rs.getString("usuario"));
            obj.put("nombre", rs.getString("nombre"));
            obj.put("imagen", rs.getString("imagen"));
            obj.put("email", rs.getString("email"));
            obj.put("sexo", rs.getString("sexo"));
            obj.put("telefono", rs.getString("telefono"));
            obj.put("celular", rs.getString("celular"));
 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }

 public JSONArray adperfil() {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select id_usuario as id,rtrim(usuario) as usuario, rtrim(primer_nombre) as nombre,rtrim(segundo_nombre) as nombre1,rtrim(primer_apellido) as apellido ,rtrim(segundo_apellido) as apellido1 ,'' as imagen,direccion,telefono  from usuario");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("usuario", rs.getString("usuario"));
            obj.put("nombre", rs.getString("nombre"));
            obj.put("nombre1", rs.getString("nombre1"));
            obj.put("apellido", rs.getString("apellido"));
            obj.put("apellido1", rs.getString("apellido1"));
            obj.put("avatar", rs.getString("imagen"));
            obj.put("direccion", rs.getString("direccion"));
            obj.put("telefono", rs.getString("telefono")); 
            
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
 
 public JSONArray buscausuario(String usuario) {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(" select id_usuario as id,rtrim(usuario) as usuario, rtrim(primer_nombre) as nombre, rtrim(segundo_nombre) as nombre1 \n" +
",rtrim(primer_apellido) as apellido ,rtrim(segundo_apellido) as apellido1 ,'' as imagen,telefono, direccion\n" +
"             from usuario  where id_usuario = "+usuario+"");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id", rs.getString("id"));
            obj.put("usuario", rs.getString("usuario"));
            obj.put("nombre", rs.getString("nombre"));
            obj.put("nombre1", rs.getString("nombre1"));
            obj.put("apellido", rs.getString("apellido"));
            obj.put("apellido1", rs.getString("apellido1"));
            obj.put("avatar", rs.getString("imagen"));
            obj.put("direccion", rs.getString("direccion"));
            obj.put("telefono", rs.getString("telefono")); 
            obj.put("imagen", rs.getString("imagen")); 
                 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
    }     catch (JSONException ex) {
              Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
 
 public JSONArray crear(String usuario,String clave,String nombre,String apellido,String nombre1,String apellido1 ,String direccion ,String telefono ) {
       JSONArray list = new JSONArray();   
     String list1 = "[{\"mensaje\":\"uno\"}]";
     
    try {
      Connection con = conn.DBConect();
      Statement stmt1 = con.createStatement();
      int id = 0;
      ResultSet rs = stmt1.executeQuery("select max(id_usuario)+1 as id from usuario; ");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            id=rs.getInt("id");
            
        }
 
      rs.close();
      stmt1.close();      
      con.close();
      
      con = conn.DBConect();
      String query = "insert into usuario (id_usuario,usuario,password,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,direccion,telefono) \n" +
"                     values  (?,?,?,?,?,?,?,?,?)";
           PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setInt(1,id);
                                stmt.setString(2,usuario);
				stmt.setString(3,clave);
				stmt.setString(4,nombre);
				stmt.setString(5,nombre1);
				stmt.setString(6,apellido);
				stmt.setString(7,apellido1);
				stmt.setString(8,direccion);
				stmt.setString(9,telefono);
				stmt.executeUpdate();
      stmt.close(); 
      con.close();
      JSONObject obj=new JSONObject();
            obj.put("mensaje", "uno");
            
                 
            list.put(obj);
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", e.getMessage());
               list.put(obj);
           } catch (JSONException ex) {
               Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
 
 
 public JSONArray actualiza_Clave(String usuario,String clave) {
       JSONArray list = new JSONArray();   
     
    try {
      Connection con = conn.DBConect();
      
       String query = "update usuario set password = ? where usuario = ?";
      PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setString(1,clave);
                                stmt.setString(2,usuario);
				stmt.executeUpdate();
      stmt.close();
      con.close();
      JSONObject obj=new JSONObject();
      
            obj.put("mensaje", "uno");
            
                 
            list.put(obj);
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", e.getMessage());
               list.put(obj);
           } catch (JSONException ex) {
               Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
 
  public JSONArray GuardaEditado(String usuario,String nombre,String apellido,String nombre1,String apellido1,String direccion,String telefono) {
       JSONArray list = new JSONArray();   
     
    try {
      Connection con = conn.DBConect();
      
       String query = "update usuario \n" +
"               set primer_nombre = ? \n" +
"               ,segundo_nombre = ? \n" +
"               ,primer_apellido = ? \n" +
"               ,segundo_apellido = ? \n" +
"               ,direccion = ? \n" +
"               ,telefono = ? \n" +
"                where usuario = ?";
      PreparedStatement stmt = con.prepareStatement(query);
                                stmt.setString(1,nombre);
                                stmt.setString(2,nombre1);
                                stmt.setString(3,apellido);
                                stmt.setString(4,apellido1);
                                stmt.setString(5,direccion);
                                stmt.setString(6,telefono);
                                stmt.setString(7,usuario);
				stmt.executeUpdate();
      stmt.close();
      con.close();
      JSONObject obj=new JSONObject();
      
            obj.put("mensaje", "uno");
            
                 
            list.put(obj);
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", e.getMessage());
               list.put(obj);
           } catch (JSONException ex) {
               Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
           }
    }     catch (JSONException ex) {
              Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }
}