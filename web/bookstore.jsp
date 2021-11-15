<%-- 
    Document   : bookstore
    Created on : Oct 24, 2019, 11:35:42 AM
    Author     : os_hoangpn
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Item"%>
<%@page import="java.util.List"%>
<%@page import="repositories.ItemDAOImpl"%>
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
                 <a href="cart.jsp" id="cart"><span>View Your Cart</span></a>  
            </div>
            <% }%>
        </div> 
        <div style="margin-left: 20%">
<!--            <h1>Book Store Customer Page</h1>-->
           
<!--            <a href="items.jsp" id="items"><button><span>View All Items In Store</span></button></a>-->
            <div id="items" style="display:flex;flex-wrap: wrap;margin-top: 30px">
            <%
                String itemName = request.getParameter("item_name");
                ItemDAOImpl itemDAOImpl = new ItemDAOImpl();

                List<Item> items = new ArrayList<Item>();
                if (itemName == null || itemName.equals("")) {
                    items = itemDAOImpl.findAll();
                } else {
                    items = itemDAOImpl.getItemByName(itemName);
                }
                Locale localeVN = new Locale("vi", "VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                for (int i = 0; i < items.size(); i++) {
                    int stt = i + 1;
                    Item item = items.get(i);
            %> 
            <div class="item" style="width:200px">
                <div class="itemImg">
                    <img src="<%= "img?ImgUrl=" + item.getUrl()%>" alt="" width="200px" height="100%">
                </div>
                <div class="itemInfo">                
                    <div style="width: 5%; height: 100%; float: left">&nbsp;</div>
                    <div style="width: 90%; height: 100%; float: left">
                        <p class="itemName" style="font-weight: bold;  height: 36px"><%= item.getName()%></p>
                        <p class="itemAuthor"><%= item.getDescription()%></p>
                        <form action="cart" method="POST" >
                            <label class="itemPrice" style="text-decoration: underline"><%= currencyVN.format(item.getSalePrice())%> </label>
                            <input name="ItemID" hidden="true" value="<%= item.getId()%>">
                            <input name="CustomerID" hidden="true" value="<%= session.getAttribute("customerID")%>">
                            <input type="submit" value="Add to Cart" style="float: right;background-color: #FFFFFF;border: 1px solid red;padding: 6px 8px;border-radius: 8px;cursor: pointer">
                        </form>  
                    </div>
                    <div style="width: 50%; height: 100%; float: left">&nbsp;</div>
                </div>
            </div>
            <%}
            %>
        </div>
        </div>
        <script>
            document.getElementsById("cart").setAttribute("href", <%=urlCart%>);
            document.getElementsById("items").setAttribute("href", <%=urlItems%>);
        </script>
    </body>
</html>
