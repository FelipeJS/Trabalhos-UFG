<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AcoesProjetos</title>
<!-- Bootstrap Styles-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="templates/menuSuperior.jsp"></jsp:include>
		<jsp:include page="templates/menuLateral.jsp"></jsp:include>
		
		
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">Meus Investimentos</h1>
					</div>
					<div class="col-md-12">
                        <h2 class="page-header">${acao.nome}</h2>
                    </div>
				</div>

				<section>


					<div class="col-xs-12">

						<div class="panel panel-default">
							<div class="panel-heading">

								<a href="cadastrarInvestimento.jsp?codAcao=${acao.id}" class="btn btn-primary">Novo investimento</a>
							</div>

							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Codigo</th>
												<th>Nome da Ação</th>
												<th>Data</th>
												<th>Quatidade</th>
												<th>Valor</th>
												<th>Custos</th>
												<th>Total</th>
												<th colspan="3" style="text-align: center;">Operações</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="investimento" items="${investimentos}">
												<tr>
													<td>${investimento.id}</td>
													<td>${investimento.acao.nome}</td>
													<td>${investimento.data}</td>
                                                    <td>${investimento.quantidade}</td>
                                                    <td>${investimento.valor}</td>
                                                    <td>${investimento.custos}</td>
                                                    <td>${investimento.total}</td>
                                                    <td><a href="investimento?opcao=editar&codInvestimento=${investimento.id}"
                                                        class="btn btn-primary center-block" >
                                                        <i class="fa fa-edit "></i>
                                                        </a></td>
                                                    <td><a href="investimento?opcao=excluir&codInvestimento=${investimento.id }&codAcao=${acao.id}"
                                                         class="btn btn-danger center-block">
                                                        <i class="fa fa-times"></i>
                                                        </a></td>
											</c:forEach>
									</table>
								</div>
							</div>
						</div>

					</div>
			</div>
			</section>
</body>
</html>
