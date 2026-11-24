<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modele.LoginBean" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Administration Serveur</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7f6;
            margin: 30px;
            color: #333;
        }
        .container {
            background: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            max-width: 600px;
            margin-bottom: 30px;
        }
        h2 {
            color: #2c3e50;
            border-bottom: 2px solid #3498db;
            padding-bottom: 5px;
            display: inline-block;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
            background: #ffffff;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
        }
        th, td {
            padding: 12px;
            border: 1px solid #e0e0e0;
            text-align: left;
        }
        th {
            background-color: #34495e;
            color: white;
        }
        button {
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
        }
        .btn-add {
            background-color: #27ae60;
            color: white;
        }
        .btn-delete {
            background-color: #e74c3c;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Nouvel Enregistrement</h2>
        <form action="Ajouter" method="POST">
            <p>
                <label>Identifiant :</label><br>
                <input type="text" name="nom" required style="width: 90%; padding: 5px;">
            </p>
            <p>
                <label>Clé d'accès :</label><br>
                <input type="text" name="password" required style="width: 90%; padding: 5px;">
            </p>
            <button type="submit" class="btn-add">Valider la création</button>
        </form>
    </div>

    <h2>Registre des membres</h2>
    <table>
        <tr>
            <th>Utilisateur</th>
            <th>Code secret</th>
            <th>Opération</th>
        </tr>
        <%
            List<LoginBean> liste = (List<LoginBean>) request.getAttribute("listeUsers");
            if (liste != null) {
                for (LoginBean user : liste) {
        %>
        <tr>
            <td><%= user.getNom() %></td>
            <td><%= user.getPassword() %></td>
            <td>
                <form action="Supprimer" method="POST" style="margin:0;">
                    <input type="hidden" name="nomASupprimer" value="<%= user.getNom() %>">
                    <button type="submit" class="btn-delete">Retirer</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>