<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Ajouter Blacklistage Syst�me</title>
</head>
<body>
<h1>
	Ajouter un blacklistage syst�me 
</h1>
<form action="/rsig/admin/blacklisteSys/modif" method="post">
Nom du th�me: <input type="text" name="theme"><br>
<input type="submit" value="submit">
</form>

</body>
</html>
