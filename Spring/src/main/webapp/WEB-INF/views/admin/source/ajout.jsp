<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Ajouter Source</title>
</head>
<body>
<h1>
	Ajouter une source  
</h1>
<form action="/rsig/admin/source/modif" method="post">
URL Fournisseur: <input type="url" name="url_fournisseur"><br>
Titre: <input type="text" name="titre"><br>
Niveau: <input type="text" name="niveau"><br>
Zone: <input type="text" name="zone"><br>
Projection: <input type="text" name="projection"><br>
Périodicité: <input type="number" name="periodicite"><br>
Description: <input type="text" name="description"><br>
<input type="submit" value="submit">
</form>

</body>
</html>
