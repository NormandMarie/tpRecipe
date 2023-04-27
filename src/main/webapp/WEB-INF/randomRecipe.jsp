<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: warie
  Date: 27/04/2023
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>recette Random</title>
</head>
<body>
<a href="${pageContext.request.contextPath}" class="btn btn-dark m-2">recipes</a>
<%--<c:if test="${empty recipe}">--%>
<%--    <p>Aucune recette trouvé.</p>--%>
<%--</c:if>--%>
<div class=" container " style="display: grid;grid-template-columns: repeat(3, 1fr);
grid-column-gap: 20px;
grid-row-gap: 20px; ">
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="${recipe.photoUrl}" alt="Card image recipe" style="
    object-fit: cover;
    height: 200px;
    width: 100%;
">
        <div class="card-body" style="min-height: 213px;">
            <div class="d-flex justify-content-between">
                <p style="margin-bottom: 0.5em;"><strong>${recipe.type} </strong></p>
                <p>${recipe.dateAdded}</p>
            </div>
            <h5 class="card-title">${recipe.name} </h5>
            <p class="card-text">${recipe.details}</p>
            <a href="#" class="btn btn-primary mb-2">${recipe.executionTime} min</a>
        </div>
    </div>
</body>
</html>
