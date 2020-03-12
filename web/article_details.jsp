<%@ page import="java.util.List" %>
<%@ page import="com.models.Article" %>
<% Article article = (Article) request.getAttribute("article");  %>
<%--
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
    <h1>Details de l'article</h1>
    <hr>
    <img src="" alt="">
    <h2><%= article.getTitre() + " (" + article.getAnnee() + ")"  %></h2>
    <hr>
    <h4>Reference</h4>
    <p><%= article.getReference() %></p>
    <h4>Auteur</h4>
    <p><%= article.getAuteur() %></p>

    <h4>Editeur</h4>
    <p><%= article.getEditeur() %></p>

    <h4>Quantite en Stock</h4>
    <p><%= article.getReference() %></p>

    <h4>Pour le prix modique de </h4>
    <p><%= article.getPrix() %></p>
    <a href="articles">
        <button>Retour</button>
    </a>
    <form action="paniers" method="POST">
        <label for="">Entrer la quantité à ajouter : </label>
        <input type="number" name="quantite">
        <input type="hidden" value="add" name="action">
        <input type="hidden" name="article_id" value="<%= article.getId() %>">
        <input type="submit" value="Valider">
    </form>
</div>
</body>
</html>
