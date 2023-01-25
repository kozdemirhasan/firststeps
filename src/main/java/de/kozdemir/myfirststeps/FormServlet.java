package de.kozdemir.myfirststeps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/submit")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final PrintWriter output = response.getWriter();
        response.setContentType("application/json"); // Typ der Rückgabe für den Browser bestimmen
        response.setCharacterEncoding("UTF-8"); // Zeichenkodierung bestimmen
        output.println("[{");
        output.println("\"title\": \"Herr\",");
        output.println("\"name\": \"Peter Parker\",");
        output.println("\"country\": \"Deutschland\",");
        output.println("\"email\": \"p.parker@shield.org\",");
        output.println("\"message\": \"Das ist meine Nachricht.\"");
        output.println("}]");

        //response.setStatus(HttpServletResponse.SC_OK); // Seite wurde gefunden, Standard
        //response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Seite wurde NICHT gefunden - als Status
        //response.sendError(HttpServletResponse.SC_NOT_FOUND); // Seite wurde NICHT gefunden - als Error
        //response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE); // Seite wurde NICHT gefunden
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Formulardaten aus dem Request abfragen */
        final String title = request.getParameter("title");
        final String name = request.getParameter("name");
        final String country = request.getParameter("country");
        final String email = request.getParameter("email");
        final String message = request.getParameter("message");

        final PrintWriter output = response.getWriter();
/*
        response.setContentType("text/html");
        output.println("<!DOCTYPE html>");
        output.println("<html><head></head><body>");
        output.println("<p>title: " + title + "</p>"); // Ausgabe wird mit dem Response an den Browser geschickt
        output.println("<p>name: " + name + "</p>");
        output.println("<p>country: " + country + "</p>");
        output.println("<p>email: " + email + "</p>");
        output.println("<p>message: " + message + "</p>");
        output.println("</body></html>");
*/

        Map<String, String> laender = new HashMap<>();
        laender.put("de", "Deutschland");
        laender.put("es", "Spanien");
        laender.put("uk", "England");
        laender.put("us", "USA");

        response.setContentType("application/json"); // Typ der Rückgabe für den Browser bestimmen
        response.setCharacterEncoding("UTF-8"); // Zeichenkodierung bestimmen
        //response.setHeader("Content-Type", "application/json; charset=UTF-8"); // Zusammengesetzt als HTTP-Header
        //response.setContentType("application/json; charset=UTF-8"); // Zusammengesetzt als HTTP-Header
        output.println("[{");
        output.println("\"title\": \"" + ((title.equals("w")) ? "Frau" : "Mann")  + "\"");
        output.println("\"name\": \"" + name + "\"");
        output.println("\"country\": \"" + laender.get(country) + "\"");
        output.println("\"email\": \"" + email + "\"");
        output.println("\"message\": \"" + message + "\"");
        output.println("}]");

    }
}
