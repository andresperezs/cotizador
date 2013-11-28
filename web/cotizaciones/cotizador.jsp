<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=9" />
        <title>Alta de cotizaciones</title>
         <style type="text/css">
		

.CSSTableGenerator {
	margin:0px;padding:0px;
	width:150%;
	-moz-border-radius-bottomleft:16px;
	-webkit-border-bottom-left-radius:16px;
	border-bottom-left-radius:16px;
	
	-moz-border-radius-bottomright:16px;
	-webkit-border-bottom-right-radius:16px;
	border-bottom-right-radius:16px;
	
	-moz-border-radius-topright:16px;
	-webkit-border-top-right-radius:16px;
	border-top-right-radius:16px;
	
	-moz-border-radius-topleft:16px;
	-webkit-border-top-left-radius:16px;
	border-top-left-radius:16px;
}.CSSTableGenerator table{
	width:150%;
	height:5%;
	margin:0px;padding:0px;
	
}.CSSTableGenerator tr:last-child td:last-child {
	-moz-border-radius-bottomright:16px;
	-webkit-border-bottom-right-radius:16px;
	border-bottom-right-radius:16px;
}
.CSSTableGenerator table tr:first-child td:first-child {
	-moz-border-radius-topleft:16px;
	-webkit-border-top-left-radius:16px;
	border-top-left-radius:16px;
}
.CSSTableGenerator table tr:first-child td:last-child {
	-moz-border-radius-topright:16px;
	-webkit-border-top-right-radius:16px;
	border-top-right-radius:16px;
}.CSSTableGenerator tr:last-child td:first-child{
	-moz-border-radius-bottomleft:16px;
	-webkit-border-bottom-left-radius:16px;
	border-bottom-left-radius:16px;
}.CSSTableGenerator tr:hover td{
	
}
.CSSTableGenerator tr:nth-child(odd){ background-color:#ffff56; }
.CSSTableGenerator tr:nth-child(even)    { background-color:#ffffff; }.CSSTableGenerator td{
	vertical-align:middle;
	border:1px solid #bfbf00;
	border-width:0px 1px 1px 0px;
	text-align:center;
	padding:3px;
	font-size:13px;
	font-family:Helvetica;
	color:#000000;
}.CSSTableGenerator tr:last-child td{
	border-width:0px 1px 0px 0px;
}.CSSTableGenerator tr td:last-child{
	border-width:0px 0px 1px 0px;
}.CSSTableGenerator tr:last-child td:last-child{
	border-width:0px 0px 0px 0px;
}
.CSSTableGenerator tr:first-child td{
		background:-o-linear-gradient(bottom, #000000 5%, #4c4c4c 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #000000), color-stop(1, #4c4c4c) );
	background:-moz-linear-gradient( center top, #000000 5%, #4c4c4c 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#000000", endColorstr="#4c4c4c");	background: -o-linear-gradient(top,#000000,4c4c4c);

	background-color:#000000;
	border:0px solid #bfbf00;
	text-align:center;
	border-width:0px 0px 1px 1px;
	font-size:13px;
	font-family:Helvetica;
	color:#ffff56;
}
		</style>
        <script type="text/javascript">
         
            function buscar()
            {
               document.forms["CotizadorForm"]["accion"].value="buscarDetalle";
               document.forms["CotizadorForm"].submit();
            }
            
            function borrar(indice,idDetalle,virtual)
            {
               if(virtual == "N"){ 
                    document.forms["CotizadorForm"]["accion"].value="borrarDetalle";
                    document.forms["CotizadorForm"]["idDetalle"].value=idDetalle;  
                    document.forms["CotizadorForm"]["indice"].value=indice;
               }else{ 
                    document.forms["CotizadorForm"]["accion"].value="borrarDetalleVirtual";
                    document.forms["CotizadorForm"]["idDetalle"].value=idDetalle;               }
                   
               
               document.forms["CotizadorForm"].submit();
            }
            
            function volver()
            {
               document.forms["CotizadorForm"]["accion"].value="volver";
               document.forms["CotizadorForm"].submit();
            }
            
            function nuevo()
            {
               document.forms["CotizadorForm"]["accion"].value="create";
               document.forms["CotizadorForm"].submit();
            }
            
            function virtual()
            {
               document.forms["CotizadorForm"]["accion"].value="virtual";
               document.forms["CotizadorForm"].submit();
            }
            
            function base()
            {
               document.forms["CotizadorForm"]["accion"].value="base";
               document.forms["CotizadorForm"].submit();
            }
            
            function backup()
            {
               document.forms["CotizadorForm"]["accion"].value="backup";
               document.forms["CotizadorForm"].submit();
            }
            
            function unidadRack()
            {
               document.forms["CotizadorForm"]["accion"].value="rack";
               document.forms["CotizadorForm"].submit();
            }
            
            function totales()
            {
               document.forms["CotizadorForm"]["accion"].value="totales";
               document.forms["CotizadorForm"].submit();
            }
            
            function editar(indice,idDetalle,virtual)
            { 
               if(virtual == "N"){ 
                    document.forms["CotizadorForm"]["accion"].value="editar";
               }else{ 
                    document.forms["CotizadorForm"]["accion"].value="editarVirtual";
               } 
               document.forms["CotizadorForm"]["indice"].value=indice;
               document.forms["CotizadorForm"]["idDetalle"].value=idDetalle;
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
            <div style="background-color:#FFCC01; width:230%;">    
            <hr style="color: black;">
            <table>
                <tr>    

                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="search" onclick="buscar();">Buscar</button> 
                    </td>
                    
                    <c:if test="${CotizadorForm.perfil == 1}">
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="nuevo();">Agregar Items</button> 
                    </td>
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="virtual();">Agregar Virtual</button> 
                    </td>
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="base();">Agregar BD</button> 
                    </td>   
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="backup();">Agregar Backup</button> 
                    </td>
                    
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="unidadRack();">Unidad Rack</button> 
                    </td>
                    
                    </c:if>
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="totales();">Totales</button> 
                    </td>
                    <td>
                        <button style="font-size:13px; font-family:Helvetica; border: solid 1px #2A4E77;text-decoration: none;" 
                                name="new" onclick="volver();">Volver</button> 
                    </td>
                </tr>
            </table>
            
            <hr style="color: black;">
            </div>      
            <div  class="CSSTableGenerator">    
            <table  style="width:150%; text-align:center;" id="dataTable">
                <tr>
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">&nbsp&nbsp</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">Descripcion</font></b></td> 
                    <td bgcolor="#000000"><b><font color="yellow">SO / Observacion</font></b></td>    
                    <td bgcolor="#000000"><b><font color="yellow">Ambiente</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">Precio  </font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">Cant</font></b></td>
                    <td bgcolor="#000000"><b><font color="yellow">Meses</font></b></td>
                    <td bgcolor="#000000"><b><font color="yellow">CAPEX SW</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">TELEFONIA</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">CAPEX DESA</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">CAPEX HW</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">OUTSOURCING</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">VIAJES</font></b></td>  
                    <td bgcolor="#000000"><b><font color="yellow">FORMACION</font></b></td> 
                        
                   <!--  <td bgcolor="#000000"><b><font color="yellow">Naturaleza</font></b></td>    -->   
                </tr>
            
                <c:forEach var="cotizacion" items="${CotizadorForm.lista}">
                        <tr>
                            <td ><img src="images/delete.png" width="20" height="20" alt="delete" onclick="borrar(${cotizacion.id},'${cotizacion.idDetalle}','${cotizacion.virtual}');"/>
                            </td>
                            <td ><img src="images/info.jpg" width="20" height="20" alt="editar" onclick="editar(${cotizacion.id},'${cotizacion.idDetalle}','${cotizacion.virtual}');"/>
                            </td>
                            <td ><font face="times new roman" color="black"><c:out value="${cotizacion.descripcion}"/></font></td>
                            <td ><font face="times new roman" color="black"><c:out value="${cotizacion.observaciones}"/></font></td>
                            <td ><font face="times new roman" color="black"><c:out value="${cotizacion.ambiente}"/></font></td>
                            <td ><font face="times new roman" color="black">${CotizadorForm.simbolo} <c:out value="${(cotizacion.precio + cotizacion.precioCapSW + cotizacion.precioTelefonia + cotizacion.precioFormacion  + cotizacion.precioOut + cotizacion.precioViajes + cotizacion.precioCapexDesa + cotizacion.precioCapexHW)*cotizacion.cantidad}"/></font></td>
                            <td ><font face="times new roman" color="black"><c:out value="${cotizacion.cantidad}"/></font></td>
                            <td ><font face="times new roman" color="black"><c:out value="${cotizacion.meses}"/></font></td>
                            <td ><font face="times new roman" color="black">${CotizadorForm.simbolo} <c:out value="${(cotizacion.precioCapSW * cotizacion.cantidad)}"/></font></td>
                            <td ><font face="times new roman" color="black">${CotizadorForm.simbolo} <c:out value="${(cotizacion.precioTelefonia * cotizacion.cantidad)}"/></font></td>
                            <td ><font face="times new roman" color="black">${CotizadorForm.simbolo} <c:out value="${(cotizacion.precioCapexDesa * cotizacion.cantidad)}"/></font></td>
                            <td ><font face="times new roman" color="black">${CotizadorForm.simbolo} <c:out value="${(cotizacion.precioCapexHW * cotizacion.cantidad)}"/></font></td>
                            <td ><font face="times new roman" color="black">${CotizadorForm.simbolo} <c:out value="${(cotizacion.precioOut * cotizacion.cantidad)}"/></font></td>
                            <td ><font face="times new roman" color="black">${CotizadorForm.simbolo} <c:out value="${(cotizacion.precioViajes * cotizacion.cantidad)}"/></font></td>
                            <td ><font face="times new roman" color="black">${CotizadorForm.simbolo} <c:out value="${(cotizacion.precioFormacion * cotizacion.cantidad)}"/></font></td>
                            
                            
                           <!-- <td><font color="black"><c:out value="${cotizacion.naturaleza}"/></font></td>-->
                        </tr>
                 </c:forEach>
                        
            </table>  
            </div>
        </html:form>
    </body>
</html>