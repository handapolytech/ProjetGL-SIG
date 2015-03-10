<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Version</title>
</head>
<body>
${msgInfo}
<h1>Ajouter une nouvelle version</h1>
<!-- Attention, ici on part de la page modif, le chemin est relatif
 donc il ne faut pas ajouter admin/source-->
<form action="modif" method="post">
ID source: <input type="number" name="id_source" value="${id_source}" readonly><br>
URL de téléchargement: <input type="text" name="url_serveur"><br>
Version: <input type="text" name="version"><br>
<input type="submit" valeur="Ajouter">
</form>

</body>
</html>
