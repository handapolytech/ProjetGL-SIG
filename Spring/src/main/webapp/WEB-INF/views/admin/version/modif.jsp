<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Version</title>
</head>
<body>
${msgInfo}
<h1>
	Détail
</h1>

<!-- Attention, ici on part de la page modif, le chemin est relatif
 donc il ne faut pas ajouter admin/source-->
<form action="modif" method="post">
id: <input type="number" name="id" value="${version.id}" readonly><br>
id source: <input type="number" name="id_source" value="${version.id_source}" readonly><br>
URL Serveur: <input type="text" name="url_serveur" value="${version.url_serveur}"><br>
Version: <input type="text" name="version" value="${version.version}"><br>
Date Création: <input type="text" name="	date_creation_fournisseur" value="${version.date_creation_fournisseur}"><br>
</form>
<form action="../source/suppr_version" method ="get">
<input type="hidden" name="id" value="${version.id}">
<input type="hidden" name="id_source" value="${version.id_source}">
<input type="submit" value="Supprimer">
</form>

</body>
</html>
