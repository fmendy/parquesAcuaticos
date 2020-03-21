<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="./pageResources.jsp" />
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="#">Postales</a>

		
			<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<s:if test="%{isUserLoged()}">
					<li class="nav-item"><a class="nav-link" href="#">Mis
							Datos </a></li>
					<li class="nav-item"><a class="nav-link" href="#">Mis Albums</a></li>
					<li class="nav-item"><a class="nav-link" href="verCompanias"><s:text name="Compania"/></a></li>
					<li class="nav-item"><a class="nav-link" href="#">Mis Albums</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Cerrar sesion </a></li>
				</s:if>
				<s:else>
					<li class="nav-item"><a class="nav-link" href="irUsuarioLogin">Iniciar Sesion </a></li>
					<li class="nav-item"><a class="nav-link" href="irRegistroUsuario">Registrarse</a></li>
				</s:else>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		
		
	</nav>
	

</body>
</html>