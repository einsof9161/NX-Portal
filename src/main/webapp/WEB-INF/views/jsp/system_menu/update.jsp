<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<%@ page import="com.nx.kernel.model.NxEntityState" %>

<!-- Content Wrapper. Contains page content -->
<div id ='content-wrapper'>
    <!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>編輯系統目錄<small>編輯後請記得點選存擋按鈕</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Tables</a></li>
			<li class="active">Simple</li>
		</ol>
	</section>
	<section class="content">
    	 <div class="box box-primary">
    		<c:set var="message" scope="session" value="${message}"/>
    		<c:set var="message" scope="session" value="${message}"/>
    	 	<c:if test="${empty message}">
			    var1 is empty or null.
			</c:if>
    	 
            <!-- form start -->
             <form:form method="POST" action="./menu/manage/save" modelAttribute="menuEdit">
            	<div class="box-body">
              	<div class="form-group">
              		<form:label path="id">ID</form:label>
              		<form:input path="id" cssClass="form-control" readonly="true"/>
                </div>
                <div class="form-group">
                	<form:label path="menuId">識別符號</form:label>
              		<form:input path="menuId" cssClass="form-control"/>
                </div>
                <div class="form-group">
                	<form:label path="name">功能名稱</form:label>
              		<form:input path="name" cssClass="form-control"/>
                </div>
                <div class="form-group">
                	<form:label path="description">功能描述</form:label>
              		<form:input path="description" cssClass="form-control"/>
                </div>
                <div class="form-group">
                	<form:label path="entityClass">對應類別</form:label>
              		<form:input path="entityClass" cssClass="form-control"/>
                </div>
                <div class="form-group">
	                <form:label path="icon">圖標</form:label>
	                <div class="input-group">
	                  <div class="input-group-addon">
	                    <i class="fa ${menuEdit.icon}"></i>
	                  </div>
	                  <form:input path="icon" cssClass="form-control"/>
                	</div>
              	</div> <!-- /.input group -->
                <div class="form-group">
                	<form:label path="hyperlink">超連結</form:label>
              		<form:input path="hyperlink" cssClass="form-control"/>
                </div>
                 <div class="form-group">
                	<form:label path="seq">順序</form:label>
              		<form:input path="seq" cssClass="form-control"/>
                </div>
			    <c:if test="${not isParent}">
			    	<div class="form-group">
                	<form:label path="parent.id">關聯父表單ID</form:label>
              		<form:input path="parent.id" cssClass="form-control"/>
                	</div>
				</c:if>	
              </div>
        	</form:form>
        	 <div class="box-footer">
              	 <button onclick='sumbitPage(this)' class="btn btn-default">儲存</button>
                 <button onclick='back()' class="btn btn-info">取消</button>
              </div>
            </div>
            <!-- /.box-body -->
          <!-- /.box -->  
    </section>
	<!-- /.content -->
	<script src="${serverCtx }/resources/nx/js/useropreation.js"></script>
</div>
<!-- /.content-wrapper -->
<%@ include file="/WEB-INF/tags/commonJS.jsp"%>