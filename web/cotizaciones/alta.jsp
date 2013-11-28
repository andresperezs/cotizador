<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<html>
    <head>
        <title>Agregar productos</title>
        <link rel="stylesheet" href="styles/tablaDetalles3.css" type="text/css">
        <script type="text/javascript">
            
            function guarda()
            {
               document.forms["CotizadorForm"]["accion"].value="insertarDetalle";
               document.forms["CotizadorForm"].submit();
            }
            
            function rechazar()
            {
               document.forms["CotizadorForm"]["accion"].value="buscarDetalle";
               document.forms["CotizadorForm"].submit();
            }
            
        </script>

    </head>
    <body background="images/prosegurFondo.jpg" style="width:100%; text-align:center; margin-top:50px;">
        <div style="background-color:#FFCC01"> 
        <HR width=100% align="center">
            <b>Agregar Items</b>
        <HR width=100% align="center">
        </div>    
        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/cotizador" >
            <div align="center" width="50%" class="CSSTableGenerator" >    
            <table id="dataTable">
                <tr></tr>     
                <tr>
                    <td ><b><font color="black">Ambiente</font></b></td>
                    <td >
                        <html:select style="width: 300px" name="CotizadorForm" property="ambiente" > 
                        <html:options collection="ambientes" property="key" labelProperty="value" />
                        </html:select> 
                    </td>
                </tr>   
                
                <tr>
                    <td ><b><font color="black">Producto</font></b></td>
                    <td >
                        <html:select onchange="habilitoVirtual()" style="width: 300px" name="CotizadorForm" property="idProducto"> 
                        <html:options collection="productos" property="key" labelProperty="value" />
                        </html:select> 
                    </td>
                </tr>        
                <tr>
                    <td ><b><font color="black">Cantidad</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="20" name="CotizadorForm" property="cantidad" /></td>    
                </tr>
                <tr>
                    <td ><b><font color="black">Meses</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="20" name="CotizadorForm" property="meses" /></td>    
                </tr>
                <tr>
                    <td ><b><font color="black">Observaciones</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="40"  name="CotizadorForm" property="observaciones" /></td>                   
                </tr>  
                <tr>
                    <html:hidden name="CotizadorForm" property="accion" />
                    <html:hidden name="CotizadorForm" property="cantidad" />
                </tr>
            </table>
            
            
            </div>
            <div align="center" width="100%" > 
                <table bgcolor="#ffff56"> <tr><td><button name="guardar" onclick="javascript:guarda();">Guardar</button></td>
                        <td><button name="cancelar" onclick="javascript:rechazar();">Cancelar</button></td>
                        </tr>                        
                </table>
            </div> 
        </html:form>
    </body>
</html>