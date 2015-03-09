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
   <a href="/rsig/admin/source/consulter">Source-Consulter</a><br>
   <a href="/rsig/admin/source/ajout">Source-Ajouter</a><br>
   <!-- Theme --><br>
   <a href="/rsig/admin/theme/consulter">Theme-Consulter</a><br>
   <a href="/rsig/admin/theme/ajout">Theme-Ajouter</a><br>
   <!-- Ici on peut ajouter des nouvelles fonctionnalités si necessaires -->
   <!-- Alerte-Utilisateur --><br>
   <a href="/rsig/admin/alerterelation/ajout">Alerte-Utilisateur-Ajouter</a><br>
   <a href="/rsig/admin/alerterelation/consulter">Alerte-Utilisateur-Consulter</a><br>
   <!-- Autres --><br>
   <a href="/rsig/admin/demandemodif/consulter">Liste-Demande-Modif-Consulter</a><br>





</body>
</html>
