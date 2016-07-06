<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<%@ page import="com.nx.kernel.model.NxEntityState" %>

<!-- Content Wrapper. Contains page content -->
<div id ='content-wrapper'>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Query User<small>preview of simple tables</small>
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
						<h3 class="box-title">使用者列表</h3>
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
								<th>編輯</th>
								<th>ID</th>
								<th>帳號</th>
								<th>設定權限</th>
								<th>姓名</th>
								<th>性別</th>
								<th>電話</th>
								<th>Email</th>
								<th>部門</th>
								<th>失效</th>
							</tr>
							<c:forEach items="${pageView.records}" var="entry">
							<tr>
						      <td >
								  <a onclick="redirectContentWrapper(this);" href="javascript:void(0);" contextUrl="employee/manage/edit?method=editEmployeeUI&id=${entry.id}">
								  	<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
								  </a>
							  </td>
							  <td> ${entry.id}</td>
							  <td> ${entry.username}</td>
						      <td>
							      <a href="control/employee/manage?method=privilegeGroupSetUI&username=${entry.username}">
								  	<i class="fa fa-lock" aria-hidden="true"></i>
								  </a>
						      </td>
						      <td>${entry.realname}</div></td>
						      <td>${entry.gender.name}</div></td>
						      <td>${entry.phone}</div></td>
						      <td>${entry.email}</div></td>
						     
						      <td>${entry.department.name}</td>
						      <td>
						      <c:if test="${entry.visible}">
						      	 <a href="control/employee/manage?method=leave&username=${entry.username}">
								  	<i class="fa fa-eye-slash" aria-hidden="true"></i>	
								 </a>
						      </c:if><c:if test="${!entry.visible}"><font color=red>已失效</font></c:if>
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