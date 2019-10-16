/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricula;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;



/**
 *
 * @author usuario
 */

public class reportes {

     Servlet.Conexion conn =  new Servlet.Conexion();     
      Connection con= conn.DBConect();
      String respuesta = "";
    public String  matriculas (String id) {
           try { 
			String reportName = "C:\\Users\\usuario\\Desktop\\mio\\Seminario de tecnologia\\SistemaINEB\\web\\Reportes\\5";
                        Map<String, Object> parameters = new HashMap<String, Object>();
                        parameters.clear();
                        parameters.put(JRParameter.REPORT_LOCALE, new Locale("es", "ES"));
			parameters.put("id",id);
			JasperPrint print = JasperFillManager.fillReport(reportName + ".jasper", parameters, con);
			// exports report to pdf
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(reportName + ".pdf")); // your output goes here
			
			exporter.exportReport();
                        
                        con.close();
                        respuesta = "Reportes/5.pdf";
		} catch (Exception e) {
                     respuesta = "error: "+e.toString();
			throw new RuntimeException("It's not possible to generate the pdf report.", e);
                       
		} 
  
            return respuesta;
    }
    
}
