/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.sun.javafx.geom.CubicApproximator;
import entities.Account;
import entities.Address;
import entities.Bookstorecard;
import entities.Cart;
import entities.Contactinfor;
import entities.Customer;
import entities.Fullname;
import entities.Membershiptype;
import entities.Person;
import entities.Wishlist;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.AccountDAOImpl;
import repositories.AddressDAOImpl;
import repositories.BookstorecardDAOImpl;
import repositories.CartDAOImpl;
import repositories.ContactInforDAOImpl;
import repositories.CustomerDAOImpl;
import repositories.FullnameDAOImpl;
import repositories.MembershiptypeDAOImpl;
import repositories.PersonDAOImpl;
import repositories.WishlistDAOImpl;

/**
 *
 * @author os_hoangpn
 */
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
        AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
        Account account = new Account();
        String redirectUrl = "result.jsp?status=%s&detail=%s";
        account.setUsername(request.getParameter("username"));
        account.setPassword(request.getParameter("password"));
        account.setRole("customer");

        FullnameDAOImpl fullnameDAOImpl = new FullnameDAOImpl();
        Fullname fullname = new Fullname();
        fullname.setFirstName(request.getParameter("firstname"));
        fullname.setMiddleName(request.getParameter("middlename"));
        fullname.setLastName(request.getParameter("lastname"));

        AddressDAOImpl addressDAOImpl = new AddressDAOImpl();
        Address address = new Address();
        address.setCity(request.getParameter("city"));
        address.setDistrict(request.getParameter("district"));
        address.setTown(request.getParameter("town"));
        address.setDescription(request.getParameter("description"));

        ContactInforDAOImpl contactInforDAOImpl = new ContactInforDAOImpl();
        Contactinfor contactinfor = new Contactinfor();
        contactinfor.setEmail(request.getParameter("email"));
        contactinfor.setPhoneNumber(request.getParameter("phonenumber"));

        PersonDAOImpl personDAOImpl = new PersonDAOImpl();
        Person person = new Person();
        person.setGender(request.getParameter("gender"));
        person.setDateOfBirth(request.getParameter("dateofbirth"));
        System.out.println(request.getParameter("dateofbirth"));
        System.out.println(person.getDateOfBirth());
        person.setIdCard(request.getParameter("idcard"));
        if (accountDAOImpl.checkUsernameExist(account.getUsername())) {
            response.sendRedirect(redirectUrl.format(redirectUrl, "Fail", "Username existed"));
        } else {
            int accountID = accountDAOImpl.save(account);
            int fullnameID = fullnameDAOImpl.save(fullname);
            int addressID = addressDAOImpl.save(address);

            contactinfor.setAddressID(address);
            contactinfor.getAddressID().setId(addressID);

            int contactinforID = contactInforDAOImpl.save(contactinfor);

            person.setAccountID(account);
            person.setContactInforID(contactinfor);
            person.setFullNameID(fullname);
            person.getAccountID().setId(accountID);
            person.getContactInforID().setId(contactinforID);
            person.getFullNameID().setId(fullnameID);
            System.out.println(person.toString());
            
            int personID = personDAOImpl.save(person);
            
            int bookstorecardID = new BookstorecardDAOImpl().save(new Bookstorecard());
            int membershiptypeID = new MembershiptypeDAOImpl().save(new Membershiptype());
            int wishlistID = new WishlistDAOImpl().save(new Wishlist());
            int cartID = new CartDAOImpl().save(new Cart());
            
            CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
            Customer customer = new Customer();
            customer.setPersonID(personID);
            customer.setCartID(new Cart());
            customer.getCartID().setId(cartID);
            customer.setBookStoreCardID(new Bookstorecard());
            customer.getBookStoreCardID().setId(bookstorecardID);
            customer.setMembershipTypeID(new Membershiptype());
            customer.getMembershipTypeID().setId(membershiptypeID);
            customer.setWishlistID(new Wishlist());
            customer.getWishlistID().setId(wishlistID);
            
            customerDAOImpl.save(customer);
            response.sendRedirect(redirectUrl.format(redirectUrl, "Success", "Register successful!"));
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
