<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 500px">
	<br> <br>

	<form name="guardarEtiquetaAdministrador"
		class="text-center border border-light p-5"
		action="guardarEtiquetaAdministrador">

		<p class="h4 mb-4">
			<s:text name="Etiqueta" />
		</p>

		<s:hidden name="etiqueta.idEtiqueta" />
		<s:hidden name="etiqueta.activo" />

		<!-- Nombre -->
		<div class="input-group mb-3">

			<div class="input-group-prepend">
				<div class="input-group-text">
					<i style='font-size: 24px' class='fas'>&#xf304;</i>

				</div>
			</div>
			<input type="text" name="etiqueta.nombre" class="form-control py-0"
				pattern="[A-Za-z]*" id="inlineFormInputGroup" placeholder="Nombre"
				required="required" value='<s:property value="etiqueta.nombre"/>'>


		</div>
		<s:fielderror fieldName="etiqueta.nombre"
			style="list-style:none; color:#970808; margin-bottom:0px" />


		<!-- Aniadir -->
		<button class="btn btn-info btn-block my-4" type="submit">
			<s:text name="Guardar" />
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