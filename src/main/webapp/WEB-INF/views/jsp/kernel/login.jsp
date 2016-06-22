<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/tags/head.jsp"%>

<body class="hold-transition login-page">
	<c:url value="/login" var="loginUrl" />
	
	
	<!-- Debug Model -->
	<%
  	 String deBugMode = (String)request.getParameter("debug");
	 if(null!=deBugMode){
	 %>
	<div class="info-box">
		<span class="info-box-icon bg-red"><i class="fa fa-bug"></i></span>
		<div class="info-box-content">
			<span class="info-box-text"> serverCtx==${serverCtx} <br>
				kernelServerCtx==>${kernelServerCtx} <br>
				webServerCtx==>${webServerCtx} <br>
				serverResourcesCtx==>${serverResourcesCtx } <br>${loginUrl} <br>
				${param}
			</span>
		</div>
		<!-- /.info-box-content -->
	</div>
	<!-- /.info-box -->
	<% }%>



	<div class="login-box" style="border-color: red; border: 1px">
		<div class="login-logo">
			<a href="#"><b>NX_</b>FLowConsole</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg"> 您好,請輸入帳號密碼登入系統.</p>

			<form name='loginForm' action="${loginUrl}" method="post">

				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>

				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>您已經成功登出.如需使用請重新登入</p>
					</div>
				</c:if>
				<div class="form-group has-feedback">
					<input type="text" name='ssoId' class="form-control"
						placeholder="請輸入您的帳號/Email"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
				<div class="form-group has-feedback">
					<input type="password" name='password' class="form-control"
						placeholder="請輸入您的密碼"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label><input type="checkbox"> 記住我</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登入</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<div class="social-auth-links text-center">
				<p>- 您也可以使用如下帳號登入 -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
					class="fa fa-facebook"></i> 透過 Facebook 登入</a> <a href="#"
					class="btn btn-block btn-social btn-google btn-flat"><i
					class="fa fa-google-plus"></i> 透過 Google+ 登入</a>

			</div>
			<!-- /.social-auth-links -->

			<a href="#">忘記密碼?</a><br> <a href="register.html"
				class="text-center">註冊新的使用者</a>

		</div>
		<!-- /.login-box-body -->

		<div style="text-align: center">
			Developed by <a target="_blank">Edward</a><br /> Theme by <a
				target="_blank" href="http://almsaeedstudio.com/AdminLTE/">AdminLTE</a>
		</div>
		<!-- /.login-box -->

	</div>
	<%@ include file="/WEB-INF/tags/commonJS.jsp"%>
	<script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-red',
         // increaseArea: '20%' // optional
        });
      });
    </script>
</body>
</html>
