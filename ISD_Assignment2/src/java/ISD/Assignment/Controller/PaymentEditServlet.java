/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ISD.Assignment.Model.Dao.PaymentDAO;
import ISD.Assignment.Model.Payment ;
import ISD.Assignment.Model.Dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author CristinaFidelino
 */
public class PaymentEditServlet  extends HttpServlet{
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PaymentDAO pyd = (PaymentDAO) session.getAttribute("pyd");
            int id = Integer.parseInt(request.getParameter("id"));
            try{
                Payment payment = pyd.searchPayment(id).get(0);
                RequestDispatcher dispatcher = request.getRequestDispatcher("edit_cardDetails.jsp");
                request.setAttribute("payment", payment);
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
            Logger.getLogger(PaymentEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}
