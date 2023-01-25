package de.kozdemir.myfirststeps;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/scopes")
public class ScopeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext application  = getServletContext();
        if (application.getAttribute("appCounter") == null) {
            application.setAttribute("appCounter", 0);
        }
        int i= (Integer) application.getAttribute("appCounter");
        application.setAttribute("appCounter", ++i);


        HttpSession session = request.getSession();

        if (session.getAttribute("sessCounter") == null) {
            session.setAttribute("sessCounter", 0);
        }
        i= (Integer) session.getAttribute("sessCounter");
        session.setAttribute("sessCounter", ++i);

        if (request.getAttribute("reqCounter") == null) {
            request.setAttribute("reqCounter", 0);
        }
        i= (Integer) request.getAttribute("reqCounter");
        request.setAttribute("reqCounter", ++i);


        getServletContext().getRequestDispatcher("/WEB-INF/tpl/scopes.jsp").forward(request, response);


    }

}
