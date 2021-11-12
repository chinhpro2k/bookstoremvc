<%-- 
    Document   : bookstore
    Created on : Oct 24, 2019, 11:35:42 AM
    Author     : os_hoangpn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
//        String urlCart = "cart.jsp?customerID="+request.getParameter("customerID");
        String urlCart = "cart.jsp";
        String urlItems = "cart.jsp?customerID=" + request.getParameter("customerID");
        session.setAttribute("customerID", request.getParameter("customerID"));
        session.setAttribute("name", request.getParameter("name"));
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store | HomePage</title>
        <style>
            html, body {
                height: 100%;
                margin: 0px;
            }
            button {
                display: inline-block;
                border-radius: 4px;
                background-color: #f4511e;
                border: none;
                color: #FFFFFF;
                text-align: center;
                font-size: 28px;
                padding: 20px;
                width: 200px;
                transition: all 0.5s;
                cursor: pointer;
                margin: 5px;
                vertical-align:middle;
            }

            button span {
                cursor: pointer;
                display: inline-block;
                position: relative;
                transition: 0.5s;
            }

            button span:after {
                content: '\00bb';
                position: absolute;
                opacity: 0;
                top: 0;
                right: -20px;
                transition: 0.5s;
            }

            button:hover span {
                padding-right: 25px;
            }

            button:hover span:after {
                opacity: 1;
                right: 0;
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
        <div style="margin-left: 20%">
            <h1>Book Store Customer Page</h1>
            <br>
            <a href="cart.jsp" id="cart"><button><span>View Your Cart</span></button></a>  
            <br>
            <a href="items.jsp" id="items"><button><span>View All Items In Store</span></button></a>
        </div>
        <script>
            document.getElementsById("cart").setAttribute("href", <%=urlCart%>);
            document.getElementsById("items").setAttribute("href", <%=urlItems%>);
        </script>
    </body>
</html>
