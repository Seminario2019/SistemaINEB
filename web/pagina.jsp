<%-- 
    Document   : pagina
    Created on : 16/10/2019, 08:15:41 PM
    Author     : usuario
--%>

<%@page import="org.json.JSONObject"%>
<%@page import="java.io.BufferedReader"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

<%@ page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@ page import="java.sql.Connection"%>        
<%@ page contentType="application/pdf" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="Servlet.Conexion" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Map" %>
<%@ page import="net.sf.jasperreports.engine.JRExporter" %>
<%@ page import="net.sf.jasperreports.engine.JRExporterParameter" %>
<%@ page import="net.sf.jasperreports.engine.JRParameter" %>
<%@ page import="net.sf.jasperreports.engine.JasperFillManager" %>
<%@ page import="net.sf.jasperreports.engine.JasperPrint" %>
<%@ page import="net.sf.jasperreports.engine.export.JRPdfExporter" %>

<%
          
            String id  = request.getParameter("id");
            ServletContext context = request.getServletContext();
  String realpath = context.getRealPath("/");
  System.out.print(realpath);
     Conexion conn =  new Conexion();     
      Connection con= conn.DBConect();
String reportName = realpath+"\\Reportes\\5.jasper";
Map<String, Object> parameters = new HashMap<String, Object>();
                        parameters.clear();
                        parameters.put(JRParameter.REPORT_LOCALE, new Locale("es", "GT"));
			parameters.put("id",id);                      
JasperPrint print = JasperFillManager.fillReport(reportName,parameters,con);


JasperExportManager.exportReportToPdfStream(print,
response.getOutputStream());

		

%>
    </body>
</html>
