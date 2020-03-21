<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 500px">
	<br> <br>

	<form name="guardarParque"
		class="text-center border border-light p-5" action="guardarParque"
		enctype="multipart/form-data" method="POST">

		<p class="h4 mb-4">
			<s:text name="Parque" />
		</p>

		<!-- id -->
		<s:hidden name="parque.idParque" />
		<s:hidden name="parque.activo" />
		<s:hidden name="parque.imagen" />

		<!-- Nombre -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">
					<s:text name="Compania.Nombre" />
				</div>
			</div>
			<input type="text" name="parque.nombre" class="form-control py-0"
				maxlength="80" id="inlineFormInputGroup" placeholder=Nombre
				required="required" value="<s:property value="parque.nombre" />">
		</div>
		<br>

		<!-- Web -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">
					<s:text name="Parque.Web" />
				</div>
			</div>
			<input type="text" name="parque.web" class="form-control py-0"
				pattern="[A-Za-z]*" maxlength="80" id="inlineFormInputGroup"
				placeholder="Web" value="<s:property value="parque.web" />">
		</div>
		<br>
		<!-- Descripcion -->
		<div class="form-group">
			<label for="exampleFormControlTextarea3"><s:text name="Parque.Descripcion" /></label>
			<textarea name="parque.descripcion" class="form-control" id="exampleFormControlTextarea3"
				rows="7"><s:property value="parque.descripcion" /></textarea>
		</div>
		<br>
		
		<!-- Compania -->
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01"><s:text
						name="Compania" /></label>
			</div>
			<s:select id="listaCompanias" name="parque.Compania.idCompania"
				list="listCompanias" listKey="idCompania" listValue="nombre" size="1"
				required="true" headerValue="Seleccione" headerKey=""
				class="browser-default custom-select" />

		</div>
		<br>

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
				id="listaProvincias" class="browser-default custom-select"
				onchange="actualizarLocalidades()" />

		</div>
		<br>
		
		<!-- Localidad -->
		<div class="input-group mb-3" id="listaLocalidades">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01"><s:text
						name="Localidad" /></label>
			</div>
			<s:select name="localidad.idLocalidad"
				list="listaLocalidades" listKey="idLocalidad" listValue="nombre"
				size="1" required="true" headerValue="Seleccione" headerKey=""
				id="listaLocalidades" class="browser-default custom-select" />

		</div>
		<br>

		<!--  imagen  -->
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
			</div>
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="fotoArchivo"
					name="uploadImagen" accept="image/*"
					aria-describedby="inputGroupFileAddon01"> <label
					class="custom-file-label" for="inputGroupFile01">Choose
					file</label>
			</div>
		</div>
		<br>

		<!-- Mostrar imagen actual -->
		<s:if test="%{parque.imagen != null  && parque.imagen != ''}">
			<br>
			<div class="text-center">
				<img src="<s:property value="parque.imagen"/>" class="rounded"
					height="250px" width="250px">
			</div>
		</s:if>
		
		<!-- Añadir mas imagenes -->
		<s:if test="%{parque.idParque > 0}">
		<s:url action="irParqueAdministradorFotos" var="irFotos">
			<s:param name="parque.idParque"><s:property value="parque.idParque" /></s:param>
		</s:url>
		<a href="<s:property value="#irFotos" />" class="btn btn-success btn-lg">
          +
        </a>
		</s:if>



		<!-- Guardar -->
		<button class="btn btn-info btn-block my-4" type="submit">
			<s:text name="Parque.Guardar" />
		</button>


		<!-- Resultado -->
		<s:if test="%{operationStatus != null}">
			<s:if test="%{operationStatus == 'CORRECT' }">
				<div class="alert alert-success" role="alert">
					<span class="alert-link">&#10003; <s:text name="Guardado" /></span>
				</div>
			</s:if>
			<s:elseif test="%{operationStatus == 'FAIL' }">
				<div class="alert alert-danger" role="alert">
					<span class="alert-link">&#10003; <s:text name="Error" /></span>
				</div>
			</s:elseif>

		</s:if>


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
				$("#listaProvinciasSelect").attr('onchange','actualizarLocalidades()');
				
			}
		});
	}
	
	function actualizarLocalidades() {
		var idprovincia = $("#listaProvinciasSelect").val();
		$.ajax({
			type : "GET",
			url : "getLocalidadesPorProvincia?provincia.idProvincia="+idprovincia,

			success : function(json) {
				$("#listaLocalidades").empty();
				$("#listaLocalidades").append(json);
				
			}
		});
	}

	
</script>
