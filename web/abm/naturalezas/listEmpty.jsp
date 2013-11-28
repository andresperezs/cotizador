<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
    <head>
        <title>ABM Naturalezas</title>
        <link rel="stylesheet" href="styles/tabla.css" type="text/css">
        <script type="text/javascript">
         
            function buscar()
            {
               document.forms["NaturalezasForm"]["accion"].value="buscar";
               document.forms["NaturalezasForm"].submit();
            }
            
            function borrar(indice)
            {
               document.forms["NaturalezasForm"]["accion"].value="borrar";
               document.forms["NaturalezasForm"]["indice"].value=indice;
               document.forms["NaturalezasForm"].submit();
            }
            
            function edit(indice)
            {
               document.forms["NaturalezasForm"]["accion"].value="edit";
               document.forms["NaturalezasForm"]["indice"].value=indice;
               document.forms["NaturalezasForm"].submit();
            }
            
            function nuevo()
            {
               document.forms["NaturalezasForm"]["accion"].value="nuevo";
               document.forms["NaturalezasForm"].submit();
            }
            
            
        </script>

    </head>
    <body background="prosegur.jpg" style="width:100%; text-align:center; margin-top:50px;">

       <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/naturalezas" >
            
            <html:hidden name="NaturalezasForm" property="accion" />
            <html:hidden name="NaturalezasForm" property="indice" />
            <div style="background-color:#FFCC01"> 
            <hr style="color: black">
            <table>
                <tr>    

                   
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="search" onclick="buscar();">Buscar</button> 
                    </td>
                    <c:if test="${NaturalezasForm.perfil == 1}">
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="nuevo();">Nuevo</button> 
                    </td>
                    </c:if>
                    
                </tr>
            </table>
            <hr style="color: black">
            </div>
            <div class="CSSTableGenerator">    
            <table  style="width:100%; text-align:center;" id="dataTable">
                <tr>
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">Descripcion</font></b></td> 
                </tr>
                     
            </table>  
            </div>
        </html:form>
    </body>
</html>