<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<title>Projet Génie Logiciel</title>

			<!-- Bootstrap -->
			<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
			<link href="<c:url value="assets/css/main.css" />" rel="stylesheet">
	</head>
	<body>
		<!-- Barre d'entête -->
		<div class="navbar navbar-inverse navbar-fixed-top navbar-default">
			<div class="navbar-header">
				<a class="navbar-brand" href="http://vps139681.ovh.net/~groupe3/">Projet GL - Groupe 3</a>
				<a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="glyphicon glyphicon-bar"></span>
					<span class="glyphicon glyphicon-bar"></span>
					<span class="glyphicon glyphicon-bar"></span>
				</a>
			</div>
			<div class="container">
				
				<ul class="nav navbar-nav navbar-left">
					<!-- Hiérarchie -->
					<li class="navbar-form navbar-left inline-form">
						<ul class="nav-breadcrumb list-inline">
							<li class="active">Accueil</li>
						</ul>
					</li>
					
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					
					<!-- Options Utilisateur -->
					<li class="dropdown navbar-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Salut Fredo<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Vue Administrateur</a></li>
							<li><a href="#">Vue Utilisateur</a></li>
							<li><a href="#">Paramètres</a></li>
							<hr/>
							<li><a href="#">Déconnexion</a></li>
						</ul>
					</li>
					
					<!-- Recherche Avancée -->
					<li class="navbar-right"><a href="#">Recherche Avancée</a></li>
					
					<!-- Recherche -->
					<form class="navbar-form navbar-right inline-form">
						<div class="form-group">
							<input type="search" class="input-sm form-control" placeholder="Recherche">
								<button type="submit" class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-search"></span>
									Chercher
								</button>
							</input>
						</div>
					</form>
				</ul>
			</div>
		</div>
		
		<!-- Corps de la page -->
		<div class="container wrapper">
			<div class="row">
				
				<!-- Sidebar -->
				<div class="col-md-2">
					<div class="sidebar-nav-fixed" data-spy="affix" data-offset-top="140">
						<ul class="nav ">
						<li> <a href="http://vps139681.ovh.net/~groupe3/">Accueil</a> </li>
						<hr/>
						<li> <a href="#">Liste des données</a> </li>
						<li> <a href="#">Alertes <span class="badge">42</span></a> </li>
						<li> <a href="#">Demandes</a> </li>
						<li> <a href="#">Profil et Abonnements</a> </li>
						<li> <a href="#">Gestion des membres</a> </li>
						<li> <a href="#">Gestions des sources</a> </li>
						</ul>
					</div>
				</div>
				
				<div class="col-md-9">
						<h1>Dernières mises à jour parmi vos abonnements</h1>
						<!-- Informations condensées de l'article -->
						<div id="content" class="row">
							<hr/>
							<div class="article-condense">
								<a href="#">Peuplement de l'Espagne</a>
								- Dernière mise à jour le
								12/12/2014
								- Thème(s) :
								<span class="label label-info">Démographie</span>
								- Zone(s) Géographique(s) :
								<span class="label label-primary">Espagne</span>
								<span class="label label-primary">Europe</span>
								- 
								<a href="#">se désabonner</a>
							</div>
							<hr/>
							<div class="article-condense">
								<a href="#">Plus grans festivals d'Europe</a>
								- Dernière mise à jour le
								12/12/2014
								- Thème(s) :
								<span class="label label-info">Festival</span>
								- Zone(s) Géographique(s) :
								<span class="label label-primary">Europe</span>
								- 
								<a href="#">s'abonner</a>
							</div>
							<hr/>
							<div class="article-condense">
								<a href="#">Peuplement de l'Espagne</a>
								- Dernière mise à jour le
								12/12/2014
								- Thème(s) :
								<span class="label label-info">Démographie</span>
								- Zone(s) Géographique(s) :
								<span class="label label-primary">Espagne</span>
								<span class="label label-primary">Europe</span>
								- 
								<a href="#">se désabonner</a>
							</div>
							<hr/>
							<div class="article-condense">
								<a href="#">Plus grans festivals d'Europe</a>
								- Dernière mise à jour le
								12/12/2014
								- Thème(s) :
								<span class="label label-info">Festival</span>
								- Zone(s) Géographique(s) :
								<span class="label label-primary">Europe</span>
								- 
								<a href="#">s'abonner</a>
							</div>
							<hr/>
							<div class="article-condense">
								<a href="#">Peuplement de l'Espagne</a>
								- Dernière mise à jour le
								12/12/2014
								- Thème(s) :
								<span class="label label-info">Démographie</span>
								- Zone(s) Géographique(s) :
								<span class="label label-primary">Espagne</span>
								<span class="label label-primary">Europe</span>
								- 
								<a href="#">se désabonner</a>
							</div>
							<hr/>
							<div class="article-condense">
								<a href="#">Plus grans festivals d'Europe</a>
								- Dernière mise à jour le
								12/12/2014
								- Thème(s) :
								<span class="label label-info">Festival</span>
								- Zone(s) Géographique(s) :
								<span class="label label-primary">Europe</span>
								- 
								<a href="#">s'abonner</a>
							</div>
							<hr/>
							<div class="article-condense">
								<a href="#">Peuplement de l'Espagne</a>
								- Dernière mise à jour le
								12/12/2014
								- Thème(s) :
								<span class="label label-info">Démographie</span>
								- Zone(s) Géographique(s) :
								<span class="label label-primary">Espagne</span>
								<span class="label label-primary">Europe</span>
								- 
								<a href="#">se désabonner</a>
							</div>
							<hr/>
							<div class="article-condense">
								<a href="#">Plus grans festivals d'Europe</a>
								- Dernière mise à jour le
								12/12/2014
								- Thème(s) :
								<span class="label label-info">Festival</span>
								- Zone(s) Géographique(s) :
								<span class="label label-primary">Europe</span>
								- 
								<a href="#">s'abonner</a>
							</div>
							<hr/>
							<div class="article-condense">
								<a href="#">Peuplement de l'Espagne</a>
								- Dernière mise à jour le
								12/12/2014
								- Thème(s) :
								<span class="label label-info">Démographie</span>
								- Zone(s) Géographique(s) :
								<span class="label label-primary">Espagne</span>
								<span class="label label-primary">Europe</span>
								- 
								<a href="#">se désabonner</a>
							</div>
						</div>
						<div id="page_navigation"> </div>
				</div>
			</div>
			
			<div class="push"></div>
		</div>
		
		<!-- Footer -->
		<footer class="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-2">
						<img src="img/logo_UPSUD.png" alt="Logo de l'Université Paris-Sud" height="80px">
					</div>
					<div class="col-md-8 footer-center">
						<p class="text-muted">
							Projet Génie Logiciel - BOSOM OUBRIK PONCET ZHANG
						</p>
						<p class="text-muted">
							Framework : <a href="http://getbootstrap.com/">Bootstrap</a>
						</p>
						<P>  The time on the server is ${serverTime}. </P>
					</div>
					<div class="col-md-2">
						<img src="img/logo_BOUYGUES.jpg" alt="Logo de Bouygues Energies & Services" height="80px">
					</div>
				</div>
			</div>
		</footer>
		
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="<c:url value="js/jquery.min.js" />"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="<c:url value="js/bootstrap.min.js" />"></script>
		<script src="<c:url value="assets/js/pagination.js" />"></script>
	</body>
</html>
