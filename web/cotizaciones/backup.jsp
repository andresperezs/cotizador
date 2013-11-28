<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<html>
    <head>
        <title>Equipo virtual</title>
        <link rel="stylesheet" href="styles/tablaDetalles2.css" type="text/css">
        <script type="text/javascript">
            
            function guarda()
            {
               if(document.forms["CotizadorForm"]["cantidad"].value == "" || document.forms["CotizadorForm"]["cantidad"].value == "0" ){
                   alert("Debe ingresar un tamaño de backup");
                   return false;
               }
               
               document.forms["CotizadorForm"]["accion"].value="insertarVirtual";
               document.forms["CotizadorForm"].submit();
            }
            
            function rechazar()
            {
               document.forms["CotizadorForm"]["accion"].value="buscarDetalle";
               document.forms["CotizadorForm"].submit();
            }
            
        </script>

    </head>
    <body background="images/prosegurFondo.jpg"  style="width:100%; text-align:center; margin-top:50px;">
        <div style="background-color:#FFCC01"> 
        <HR color="black" width=100% align="center">
            <b>Agregar tamaño de backup en GB</b >
        <HR color="black" width=100% align="center">
        </div>
        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/cotizador" >
        <div class="CSSTableGenerator">       
            <table  id="dataTable" >
                 
                <tr></tr>
                <tr>
                    <td ><b><font color="black">Tamaño</font></b></td>
                    <td  ><html:text style="width: 300px" maxlength="3" name="CotizadorForm" property="cantidad" /></td>    
                </tr>
                
                <tr>
                    <td ><b><font color="black">Ambiente</font></b></td>
                    <td >
                        <html:select style="width: 300px" name="CotizadorForm" property="ambiente"> 
                        <html:options collection="ambientes" property="key" labelProperty="value" />
                        </html:select> 
                    </td>
                </tr>      
                
                                
                <tr>
                    <html:hidden name="CotizadorForm" property="accion" />
                    <html:hidden name="CotizadorForm" property="cantidad" />
                </tr>
            </table>
            
            <button name="guardar" onclick="javascript:guarda();">Guardar</button> 
            <button name="cancelar" onclick="javascript:rechazar();">Cancelar</button> 
        </div>
        </html:form>
    </body>
</html>