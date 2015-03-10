<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Acceuil Administrateur</title>
</head>
<body>
<h1>
	Bienvenue  
</h1>

<P>Que voulez vous faire?</P>
<!-- <form action="" method="get">
<select id="choix" name="choixFonction">
	Source
   <option value="10">Source-Consulter</option>
   <option value="11">Source-Ajouter</option>
   Version
   <option value="21">Source-Ajouter-Version</option>
   <option value="22">Source-Supprimer-Version</option>
   Theme
   <option value="30">Theme-Consulter</option>
   <option value="31">Theme-Ajouter</option>
   Blacklistage
   <option value="51">Blacklistage_Systeme-Ajouter</option>
   <option value="52">Blacklistage_Systeme-Supprimer</option>
   Ici on peut ajouter des nouvelles fonctionnalités si necessaires
   Systèmes
   <option value="91">Alerte-Utilisateur-Ajouter</option>
   <option value="92">Liste-Demande-Modif-Consulter</option> 
</select> 
<input type="submit" value="Accéder">
</form> -->

	<!-- Source -->
   <a href="/rsig/user/utilisateur/modif">Gestion de compte</a><br>
   <!-- Theme --><br>
   <a href="/rsig/user/source/consulter">Source-consulter</a><br>
   <!-- Ici on peut ajouter des nouvelles fonctionnalités si necessaires -->
   <!-- Autres --><br>
   <a href="/rsig/user/demandemodif/ajout">Liste-Demande-Modif-Ajouter</a><br>
   <a href="/rsig/user/demandemodif/consulter">Liste-Demande-Modif-Consulter</a><br>
   <br>
	<form action="recherche" method="get">
	Recherche:<input name="mot" type="text">
	<input type="submit" value="Rechercher">
	</form>




</body>
</html>
