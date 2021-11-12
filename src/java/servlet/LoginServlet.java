/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.Account;
import entities.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.AccountDAOImpl;
import repositories.PersonDAOImpl;

/**
 *
 * @author os_hoangpn
 */
public class LoginServlet extends HttpServlet {

    AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
    Account account = new Account();

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        account.setUsername(request.getParameter("username"));
        account.setPassword(request.getParameter("password"));

        Account a = accountDAOImpl.checkAccount(account);
        String redirectUrl = "result.jsp?status=%s&detail=%s";

        int customerID = a.getId();
        Person p = new PersonDAOImpl().getPersonByAccountID(customerID);
        String name = p.getFullNameID().getLastName() + " " + p.getFullNameID().getMiddleName() + " " + p.getFullNameID().getFirstName();
        if (a != null) {
            if (a.getRole().equalsIgnoreCase("employee")) {
                response.sendRedirect(redirectUrl.format("stafflogin.jsp?customerID=" + p.getId() + "&name=" + name));
            } else {
                response.sendRedirect(redirectUrl.format("bookstore.jsp?customerID=" + p.getId() + "&name=" + name));
            }
        } else {
            response.sendRedirect(redirectUrl.format(redirectUrl, "Fail", "Authentication failed"));
        }
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
