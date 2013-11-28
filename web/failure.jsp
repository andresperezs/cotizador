<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<html>
    <head>
        <title>Login Page</title>

        <script type="text/javascript">
            
            function reset()
            {
                document.forms["LoginForm"]["userName"].value="";
                document.forms["LoginForm"]["password"].value="";
                document.forms["LoginForm"]["moneda"].value="";
            }
        </script>

    </head>
    <body bgcolor="#FFCC01" onload="javascript:reset()" align="center" style="width:100%; text-align:center; margin-top:200px;">
        <h1>Portal de cotizaciones de explotación</h1>
        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/login" >
            <table align="center">
                <tr>
                    <td><b>Usuario :</b></td><td><html:text name="LoginForm" property="userName" /></td>
                </tr>
                <tr>
                    <td><b>Contraseña  :</b></td><td><html:password name="LoginForm" property="password" /></td>
                </tr>
                <tr>
                    <td><b>Dominio   :</b></td>
                    <td>
                        <html:select style="width: 155px" name="LoginForm" property="moneda" > 
                            <option value="latam1">LATAM</option>
                            <option value="latam2">BRASIL</option>
                            <option value="emea">EMEA</option>
                        </html:select> 
                    </td>
                </tr>
                </table> 
                <table align="center">
                <tr>
                    <td><html:submit style="width: 200px" value="Ingresar" /></td>
                </tr>
            </table> 
            
        </html:form>
        
    </body>
</html>