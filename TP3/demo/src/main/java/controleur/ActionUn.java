package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.UserBean;

@WebServlet("/ActionUn")
public class ActionUn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // On récupère les nouvelles valeurs
        String attr2 = request.getParameter("attr2");
        String attr3 = request.getParameter("attr3");
        
        // On récupère la session et le Bean existant
        HttpSession session = request.getSession(false);
        if (session != null) {
            UserBean user = (UserBean) session.getAttribute("leBean");
            if (user != null) {
                // On met à jour les attributs
                user.setAttribut2(attr2);
                user.setAttribut3(attr3);
                // On remet le Bean mis à jour dans la session
                session.setAttribute("leBean", user);
            }
        }
        
        // On recharge la Page1 pour afficher les changements
        getServletContext().getRequestDispatcher("/Page1.jsp").forward(request, response);
    }
}