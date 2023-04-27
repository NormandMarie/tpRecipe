<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 27/04/2023
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edition profil</title>
</head>
<body>
<div class="card mb-3">
    <img class="card-img-top" src="${userDto.photo}" alt="Card image cap" style="height: 300px; object-fit: cover">
    <div class="card-body">
        <h5 class="card-title">${userDto.prenom} ${userDto.nom}</h5>
    </div>
   <form action="${pageContext.request.contextPath}/secured/update" method="post" class="container">
       <div class="col">
           <input type="hidden" name="email" class="form-control" value="${userDto.email}">
           <input type="text" name="prenom" class="form-control" value="${userDto.prenom}">
       </div>
       <div class="col">
           <input type="text" name="nom" class="form-control"value="${userDto.nom}">
       </div>
       <div class="form-group">
           <label for="exampleInputphoto">photo </label>
           <input type="text"  name="photo" class="form-control" id="exampleInputphoto" aria-describedby="photo"value="${userDto.photo}">
       </div>
       <button type="submit" class="btn btn-primary" class="d-flex">changement</button>
   </form>
</div>
</body>
</html>
