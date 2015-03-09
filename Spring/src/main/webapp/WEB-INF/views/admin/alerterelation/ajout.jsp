<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Ajouter Alerte Utilisateur</title>
</head>
<body>
<h1>
	Ajouter une alerte  
</h1>
<form action="/rsig/admin/alerterelation/modif" method="post">
<input name="id_source" type="hidden" value="1">
Utilisateur: <select name="id_utilisateur">
<c:forEach items="${users}" var="user">
	<option value="<c:out value = "${user.id}" />"><c:out value = "${user.id}" /> - <c:out value = "${user.nom}" /></option>
</c:forEach>
</select><br>
Priorité:<input type="number" name="priorite"><br>
Sujet:<input type="text" name="sujet"><br>
Type:<input type="text" name="type"><br>
Statut:<input type="text" name="statut"><br>
Description:<input type="text" name="description"><br>
<input type="submit" value="submit">
</form>

</body>
</html>
