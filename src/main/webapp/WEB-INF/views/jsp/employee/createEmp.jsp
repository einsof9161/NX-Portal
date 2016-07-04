<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<%@ page import="com.nx.kernel.model.NxEntityState" %>

<!-- Content Wrapper. Contains page content -->
<div id ='content-wrapper'>
    <!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>編輯員工<small>編輯後請記得點選存擋按鈕</small>
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
    	 	<c:if test="${empty message}">
			    var1 is empty or null.
			</c:if>
    	 
            <!-- form start -->
            <form:form method="POST" action="./employee/manage/save" modelAttribute="empEdit">
            	<div class="box-body">
              	<div class="form-group">
              		<form:label path="id">序號</form:label>
              		<form:input path="id" cssClass="form-control" readonly="true"/>
                </div>
              	<div class="form-group">
              		<form:label path="username">帳號</form:label>
              		<form:input path="username" cssClass="form-control" readonly="true"/>
                </div>
                <div class="form-group">
                	<form:label path="email">電子郵件</form:label>
              		<form:input path="email" cssClass="form-control"/>
                </div>
                <div class="form-group">
                	<form:label path="realname">姓名</form:label>
              		<form:input path="realname" cssClass="form-control"/>
                </div>
                <div class="form-group">
                	<form:label path="gender">性別</form:label>
              		<form:input path="gender" cssClass="form-control"/>
                </div>
                <div class="form-group">
                	<form:label path="phone">電話</form:label>
              		<form:input path="phone" cssClass="form-control"/>
                </div>
                <div class="form-group">
              		<form:hidden path="password" cssClass="form-control"/>
                </div>
                <div class="form-group">
                	<form:hidden path="image.id" />
                </div>
              </div>
        	</form:form>
        	
        	<form id="fileUpload" method="post" enctype="multipart/form-data">
				<div class="box-body">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="form-group">
	                	<label for="imageName">選擇員工相片</label>
	                	<input name="empImg" id="empImg" type="file" />
	                </div>
	                <div id="previewImg" class="form-group">
	                <c:if test="${not empty empEdit.image.id}">
			    		<img src='./getImage/${empEdit.image.id}' id='${empEdit.image.id }' width='160px' height='160px' class='img-circle' />
					</c:if>
					
	               </div>
                </div>
			</form>
			
			<div class="box-body">
	        	<div class="form-group">
            		<button value="Submit" onclick="uploadImage()" >上傳</button>
            	</div>
            </div>
        	 <div class="box-footer">
              	 <button onclick='sumbitPage(this)' class="btn btn-default">儲存</button>
                 <button onclick='go()' class="btn btn-info">取消</button>
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