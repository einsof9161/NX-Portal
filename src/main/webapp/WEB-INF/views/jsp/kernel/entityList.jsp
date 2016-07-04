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
								<th>ID</th>
								<th>Account</th>
								<th>FirstName</th>
								<th>LastName</th>
								<th>Email</th>
								<th>State</th>
								<security:authorize access="hasRole('ADMIN')">
									<th>Edit</th>
									<th>Delete</th>
								</security:authorize>
								
							</tr>
							<c:forEach items="${entityList}" var="nxUser">
								<tr>
									<td>${nxUser.id }</td>
									<td>${nxUser.ssoId }</td>
									<td>${nxUser.firstName }</td>
									<td>${nxUser.lastName }</td>
									<td>${nxUser.email }</td>
									<c:choose>
										<c:when test="${nxMenu.state eq NxEntityState.ACTIVE.getState()}">
											<td><span class="label label-success">${nxUser.state }</span></td>
										</c:when>
										<c:when test="${nxMenu.state eq NxEntityState.INACTIVE.getState()}">
											<td><span class="label label-danger">${nxUser.state }</span></td>
										</c:when>
										<c:otherwise>
											<td><span class="label label-danger">${nxUser.state }</span></td>
										</c:otherwise>
									</c:choose> 
									<security:authorize access="hasRole('ADMIN')">
										<td><button type="button" class="btn btn-default btn-xs" onclick="editEntity()"><i class="fa fa-pencil"></i></button></td>
										<td><button type="button" class="btn btn-default btn-xs" onclick="deleteEntity()"><i class="fa fa-trash-o"></i></button></td>
									</security:authorize>
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