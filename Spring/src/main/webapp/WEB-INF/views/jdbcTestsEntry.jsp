<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JDBC Test</title>
</head>
<body>
<form action="jdbcTests" method="post">
<select id="ListeElement" name="tableName"> 
   <option value="test">Test</option>
   <option value="utilisateur">Utilisateur</option>
   <option value="source">Source</option>
   <option value="theme">Theme</option>
   <option value="themeRelation">ThemeRelation</option>
   <option value="version">Version</option>
   <option value="abonnementRelation">AbonnementRelation</option> 
   <option value="alerteRelation">AlerteRelation</option> 
   <option value="blacklistageSysteme">BlacklistageSysteme</option> 
   <option value="blacklistageUtilisateurRelation">BlacklistageUtilisateurRelation</option>
   <option value="demandeModifRelation">DemandeModifRelation</option>  
</select> 
<input type="submit" value="Test">
</form>
</body>
</html>