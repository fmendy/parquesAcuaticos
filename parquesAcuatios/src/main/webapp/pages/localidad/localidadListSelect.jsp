<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageResources.jsp" />
<!-- Localidad -->


<div class="input-group-prepend">
	<label class="input-group-text" for="inputGroupSelect01"><s:text
			name="Localidad" /></label>
</div>
<s:select name="localidad.idLocalidad" list="listaLocalidades"
	listKey="idLocalidad" listValue="nombre" size="1" required="true"
	headerValue="Seleccione" headerKey="" id="listaLocalidadesSelect"
	class="browser-default custom-select" />


