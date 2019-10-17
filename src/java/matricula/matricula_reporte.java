/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricula;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author usuario
 */
@WebServlet(name = "matricula_reporte", urlPatterns = {"/matricula_reporte"})
public class matricula_reporte extends HttpServlet {

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
//          StringBuilder sb = new StringBuilder();
//        BufferedReader br = request.getReader();
//         
//        
//        try {
//            
//            
//            String str = null;
//            while ((str = br.readLine()) != null) {
//                sb.append(str);
//            }
//            JSONObject jObj = new JSONObject(sb.toString());
//            
//            String id  = jObj.getString("id");      
//      reportes crud = new reportes();
//      
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println(crud.matriculas(id));
//       }
//        
//                } catch (JSONException ex) {
//            java.util.logging.Logger.getLogger(matricula_nuevo.class.getName()).log(Level.SEVERE, null, ex);
//        }    
     Servlet.Conexion conn =  new Servlet.Conexion();     
      Connection con= conn.DBConect();
      String respuesta = "";
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      StringBuilder sb = new StringBuilder();
      BufferedReader br = request.getReader();
           try { 
                String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            JSONObject jObj = new JSONObject(sb.toString());
            String id  = jObj.getString("id"); 
			String reportName = "C:\\Users\\usuario\\Desktop\\mio\\Seminario de tecnologia\\SistemaINEB\\web\\Reportes\\5";
                        Map<String, Object> parameters = new HashMap<String, Object>();
                        parameters.clear();
                        parameters.put(JRParameter.REPORT_LOCALE, new Locale("es", "GT"));
			parameters.put("id",id);
			JasperPrint print = JasperFillManager.fillReport(reportName + ".jasper", parameters, con);
			
			JasperExportManager.exportReportToPdfStream(print, baos);

                        con.close();
                       try (PrintWriter out = response.getWriter()) {
                            /* TODO output your page here. You may use following sample code. */
                            out.println(baos.toByteArray());
                       }

		} catch (Exception e) {
                     respuesta = "error: "+e.toString();
			throw new RuntimeException("It's not possible to generate the pdf report.", e);
                       
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
