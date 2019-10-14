/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import grados.Grados_CRUD;

/**
 *
 * @author usuario
 */
@WebServlet(name = "Grado_guadaEdit", urlPatterns = {"/Grado_guadaEdit"})
public class Grado_guadaEdit extends HttpServlet {

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
       
               
String id = null ;
String nombre = null ;
String seccion = null ;
    StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
         
        
        try {
            
            
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            JSONObject jObj = new JSONObject(sb.toString());
            
            id = jObj.getJSONObject("datos").getString("id");
            nombre = jObj.getJSONObject("datos").getString("nombre");
            seccion = jObj.getJSONObject("datos").getString("seccion");
      Grados_CRUD crud = new Grados_CRUD();
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(crud.Grados_GuardaEdit(id,nombre,seccion));
        }
        
                } catch (JSONException ex) {
            java.util.logging.Logger.getLogger(Grado_guadaEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
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
