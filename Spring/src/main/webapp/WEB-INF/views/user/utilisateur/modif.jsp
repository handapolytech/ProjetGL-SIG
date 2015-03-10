<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Profil</title>
</head>
<body>
${msgInfo}
<h1>
	Profil
</h1>
<!-- Attention, ici on part de la page modif, le chemin est relatif
 donc il ne faut pas ajouter admin/theme-->
<form action="modif" method="post">
<input name="id" type="hidden" value="${utilisateur.id}" readonly>
Nom:<input type="text" name="nom" value="${utilisateur.nom}" readonly><br>
E-mail:<input type="text" name="email" value="${utilisateur.email}"><br>
Role:<input type="text" name="role" value="${utilisateur.role}" readonly><br>
Fréquence des alertes :<input type="number" name="alert_frequence" value="${utilisateur.alert_frequence}"><br>
<input type="submit" value="Modifier">
</form>

</body>
</html>
