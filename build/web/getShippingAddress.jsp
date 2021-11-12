<%-- 
    Document   : getShippingAddress
    Created on : Nov 5, 2019, 11:29:57 PM
    Author     : os_hoangpn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            html, body {
                height: 100%;
                margin: 0px;
            }
        </style>
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
        <h1 style="margin-left: 300px;">We need shipping information for your order...</h1>
        <div style="margin-left: 30%; width: 20%;text-align: right;">
            <form action="shippingaddress" method="POST" >                
                <div>
                    <label>City</label>
                    <input type="text" name="city"> 
                    <br>
                    <label>District</label>
                    <input type="text" name="district"> 
                    <br>
                    <label>Town</label>
                    <input type="text" name="town">  
                    <br>
                    <label>Description</label>
                    <input type="text" name="desciption">
                    <br>
                    <br>
                    <label>Note(Time, Phone number,...)</label>
                    <input type="text" name="note">                    
                </div>
                <br>
                <input type="submit" style="margin-left: 200px">
            </form>
        </div>
    </body>
</html>
