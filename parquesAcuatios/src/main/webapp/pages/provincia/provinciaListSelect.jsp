<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageResources.jsp" />
<!-- Provincia -->


<div class="input-group-prepend">
	<label class="input-group-text" for="inputGroupSelect01"><s:text
			name="Provincia" /></label>
</div>
<s:select name="localidad.provincia.idProvincia" list="listaProvincias"
	listKey="idProvincia" listValue="nombre" size="1" required="true"
	headerValue="Seleccione" headerKey="" id="listaProvincias"
	class="browser-default custom-select" />


