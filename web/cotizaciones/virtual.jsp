<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<html>
    <head>
        <title>Equipo virtual</title>
        <link rel="stylesheet" href="styles/tablaDetalles3.css" type="text/css">
        <script type="text/javascript">
            
            function guarda()
            {
               if(document.forms["CotizadorForm"]["disco"].value == "" || document.forms["CotizadorForm"]["disco"].value == "0" ){
                   alert("Debe ingresar un tamaño se storage en GB");
                   return false;
               }
               if(document.forms["CotizadorForm"]["memoria"].value == "" || document.forms["CotizadorForm"]["memoria"].value == "0" ){
                   alert("Debe ingresar un tamaño de memoria en GB");
                   return false;
               }
               if(document.forms["CotizadorForm"]["procesador"].value == "" || document.forms["CotizadorForm"]["procesador"].value == "0" ){
                   alert("Debe ingresar una cantidad de procesadores para el equipo");
                   return false;
               }
               if(document.forms["CotizadorForm"]["cantidad"].value == "" || document.forms["CotizadorForm"]["cantidad"].value == "0" ){
                   alert("Debe ingresar la cantidad de equipos con estas caracteristicas quiere cotizar");
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
        <HR width=100% align="center">
            <b>Equipo virtual</b>
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
                    <td ><b><font color="black">Sistema Operativo</font></b></td>
                    <td >
                        <html:select style="width: 300px" name="CotizadorForm" property="sistemaOperativo" > 
                        <html:options collection="so" property="key" labelProperty="value" />
                        </html:select> 
                    </td>
                </tr>   
                
                <tr>
                    <td ><b><font color="black">Raid</font></b></td>
                    <td >
                        <html:select style="width: 300px" name="CotizadorForm" property="raid"> 
                        <html:options collection="raid" property="key" labelProperty="value" />
                        </html:select> 
                    </td>
                </tr>      
                
                <tr>
                    <td ><b><font color="black">Storage</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="20" name="CotizadorForm" property="disco" /></td>    
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
                    <td ><b><font color="black">Memoria</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="20" name="CotizadorForm" property="memoria" /></td>    
                </tr>
                
                <tr>
                    <td ><b><font color="black">Procesadores</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="20"  name="CotizadorForm" property="procesador" /></td>                   
                </tr>  
                <tr>
                    <td ><b><font color="black">Cantidad</font></b></td>
                    <td ><html:text style="width: 300px" maxlength="20"  name="CotizadorForm" property="cantidad" /></td>                   
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