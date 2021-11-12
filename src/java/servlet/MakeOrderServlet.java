/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.Item;
import entities.Onlineorder;
import entities.Orderline;
import entities.Shippingaddress;
import entities.Voucher;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.ItemDAOImpl;
import repositories.OnlineOrderDAOImpl;
import repositories.OrderlineDAOImpl;
import repositories.VoucherDAOImpl;

/**
 *
 * @author os_hoangpn
 */
public class MakeOrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(request.getParameter("method") + " " + request.getSession().getAttribute("shippingaddressID"));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int shippingaddressID = Integer.parseInt(request.getSession().getAttribute("shippingaddressID").toString());
        int customerID = Integer.parseInt(request.getSession().getAttribute("customerID").toString());
        String paymentmethod = request.getParameter("method");
        Shippingaddress s = new Shippingaddress();
        s.setId(shippingaddressID);

        VoucherDAOImpl voucherDAOImpl = new VoucherDAOImpl();
        Voucher v = new Voucher();
        v.setName("0");
        v.setDescription("0");
        v.setDiscountAmount(new BigInteger("0"));
        v.setDiscountPercent(0);

        int voucherID = voucherDAOImpl.save(v);
        v.setId(voucherID);

        OnlineOrderDAOImpl oImpl = new OnlineOrderDAOImpl();
        Onlineorder o = new Onlineorder();
        o.setCustomerID(customerID);
        o.setPaymentmethod(paymentmethod);
        o.setVoucherID(v);
        o.setShippingAddressID(s);
        o.setState("Processing");

        int orderID = oImpl.save(o);
        o.setOrderID(orderID);
        ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
        List<Item> items = itemDAOImpl.findItemInCart(customerID);

        OrderlineDAOImpl orderlineDAOImpl = new OrderlineDAOImpl();
        for (Item i : items) {
            Orderline o1 = new Orderline();
            o1.setItemID(i);
            o1.setOrderID(o);
            orderlineDAOImpl.save(o1);
        }

        String redirectUrl = "result.jsp?status=%s&detail=%s";
        response.sendRedirect(redirectUrl.format(redirectUrl, "Success", "Make order successful, our staff will process it soon!"));

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
