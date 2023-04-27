<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 27/04/2023
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Recipe</title>
</head>
<body >
<a href="${pageContext.request.contextPath}" class="btn btn-dark m-2">recipes</a>
<div class="container">
    <h1 style="text-align: center;margin:30px ">Ajout d'une recette</h1>
    <form action="${pageContext.request.contextPath}/secured/createRecipe"  method="post">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-nom">nom</span>
            </div>
            <input type="text"  name="name" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-Type">Type</span>
            </div>
            <input type="text" name="type" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
        </div><div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="inputGroup-sizing-temps">temps</span>
        </div>
        <input type="number"  name="time" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
    </div>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text">Détails</span>
            </div>
            <textarea class="form-control" name="details" aria-label="With textarea"></textarea>
        </div>
    <div class="input-group mb-3 mt-3">
    <div class="input-group-prepend">
        <span class="input-group-text" id="inputGroup-sizing-photo">Url photo</span>
    </div>
    <input type="text" class="form-control" name="photo" aria-label="Default" aria-describedby="inputGroup-sizing-default">
    </div>

<button type="submit" class="btn btn-primary m-2" >ajout recette </button>
 </form>
</div>
</body>
</html>
