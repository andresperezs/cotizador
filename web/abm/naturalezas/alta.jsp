<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<html>
    <head>
        <title>Nueva naturaleza</title>
        <link rel="stylesheet" href="styles/tablaDetalles2.css" type="text/css">
        <script type="text/javascript">
            
            function guarda()
            {
               if(document.forms["NaturalezasForm"]["nombre"].value == ""){
                   alert("Debe ingresar un nombre");
                   return false;
               }
               document.forms["NaturalezasForm"]["accion"].value="insertar";
               document.forms["NaturalezasForm"].submit();
            }
            
            function rechazar()
            {
               document.forms["NaturalezasForm"]["accion"].value="buscar";
               document.forms["NaturalezasForm"].submit();
            }
            
        </script>

    </head>
    <body background="images/prosegurFondo.jpg"  style="width:100%; text-align:center; margin-top:50px;">
         <div style="background-color:#FFCC01"> 
        <HR width=100% align="center">
            <b>Nueva naturaleza</b>
        <HR width=100% align="center">
        </div>    
        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/naturalezas" >
            <div  class="CSSTableGenerator">    
            <table id="dataTable">
                 
                <tr>
                    <td bgcolor="#000000"><b><font color="yellow">Nombre</font></b></td>
                    <td><html:text style="width: 300px" maxlength="25" name="NaturalezasForm" property="nombre" /></td>    
                </tr>
                 
                <tr>
                    <html:hidden name="NaturalezasForm" property="accion" />
                </tr>
            </table>
            
            <button name="guardar" onclick="javascript:guarda();">Guardar</button> 
            <button name="cancelar" onclick="javascript:rechazar();">Cancelar</button> 
            </div>
        </html:form>
    </body>
</html>