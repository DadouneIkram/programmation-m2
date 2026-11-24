package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.UserBean;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        // "Si login valide" (Ici on fait un test simple : il faut que ça ne soit pas vide)
        if (login != null && !login.trim().isEmpty() && pass != null && !pass.trim().isEmpty()) {
            
            // "création du bean"
            UserBean utilisateur = new UserBean();
            utilisateur.setLogin(login);
            utilisateur.setAttribut2("Vide"); // Valeur par défaut
            utilisateur.setAttribut3("Vide"); // Valeur par défaut
            
            // On sauvegarde le bean dans la SESSION pour qu'il soit accessible partout
            HttpSession session = request.getSession();
            session.setAttribute("leBean", utilisateur);
            
            // "-> Page1.jsp"
            getServletContext().getRequestDispatcher("/Page1.jsp").forward(request, response);
            
        } else {
            // "Sinon -> erreur.jsp"
            getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
        }
    }
}