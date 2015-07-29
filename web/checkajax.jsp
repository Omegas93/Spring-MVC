<%-- 
    Document   : checkajax
    Created on : Jun 27, 2015, 11:14:16 AM
    Author     : EDU-Stud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <input type="text" id="location" onblur="checkemp();"></input>
            <label id="label"> input empty</label>
              <select id="sel">
            <option>  </option>
            </select>
           <input type="button" onclick=""> </input>
   </form>
    </body>
    
    <script>
     function checkemp() {
       
       var value = document.getElementById("location").value;
       if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("label").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET","Servlethiber?value="+value ,true);
        //xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send();
       
//alert(str);
    
    }
    </script>

</html>
