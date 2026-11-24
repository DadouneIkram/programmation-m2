package controleur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoginService;

public class Debut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService service = new LoginService();
        // On récupère tous les utilisateurs et on les envoie à la JSP
        request.setAttribute("listeUsers", service.findAll());
        getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
    }
}