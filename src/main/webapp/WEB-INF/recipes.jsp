<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
  <title>My recipe book</title>
</head>
<body>
<div class="container ">
    <% if(request.getSession().getAttribute("email") != null) { %>
    <a href="${pageContext.request.contextPath}/secured/logout" class="btn btn-danger">Déconnexion</a>
    <a href="${pageContext.request.contextPath}/secured/update?email=${email}" class="btn btn-success">Profil</a>
    <a href="${pageContext.request.contextPath}/secured/random" class="btn btn-info"> recette  aléatoire</a>
    <a href="${pageContext.request.contextPath}/secured/createRecipe" class="btn btn-success">Ajout recette </a>
    <form action="${pageContext.request.contextPath}/" method="post" >
        <input type="search" name="keyword" placeholder="votre recherche">
        <button type="submit" class="btn btn-danger">recherche</button>
    </form>

    <% } else { %>
        <a href="${pageContext.request.contextPath}/login" class="btn btn-success">connexion</a>
        <% } %>
    <h1 style="text-align: center"> My recipe book  </h1>
  <c:if test="${empty recipeDtos}">
    <p>Aucun post trouvé.</p>
  </c:if>
  <div class=" container " style="display: grid;grid-template-columns: repeat(3, 1fr);
grid-column-gap: 20px;
grid-row-gap: 20px; ">
  <c:forEach items="${recipeDtos}" var="recipe">
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
  </c:forEach>
<br/>
</div>
</div>

</body>
</html>