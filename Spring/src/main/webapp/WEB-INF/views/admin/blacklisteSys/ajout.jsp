<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Ajouter Blacklistage Système</title>
</head>
<body>
<h1>
	Ajouter un blacklistage système 
</h1>
<form action="/rsig/admin/blacklisteSys/modif" method="post">
Nom du thème: <input type="text" name="theme"><br>
<input type="submit" value="submit">
</form>

</body>
</html>
