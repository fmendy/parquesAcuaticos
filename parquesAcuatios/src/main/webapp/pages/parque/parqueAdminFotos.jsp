<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 800px">
	<br> <br>

	<form name="guardarParqueAdministradorFotos"
		class="text-center border border-light p-5"
		action="guardarParqueAdministradorFotos" enctype="multipart/form-data"
		method="POST">

		<s:hidden name="parque.idParque" />
		<p class="h4 mb-4">
			<s:property value="parque.nombre" />
		</p>

		<!--  foto actuales -->
		<s:if test="%{parque.listFoto.size() > 0}">
			<div class="container">
				<div class="card-group">
					<div class="row">
						<s:iterator status="stat" value="parque.listFoto">
							<s:if test="%{parque.listFoto[#stat.index].activo == 1}">

								<s:hidden name="parque.listFoto[%{#stat.index}].idFoto"
									id="idFoto_%{#stat.index}" />
								<s:hidden name="parque.listFoto[%{#stat.index}].url"
									id="url_%{#stat.index}" />
								<s:hidden name="parque.listFoto[%{#stat.index}].activo"
									id="activo_%{#stat.index}" />
								<s:hidden
									name="parque.listFoto[%{#stat.index}].tipoFoto.idTipoFoto"
									id="tipoFoto_%{#stat.index}" />
								<div class="card col-md-4">
									<img class="card-img-top"
										style="max-height: 250px; max-width: 250px"
										src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/20190710102234/download3.png">
									<div class="card-body">
										<!--checked -->
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												id="defaultUnchecked_<s:property value="%{#stat.index}"/>"
												onclick="changeStatus(<s:property value="%{#stat.index}"/>)">
											<label class="custom-control-label"
												for="defaultUnchecked_<s:property value="%{#stat.index}"/>">
												<i class='fas fa-trash-alt' style="color: red"></i>
											</label>
										</div>
										<p class="card-text">
											<s:if
												test="%{parque.listFoto[#stat.index].tipoFoto.idTipoFoto == 2}">
												<s:text name="Imagen.secundarias" />
											</s:if>
											<s:elseif
												test="%{parque.listFoto[#stat.index].tipoFoto.idTipoFoto == 1}">
												<s:text name="Imagen.principal" />
											</s:elseif>

										</p>
									</div>
								</div>
							</s:if>

						</s:iterator>
					</div>
				</div>
			</div>
			<br>
		</s:if>
		<!-- End fotos actuales -->





		<!--  imagen  -->
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroupFileAddon01"><s:text
						name="Imagen.principal" /></span>
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

		<!--  imagen  -->
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroupFileAddon01"><s:text
						name="Imagen.secundarias" /></span>
			</div>
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="fotoArchivo"
					multiple="multiple" name="multiplesImagenes" accept="image/*"
					aria-describedby="inputGroupFileAddon01"> <label
					class="custom-file-label" for="inputGroupFile01">Choose
					file</label>
			</div>
		</div>
		<br>

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
			<s:elseif test="%{operationStatus == 'FAILED' }">
				<div class="alert alert-danger" role="alert">
					<span class="alert-link">&#10003; <s:text name="Error" /></span>
				</div>
			</s:elseif>

		</s:if>

	</form>
</div>
<jsp:include page="/pages/general/pageFooter.jsp" />
<script>
	function changeStatus(id){
		if($("#activo_"+id).val() == 'true'){
			$("#activo_"+id).val('false');
		}else{
			$("#activo_"+id).val('true');
		}
	}
</script>