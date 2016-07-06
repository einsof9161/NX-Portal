<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/head.jsp"%>


<body class="hold-transition skin-blue fixed sidebar-mini">
	
	<!-- Site wrapper -->
	<div class="wrapper">
		
		<!-- Site Navigation bar-->
		<jsp:include page="/WEB-INF/views/jsp/common/nav.jsp"/>
		
		<!-- Left side column. contains the sidebar -->
		<aside class="main-sidebar">
			<jsp:include page="/WEB-INF/views/jsp/common/menu.jsp"/>
		</aside>
		
		<!-- Content Wrapper. Contains page content -->
		<div id='content' class="content-wrapper">
			<jsp:include page="/WEB-INF/views/jsp/common/main.jsp"/>
		</div>
		
		<jsp:include page="/WEB-INF/views/jsp/common/footer.jsp"/>
		
		<%@ include file="/WEB-INF/tags/commonJS.jsp"%>
		<script src="${serverCtx }/resources/nx/js/main.js"></script>
</body>
</html>
