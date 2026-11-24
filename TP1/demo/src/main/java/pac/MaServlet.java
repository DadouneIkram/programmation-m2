package pac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("leNom");
        String mdp = request.getParameter("mdp");
        
        // Validation des identifiants
        if ("ali".equals(nom) && "baba".equals(mdp)) {
            getServletContext().getRequestDispatcher("/ok.html").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/pasok.html").forward(request, response);
        }
    }
}