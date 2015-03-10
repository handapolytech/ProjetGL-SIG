<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Modifer Source</title>
</head>
<body>
${msgInfo}
<h1>
	Détail
</h1>
Thèmes:<br>
<ul style="list-style-type:disc">
<c:forEach items="${themes}" var="theme">
	<li><c:out value = "${theme.theme}" /></li>
</c:forEach>
</ul>
<!-- Attention, ici on part de la page modif, le chemin est relatif
 donc il ne faut pas ajouter admin/source-->
<form action="modif" method="post">
id: <input type="number" name="id" value="${id}" readonly><br>
URL Fournisseur: <input type="url" name="url_fournisseur" value="${url_fournisseur}"><br>
Titre: <input type="text" name="titre" value="${titre}"><br>
Niveau: <input type="text" name="niveau" value="${niveau}"><br>
Zone: <input type="text" name="zone" value="${zone}"><br>
Projection: <input type="text" name="projection" value="${projection}"><br>
Périodicité: <input type="text" name="periodicite" value="${periodicite}"><br>
Description: <input type="text" name="description" value="${description}"><br>
</form>

<form action="abonner" method ="post">
<input type="hidden" name="id" value="${id}">
Abonnée: <input type="checkbox" name="abonner" value="1" ${abonner} disabled="disabled">
<input type="submit" value="Abonner/Désabonner">
</form>

<form action="masquer" method ="post">
<input type="hidden" name="id" value="${id}">
Masqué: <input type="checkbox" name="masquer" value="1" ${masquer} disabled="disabled">
<input type="submit" value="Masquer/Afficher">
</form>

<h2>Versions</h2>
<table>
<tr><th>ID</th><th>URL Serveur</th><th>version</th><th>Date création</th><th>Détail</th></tr>
<c:forEach items="${versions}" var="version">
	<tr>
		<td><c:out value = "${version.id}" /></td>
		<td><c:out value = "${version.url_serveur}" /></td>
		<td><c:out value = "${version.version}" /></td>
		<td><c:out value = "${version.date_creation_fournisseur}" /></td>
		<td><a href="../version/modif?id=<c:out value = "${version.id}" />"><c:out value = "${version.id}" /></a></td>
	</tr>
</c:forEach>
</table>



</body>
</html>
