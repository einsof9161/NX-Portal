<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<%@ page import="com.nx.kernel.model.NxEntityState" %>

<!-- Content Wrapper. Contains page content -->
<div id ='content-wrapper'>
    
    <!-- Main content -->
    <section class="content">
      <div class="error-page">
        <h2 class="headline text-red">500</h2>

        <div class="error-content">
          <h3><i class="fa fa-warning text-red"></i>Sorry.伺服器可能出了些問題..</h3>
          <p id = 'errorMessage'></p>
        </div>
      </div>
      <!-- /.error-page -->
    </section>
    <!-- /.content -->
  </div>
<!-- /.content-wrapper -->
<%@ include file="/WEB-INF/tags/commonJS.jsp"%>