<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Connexion</title></head>
<body>
    <h2>Authentification</h2>
    <!-- Le formulaire pointe maintenant vers la Servlet unique -->
    <form action="ControleurPrincipal" method="POST">
        <label>Login :</label>
        <input type="text" name="login" required><br><br>
        
        <label>Password :</label>
        <input type="password" name="password" required><br><br>
        
        <!-- C'est ce paramètre caché qui donne la "provenance" à la Factory ! -->
        <input type="hidden" name="action" value="login">
        
        <button type="submit">ok</button>
    </form>
</body>
</html>