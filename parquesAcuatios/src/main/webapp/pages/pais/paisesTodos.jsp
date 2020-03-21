<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="container" style="max-width: 1000px">
	<br> <br>

	<h1>
		<s:text name="Paises.numero" />
		:
		<s:property value="listPaises.size()" />
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
				<th><s:text name="Pais" /></th>
			</tr>
		</thead>
		<!--Table head-->

		<!--Table body-->
		<tbody>
			<s:iterator status="stat" var="pais" value="listPaises">
				<tr>
					<td><s:url action="verPais" var="irPais">
							<s:param name="pais.idPais">
								<s:property value="#pais.idPais" />
							</s:param>
						</s:url> <a style="text-decoration: none; color: inherit;"
						href="<s:property value="#irPais" />"> <s:if
								test="%{#pais.imagen !=null && #pais.imagen !=''}">
								<td rowspan="2"><img
									src="<s:property value="#pais.imagen" />"
									style="max-width: 25px; max-height: 25px"></td>
							</s:if> <s:property value="#pais.nombre" />
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