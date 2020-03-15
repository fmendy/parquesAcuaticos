<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 500px">
	<br> <br>

	<form name="guardarCompania"
		class="text-center border border-light p-5" action="guardarCompania"
		enctype="multipart/form-data" method="POST">

		<p class="h4 mb-4">
			<s:text name="Compania" />
		</p>

		<!-- id -->
		<s:hidden name="compania.idCompania" />
		<s:hidden name="compania.activo" />
		<s:hidden name="compania.imagen" />

		<!-- Nombre -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">
					<s:text name="Compania.Nombre" />
				</div>
			</div>
			<input type="text" name="compania.nombre" class="form-control py-0"
				maxlength="80" id="inlineFormInputGroup" placeholder=Nombre
				required="required" value="<s:property value="compania.nombre" />">
		</div>
		<br>

		<!-- Web -->
		<div class="input-group mb-2">
			<div class="input-group-prepend">
				<div class="input-group-text">
					<s:text name="Compania.Web" />
				</div>
			</div>
			<input type="text" name="compania.web" class="form-control py-0"
				pattern="[A-Za-z]*" maxlength="80" id="inlineFormInputGroup"
				placeholder="Web" value="<s:property value="compania.web" />">
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

		<!-- Mostrar imagen actual -->
		<s:if test="%{compania.imagen != null  && compania.imagen != ''}">
			<br>
			<div class="text-center">
				<img src="<s:property value="compania.imagen"/>" class="rounded"
					height="250px" width="250px">
			</div>
		</s:if>

		<!-- Guardar -->
		<button class="btn btn-info btn-block my-4" type="submit">
			<s:text name="Compania.Guardar" />
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
