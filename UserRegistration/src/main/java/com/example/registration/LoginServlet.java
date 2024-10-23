package com.example.registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    private UserDAO userDAO = new UserDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get email/username and password from the form
        String emailOrUsername = request.getParameter("emailOrUsername");
        String password = request.getParameter("password");

        // Validate the user's login credentials
        User user = userDAO.validateUser(emailOrUsername, password);

        if (user != null) {
            // Login successful, redirect to user dashboard or homepage
            response.sendRedirect("dashboard.jsp");
        } else {
            // Login failed, display error message
            request.setAttribute("errorMessage", "Invalid email/username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
