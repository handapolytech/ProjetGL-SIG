<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Consulter les Themes</title>
</head>
<body>
${msgInfo}
<h1>
	Liste des themes
</h1>
<table>
	<tr><th>id</th><th>Nom du theme</th><th>Détail</th></tr>
	<c:forEach items="${themes}" var="theme">
		<tr>
				<td><c:out value = "${theme.id}" /></td>
				<td><c:out value = "${theme.theme}" /></td>
				<td><a href="modif?id=${theme.id}"><c:out value = "${theme.id}" /></a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
