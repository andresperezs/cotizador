<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<html>
    <head>
        <title>Edicion PGI-Clarity</title>
        <link rel="stylesheet" href="styles/tablaDetalles3.css" type="text/css">
        <script type="text/javascript">
            
            function guarda()
            {
               document.forms["CotizadorForm"]["accion"].value="saveInfo";
               document.forms["CotizadorForm"].submit();
            }
            
            function rechazar()
            {
               document.forms["CotizadorForm"]["accion"].value="buscar";
               document.forms["CotizadorForm"].submit();
            }
            
        </script>

    </head>
    <body background="images/prosegurFondo.jpg" style="width:100%; text-align:center; margin-top:50px;">
        <div style="background-color:#FFCC01"> 
        <HR  width=100% align="center">
            <b>Editar</b>
        <HR  width=100% align="center">
        </div>    
        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/cotizador" >
            <div align="center" width="50%" class="CSSTableGenerator" >  
              
            <table align="center"  style="width:30%; text-align:center; border-collapse: collapse;" id="dataTable" border="1" bordercolor="BLACK">
                <tr></tr>     
                <tr>
                    <td ><b><font color="black">Nombre</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="20"  name="CotizadorForm" property="nombre" /></td>                   
                </tr>  
                
                <tr>
                    <td ><b><font color="black">PGI</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="20"  name="CotizadorForm" property="pgi" /></td>                   
                </tr>  
                
                <tr>
                    <td ><b><font color="black">Clarity</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="20"  name="CotizadorForm" property="clarity" /></td>                   
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