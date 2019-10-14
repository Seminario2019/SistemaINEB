/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;

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

/**
 *
 * @author usuario
 */
@WebServlet(name = "alumno_guadaEdit", urlPatterns = {"/alumno_guadaEdit"})
public class alumno_guadaEdit extends HttpServlet {

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
        
        String correlativo = null ;
        String codigo = null ;
String pnombre = null ;
String snombre = null ;
String papellido = null ;
String sapellido = null ;
String nfecha = null ;
         
        
        try {
            

        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
            
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            JSONObject jObj = new JSONObject(sb.toString());
            
            correlativo  = jObj.getJSONObject("datos").getString("correlativo");
            codigo = jObj.getJSONObject("datos").getString("codigo");
            pnombre = jObj.getJSONObject("datos").getString("pnombre");
            snombre = jObj.getJSONObject("datos").getString("snombre");
            papellido = jObj.getJSONObject("datos").getString("papellido");
            sapellido = jObj.getJSONObject("datos").getString("sapellido");
            nfecha = jObj.getJSONObject("datos").getString("nfecha");
      alumno_CRUD crud = new alumno_CRUD();
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(crud.GuardaEdit(correlativo,codigo,pnombre,snombre,papellido,sapellido,nfecha));
        }
        
                } catch (JSONException ex) {
            java.util.logging.Logger.getLogger(alumno_guadaEdit.class.getName()).log(Level.SEVERE, null, ex);
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
