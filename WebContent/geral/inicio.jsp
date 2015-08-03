<%@ include file="/geral/header.jsp"%>

<div id="content" class="colM" style="text-align: center;" >
	<div id="content-main" >
<html:form action="inicio" method="post" styleId='relatorioForm' >
<input type="hidden" name="nomeGrupoParametro" id="nomeGrupoParametro"/>
<input type="hidden" name="identificadorGrupoParametro" id="identificadorGrupoParametro"/>
<%@ include file="/geral/mensagens.jsp"%>
			<table>
				<tr>
					<td><html:select property="tipoItemProvento"
							styleId="tipoItemProvento" onchange="recarregaItemProvento()">
							<html:option value="">Proventos e Descontos</html:option>
							<html:option value="1">Proventos</html:option>
							<html:option value="2">Descontos</html:option>
						</html:select>
						<select name="nomeRelatorio" id="nomeRelatorio">
							<option value="relatorio_conferencia_valor.rep" >Relatório Conferência</option>
							<option value="relatorio_detalhamento_valor.rep">Relatório Detalhamento</option>
							
						</select>
						
						</td>
				</tr>
				<tr>
					<td>
						<div>
						<html:select property="numeroLote"
							styleId="numeroLote" >
							<html:option value="">Todos</html:option>
							<html:option value="1">1º Lote</html:option>
							<html:option value="3,4">2º Lote</html:option>
						</html:select>
							Grupo:
						<html:text property="numeroGrupo" styleId="numeroGrupo"/>
						</div> <input type="hidden" name="acao" value="carregar" />
					</td>
				</tr>
				<tr>
					<td>
						<div style="width: 300px; float: left;">
							<select size="20" multiple name="availableItems"
								id="availableItems" style="width: 300px !important;">
								<c:forEach var="prov" items="${listaProventoDesconto}">
									<option value="${prov.codigoProventoDesconto}">${prov.codigoProventoDesconto}
										- ${prov.nomeProventoDesconto}</option>
								</c:forEach>
							</select>

						</div>

						<div style="width: 100px; float: left;">
							<input type="button" class="btn" value="    Inlcuir    "
								onclick="addItems();" /> <input type="button" class="btn"
								value="Incluir Todos" onclick="addAll();" /> <input
								type="button" class="btn" value=" Excluir "
								onclick="removeItems();" /> <input type="button" class="btn"
								value="Excluir Todos" onclick="removeAll();" />
						</div>
						<div style="width: 250px; float: left">
						<html:select property="listaProventoSelecionado" styleId="listaProventoSelecionado" size="20"  multiple="multiple" style="width: 250px;">
						<html:options collection="listaProventoSelecionado" property="id" labelProperty="descritor"/>
						</html:select>
							
						</div> <br>
					</td>
				</tr>
				<tr>
					<td>
						<div id="amandy" style="text-align: center;">
							<input type="button" class="btn" value="Imprimir" style="width: 130px !important;"
								onclick="frmSubmit();" />
							<input type="button" class="btn" value="Salvar Parâmetros" id="btnSalvarParametros" style="width: 130px !important;"
								onclick="showPopup();" name="btnSalvarParametros"/>	
							<input type="button" class="btn" value="Carregar Parâmetros" style="width: 130px !important;"
								id="carregarParametros" name="carregarParametros" />	
						</div>
					</td>
				</tr>
			</table>
		</html:form>
	</div>

<ajax:htmlContent
  baseUrl="inicio.do?acao=listaGrupoParametro"
  target="divPopup" postFunction="showPopup"
  parameters=""  source="carregarParametros"/>
<ajax:htmlContent
  baseUrl="inicio.do?acao=popUpGrupoParametroForm"
  target="divPopup" postFunction="showPopup"
  parameters=""  source="btnSalvarParametros"/>


</div>
