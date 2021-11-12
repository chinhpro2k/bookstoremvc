<%-- 
    Document   : index
    Created on : Oct 23, 2019, 9:09:46 PM
    Author     : os_hoangpn
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            html, body {
                height: 100%;
                margin: 0px;
            }
        </style>
        <title>Book Store</title>
    </head>
    <body style="background-color: azure;">
        <div id="header" style="background-color: #e8e8e8; box-sizing: border-box; height: 150px">
            <div style="float: left; margin-left: 20px">
                <a href="/book-store/index.jsp"><img src="resources/logo.png" ></a>
            </div>
            <div style="float: left; margin-left: 100px; margin-top: 50px; background-color: white; border: 3px solid coral;">
                <form action="items.jsp" method="GET">
                    <input type="text" name="item_name" placeholder="Search everything you need..." style="width: 600px; height: 40px; float: left; border: none">
                    <input type="image" style="width: 50px; height: 40px; float: left" src="resources/searchbtn.png">
                </form>
            </div>
            <% if (session.getAttribute("customerID") == null) { %>
            <div style="float: left; margin-left: 100px; margin-top: 50px;">
                <a href="login.jsp" style="font-size: 24px; text-decoration: none; font-weight: bold; color: darkcyan">Login</a>
                <br>
                No account? <a href="register.jsp" style="color: red">Register Now!</a>    
            </div>
            <% } else {%>
            <div style="float: left; margin-left: 100px; margin-top: 50px;">
                Hello <%= session.getAttribute("name")%>
                <a href="/book-store/logout.jsp">Logout</a>
                <br>
                <% String mainPage = "bookstore.jsp?customerID=" + session.getAttribute("customerID") + "&name=" + session.getAttribute("name"); %>
                <a href="<%= mainPage %>">Go to main page</a>
            </div>
            <% }%>
        </div>
        <div id="body" style="width: 100%; height: 600px" >
            <div style="width: 10%; height: 100%; float: left;">&nbsp;</div>
            <div id="menu" style="width: 20%; height: 100%; float: left; border: 1px solid white; text-align: center; font-size: 15px; text-decoration: underline">
                <div style="width: 100%; height: 10%; background-color: burlywood; font-weight: bold; font-size: 40px; text-decoration: overline">Category</div>
                <div style="width: 100%; height: 10%; border: 1px solid white; background-color: cadetblue; font-family: monospace">Literature & Fiction</div>
                <div style="width: 100%; height: 10%; border: 1px solid white; background-color: cadetblue; font-family: monospace">Romance</div>
                <div style="width: 100%; height: 10%; border: 1px solid white; background-color: cadetblue; font-family: monospace">Crime & Thriller</div>
                <div style="width: 100%; height: 10%; border: 1px solid white; background-color: cadetblue; font-family: monospace">Children & Young Adult</div>
                <div style="width: 100%; height: 10%; border: 1px solid white; background-color: cadetblue; font-family: monospace">Sci-fi & Fantasy</div>
                <div style="width: 100%; height: 10%; border: 1px solid white; background-color: cadetblue; font-family: monospace">Business & Economics</div>
                <div style="width: 100%; height: 10%; border: 1px solid white; background-color: cadetblue; font-family: monospace">Biographies & Memoirs</div>
                <div style="width: 100%; height: 10%; border: 1px solid white; background-color: cadetblue; font-family: monospace">Indian Writing</div>
            </div>
            <div style="width: 60%; height: 100%; float: left;">
                <div style="height: 70%">
                    <img src="resources/Bannertong_915x423.png" width="800px" height="400px" style=" border: 6px solid white;">
                </div>
                <div style="height: 30%">
                    <div style="float: left">
                        <img src="resources/Banner_Coupon_596x186.png" height="120px" width="490px" style=" border: 6px solid white;">                        
                    </div>
                    <div style="float: left">
                        <img src="resources/Banner_ngoaivan10_270x186.png" height="120px" width="290px" style=" border: 6px solid white;">
                    </div>                    
                </div>
            </div> 
            <div style="width: 10%; height: 100%; float: left;">&nbsp;</div           
        </div>
    </body>
</html>
