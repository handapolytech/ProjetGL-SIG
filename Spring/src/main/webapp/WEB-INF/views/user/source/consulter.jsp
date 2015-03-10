<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Consulter les Sources</title>
</head>
<body>
${msgInfo}
<h1>
	Liste des sources
</h1>
<center><h2>Sources Abonnées</h2></center>
<table>
	<tr><th>id</th><th>URL fournisseur</th><th>Titre</th><th>Niveau</th>
	<th>Zone</th><th>Projection</th><th>Périodicité</th><th>Description</th><th>Détail</th></tr>
	<c:forEach items="${sourcesAbonne}" var="sourceAbonne">
		<tr>
				<td><c:out value = "${sourceAbonne.id}" /></td>
				<td><c:out value = "${sourceAbonne.url_fournisseur}" /></td>
				<td><c:out value = "${sourceAbonne.titre}" /></td>
				<td><c:out value = "${sourceAbonne.niveau}" /></td>
				<td><c:out value = "${sourceAbonne.zone}" /></td>
				<td><c:out value = "${sourceAbonne.projection}" /></td>
				<td><c:out value = "${sourceAbonne.periodicite}" /></td>
				<td><c:out value = "${sourceAbonne.description}" /></td>
				<td><a href="modif?id=${sourceAbonne.id}"><c:out value = "${sourceAbonne.id}" /></a></td>
		</tr>
	</c:forEach>
</table>
<center><h2>Sources accesibles</h2></center>
<table>
	<tr><th>id</th><th>URL fournisseur</th><th>Titre</th><th>Niveau</th>
	<th>Zone</th><th>Projection</th><th>Périodicité</th><th>Description</th><th>Détail</th></tr>
	<c:forEach items="${sourcesDispo}" var="sourceDispo">
		<tr>
				<td><c:out value = "${sourceDispo.id}" /></td>
				<td><c:out value = "${sourceDispo.url_fournisseur}" /></td>
				<td><c:out value = "${sourceDispo.titre}" /></td>
				<td><c:out value = "${sourceDispo.niveau}" /></td>
				<td><c:out value = "${sourceDispo.zone}" /></td>
				<td><c:out value = "${sourceDispo.projection}" /></td>
				<td><c:out value = "${sourceDispo.periodicite}" /></td>
				<td><c:out value = "${sourceDispo.description}" /></td>
				<td><a href="modif?id=${sourceDispo.id}"><c:out value = "${sourceDispo.id}" /></a></td>
		</tr>
	</c:forEach>
</table>


<center><h2>Sources masqués</h2></center>
<table>
	<tr><th>id</th><th>URL fournisseur</th><th>Titre</th><th>Niveau</th>
	<th>Zone</th><th>Projection</th><th>Périodicité</th><th>Description</th><th>Détail</th></tr>
	<c:forEach items="${sourcesMasquee}" var="sourceMasquee">
		<tr>
				<td><c:out value = "${sourceMasquee.id}" /></td>
				<td><c:out value = "${sourceMasquee.url_fournisseur}" /></td>
				<td><c:out value = "${sourceMasquee.titre}" /></td>
				<td><c:out value = "${sourceMasquee.niveau}" /></td>
				<td><c:out value = "${sourceMasquee.zone}" /></td>
				<td><c:out value = "${sourceMasquee.projection}" /></td>
				<td><c:out value = "${sourceMasquee.periodicite}" /></td>
				<td><c:out value = "${sourceMasquee.description}" /></td>
				<td><a href="modif?id=${sourceMasquee.id}"><c:out value = "${sourceMasquee.id}" /></a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
