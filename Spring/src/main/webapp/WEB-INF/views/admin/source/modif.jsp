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
	<li><c:out value = "${theme.theme}" />  <a href="modif_retirer_theme?id=${id}&id_tr_retirer=<c:out value = "${theme.id}" />">Retirer</a></li>
</c:forEach>
<li><form action="modif_associer_theme" method="get">
<input type="hidden" name="id" value="${id}">
Associer à un theme <select name="id_theme_associer">
<option value="0">------</option>
<c:forEach items="${idThemes}" var="idTheme">
	<option value="<c:out value = "${idTheme.id}" />"><c:out value = "${idTheme.id}" /> - <c:out value = "${idTheme.theme}" /></option>
</c:forEach>
</select>
<input type="submit" value="Associer">
</form></li>
</ul>
<!-- Attention, ici on part de la page modif, le chemin est relatif
 donc il ne faut pas ajouter admin/source-->
<form action="modif" method="post">
id: <input type="number" name="id" value="${id}" readonly><br>
Masqué: <input type="checkbox" name="masquer" value="1" ${masquer}><br>
URL Fournisseur: <input type="url" name="url_fournisseur" value="${url_fournisseur}"><br>
Titre: <input type="text" name="titre" value="${titre}"><br>
Niveau: <input type="text" name="niveau" value="${niveau}"><br>
Zone: <input type="text" name="zone" value="${zone}"><br>
Projection: <input type="text" name="projection" value="${projection}"><br>
Périodicité: <input type="text" name="periodicite" value="${periodicite}"><br>
Description: <input type="text" name="description" value="${description}"><br>
<input type="submit" value="Modifier">
</form>
<form action="suppr" method ="get"><input type="hidden" name="id" value="${id}"><br><input type="submit" value="Supprimer"></form>

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
<form action="../version/ajout" method="get">
<input type="hidden" name="id_source" value="${id}">
<input type="submit" value="Ajouter une version">
</form>

</body>
</html>
