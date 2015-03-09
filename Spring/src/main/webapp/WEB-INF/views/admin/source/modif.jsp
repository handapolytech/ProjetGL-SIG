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

</body>
</html>
