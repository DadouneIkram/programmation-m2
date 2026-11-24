package controleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
    // Chaque action exécutera son code ici et retournera le nom de la page JSP suivante
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}