<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
    <head>
        <title>ABM Productos</title>
        <link rel="stylesheet" href="styles/tabla.css" type="text/css">
        <script type="text/javascript">
         
            function buscar()
            {
               document.forms["ProductosForm"]["accion"].value="buscar";
               document.forms["ProductosForm"].submit();
            }
            
            function borrar(indice)
            {
               document.forms["ProductosForm"]["accion"].value="borrar";
               document.forms["ProductosForm"]["indice"].value=indice;
               document.forms["ProductosForm"].submit();
            }
            
            function edit(indice)
            {
               document.forms["ProductosForm"]["accion"].value="edit";
               document.forms["ProductosForm"]["indice"].value=indice;
               document.forms["ProductosForm"].submit();
            }
            
            function nuevo()
            {
               document.forms["ProductosForm"]["accion"].value="nuevo";
               document.forms["ProductosForm"].submit();
            }
            
            function nuevoStd()
            {
               document.forms["ProductosForm"]["accion"].value="nuevoStd";
               document.forms["ProductosForm"].submit();
            }
            
        </script>

    </head>
    <body background="images/prosegurFondo.jpg" style="width:100%; text-align:center; margin-top:50px;">
   
        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/productos" >
            
            <html:hidden name="ProductosForm" property="accion" />
            <html:hidden name="ProductosForm" property="indice" />
            <div style="background-color:#FFCC01"> 
            <hr style="color: black">
            <table>
                <tr>    

                   
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="search" onclick="buscar();">Buscar</button> 
                    </td>
                    <c:if test="${ProductosForm.perfil == 1}">
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="nuevo();">Nuevo</button> 
                    </td>
                    </c:if>
                    
                </tr>
            </table>
            <hr style="color: black">
            </div>
            <div  class="CSSTableGenerator">    
            <table  style="width:100%; text-align:center;" id="dataTable">
                <tr>
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">Descripcion</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">Precio</font></b></td>      
                </tr>
            
                <c:forEach var="prod" items="${ProductosForm.lista}">
                        <tr>
                            <c:if test="${ProductosForm.perfil == 1}">
                            <td ><img src="images/delete.png" width="20" height="20" alt="delete" onclick="borrar(${prod.id});"/>
                            </td>
                            <td ><img src="images/info.jpg" width="20" height="20" alt="editar" onclick="edit(${prod.id});"/>
                            </td>
                            </c:if>
                            <c:if test="${ProductosForm.perfil != 1}">
                                <td></td>
                                <td></td>
                            </c:if>    
                            <td ><font color="black"><c:out value="${prod.descripcion}"/></font></td>
                            <td ><font color="black"><c:out value="${prod.precio}"/></font></td>
                        </tr>
                 </c:forEach>
                        
            </table>  
            </div>
        </html:form>
    </body>
</html>