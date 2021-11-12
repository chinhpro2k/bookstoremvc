<%-- 
    Document   : staff
    Created on : Nov 6, 2019, 10:18:36 AM
    Author     : os_hoangpn
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="entities.Item"%>
<%@page import="repositories.ItemDAOImpl"%>
<%@page import="entities.Orderline"%>
<%@page import="java.util.List"%>
<%@page import="repositories.OrderlineDAOImpl"%>
<%@page import="entities.Onlineorder"%>
<%@page import="repositories.OnlineOrderDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search result</title>
        <style>
            html, body {
                height: 100%;
                margin: 0px;
            }
            td,th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            tr:nth-child(even){background-color: #f2f2f2;}

            tr:hover {background-color: #ddd;}

            th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
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
                <% String mainPage = "stafflogin.jsp?customerID=" + session.getAttribute("customerID") + "&name=" + session.getAttribute("name");%>
                <a href="<%= mainPage%>">Go to main page</a>
            </div>
            <% }%>
        </div>
        <div style="margin-left: 20%">
            <%
                OnlineOrderDAOImpl aOImpl = new OnlineOrderDAOImpl();
                Onlineorder onlineorder = aOImpl.searchOnlineOrders(Integer.parseInt(request.getParameter("orderID")));
                OrderlineDAOImpl orderlineDAOImpl = new OrderlineDAOImpl();
                List<Orderline> list = orderlineDAOImpl.getOrderLinesByOrderId(Integer.parseInt(request.getParameter("orderID")));
                Locale localeVN = new Locale("vi", "VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                long total = 0;
            %>
            <br>
            <div><span style="font-weight: bold">Order ID:</span> <span style="color: firebrick"><%= onlineorder.getOrderID()%></span></div>
            <div><span style="font-weight: bold">Customer ID:</span> <span style="color: firebrick"><%= onlineorder.getCustomerID()%></span></div>
            <div><span style="font-weight: bold">Payment method:</span> <span style="color: firebrick"><%= onlineorder.getPaymentmethod()%></span></div>
            <div><span style="font-weight: bold">State:</span> <span style="color: firebrick"><%= onlineorder.getState()%></span></div>
            <br>
            <table>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Price</td>
                </tr>
                <% for (Orderline i : list) {
                        total += Long.parseLong(i.getItemID().getSalePrice().toString());
                %>
                <tr>
                    <td> <%= i.getItemID().getId()%></td>
                    <td> <%= i.getItemID().getName()%></td>
                    <td> <%= currencyVN.format(i.getItemID().getSalePrice())%></td>
                    <% }%>
                </tr>
            </table>
            <p style="font-weight: bold">Total: <%= currencyVN.format(total)%></p>
            <br>
            <form action="OnlineOrderServlet" method="POST">
                <input type="text" name="orderID" value="<%= request.getParameter("orderID")%>"  hidden="true"/>
                <div>
                    <select name="method" onchange="">
                        <option value="Wait for payment">Wait for payment</option>
                        <option value="Getting in stock">Getting in stock</option>
                        <option value="On Delivery">On Delivery</option>
                        <option value="Accepted">Accepted</option>
                        <option value="Canceled">Canceled</option>
                    </select>     
                    <input name="ItemID" hidden="true" value="<%= onlineorder.getOrderID()%>">
                </div>
                <input type="submit" name="button1" value="Update">

            </form>

        </div>
    </body>
</html>
