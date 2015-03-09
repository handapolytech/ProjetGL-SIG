<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Consulter les alertes utilisateur</title>
</head>
<body>
${msgInfo}
<h1>
	Liste des alertes utilisateur
</h1>
<table>
	<tr><th>id</th><th>id utilisateur</th><th>Priorité</th><th>Date</th>
	<th>Sujet</th><th>Type</th><th>Statut</th><th>Détail</th></tr>
	<c:forEach items="${alerteRelations}" var="alerte">
		<tr>
				<td><c:out value = "${alerte.id}" /></td>
				<td><c:out value = "${alerte.id_utilisateur}" /></td>
				<td><c:out value = "${alerte.priorite}" /></td>
				<td><c:out value = "${alerte.date}" /></td>
				<td><c:out value = "${alerte.sujet}" /></td>
				<td><c:out value = "${alerte.type}" /></td>
				<td><c:out value = "${alerte.statut}" /></td>
				<td><a href="modif?id=${alerte.id}"><c:out value = "${alerte.id}" /></a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
