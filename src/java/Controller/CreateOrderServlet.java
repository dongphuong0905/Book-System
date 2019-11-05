/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CityDAO;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import Model.Item;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trong
 */
@WebServlet(name = "CreateOrderServlet", urlPatterns = {"/createorder"})
public class CreateOrderServlet extends HttpServlet {

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
            out.println("<title>Servlet CreateOrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateOrderServlet at " + request.getContextPath() + "</h1>");
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
        OrderDAO orderDao = new OrderDAO();
        OrderDetailDAO orderDetailDao = new OrderDetailDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("CurrUser");
        List<Item> itemList = new ArrayList<>();
        BigDecimal totalPrice = new BigDecimal(0);
        String paymentMethod = request.getParameter("paymentMethod");
        String address = request.getParameter("address");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("shoppingCart")) {
                itemList = new Gson().fromJson(cookie.getValue(), new TypeToken<List<Item>>() {
                }.getType());
            }
        }
        for (Item item : itemList) {
            totalPrice = (totalPrice.add(BigDecimal.valueOf(item.getPrice().doubleValue() * item.getQuantity()))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        
        orderDao.add(user.getUserId(), 4, totalPrice, paymentMethod, 0, CityDAO.getCity(Integer.parseInt(request.getParameter("city"))).getName() + " " + address);
        for(Item item : itemList) {
            orderDetailDao.add(orderDao.getCurrentOrderId(user.getUserId()), item.getBookId(), 0, item.getPrice(), item.getQuantity());
        }
        
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("shoppingCart")){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        request.getRequestDispatcher("/loadorder").forward(request, response);
        //response.sendRedirect("order-complete.jsp");
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
        processRequest(request, response);
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
