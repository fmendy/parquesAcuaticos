<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 1000px">
	<br> <br>
	<!--Table-->
	<table class="table table-hover table-fixed">

		<!--Table head-->
		<thead>
			<tr>
				<th>#</th>
				<th><s:text name="Compania.Nombre" /></th>
				<th><s:text name="Compania.Web" /></th>
				<th><s:text name="Compania.Numero.Parques" /></th>
			</tr>
		</thead>
		<!--Table head-->

		<!--Table body-->
		<tbody>

			<s:iterator status="stat" var="comp" value="listCompanias">
				<s:hidden name="listCompanias[%{#stat.index}].idCompania"
					id="idCompania_%{#stat.index}" />
				<s:url action="verCompania" var="irCompania">
					<s:param name="compania.idCompania">
						<s:property value="#comp.idCompania" />
					</s:param>
				</s:url>

				<tr>

					<th scope="row"><a
						style="text-decoration: none; color: inherit;"
						href="<s:property value="#irCompania" />"><s:property
								value="%{#stat.index}" /> </a></th>
					<td><a style="text-decoration: none; color: inherit;"
						href="<s:property value="#irCompania" />"><s:property
								value="#comp.nombre" /></a></td>
					<td><a style="text-decoration: none; color: inherit;"
						href="<s:property value="#irCompania" />"><s:property
								value="#comp.web" /></a></td>
					<td><a style="text-decoration: none; color: inherit;"
						href="<s:property value="#irCompania" />"><s:property
								value="#comp.listParque.size" /></a></td>
				</tr>

			</s:iterator>
		</tbody>
		<!--Table body-->
	</table>
	<!--Table-->
</div>
<jsp:include page="/pages/general/pageFooter.jsp" />