<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 500px">
	<br> <br>

	<!-- Default form login -->
	<form name="loginUsuario" class="text-center border border-light p-5"
		action="loginUsuario">

		<p class="h4 mb-4">
			<s:text name="Iniciar.Sesion" />
		</p>

		<!-- Email -->
		<!-- Email -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">@</div>
			</div>
			<input type="email" name="usuario.email" class="form-control py-0"
				id="inlineFormInputGroup" placeholder="E-mail" required="required">
		</div>
		<br>

		<!-- Password -->
		<!-- Password -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">
					<i style="font-size: 24px" class="fa">&#xf023;</i>
				</div>
			</div>
			<input type="password" name="usuario.password" 
				class="form-control py-0" id="inlineFormInputGroup"
				placeholder="Password" required="required">
		</div>
		<br>

		<div class="d-flex justify-content-around">
			<div>
				<!-- Remember me -->
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input"
						id="defaultLoginFormRemember"> <label
						class="custom-control-label" for="defaultLoginFormRemember"><s:text
							name="Recordarme" /> </label>
				</div>
			</div>
			<div>
				<!-- Forgot password -->
				<a href=""><s:text name="Password.Olvidada" /></a>
			</div>
		</div>

		<!-- Sign in button -->
		<button class="btn btn-info btn-block my-4" type="submit">
			<s:text name="Iniciar.Sesion" />
		</button>

		<!-- Register -->
		<p>
			<s:text name="No.Eres.Miembro" />
			<a href="irRegistroUsuario"><s:text name="Registrate" /></a>
		</p>


	</form>
	<!-- Default form login -->
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
