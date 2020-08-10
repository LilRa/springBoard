<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/WEB-INF/views/include/00_head.jsp" %>
<script src="/resources/jquery-3.1.1.min.js"></script>
<script src="/resources/js/searchRest.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

        <!-- Left side column. contains the logo and sidebar -->
		<%@ include file="/WEB-INF/views/include/40_leftSideMenu.jsp" %>


        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    게시판
                    <small>게시판</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-hand-peace-o"></i> 게시판</a></li>
                    <li class="active">게시판</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content container-fluid">
                <div class="">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Board</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="table-responsive mailbox-messages">
                                <table class="table table-hover">
                                    <tbody>
                                        <tr>
                                            <th style="width: 40px">#</th>
                                            <th>제목</th>
                                            <th>글쓴이</th>
                                            <th style="width: 80px">조회수</th>
                                            <th style="width: 100px">작성일</th>
                                        </tr>

                                    </tbody>

                                </table>
                 			<form action='<c:url value="/upload/fileUpload"/>' method="POST" enctype="multipart/form-data">
		                            <input class="form-control" placeholder="Writer:" name="CREA_ID" value="LilRa" readonly>
						     		   <a class="btn btn-default file_add" onclick="addFile()">파일추가</a>
						            <input multiple="multiple" name="file" type="file">
						            	<a href='#this' class="btn" name='file-delete'>삭제</a>
							    <button type="submit" class="btn btn-default">작성하기</button>
							</form>
                                <!-- /.table -->
                            </div>
                            <!-- /.mail-box-messages -->
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /. box -->
                </div>
            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <!-- Main Footer -->
		<%@ include file="/WEB-INF/views/include/70_footer.jsp" %>

    </div>
    <!-- ./wrapper -->
    
	<%@ include file="/WEB-INF/views/include/01_plugins.jsp" %>

</body>
</html>