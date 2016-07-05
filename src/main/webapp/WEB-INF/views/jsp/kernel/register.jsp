<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/tags/head.jsp"%>


<body class="hold-transition login-page">
<div class="register-box">
  <div class="register-logo">
    <a href="../../index2.html"><b>Nx_</b>FLowConsole</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">註冊新用戶</p>
	
    <form:form method="POST" modelAttribute="register" action="./saveRegistration">
    	<c:set var="nameBindError"><form:errors path="username"/></c:set>
    	<c:set var="passwordBindError"><form:errors path="password"/></c:set>
    	<c:set var="emailBindError"><form:errors path="email"/></c:set>
    	<c:set var="realnameBindError"><form:errors path="realname"/></c:set>
    	<c:set var="genderBindError"><form:errors path="gender"/></c:set>
    	
	    <div class="form-group ${not empty nameBindError?"has-error":"has-feedback"}">
	    	<c:if test="${not empty nameBindError}">
				<label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i>${nameBindError}</label>
		   </c:if>
	    	<input type="text" name="username" class="form-control" placeholder="請輸入帳號(字母加上英文)" value="${register.username}">
		   	<span class="glyphicon glyphicon-user form-control-feedback"></span>
	    </div>
		<div class="form-group ${not empty realnameBindError?"has-error":"has-feedback"}">
			<c:if test="${not empty realnameBindError}">
				<label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i>${realnameBindError}</label>
		   </c:if>
			<input type="text" name="realname" class="form-control" placeholder="真實姓名" value="${register.realname}">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		</div>
		<div class="form-group ${not empty emailBindError?"has-error":"has-feedback"}">
			<c:if test="${not empty emailBindError}">
				<label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i>${emailBindError}</label>
		   </c:if>
		   <input type="email" name="email"  class="form-control" placeholder="Email地址" value="${register.email}">
			<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
		<div class="form-group ${not empty passwordBindError?"has-error":"has-feedback"}">
      		<c:if test="${not empty passwordBindError}">
				<label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i>${passwordBindError}</label>
		   </c:if>
        	<input type="password" name="password" class="form-control" placeholder="請輸入密碼">
        	<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		</div>
		<div class="form-group ${not empty passwordBindError?"has-error":"has-feedback"}">
			<c:if test="${not empty passwordBindError}">
				<label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i>${passwordBindError}</label>
		   </c:if>
			<input type="password" name="re-password"  class="form-control" placeholder="請再次輸入密碼">
			<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
		</div>
		
		<div class="form-group ${not empty genderBindError?"has-error":""}">
			<c:if test="${not empty genderBindError}">
				<label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i>${genderBindError}</label>
		   </c:if>
			<form:select path="gender" cssClass="form-control">
				<form:option value="" label="選擇性別" />
				<form:options items="${gerderList}" />
			</form:select>
		</div>
		<div class="row">
		<div class="col-xs-8">
			<div class="checkbox icheck">
				<label>
					<input type="checkbox"> 我同意</input>
				</label>
			</div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">註冊</button>
        </div>
        <!-- /.col -->
      </div>
		
	</form:form>

    <div class="social-auth-links text-center">
    
    </div>

    <a href="./login" class="text-center">已經是用戶?</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

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