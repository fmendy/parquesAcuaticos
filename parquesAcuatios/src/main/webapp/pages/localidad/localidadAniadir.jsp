<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 500px">
	<br> <br>

	<form name="localidadAniadir" class="text-center border border-light p-5"
		action="localidadAniadir">

		<p class="h4 mb-4">
			<s:text name="Localidad" />
		</p>


		<!-- Pais -->
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01"><s:text
						name="Pais" /></label>
			</div>
			<s:select id="listaPaises" name="localidad.provincia.pais.idpais"
				list="listaPaises" listKey="idPais" listValue="nombre" size="1"
				required="true" headerValue="Seleccione" headerKey=""
				class="browser-default custom-select"
				onchange="actualizarProvincias()" />

		</div>
		<br>

		<!-- Provincia -->
		<div class="input-group mb-3" id="listaProvincias">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01"><s:text
						name="Provincia" /></label>
			</div>
			<s:select name="localidad.provincia.idProvincia"
				list="listaProvincias" listKey="idProvincia" listValue="nombre"
				size="1" required="true" headerValue="Seleccione" headerKey=""
				id="listaProvincias" class="browser-default custom-select" />

		</div>
		<br>
		
		<!-- Localidad -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">
					<s:text
						name="Localidad.Nombre" />
				</div>
			</div>
			<input type="text" name="localidad.nombre" class="form-control py-0" pattern="[A-Za-z]*"
				id="inlineFormInputGroup" placeholder="Localidad" required="required" >
		</div>
		<br>
		
		<!-- Aniadir -->
		<button class="btn btn-info btn-block my-4" type="submit">
			<s:text name="Localidad.Aniadir" />
		</button>


	</form>
</div>
<jsp:include page="/pages/general/pageFooter.jsp" />
<script>
	function actualizarProvincias() {
		var idpais = $("#listaPaises").val();
		$.ajax({
			type : "GET",
			url : "getProvinciasPais?pais.idPais="+idpais,

			success : function(json) {
				$("#listaProvincias").empty();
				$("#listaProvincias").append(json);
				
			}
		});
	}

	
</script>