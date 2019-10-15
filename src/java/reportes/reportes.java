/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;



/**
 *
 * @author usuario
 */

public class reportes {

     Servlet.Conexion conn =  new Servlet.Conexion();
     
      Connection con = conn.DBConect();
      File miDir = new File (".");
     
     String dir = "C:\\Users\\usuario\\Desktop\\mio\\Seminario de tecnologia\\SistemaINEB\\web\\Reportes\\";
     
    private static final String fileName = "seminario1";
    public String  matriculas () {
        HashMap hm = new HashMap();
        hm.put("IS_IGNORE_PAGINATION",Boolean.FALSE);
 
        String jrxmlFileName = fileName + ".jrxml";
        String jasperFileName = fileName + ".jasper";
        String pdfFileName = fileName + ".pdf";
 
        System.out.println("Start ....");
 
 
            // Get the connection
            try {
                
                JasperDesign design = JRXmlLoader.load(dir+jrxmlFileName);
                JasperReport jasperReport = JasperCompileManager.compileReport(dir+jrxmlFileName);
 
                JasperPrint jprint= JasperFillManager.fillReport(jasperReport, null, conn.DBConect());
 
                FileOutputStream fos = new FileOutputStream(dir+pdfFileName);
 
                JRPdfExporter exporter = new JRPdfExporter();     
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
                exporter.exportReport();
 
                fos.flush();
                fos.close();
                System.out.println("Done exporting reports to pdf");
            } catch (JRException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return pdfFileName;
    }
    
}
