<%@ page import="java.util.List" %>
<%@ page import="com.models.Article" %>
<%@ page import="com.models.Panier" %>
<%@ page import="com.models.Commande" %><%--
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
    <h1>Vos commandes</h1>
    <hr>
    <table class="table table-striped">
        <thead>
        <th  scope="col">#ID de la commande</th>
        <th scope="col">Date</th>
        <th scope="col">Articles</th>
        <th scope="col">Prix total</th>
        </thead>
        <%
            for (Commande commande : (List<Commande>) request.getAttribute("commandes")) {
                float prixTotal = 0;
        %>
        <tr>
        <td><%= commande.getId() %></td>
        <td><%= commande.getDateCommande() %></td>
        <td>
            <ol>
            <%
                for (Panier panier : commande.getPaniers()) {
                    prixTotal += panier.getArticle().getPrix() * panier.getQuantite();
            %>
                    <li><%= panier.getArticle().getTitre() + " : " + panier.getQuantite() + " x " + panier.getArticle().getPrix()  + " DH" %></li>
            <%
                }
            %>
            </ol>
        </td>
        <td><%= prixTotal  + " DH" %></td>
        </tr>
        <%

            }
        %>
    </table>
</div>
</body>
</html>
