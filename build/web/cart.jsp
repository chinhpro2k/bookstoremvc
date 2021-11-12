<%-- 
    Document   : cart
    Created on : Oct 24, 2019, 2:57:20 AM
    Author     : os_hoangpn
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="entities.Item"%>
<%@page import="java.util.List"%>
<%@page import="repositories.ItemDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store | Cart</title>
        <link rel="stylesheet" href="css/cart.css">
        <style>
            table, td {
                border: 1px solid black;
                border-collapse: collapse;
                text-align: center;
            }
            html, body {
                height: 100%;
                margin: 0px;
            }

            .item {
                box-sizing: border-box;
                border: 0px solid #000;
                height: 150px;
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
                <% String mainPage = "bookstore.jsp?customerID=" + session.getAttribute("customerID") + "&name=" + session.getAttribute("name");%>
                <a href="<%= mainPage%>">Go to main page</a>
            </div>
            <% }%>
        </div> 
        <h1 style="margin-left: 10%">Your Cart</h1>
        <div id="items">
            <%
                ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
                List<Item> items = itemDAOImpl.findItemInCart(Integer.parseInt(session.getAttribute("customerID").toString()));
                Locale localeVN = new Locale("vi", "VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                long total = 0;
                for (int i = 0; i < items.size(); i++) {
                    int stt = i + 1;
                    Item item = items.get(i);
                    total += Long.parseLong(item.getSalePrice().toString());
            %>            
            <div class="item">
                <div class="itemImg">
                    <img src="<%= "img?ImgUrl=" + item.getUrl()%>" alt="" width="100%" height="100%">
                </div>
                <div class="itemName"><%= item.getName()%></div>
                <div class="itemPrice"><%= currencyVN.format(item.getSalePrice())%></div>
            </div>
            <%}
            %>
        </div>
        <div id="makeOrder">
            <p style="font-weight: bold">Total: <%= currencyVN.format(total)%></p>
            <br>
            <a href="getShippingAddress.jsp"><button>Make Order</button></a>
        </div>
    </body>
</html>
