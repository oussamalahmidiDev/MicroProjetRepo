<%--
  Created by IntelliJ IDEA.
  User: oussamalahmidi
  Date: 07/03/2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp" />
<body>
<h1>Identifiez-vous</h1>
<hr>
<div class="container">
    <form action="login" method="POST">
        <label for="" class="label">Email</label>
        <input type="email" name="email"><br>

        <label for="" class="label">Mot de passe <span style="color:red">*</span></label>
        <input type="password" name="password"><br>

        <input type="submit" value="Valider" class="submit"><br>

        <%--        <span style="color:'red'">*</span> : champ--%>


    </form>
</div>
</body>
</html>
