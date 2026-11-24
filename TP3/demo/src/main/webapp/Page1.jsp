<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modele.UserBean" %>
<!DOCTYPE html>
<html>
<head><title>Page 1</title></head>
<body>
    <%
        // On récupère le bean depuis la session
        UserBean user = (UserBean) session.getAttribute("leBean");
        if (user != null) {
    %>
        <!-- Affiche "Welcome Charly" par exemple -->
        <h2>Welcome <%= user.getLogin() %> !</h2>
        
        <!-- Le lien de déconnexion (pointera vers LogoutAction.class plus tard) -->
        <a href="LogoutAction">Logout</a>
        <hr>

        <form action="ActionUn" method="POST">
            <!-- On affiche la valeur actuelle et on permet de la modifier -->
            <label>Attribut 2 :</label>
            <input type="text" name="attr2" value="<%= user.getAttribut2() %>"><br><br>
            
            <label>Attribut 3 :</label>
            <input type="text" name="attr3" value="<%= user.getAttribut3() %>"><br><br>
            
            <button type="submit">ok</button>
        </form>
    <%
        } else {
            // Si on essaie de venir ici sans s'être connecté
            response.sendRedirect("Login.jsp");
        }
    %>
</body>
</html>