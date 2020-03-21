<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="container" style="max-width: 1000px">
	<br> <br>

	<s:if test="%{provincia.imagen !=null && provincia.imagen !=''}">
		<td rowspan="2"><img
			src="<s:property value="provincia.imagen" />"
			style="max-width: 250px; max-height: 250px"></td>
	</s:if>
	<h1>
		<a href="verPaises" style="text-decoration: none; color: inherit;"><s:text
				name="Pais" /> </a> >
		<s:url action="verPais" var="irPais">
			<s:param name="pais.idPais">
				<s:property value="provincia.pais.idPais" />
			</s:param>
		</s:url>
		<a style="text-decoration: none; color: inherit;"
			href="<s:property value="#irPais" />"> <s:property
				value="provincia.pais.nombre" /></a> >
		<s:property value="provincia.nombre" />
	</h1>
	<br />

	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item"><a class="nav-link active" id="home-tab"
			data-toggle="tab" href="#home" role="tab" aria-controls="home"
			aria-selected="true"><i class='fas fa-swimming-pool'
				style='font-size: 36px'></i></a></li>
		<li class="nav-item"><a class="nav-link" id="provincia-tab"
			data-toggle="tab" href="#provincia" role="tab"
			aria-controls="provincia" aria-selected="false"><i
				class='fas fa-map-marker-alt' style='font-size: 36px'></i></a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="home" role="tabpanel"
			aria-labelledby="home-tab">
			<br>
			<h3>
				<s:text name="Parque" />
			</h3>
			<br>
			<div class="input-group mb-2" style="width: 25%">
				<div class="input-group-prepend">
					<div class="input-group-text">
						<i class="fas fa-search" aria-hidden="true"></i>
					</div>
				</div>
				<input type="text" class="form-control py-0" id="search1"
					placeholder="<s:text name="Escribe.para.buscar" />">
			</div>


			<!--Table-->
			<table class="table table-hover table-fixed" id="mytable1">
				<!--Table head-->

				<thead>
					<tr>
						<th><s:text name="Parque" /></th>
						<th><s:text name="Localidad" /></th>
					</tr>
				</thead>
				<!--Table head-->

				<!--Table body-->
				<tbody>

					<s:iterator status="stat" var="localidad"
						value="provincia.listLocalidad">
						<s:iterator var="parque" value="#localidad.listParque">
							<tr>
								<s:url action="verParque" var="irParque">
									<s:param name="parque.idParque">
										<s:property value="#parque.idParque" />
									</s:param>
								</s:url>

								<th scope="row"><a
									style="text-decoration: none; color: inherit;"
									href="<s:property value="#irParque" />"> <s:property
											value="%{#parque.nombre}" /></a></th>


								<td><s:property value="#localidad.nombre" /></td>

							</tr>
						</s:iterator>
					</s:iterator>
				</tbody>
				<!--Table body-->
			</table>
		</div>


		<div class="tab-pane fade" id="provincia" role="tabpanel"
			aria-labelledby="provincia-tab">
			<br>

			<h3>
				<s:text name="Localidad" />
			</h3>

			<br>
			<div class="input-group mb-2" style="width: 25%">
				<div class="input-group-prepend">
					<div class="input-group-text">
						<i class="fas fa-search" aria-hidden="true"></i>
					</div>
				</div>
				<input type="text" class="form-control py-0" id="search2"
					placeholder="<s:text name="Escribe.para.buscar" />">
			</div>

			<!--Table-->
			<table class="table table-hover table-fixed" id="mytable2">
				<!--Table head-->

				<thead>
					<tr>
						<th>#</th>
						<th><s:text name="Localidad" /></th>
						<th><s:text name="Localidad.numero.parques" /></th>
					</tr>
				</thead>
				<!--Table head-->

				<!--Table body-->
				<tbody>

					<s:iterator status="stat" var="localidad"
						value="provincia.listLocalidad">
						<tr>

							<th scope="row"><s:property value="%{#stat.index+1}" /></th>
							<td><s:property value="#localidad.nombre" /></td>
							<td><s:set var="total" value="0" /> <s:property
									value="#localidad.listParque.size()" /></td>
						</tr>
					</s:iterator>
				</tbody>
				<!--Table body-->
			</table>

		</div>


	</div>



</div>
<jsp:include page="/pages/general/pageFooter.jsp" />
<script>
	// Write on keyup event of keyword input element
	$(document).ready(
			function() {
				$("#search1").keyup(
						function() {
							_this = this;
							// Show only matching TR, hide rest of them
							$.each($("#mytable1 tbody tr"), function() {
								if ($(this).text().toLowerCase().indexOf(
										$(_this).val().toLowerCase()) === -1)
									$(this).hide();
								else
									$(this).show();
							});
						});

				$("#search2").keyup(
						function() {
							_this = this;
							// Show only matching TR, hide rest of them
							$.each($("#mytable2 tbody tr"), function() {
								if ($(this).text().toLowerCase().indexOf(
										$(_this).val().toLowerCase()) === -1)
									$(this).hide();
								else
									$(this).show();
							});
						});
			});
</script>
