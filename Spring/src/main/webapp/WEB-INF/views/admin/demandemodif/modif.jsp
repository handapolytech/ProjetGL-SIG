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
Utilisateur: <input name="id_utilisateur" value="${demandeModifRelation.id_utilisateur}" readonly><br>
<input name="id" type="hidden" value="${demandeModifRelation.id}">
<input name="id_source" type="hidden" value="${demandeModifRelation.id_source}">
Date:<input type="text" name="date" value="${demandeModifRelation.date}" readonly><br>
Type:<input type="text" name="type" value="${demandeModifRelation.type}"><br>
Statut:<input type="text" name="statut" value="${demandeModifRelation.statut}"><br>
Description:<input type="text" name="description" value="${demandeModifRelation.description}"><br>
</form>
<form action="suppr" method ="get"><input type="hidden" name="id" value="${demandeModifRelation.id}"><br><input type="submit" value="Supprimer"></form>

</body>
</html>
