package com.ayhanekin;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet extends HttpServlet {

    // This method will be executed whenever there is request
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        System.out.println("In service");
        response.setContentType("text/html");
        try {
            response.getWriter().println("<h1><b><i>Selam ali kim<h1/><b/><i/>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
