package controleur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoginService;

public class Ajouter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String pwd = request.getParameter("password");
        
        LoginService service = new LoginService();
        service.ajoute(nom, pwd);
        
        response.sendRedirect("Debut");
    }
}