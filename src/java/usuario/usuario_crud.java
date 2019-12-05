package usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class usuario_crud {

      Servlet.Conexion conn =  new Servlet.Conexion();
  public usuario_crud(){
  }
 

  public JSONArray login(String usuario, String Clave) {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select rtrim(id_usuario) id_user, rtrim(usuario) usuario,password clave,rtrim(primer_nombre)+' '+rtrim(primer_apellido) as nombre from usuario where usuario = '"+usuario+"' and password =  '"+Clave+"'   ");
      while(rs.next()){
            JSONObject obj=new JSONObject();
            obj.put("id_user", rs.getString("id_user"));
            obj.put("usuario", rs.getString("usuario"));
            obj.put("nombre", rs.getString("nombre"));
 
            list.put(obj);
        }
 
      rs.close();
      stmt.close();
      con.close();
    }catch (SQLException e){
      System.out.println("error: "+e.getMessage());
      JSONObject obj=new JSONObject();
         try {
             obj.put("error", e.getMessage());             
             list.put(obj);
         } catch (JSONException ex) {
             Logger.getLogger(usuario_crud.class.getName()).log(Level.SEVERE, null, ex);
         }
    }     catch (JSONException ex) {
              Logger.getLogger(usuario_crud.class.getName()).log(Level.SEVERE, null, ex);
             
          }
    return list;
  }


}