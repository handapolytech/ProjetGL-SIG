<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Consulter les demandes de modifications</title>
</head>
<body>
${msgInfo}
<h1>
	Liste des demandes de modifications
</h1>
<table>
	<tr><th>id</th><th>id utilisateur</th><th>id source</th><th>Date</th>
	<th>Type</th><th>Statut</th><th>Détail</th></tr>
	<c:forEach items="${demandeModifRelations}" var="demandeModifRelation">
		<tr>
				<td><c:out value = "${demandeModifRelation.id}" /></td>
				<td><c:out value = "${demandeModifRelation.id_utilisateur}" /></td>
				<td><a href="/rsig/admin/source/modif?id=<c:out value = "${demandeModifRelation.id_source}" />"><c:out value = "${demandeModifRelation.id_source}" /></a></td>
				<td><c:out value = "${demandeModifRelation.date}" /></td>
				<td><c:out value = "${demandeModifRelation.type}" /></td>
				<td><c:out value = "${demandeModifRelation.statut}" /></td>
				<td><a href="modif?id=${demandeModifRelation.id}"><c:out value = "${demandeModifRelation.id}" /></a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
