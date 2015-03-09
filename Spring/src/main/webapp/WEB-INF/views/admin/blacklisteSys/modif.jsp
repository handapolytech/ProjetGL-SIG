<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Modifer Theme</title>
</head>
<body>
${msgInfo}
<h1>
	Détail
</h1>
<!-- Attention, ici on part de la page modif, le chemin est relatif
 donc il ne faut pas ajouter admin/theme-->
<form action="modif" method="post">
id: <input type="number" name="id" value="${id}" readonly><br>
Nom du thème: <input type="text" name="theme" value="${theme}"><br>
<input type="submit" value="Modifier">
</form>
<form action="suppr" method ="get"><input type="hidden" name="id" value="${id}"><br><input type="submit" value="Supprimer"></form>

</body>
</html>
