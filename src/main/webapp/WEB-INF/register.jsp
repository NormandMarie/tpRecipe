<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 27/04/2023
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<html>
<head>
    <title>S'incrire</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post">
    <div class="row">
        <div class="col">
            <input type="text" name="prenom" class="form-control" placeholder="prenom">
        </div>
        <div class="col">
            <input type="text" name="nom" class="form-control" placeholder="nom">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Email </label>
            <input type="email"  name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Entrée email">
            <small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais votre e-mail avec quelqu'un d'autre.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputphoto">photo </label>
            <input type="text"  name="photo" class="form-control" id="exampleInputphoto" aria-describedby="photo" placeholder="Entrée url de l'image">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">mot de passe</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="mot de passe">
        </div>
    </div>
    <button type="submit">s'incrire</button>
</form>
</body>
</html>
