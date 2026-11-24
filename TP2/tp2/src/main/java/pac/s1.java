package pac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; // Ajout nécessaire pour la session

public class s1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public s1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get fonctionne!");
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Récupération du paramètre
        String nom = request.getParameter("LeNom");
        System.out.println(nom);
        
        // 2. Création et utilisation de la session
        HttpSession la_session = request.getSession();
        la_session.setAttribute("LeNom", nom);
        
        // 3. Inclusion du fichier JSP
        getServletContext().getRequestDispatcher("/suite.jsp").include(request,response);
        doGet(request, response);
    }
}