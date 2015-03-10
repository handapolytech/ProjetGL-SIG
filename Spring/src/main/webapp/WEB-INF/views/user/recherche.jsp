<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Résultat de recherche pour les sources</title>
</head>
<body>
${msgInfo}
<h1>
	Résultat de la recherche
</h1>
<h2>Mot clé: ${mot} </h2>
<table>
	<tr><th>id</th><th>URL fournisseur</th><th>Titre</th><th>Niveau</th>
	<th>Zone</th><th>Projection</th><th>Périodicité</th><th>Description</th><th>Détail</th></tr>
	<c:forEach items="${sources}" var="source">
		<tr>
				<td><c:out value = "${source.id}" /></td>
				<td><c:out value = "${source.url_fournisseur}" /></td>
				<td><c:out value = "${source.titre}" /></td>
				<td><c:out value = "${source.niveau}" /></td>
				<td><c:out value = "${source.zone}" /></td>
				<td><c:out value = "${source.projection}" /></td>
				<td><c:out value = "${source.periodicite}" /></td>
				<td><c:out value = "${source.description}" /></td>
				<td><a href="source/modif?id=${source.id}"><c:out value = "${source.id}" /></a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
