<%@ page import="java.util.List" %>
<%@ page import="com.models.Article" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>

<%--<%@ page isELIgnored="false"%>--%>
<%  List<Article> articles = (List<Article>) request.getAttribute("articles"); %>


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
<hr>
<c:out value="${'Welcome JSTL'}" />
<div class="container">
    <form action="articles">
        <label for="">Choisissez le genre : </label>
        <select name="genre" id="">
            <option value="Tous">Tous</option>
            <option value="Jazz">Jazz</option>
            <option value="Classique">Classique</option>
            <option value="Pop">Pop</option>
        </select>
        <input type="submit" value="Valider">
    </form>
    <hr>
    <c:import
        url="xml"
        var="citizenXML"/>
<%--    <x:parse var="doc" xml="${citizenXML}" />--%>
<%--    <table border="1">--%>
<%--        <x:forEach var="citizen" select="$doc/citizens/citizen">--%>
<%--            <tr>--%>
<%--                <td><x:out select="ssn" /></td>--%>
<%--                <td><x:out select="firstname" /></td>--%>
<%--                <td><x:out select="lastname" /></td>--%>
<%--                <td><x:out select="role" /></td>--%>
<%--                <td><x:out select="salary"/></td>--%>
<%--            </tr>--%>
<%--        </x:forEach>--%>
<%--    </table>--%>

    <table class="table table-striped" >
        <thead>
            <th>Reference</th>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Photo</th>
            <th>Prix</th>
            <th></th>
        </thead>
<%--            <jsp:useBean id="CalculationBean" scope="request" type=""/>--%>
<%--        <c:set var = "articles" scope = "session" value = "${ List<Article> request.getAttribute('articles') }"/>--%>
            <c:forEach var="VAR" items="${ articles }">
                <tr>
                    <td>
                        <a href="articles?id=${ VAR.getId() }"> ${ VAR.getReference() }</a>
                    </td>
                    <td> ${ VAR.getTitre() } </td>
                    <td> ${ VAR.getAuteur() } </td>
                    <td>
                        <img src="${ VAR.getImage() } " height="70" alt="">
<%--                            ${ VAR.getImage() } --%>
                    </td>
                    <td> ${ VAR.getPrix() } </td>
                    <td>
                        <%--                <a href="<%= article.getId() %>"> Ajouter au panier</a> --%>
                        <form action="paniers" method="POST">
                            <label for="">Qte : </label>
                            <input type="number" name="quantite" value="1">
                            <input type="hidden" value="add" name="action">
                            <input type="hidden" name="article_id" value="${ VAR.getId() }">
                            <input type="submit" value="Ajouter au panier">
                        </form>
                    </td>
                </tr>
            </c:forEach>


    <%--        &lt;%&ndash;%>
<%--        for (Article article : (List<Article>) request.getAttribute("articles")) {--%>
<%--          %>--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <a href="articles?id=<%= article.getId() %>"> <%= article.getReference() %></a>--%>
<%--            </td>--%>
<%--            <td> <%= article.getTitre() %> </td>--%>
<%--            <td> <%= article.getAuteur() %> </td>--%>
<%--            <td> <%= article.getImage() %> </td>--%>
<%--            <td> <%= article.getPrix() %> </td>--%>
<%--            <td>--%>
<%--&lt;%&ndash;                <a href="<%= article.getId() %>"> Ajouter au panier</a> &ndash;%&gt;--%>
<%--                <form action="paniers" method="POST">--%>
<%--                    <label for="">Qte : </label>--%>
<%--                    <input type="number" name="quantite" value="1">--%>
<%--                    <input type="hidden" value="add" name="action">--%>
<%--                    <input type="hidden" name="article_id" value="<%= article.getId() %>">--%>
<%--                    <input type="submit" value="Ajouter au panier">--%>
<%--                </form>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        &lt;%&ndash;%>

<%--        }--%>
<%--        %>--%>
    </table>
</div>
</body>
</html>
