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
						<h1 class="page-header">Minhas Ações</h1>
					</div>
				</div>

				<section>


					<div class="col-xs-12">

						<div class="panel panel-default">
							<div class="panel-heading">

								<a href="cadastrarAcao.jsp" class="btn btn-primary">Nova
									Ação</a>
							</div>

							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Codigo.</th>
												<th>Ação</th>
												<th>Descrição</th>
												<th>Quatidade</th>
												<th>Valor Total</th>
												<th colspan="3" style="text-align: center;">Operações</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="acao" items="${acoes}">
												<tr>
													<td>${acao.id}</td>
													<td>${acao.nome}</td>
													<td>${acao.descricao}</td>
                                                    <td>${acao.quantidade}</td>
                                                    <td>${acao.preco}</td>
                                                    <td><a href="investimento?opcao=listar&codAcao=${acao.id}" 
                                                        class="btn btn-success center-block">
                                                        <i class="fa fa-money"></i>
                                                        Investimentos</a></td>
                                                    <td><a href="acao?opcao=editar&codAcao=${acao.id}"
                                                        class="btn btn-primary center-block" >
                                                        <i class="fa fa-edit "></i>
                                                        </a></td>
                                                    <td><a href="acao?opcao=excluir&codAcao=${acao.id }"
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
