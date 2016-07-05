<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<%@ page import="com.nx.kernel.model.NxEntityState" %>

<!-- Content Wrapper. Contains page content -->
<div id ='content-wrapper'>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Query Menu<small>preview of simple tables</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Tables</a></li>
			<li class="active">Simple</li>
		</ol>
	</section>
	
	
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">子系統選單列表</h3>
						<div class="box-tools">
							<div class="input-group" style="width: 150px;">
								<input type="text" name="table_search"
									class="form-control input-sm pull-right" placeholder="Search">
								<div class="input-group-btn">
									<button class="btn btn-sm btn-default">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">
						<table class="table table-hover">
							<tr>
								<th>ID</th>
								<th>編輯</th>
								<th>名稱</th>
								<th>描述</th>
								<th>連結</th>
								<th>圖示</th>
								<th>標示符</th>
								<th>順序</th>
								<th>關聯父選單</th>
								<th>關聯父ID</th>
								<th>失效</th>
							</tr>
							<c:forEach items="${pageView.records}" var="entry">
							<tr>
							  <td> ${entry.id}</td>
						      <td >
						      	  <!-- "menu/manage/edit?method=editMenuUI&isParent=${isParent}&id=${entry.id}" -->
								  <a onclick="redirectContentWrapper(this);" href="javascript:void(0);" contextUrl="menu/manage/edit?method=editMenuUI&isParent=${isParent}&id=${entry.id}">
								  	<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
								  </a>
							  </td>
						      <td>${entry.name}</td>
						      <td>${entry.description}</td>
						      <td>${entry.hyperlink}</td>
						      <td><i class="fa ${entry.icon}" aria-hidden="true"></i></td>
						      <td>${entry.menuId}</td>
						   
						      <td>${entry.seq}</td>
						      <td>${entry.parent.id}</td>
						      <td>${entry.parent.name}</td>
						      <td><a href="control/employee/manage?method=leave&username=${entry.id}">
								  	<i class="fa fa-eye-slash" aria-hidden="true"></i>
								 </a>
						      </td>
							</tr>
							</c:forEach>
						
						</table>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
	<!-- /.content -->
	<script src="${serverCtx }/resources/nx/js/useropreation.js"></script>
</div>
<!-- /.content-wrapper -->
<%@ include file="/WEB-INF/tags/commonJS.jsp"%>