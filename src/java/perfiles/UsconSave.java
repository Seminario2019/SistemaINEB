/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import usuario.Servlet_Usuarios;

/**
 *
 * @author usuario
 */
@WebServlet(name = "UsconSave", urlPatterns = {"/UsconSave"})
public class UsconSave extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
         JSONArray list = new JSONArray();   
        String user_name = "";
        String clave = "";
        String clave1 = "";
        String clave2 = "";
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
         
        
        try {
            
            
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            JSONObject jObj = new JSONObject(sb.toString());
            user_name = jObj.getJSONObject("datos").getString("usuario");
            clave = jObj.getJSONObject("datos").getString("contrasena");
            clave1 = jObj.getJSONObject("datos").getString("contrasena1");
            clave2 = jObj.getJSONObject("datos").getString("contrasena2");
      perfiles.perfiles_crud crud = new perfiles.perfiles_crud();
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(clave1.equals(clave2)){
            out.println(crud.actualiza_Clave(user_name, clave1));
            }else {
                JSONObject obj=new JSONObject();
           try {
               obj.put("mensaje", "Contraseña no coinsiden");
               list.put(obj);
                 out.println(list);
           } catch (JSONException ex) {
               Logger.getLogger(perfiles_crud.class.getName()).log(Level.SEVERE, null, ex);
           }
          
            }
        }
        
                } catch (JSONException ex) {
            java.util.logging.Logger.getLogger(UsconSave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
