<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 1000px">
	<br> <br>

	<table>
		<tr>
			<s:if test="%{compania.imagen !=null && compania.imagen !=''}">
				<td rowspan="2"><img
					src="<s:property value="compania.imagen" />"
					style="max-width: 250px; max-height: 250px"></td>
			</s:if>
			<td><h1>
					<s:property value="compania.nombre" />
				</h1></td>
		</tr>
		<s:if test="%{compania.web !=null && compania.web !=''}">
			<tr>
				<td><s:text name="Compania.Web" /> <a
					href="<s:text name="Compania.Web" />"> <s:property
							value="compania.web" />
				</a> <br> <br></td>
			</tr>
		</s:if>
	</table>

	<br> <br>

	<s:text name="Compania.Numero.Parques" />
	:
	<s:property value="compania.listParque.size()" />
	<!--Table-->
	<table class="table table-hover table-fixed">
		<!--Table head-->

		<thead>
			<tr>
				<th>#</th>
				<th><s:text name="Parque.Nombre" /></th>
				<th><s:text name="Parque.Web" /></th>
				<th><s:text name="Pais" /></th>
				<th><s:text name="Provincia" /></th>
				<th><s:text name="Localidad" /></th>
			</tr>
		</thead>
		<!--Table head-->

		<!--Table body-->
		<tbody>

			<s:iterator status="stat" var="parque" value="compania.listParque">
				<s:url action="verCompania" var="irCompania">
					<s:param name="compania.idCompania">
						<s:property value="#comp.idCompania" />
					</s:param>
				</s:url>
				
				<s:url action="verPais" var="irPais">
					<s:param name="pais.idPais">
						<s:property value="#parque.localidad.provincia.pais.idPais" />
					</s:param>
				</s:url>
				
				<s:url action="verProvincia" var="irProvincia">
					<s:param name="provincia.idProvincia">
						<s:property value="#parque.localidad.provincia.idProvincia" />
					</s:param>
				</s:url>
				
				<s:url action="verParque" var="irParque">
					<s:param name="parque.idParque">
						<s:property value="#parque.idParque" />
					</s:param>
				</s:url>

				<tr>

					<th scope="row"><s:property
								value="%{#stat.index+1}" /></th>
					<td><a style="text-decoration: none; color: inherit;"
						href="<s:property value="#irParque" />"><s:property
								value="#parque.nombre" /></a></td>
					<td><a style="text-decoration: none; color: inherit;"
						href="<s:property value="#parque.web" />"><s:property
								value="#parque.web" /></a></td>
					<td><a style="text-decoration: none; color: inherit;"
						href="<s:property value="#irPais" />"><s:property
								value="#parque.localidad.provincia.pais.nombre" /></a></td>
					<td><a style="text-decoration: none; color: inherit;"
						href="<s:property value="#irProvincia" />"><s:property
								value="#parque.localidad.provincia.nombre" /></a></td>
					<td><s:property
								value="#parque.localidad.nombre" /></td>
				</tr>

			</s:iterator>
		</tbody>
		<!--Table body-->
	</table>





</div>
<jsp:include page="/pages/general/pageFooter.jsp" />