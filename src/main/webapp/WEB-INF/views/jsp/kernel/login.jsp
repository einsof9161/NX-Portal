<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<!DOCTYPE html>
<html>
  <head>
  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>NX Flow Admin Console| Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    
    <!-- 設定BootStarp 3.3.5 -->
    ${serverCtx}=====
    ${kernelServerCtx}=====
    ${webServerCtx}=====
    ${serverResourcesCtx }
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/bootstrap/css/bootstrap.min.css"">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/font-awesome-4.6.1/css/font-awesome.min.css">
    
    <!-- Ionicons -->
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/ionicons-2.0.1/css/ionicons.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/adminLTE/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="${serverResourcesCtx}/plugins/html5shiv/html5shiv.min.js"></script>
        <script src="${serverResourcesCtx}/plugins/respond/respond.min.js"></script>
    <![endif]-->
    
     <!-- jQuery 2.1.4 -->
    <script src="${serverResourcesCtx}/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="${serverResourcesCtx}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="${serverResourcesCtx}/plugins/iCheck/icheck.min.js"></script>
  </head>
  <body class="hold-transition login-page">
    <div class="login-box" style="border-color: red;border: 1px">
      <div class="login-logo">
        <a href="#"><b>NX_</b>FLowSystem</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg"> 您好,請輸入帳號密碼登入系統.</p>
        <form name='loginForm' action="${serverCtx}/KernelServer/validate" method="post">
          <div class="form-group has-feedback">
            <input type="text" id='account' name='account' class="form-control" placeholder="請輸入您的帳號/Email">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div> 
          <div class="form-group has-feedback">
            <input type="password" id='pwd' name='pwd' class="form-control" placeholder="請輸入您的密碼">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label><input type="checkbox"> 記住我</label>
              </div>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">登入</button>
            </div><!-- /.col -->
          </div>
        </form>

        <div class="social-auth-links text-center">
          <p>- 您也可以使用如下帳號登入 -</p>
          <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> 透過 Facebook 登入</a>
          <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> 透過 Google+ 登入</a>
        </div><!-- /.social-auth-links -->

        <a href="#">忘記密碼?</a><br>
        <a href="register.html" class="text-center">註冊新的使用者</a>

      </div><!-- /.login-box-body -->
      
      <div style="text-align: center">Developed by <a target="_blank" >Edward</a><br />
		Theme by <a target="_blank" href="http://almsaeedstudio.com/AdminLTE/" >AdminLTE</a>
    </div><!-- /.login-box -->
	
	</div>
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
