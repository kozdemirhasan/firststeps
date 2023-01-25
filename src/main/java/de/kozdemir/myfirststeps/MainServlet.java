package de.lubowiecki.firststeps;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(name = "mainServlet", value = "/main")
//@WebServlet("/main") // Es wird nur das URL-Mapping reingeschrieben
@WebServlet(value = {"", "/main"}, loadOnStartup = 1) // LoadOnStartup = Wird instanziert sobald der Server startet
public class MainServlet extends HttpServlet { // Servlet(Interface) > GenericServlet(abstrakte Klasse) > HttpServlet(konkrete Klasse)

    @Override
    public void init() throws ServletException { // Wird nach der Instanzierung des Servlets automatisch aufgerufen
        // Hier kann man wichtige Resourcen für den Betrieb des Servlets bereitstellen
        //System.out.println("-------- INIT ----------");
        super.init();
    }

    // Wird für jede Anfrage des Browsers aufgerufen und gibt die Anfrage an die passende do...-Methode weiter
    // z.B. GET-Anfragen an doGet(), POST-Anfragen an doPost() etc.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("-------- SERVICE ----------");
        super.service(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("-------- GET ----------");
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("-------- POST ----------");
        process(req, resp);
    }

    /* Weitere Servicemethoden:
        doDelete()
        doHead()
        doOptions()
        doPut()
        doTrace()
     */

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // req = Anfrage vom Browser, liefert Informationen
        // resp = Antwort des Servlets (anfangs noch leer), wird am Ende an den Browser geschickt

        ServletContext context = this.getServletContext();

        // getParameter bekommt name aus dem Formular als key
        String action  = req.getParameter("a");

        String title = "";
        String headline = "";
        String headerImg = "";
        String template = "vorlage";

        if(action == null)
            action = "leer";

        switch(action) {

            case "products":
                title = "Produkte";
                headline = "Das sind unsere Produkte";
                headerImg = "img1.jpg";
                break;

            case "services":
                title = "Services";
                headline = "Das sind unsere Services";
                headerImg = "img2.jpg";
                break;

            case "team":
                title = "Team";
                headline = "Unsere volle Kompetenz";
                headerImg = "img3.jpg";
                break;

            case "contact":
                title = "Konktakt";
                headline = "Schreiben Sie uns doch...";
                headerImg = "img1.jpg";
                template = "contact-form";
                break;

            default:
                title = "Home";
                headline = "Herzlich Willkommen";
                headerImg = "img2.jpg";
                break;
        }

        // Platzhalter für das Template erzeugen
        req.setAttribute("title", title);
        req.setAttribute("headline", headline);
        req.setAttribute("headerImg", headerImg);

        System.out.println(getServletInfo()); // Informationen zum Servlet
        System.out.println(getServletConfig()); // Configuration des Servlets

        // Referenz auf die Laufzeitumgebung des Servlets, bietet viele zusätzlichen Dienste an
        System.out.println(getServletContext());

        /*
        getInitParameter("name_des_parameters"); // Einlesen von Configurationsparams
        getInitParameterNames(); // Liefert alle Namen vorhandener Parameter
         */

        // Vorlage aufrufen
        resp.addCookie(new Cookie("name", "Peter")); // Antwort wird um ein Cookie erweitert
        context.getRequestDispatcher("/WEB-INF/tpl/" + template + ".jsp").forward(req, resp);
    }

    @Override
    public void destroy() { // Wird aufgerufen, bevor das Servlet aus dem Dienst entfernt wird
        //System.out.println("-------------- DESTROY -------------");
        super.destroy();
    }
}