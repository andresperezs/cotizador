<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
    <head>
        <title>Totales</title>
        <link rel="stylesheet" href="styles/tabla.css" type="text/css">
        <script type="text/javascript">
            function rechazar()
            {
               document.forms["CotizadorForm"]["accion"].value="buscarDetalle";
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
            <html:hidden name="CotizadorForm" property="indice" />
            <html:hidden name="CotizadorForm" property="idDetalle" />
            <div style="background-color:#FFCC01"> 
            <hr style="color: black">
            <table>
                <tr>    
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="search" onclick="javascript:rechazar();">Volver</button> 
                    </td>      
                </tr>
            </table>
            <hr style="color: black"> 
            </div> 
            <div class="CSSTableGenerator">  
            <table   id="dataTable" >
                <tr>
                    
                    <td bgcolor="#000000"><b><font color="yellow">Ambiente</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">Costos</font></b></td>    
                </tr>
            
                <c:forEach var="cotizacion" items="${CotizadorForm.listaAmbientes}">
                        <tr>
                            <td ><font color="black"><c:out value="${cotizacion.descripcion}"/></font></td>
                            <td ><font color="black"><c:out value="${cotizacion.id}"/></font></td>
                        </tr>
                 </c:forEach>
                        
            </table>  
            <table id="dataTable" >
                <tr>
                    
                    <td bgcolor="#000000"><b><font color="yellow">Naturaleza</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">Costos</font></b></td>    
                </tr>
            
                <c:forEach var="cotizacion" items="${CotizadorForm.listaNaturaleza}">
                        <tr>
                            <td ><font color="black"><c:out value="${cotizacion.descripcion}"/></font></td>
                            <td ><font color="black"><c:out value="${cotizacion.id}"/></font></td>
                        </tr>
                 </c:forEach>
                        
            </table>  
            
             <table  id="dataTable" >
                <tr>
                    
                    <td bgcolor="#000000"><b><font color="yellow">Total general</font></b></td> 
                    <td ><font color="yellow"><c:out value="${CotizadorForm.total}"/></font></td>
                </tr>
                        
            </table>  
            </div>    
        </html:form>
    </body>
</html>