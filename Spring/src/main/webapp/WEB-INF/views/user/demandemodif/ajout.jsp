<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Modifer Une demande de modification</title>
</head>
<body>
${msgInfo}
<h1>
	Détail
</h1>
<!-- Attention, ici on part de la page modif, le chemin est relatif
 donc il ne faut pas ajouter admin/theme-->
<form action="modif" method="post">
Source:<select name="id_source">
<c:forEach items="${sources}" var="source">
	<option value="<c:out value = "${source.id}" />"><c:out value = "${source.id}" /> - <c:out value = "${source.titre}" /></option>
</c:forEach>
</select><br>
Type:<input type="text" name="type" value="${demandeModifRelation.type}"><br>
Description:<input type="text" name="description" value="${demandeModifRelation.description}"><br>
<input type="submit" value="Envoyer">
</form>

</body>
</html>
