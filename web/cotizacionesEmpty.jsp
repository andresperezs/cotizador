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
         
            function buscar()
            {
               document.forms["CotizadorForm"]["accion"].value="buscar";
               document.forms["CotizadorForm"].submit();
            }
            
            function nuevo()
            {
               if(document.forms["CotizadorForm"]["nombre"].value=="") {
                    alert("Ingrese un nombre")
                    return null;                    
               }
               if(document.forms["CotizadorForm"]["nombre"].value=="Nombre de Proyecto") {
                    alert("Ingrese un nombre valido de proyecto")
                    return null;                    
               }
                             
               document.forms["CotizadorForm"]["accion"].value="insertarCabecera";
               document.forms["CotizadorForm"].submit();
            }
        </script>

    </head>
    <body background="images/prosegurFondo.jpg" style="width:98%; text-align:center; margin-top:50px;">

        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/cotizador" >
        <div style="background-color:#FFCC01">      
            <html:hidden name="CotizadorForm" property="accion" />
            <hr style="color: black">
            <table>
                <tr>    

                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="search" onclick="buscar();">Buscar</button> 
                    </td><td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="nuevo();">Nuevo</button> 
                    </td>
                    <td>
                        <html:text name="CotizadorForm"  size="35" maxlength="20" value="" property="nombre" />
                    </td> 
                </tr>
            </table>
            <hr style="color: black">
        </div>     
        <div  class="CSSTableGenerator">                     
            <table style="width:100%; text-align:center;" id="dataTable" >
                <tr>
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">Nombre del proyecto</font></b></td>      
                    <td bgcolor="#000000"><b><font color="yellow">PGI</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">Clarity</font></b></td>  
                </tr>
                
            </table>
        </div>    
        </html:form>
    </body>
</html>