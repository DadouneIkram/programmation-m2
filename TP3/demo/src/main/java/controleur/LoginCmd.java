package controleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.UserBean;

public class LoginCmd implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if ("ikram".equals(login) && "1234".equals(pass)) {
            UserBean utilisateur = new UserBean();
            utilisateur.setLogin(login);
            
            HttpSession session = request.getSession();
            session.setAttribute("leBean", utilisateur);
            
            return "/Page1.jsp"; // Si succès, on retourne la vue suivante
        }
        return "/erreur.jsp"; // Sinon, on retourne la page d'erreur
    }
}