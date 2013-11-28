<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<html>
    <head>
        <title>Nuevo producto</title>
        <link rel="stylesheet" href="styles/tablaDetalles3.css" type="text/css">
        <script type="text/javascript">
            
            function guarda()
            {
               if(document.forms["ProductosForm"]["nombre"].value == ""){
                   alert("Debe ingresar un nombre");
                   return false;
               }
               if(document.forms["ProductosForm"]["precio"].value == ""){
                   alert("Debe ingresar un precio");
                   return false;
               }
               
               document.forms["ProductosForm"]["accion"].value="insertar";
               document.forms["ProductosForm"].submit();
            }
            
            function rechazar()
            {
               document.forms["ProductosForm"]["accion"].value="buscar";
               document.forms["ProductosForm"].submit();
            }
            
        </script>

    </head>
    <body background="images/prosegurFondo.jpg"  style="width:100%; text-align:center; margin-top:50px;">
           
        <div <div style="background-color:#FFCC01"> 
        <HR  width=100% align="center">
            <b>Nuevo Producto</b>
        <HR  width=100% align="center">
        </div>    
        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/productos" >
            <div align="center" width="50%" class="CSSTableGenerator" >    
            <table id="dataTable" >
                
                <tr>
                </tr>
                <tr>
                    <td ><b>Nombre</b></td>
                    <td><html:text style="width: 300px" maxlength="35" name="ProductosForm" property="nombre" /></td>    
                </tr>
                
                <tr>
                    <td ><b>Precio</b></td>
                    <td><html:text style="width: 300px" maxlength="20"  name="ProductosForm" property="precio" /></td>                   
                </tr>  
                <tr>
                    <td ><b>Naturaleza</b></td>
                    <td>
                        <html:select style="width: 300px" name="ProductosForm" property="naturaleza"> 
                        <html:options collection="naturalezas" property="key" labelProperty="value" />
                        </html:select> 
                    </td>
                    
                </tr>  
                <tr>
                    <td ><b>Tipo</b></td>
                    <td>
                        <html:select style="width: 300px" name="ProductosForm" property="tipo"> 
                        <html:options collection="tipos" property="key" labelProperty="value" />
                        </html:select> 
                    </td>
                    
                </tr> 
                <html:hidden name="ProductosForm" property="accion" />
            </table>
            </div>
            <div align="center" width="100%" > 
                <table bgcolor="#ffff56"> <tr><td><button name="guardar" onclick="javascript:guarda();">Guardar</button></td>
                        <td><button name="cancelar" onclick="javascript:rechazar();">Cancelar</button></td>
                        </tr>                        
                </table>
            </div>  
            <div align="center" width="100%" > 
                <table>
                <tr><td>    </td></tr>
                <tr><td>    </td></tr>
                <tr><td>    </td></tr>
                <tr><td><font size="2px">1 - Comunicaciones no suma CAPEX DESA</font></td></tr>
                <tr><td><font size="2px">2 - Fisico suma valor fijo a CAPEX HW</font></td></tr>
                <tr><td><font size="2px">3 - Licencia DB determinan las licencias a listar al agregar DB</font></td></tr>
                <tr><td><font size="2px">4 - Licencia SO determinan las licencias a listar al agregar una virtual</font></td></tr>
                </table>
            </div>  
        </html:form>
    </body>
</html>