<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
    <head>
        <title>Alta de cotizaciones</title>
        <link rel="stylesheet" href="styles/tabla.css" type="text/css">
        <script type="text/javascript">
         
            function buscar()
            {
               document.forms["CotizadorForm"]["accion"].value="borrarDetalle";
               document.forms["CotizadorForm"].submit();
            }
            
            function volver()
            {
               document.forms["CotizadorForm"]["accion"].value="volver";
               document.forms["CotizadorForm"].submit();
            }
            
            function nuevo()
            {
               document.forms["CotizadorForm"]["accion"].value="create";
               document.forms["CotizadorForm"].submit();
            }
            
            function virtual()
            {
               document.forms["CotizadorForm"]["accion"].value="virtual";
               document.forms["CotizadorForm"].submit();
            }
            
            function base()
            {
               document.forms["CotizadorForm"]["accion"].value="base";
               document.forms["CotizadorForm"].submit();
            }
            
            function backup()
            {
               document.forms["CotizadorForm"]["accion"].value="backup";
               document.forms["CotizadorForm"].submit();
            }
            
            function unidadRack()
            {
               document.forms["CotizadorForm"]["accion"].value="rack";
               document.forms["CotizadorForm"].submit();
            }
            
        </script>

    </head>
    <body background="images/prosegurFondo.jpg">

        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/cotizador" >
            
            <html:hidden name="CotizadorForm" property="accion" />
            <div style="background-color:#FFCC01">               
            <hr style="color: black">
            <table>
                <tr>    

                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="search" onclick="buscar();">Buscar</button> 
                    </td>
                    
                    <c:if test="${CotizadorForm.perfil == 1}">
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="nuevo();">Agregar Items</button> 
                    </td>
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="virtual();">Agregar Virtual</button> 
                    </td>
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="base();">Agregar BD</button> 
                    </td>
                    
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="backup();">Agregar Backup</button> 
                    </td>
                    
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="unidadRack();">Unidad Rack</button> 
                    </td>
                    
                    </c:if>
                    
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="volver();">Volver</button> 
                    </td>
                </tr>
            </table>
            </div>          
            <hr style="color: black">
            <div  class="CSSTableGenerator">    
             <table  style="width:100%; text-align:center;" id="dataTable">
                <tr>
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">Descripcion</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">SO / Observacion</font></b></td>    
                    <td bgcolor="#000000"><b><font color="yellow">Ambiente</font></b></td>     
                    <td bgcolor="#000000"><b><font color="yellow">CAPEX SW</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">TELEFONIA</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">CAPEX DESA</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">CAPEX HW</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">Cant</font></b></td>
                    <td bgcolor="#000000"><b><font color="yellow">Precio       </font></b></td>           
                </tr>
                
            </table>
            </div>
    
        </html:form>
    </body>
</html>