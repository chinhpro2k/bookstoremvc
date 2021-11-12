<%-- 
    Document   : register.jsp
    Created on : Nov 5, 2019, 9:12:39 PM
    Author     : os_hoangpn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>
            /*            div{
                            width: 20%;
                            text-align: right;
                        }*/
            html, body {
                height: 100%;
                margin: 0px;
            } 
        </style>
    </head>
    <body style="background-color: azure; height: 200px">
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
        <h1 style="margin-left: 300px; color: red">Register now for your First-Super-Discount!</h1>
        <div style="margin-left: 30%; width: 20%;text-align: right;">
            <form action="register" method="POST" >
                <div>
                    <label>Username</label>
                    <input type="text" name="username">
                    <br>
                    <label>Password</label>
                    <input type="password" name="password">                
                </div>
                <br>
                <div>
                    <label>FirstName</label>
                    <input type="text" name="firstname">
                    <br>
                    <label>MiddleName</label>
                    <input type="text" name="middlename">
                    <br>
                    <label>LastName</label>
                    <input type="text" name="lastname">                
                </div>
                <br>
                <div>
                    <label>IDCard</label>
                    <input type="text" name="idcard"> 
                    <br>
                    <input type="radio" name="gender" value="Male">Male
                    <input type="radio" name="gender" value="Female">Female
                    <input type="radio" name="gender" value="3rd">3rd
                    <br>
                    <br>
                    <label>Date Of Birth</label>
                    <input type="date" name ="dateofbirth" >
                </div>
                <br>
                <div>
                    <label>PhoneNumber</label>
                    <input type="text" name="phonenumber">
                    <br>
                    <label>Email</label>
                    <input type="text" name="email">
                    <br>
                    <br>
                    <label style="margin-right: 70px">Address</label>
                    <br>
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
                </div>
                <br>
                <input type="submit" style="margin-left: 200px">
            </form>
        </div>
    </body>
</html>
