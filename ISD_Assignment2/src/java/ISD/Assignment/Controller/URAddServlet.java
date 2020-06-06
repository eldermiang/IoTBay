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

import ISD.Assignment.Model.Dao.UserRecordDao;
import ISD.Assignment.Model.UserRecord;
import ISD.Assignment.Model.Dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class URAddServlet extends HttpServlet{
     @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            UserRecordDao ur = (UserRecordDao) session.getAttribute("ur");
		String userID = request.getParameter("userID");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String dob = request.getParameter("dob");
                String gender = request.getParameter("gender");
                String address = request.getParameter("address");
                String postcode = request.getParameter("postcode");
                String phonenumber = request.getParameter("phonenumber");
                String role = request.getParameter("role");
                try {
                    ur.addUserRecord(userID, email, password, name, dob, gender, address, postcode, phonenumber, role);
                    response.sendRedirect("URServlet");
                } catch (SQLException e) {
                   throw new ServletException("Cannot add user record to the DB", e);  
                }
        }
}
