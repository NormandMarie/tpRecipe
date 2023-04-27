<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 27/04/2023
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" class="container" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Email </label>
        <input type="email"  name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Entrée email">
        <small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais votre e-mail avec quelqu'un d'autre.</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">mot de passe</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="mot de passe">
    </div>
    <div class="form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Es jolie?</label>
    </div>
    <button type="submit" class="btn btn-primary">Connexion</button>
</form>
<a href="register">inscription </a>
<c:if test="${isError == true}">
    <p>veuillez réessayer.</p>
</c:if>
</body>
</html>
