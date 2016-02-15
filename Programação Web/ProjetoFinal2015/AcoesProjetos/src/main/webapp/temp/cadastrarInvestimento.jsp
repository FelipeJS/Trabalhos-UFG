<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
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
						<h1 class="page-header">Investimentos</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading"></div>
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-6">
										<form role="form" method="post" action="investimento">
										
										
											<div class="form-group" ng-app>
												<label hidden="true">Codigo</label> 
												<input class="form-control" name="id" type="hidden"/>
												<label>Data</label>
												<input class="form-control" name="data" type="date"/> 
												<label>Quantidade</label>
												<input class="form-control" name="quantidade" ng-model="quantidade"/> 
												<label>Valor</label> 
												<input class="form-control" name="valor" ng-model="valor"/> 
												<label>Custos</label> 
												<input class="form-control" name="custos" ng-model="custos"/> 
												<label>Total</label> 
												<input class="form-control" name="total" ng-value="quantidade*valor-custos" readonly="readonly"/>
												<label>Acao</label> 
												<%=request.getParameter("codAcao")%>
												<input class="form-control" name="acao" type="hidden"
												value="<%=request.getParameter("codAcao")%>"/> 
												
											</div>
											<button type="submit" class="btn btn-default"
											name="opcao" value="inserir">Salvar</button>
										</form>
									</div>
									<!-- /.col-lg-6 (nested) -->
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