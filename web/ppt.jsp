<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <link rel="stylesheet" href="styles/tabla.css" type="text/css">
    <head>
        <title>Cotizaciones</title>

        <script type="text/javascript">
         
           
        </script>

    </head>
    <body background="images/prosegurFondo.jpg" style="width:98%; text-align:center; margin-top:50px;">

        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/cotizador" >
        <div style="background-color:#FFCC01">      
            <html:hidden name="CotizadorForm" property="accion" />
        </div>      
            
            <embed src=?aaaa.pdf? width=?500? height=?375"></embed>
               
           
        </html:form>
    </body>
</html>