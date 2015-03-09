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
Utilisateur: <input name="id_utilisateur" value="${alerteRelation.id_utilisateur}" readonly><br>
<input name="id" type="hidden" value="${alerteRelation.id}">
<input name="id_source" type="hidden" value="1">
Priorité:<input type="number" name="priorite" value="${alerteRelation.priorite}"><br>
Date:<input type="text" name="date" value="${alerteRelation.date}" readonly><br>
Sujet:<input type="text" name="sujet" value="${alerteRelation.sujet}"><br>
Type:<input type="text" name="type" value="${alerteRelation.type}"><br>
Statut:<input type="text" name="statut" value="${alerteRelation.statut}"><br>
Description:<input type="text" name="description" value="${alerteRelation.description}"><br>
</form>
<form action="suppr" method ="get"><input type="hidden" name="id" value="${alerteRelation.id}"><br><input type="submit" value="Supprimer"></form>

</body>
</html>
