package de.kozdemir.myfirststeps;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     getServletContext().getRequestDispatcher("/WEB-INF/tpl/login-form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String user = request.getParameter("user");
        final String password = request.getParameter("password");

        //admin
        if(user.equals("admin") && password.equals("geheim")){
            HttpSession session = request.getSession();
            session.setAttribute("signedIn", true );
            session.setAttribute("signedAs", "ADMIN" );
            getServletContext().getRequestDispatcher("/WEB-INF/tpl/admin.jsp").forward(request,response);
        }
        else{
            request.setAttribute("msg", "LOGIN_ERROR");
            getServletContext().getRequestDispatcher("/WEB-INF/tpl/login-form.jsp").forward(request,response);
        }


    }
}
