package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutAction")
public class LogoutAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // On récupère la session actuelle
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // On détruit la session (supprime le Bean mémorisé)
            session.invalidate();
        }
        
        // On redirige vers la page d'au revoir
        getServletContext().getRequestDispatcher("/GoodBye.jsp").forward(request, response);
    }
}