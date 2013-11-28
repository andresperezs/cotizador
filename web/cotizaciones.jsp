<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        
        <link rel="stylesheet" href="styles/tabla.css" type="text/css">
        
        <title>Cotizaciones</title>

        <script type="text/javascript">
         
            function buscar()
            {
               document.forms["CotizadorForm"]["accion"].value="buscar";
               document.forms["CotizadorForm"].submit();
            }
            
            function borrar(indice)
            {
               document.forms["CotizadorForm"]["accion"].value="borrar";
               document.forms["CotizadorForm"]["indice"].value=indice;
               document.forms["CotizadorForm"].submit();
            }
            
            function detalle(indice)
            {
               document.forms["CotizadorForm"]["accion"].value="detalle";
               document.forms["CotizadorForm"]["indice"].value=indice;
               document.forms["CotizadorForm"].submit();
            }
            
            function edit(indice)
            {
               document.forms["CotizadorForm"]["accion"].value="editInfo";
               document.forms["CotizadorForm"]["indice"].value=indice;
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
            
            function exportar()
            {
               document.forms["CotizadorForm"]["accion"].value="exportar";
               document.forms["CotizadorForm"].submit();
            }
            
            function exportarDetalle(indice,descripcion)
            {
               document.forms["CotizadorForm"]["accion"].value="exportarDetalle";
               document.forms["CotizadorForm"]["indice"].value=indice;
               document.forms["CotizadorForm"]["descripcion"].value=descripcion;
               document.forms["CotizadorForm"].submit();
            }
        </script>

    </head>
     <body background="images/prosegurFondo.jpg"  style="width:98%; text-align:center; margin-top:50px;">

        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/cotizador" >
            
            <html:hidden name="CotizadorForm" property="accion" />
            <html:hidden name="CotizadorForm" property="indice" />
            <html:hidden name="CotizadorForm" property="descripcion" />
            <div style="background-color:#FFCC01">   
            <hr style="color: black">
            <table>
                <tr>    

                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="search" onclick="buscar();">Buscar</button> 
                    </td>
                    <td>
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
            <table   style="width:100%; text-align:center;" id="dataTable" >
                <tr>
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">Nombre del proyecto</font></b></td>      
                    <td bgcolor="#000000"><b><font color="yellow">PGI</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">Clarity</font></b></td>  
                </tr>
            
                <c:forEach var="cotizacion" items="${CotizadorForm.lista}">
                        <tr>
                            <c:if test="${CotizadorForm.perfil == 1}">
                            <td><img src="images/delete.png" width="20" height="20" alt="delete" onclick="borrar(${cotizacion.id});"/>
                            </td>
                            </c:if>
                            <c:if test="${CotizadorForm.perfil != 1}">
                            <td>
                            </td>
                            </c:if>
                            <td ><img src="images/info.jpg" width="20" height="20" alt="ver detalle" onclick="detalle(${cotizacion.id});"/>
                            </td>
                            <td><img src="images/ca.gif" width="20" height="20" alt="Editar informacion" onclick="edit(${cotizacion.id});"/>
                            </td>
                            <td><img src="images/pdf.png" width="20" height="20" alt="exportar" onclick="exportarDetalle(${cotizacion.id},'${cotizacion.nombre}');"/>
                            </td>
                            <td><font face="times new roman" color="black"><c:out value="${cotizacion.nombre}"/></font></td>
                            <td><font face="times new roman" color="black"><c:out value="${cotizacion.pgi}"/></font></td>
                            <td><font face="times new roman" color="black"><c:out value="${cotizacion.clarity}"/></font></td>
                        </tr>
                 </c:forEach>
                        
            </table>  
                    </div>
        </html:form>
    </body>
</html>