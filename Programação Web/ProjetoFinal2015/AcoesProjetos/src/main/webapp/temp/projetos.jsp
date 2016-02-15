<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
        <jsp:include page="templates/menuSuperior.jsp"></jsp:include>
        <jsp:include page="templates/menuLateral.jsp"></jsp:include>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Meus Projetos
                        </h1>
                    </div>
                </div> 
	
	<section>
	
				
		<div class="col-md-8 col-sm-12 col-xs-12">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                
				<a href="cadastrarProjeto.jsp" class="btn btn-primary">Novo Projeto</a>
				</div>
                            
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>S No.</th>
                                                <th>Projeto</th>
                                                <th>Data Inicio</th>
                                                <th>Data Fim</th>
                                                <th colspan="2" style="text-align:center;">Operações</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Construir casa</td>
                                                <td>13/04/2015</td>
                                                <td>13/04/2015</td>
                                                <td><button class="btn btn-primary"><i class="fa fa-edit "></i> Edit</button></td>
												<td><button class="btn btn-danger"><i class="fa fa-pencil"></i> Delete</button></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Casamento</td>
                                                <td>13/04/2015</td>
                                                <td>13/04/2015</td>
                                                <td><button class="btn btn-primary"><i class="fa fa-edit "></i> Edit</button></td>
												<td><button class="btn btn-danger"><i class="fa fa-pencil"></i> Delete</button></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Site Vendas</td>
                                                <td>13/04/2015</td>
                                                <td>13/04/2015</td>
                                                <td><button class="btn btn-primary"><i class="fa fa-edit "></i> Edit</button></td>
												<td><button class="btn btn-danger"><i class="fa fa-pencil"></i> Delete</button></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
	</section>
</body>
</html>
