<%@ page import="com.models.User" %>
<%@ page import="com.controllers.AuthController" %><%--
  Created by IntelliJ IDEA.
  User: oussamalahmidi
  Date: 07/03/2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp" />
<body>
<jsp:include page="navbar.jsp" />

<div class="container">
    <h1>Bonjour Monsieur <%= AuthController.currentUser(request).getNom() + " " + AuthController.currentUser(request).getPrenom()  %></h1>
    <hr>
    <h2><a href="articles">Consulter le catalogue</a></h2>
    <h2><a href="commandes">Suivre vos commandes</a></h2>
    <h2><a href="paniers">Visualiser votre panier</a></h2>
</div>
</body>
</html>
