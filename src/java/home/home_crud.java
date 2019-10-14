package home;
import usuario.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class home_crud {

      Servlet.Conexion conn =  new Servlet.Conexion();
  public home_crud(){
  }
 

  public JSONArray usuarios(String usuario) {
         
     JSONArray list = new JSONArray();
    try {
      Connection con = conn.DBConect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT ID_USUARIO as id, rtrim(USUARIO) as usuario,rtrim(PRIMER_NOMBRE)+' '+rtrim(PRIMER_APELLIDO) as nombre \n" +
"                ,'' as imagen,DIRECCION email,'' sexo,TELEFONO telefono,'' celular \n" +
"               FROM USUARIO where USUARIO =  '"+usuario+"' ");
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
              Logger.getLogger(home_crud.class.getName()).log(Level.SEVERE, null, ex);
          }
    return list;
  }


}