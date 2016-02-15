<%@page import="java.util.Date"%>
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
                            Meus projetos
                        </h1>
                    </div>
                </div>
<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" method="post" action="cadastroProjeto">
                                        <div class="form-group">
                                            <label>Nome do projeto</label>
                                            <input class="form-control" name="nome">                                            
                                        </div>
                                        <div class="form-group">
                                            <label>Data de inicio</label>
                                            <input class="form-control" name="inicio" value="<%=new Date()%>">                                            
                                        </div>
                                        <div class="form-group">
                                            <label>Status</label>
                                            <input class="form-control" name="status">                                            
                                        </div>
                                        <button type="submit" class="btn btn-default" name="cadastro" value="salvar">Submit Button</button>                                        
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