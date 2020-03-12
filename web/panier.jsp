<%@ page import="java.util.List" %>
<%@ page import="com.models.Article" %>
<%@ page import="com.models.Panier" %>
<% List<Panier> paniers = (List<Panier>) request.getAttribute("paniers"); %>
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
    <h1>Votre Panier</h1>
    <hr>
    <%
        if (paniers.size() == 0) {
            %> <h2>Panier est vide. Ajouter des articles : <a href="articles">Catalogue</a></h2> <%
    } else {
    %>
    <table class="table table-striped">
        <thead>
        <th>Reference</th>
        <th>Titre</th>
        <th>Photo</th>
        <th>Prix</th>
        <th>Quantite</th>
        <th></th>
        </thead>
        <%
            float prixTotal = 0;
            for (Panier panier : (List<Panier>) request.getAttribute("paniers")) {
                prixTotal += panier.getArticle().getPrix() * panier.getQuantite();
        %>
        <tr>
        <td><%= panier.getArticle().getReference() %></td>
        <td><%= panier.getArticle().getTitre() %></td>
        <td><%= panier.getArticle().getImage() %></td>
        <td><%= panier.getArticle().getPrix() %></td>
        <td><%= panier.getQuantite() %></td>

        <td>
            <form action="paniers" method="POST">
                <input type="hidden" value="delete" name="action">
                <input type="hidden" value="<%= panier.getId() %>" name="panier_id">
                <input type="submit" value="Supprimer du panier">
            </form>
        </td>
        </tr>
        <%
            }
        %>
        <h3>Le prix total : <%= prixTotal %> DH</h3>

    </table>
    <form action="commandes" method="POST">
        <input type="submit" value="Poursuivre la commande">
    </form>
    <% } %>
</div>
</body>
</html>
