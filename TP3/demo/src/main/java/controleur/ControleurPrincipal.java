package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControleurPrincipal") // L'URL unique pour toute l'application !
public class ControleurPrincipal extends HttpServlet {
    
    // On utilise doPost pour gérer toutes les validations de formulaires
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. On regarde d'où vient la requête (la "provenance" demandée par la prof)
        String provenance = request.getParameter("action");
        
        // 2. On utilise ta Factory pour créer l'instance correspondante sans faire de "if"
        IAction monAction = MaFactory.getAction(provenance);
        
        if (monAction != null) {
            try {
                // 3. On exécute le code de la classe (LoginCmd, UpdateCmd...) et on récupère la page JSP suivante
                String vue = monAction.execute(request, response);
                
                // 4. On affiche la page JSP
                getServletContext().getRequestDispatcher(vue).forward(request, response);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("Erreur : Action non reconnue par la Factory.");
        }
    }
}