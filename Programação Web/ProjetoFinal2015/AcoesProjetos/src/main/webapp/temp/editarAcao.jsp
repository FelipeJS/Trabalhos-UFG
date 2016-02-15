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
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">Minhas Ações</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-6">
										<form role="form" method="post" action="acao">
											<div class="form-group">
												<label>ID da ação</label> 
												${p.id}<input class="form-control" type="hidden"
													name="id" value="${p.id}">
											</div>
											<div class="form-group">
												<label>Nome da ação</label> <input class="form-control"
													name="nome" value="${p.nome}">
											</div>
											<div class="form-group">
												<label>Tipo de ação</label> 
												<select class="form-control" name="descricao">
													<option value="${p.descricao}">ON</option>
													<!-- Ordinária nominativa -->
													<option value="${p.descricao}">PN</option>
													<!--  Preferência nominativa -->
												</select>
											</div>
											<div class="form-group">
												<label>Quantidade</label> <input class="form-control"
													name="quantidade" value="${p.quantidade}" readonly="readonly">
											</div>
											<div class="form-group">
												<label>Valor unitário da ação</label>
												<div class="form-group input-group">
													<span class="input-group-addon">$</span> <input type="text"
														class="form-control" name="valor" value="${p.preco}" readonly="readonly"> <span
														class="input-group-addon">.00</span>
												</div>
											</div>
											<button type="submit" class="btn btn-default" name="opcao"
												value="carregarEdicao">Editar Ação</button>
										</form>
									</div>
								</div>
								<!-- /.row (nested) -->
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
</body>
</html>