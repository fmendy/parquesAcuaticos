<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 1000px">
	<br> <br>

	<h1>
		<s:text name="Etiquetas.numero" />
		:
		<s:property value="listEtiquetas.size()" />
	</h1>
	<br>


	<div class="input-group mb-2" style="width: 25%">
		<div class="input-group-prepend">
			<div class="input-group-text">
				<i class="fas fa-search" aria-hidden="true"></i>
			</div>
		</div>
		<input type="text" class="form-control py-0" id="search"
			placeholder="<s:text name="Escribe.para.buscar" />">
	</div>


	<!--Table-->
	<table class="table table-hover table-fixed" id="mytable">
		<!--Table head-->

		<thead>
			<tr>
				<th><s:text name="Etiqueta" /></th>
			</tr>
		</thead>
		<!--Table head-->

		<!--Table body-->
		<tbody>
			<s:iterator status="stat" var="etiqueta" value="listEtiquetas">
				<tr>
					<td><s:url action="verEtiquetaAdministrador" var="irEtiqueta">
							<s:param name="etiqueta.idEtiqueta">
								<s:property value="#etiqueta.idEtiqueta" />
							</s:param>
						</s:url> <a style="text-decoration: none; color: inherit;"
						href="<s:property value="#irEtiqueta" />"> <s:property
								value="#etiqueta.nombre" />
					</a></td>
				</tr>

			</s:iterator>
		</tbody>
	</table>

</div>
<jsp:include page="/pages/general/pageFooter.jsp" />
<script>
	// Write on keyup event of keyword input element
	$(document).ready(
			function() {
				$("#search").keyup(
						function() {
							_this = this;
							// Show only matching TR, hide rest of them
							$.each($("#mytable tbody tr"), function() {
								if ($(this).text().toLowerCase().indexOf(
										$(_this).val().toLowerCase()) === -1)
									$(this).hide();
								else
									$(this).show();
							});
						});
			});
</script>
</div>
<jsp:include page="/pages/general/pageFooter.jsp" />