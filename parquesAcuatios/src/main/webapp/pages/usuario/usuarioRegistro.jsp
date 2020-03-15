<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 500px">
	<br> <br>

	<form name="registrarUsuario"
		class="text-center border border-light p-5" action="registrarUsuario">

		<p class="h4 mb-4">
			<s:text name="Registrar" />
		</p>

		<!-- Email -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">@</div>
			</div>
			<input type="email" name="usuario.email" class="form-control py-0"
				id="inlineFormInputGroup" placeholder="E-mail" required="required">
			
		</div>
			<s:fielderror fieldName="usuario.email" style="list-style:none; color:#970808; margin-bottom:0px" />	
		<br>

		<!-- Apodo -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">
					N
				</div>
			</div>
			<input type="text" name="usuario.apodo" class="form-control py-0"
				id="inlineFormInputGroup" placeholder="nick" required="required">
		</div>
		<s:fielderror fieldName="usuario.apodo" style="list-style:none; color:#970808; margin-bottom:0px" />
		<br>



		<!-- Password -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">
					<i style="font-size: 24px" class="fa">&#xf023;</i>
				</div>
			</div>
			<input type="password" name="usuario.password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="<s:text name="Password.Condiciones"/>"
				class="form-control py-0" id="inlineFormInputGroup"
				placeholder="Password" required="required">
		</div>





		<!-- Sign in button -->
		<button class="btn btn-info btn-block my-4" type="submit">
			<s:text name="Registrar" />
		</button>

		<!-- Register -->
		<p>
			<s:text name="Ya.Eres.Miembro" />
			<a href="irUsuarioLogin"><s:text name="Iniciar.Sesion" /></a>
		</p>


	</form>
</div>
<jsp:include page="/pages/general/pageFooter.jsp" />
<script>
	// Disable form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Get the forms we want to add validation styles to
			var forms = document.getElementsByClassName('needs-validation');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>
