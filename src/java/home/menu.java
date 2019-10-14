/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@WebServlet(name = "menu", urlPatterns = {"/menu"})
public class menu extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("[{\"Grupo\":\"CONFIGURACION\",\"lista\":\"1\""
                    + ",\"menu\":["
                        + "{\"page\":\"adperfil\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Perfiles de usuarios\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]},"
                        + "{\"page\":\"jornadas\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Jornadas\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]},"
                        + "{\"page\":\"Grados\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Grados\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]},"
                        + "{\"page\":\"tipo_actividad\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Tipo de actividad\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]}"
                    + "]"
                    + "},"
                    + "{\"Grupo\":\"OPERACIONES\",\"lista\":\"2\""
                    + ",\"menu\":["
                        + "{\"page\":\"asignatura\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Asignaruta\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]},"
                        + "{\"page\":\"actividad\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Actividad\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]},"
                        + "{\"page\":\"alumnos\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Alumnos\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]}"
                    + "]"
                    + "},"
                    + "{\"Grupo\":\"REGISTROS\",\"lista\":\"3\""
                    + ",\"menu\":["
                        + "{\"page\":\"notas\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Registro de notas\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]},"
                        + "{\"page\":\"pagos\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Pagos\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]},"
                        + "{\"page\":\"matricula\",\"id_men\":\"4\",\"icon\":\"user-plus\",\"nombre\":\"Matriculas\",\"subicon\":\"\",\"lista\":\"\",\"submenu\":[]}"
                    + "]"
                    + "}"
                    + "]");
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
