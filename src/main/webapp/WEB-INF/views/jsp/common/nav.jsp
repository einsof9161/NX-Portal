<%@ page contentType="text/html;charset=UTF-8" import="com.nx.kernel.model.user.NxEmployee"%>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<header class="main-header">
	<!-- Logo -->
	<a href="./main" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>N</b>X</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>NX</b>FlowConsole</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span> <span
			class="icon-bar"></span> <span class="icon-bar"></span> <span
			class="icon-bar"></span>
		</a>
		
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- Messages: style can be found in dropdown.less-->
				<li class="dropdown messages-menu">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="fa fa-envelope-o"></i><span class="label label-success">4</span>
					</a>
					<ul class="dropdown-menu">
							<li class="header">您有四個訊息</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">
									<li>
									<c:set var="sessionUser" scope="session" value="${sessionUserBean}"/>
										<!-- start message --> 
										<a href="#">
											<div class="pull-left">
												<img src="./getImage/${sessionUser.getImage().getId()}" class="img-circle" alt="User Image">
											</div>
											<h4>Support Team <small><i class="fa fa-clock-o"></i>5mins</small></h4>
											<p>您有一個新的通知</p>
										</a>
									</li>
									<!-- end message -->
								</ul>
							</li>
							<li class="footer"><a href="#">See All Messages</a></li>
					</ul>
				</li>
				<!-- Tasks: style can be found in dropdown.less -->
				<li class="dropdown tasks-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-flag-o"></i> <span class="label label-danger">9</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">您有9筆待處理簽核</li>
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu">
								<li>
									<!-- Task item --> <a href="#">
										<h3>
											<b>FlowNo:12389074123</b> : T10申請人填寫資訊 <small
												class="pull-right">20%</small>
										</h3>
										<div class="progress xs">
											<div class="progress-bar progress-bar-aqua"
												style="width: 20%" role="progressbar" aria-valuenow="20"
												aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only">完成進度</span>
											</div>
										</div>
								</a>
								</li>
								<!-- end task item -->
							</ul>
						</li>
						<li class="footer"><a href="#">檢視所有待處理工作</a></li>
					</ul></li>
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <!--  <img src="../../dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> -->
					<i class="fa fa-user"></i><span class="hidden-xs">Welcome! ${sessionUser.getRealname()}</span>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header">
							<img src="./getImage/${sessionUser.getImage().getId()}" class="img-circle" alt="User Image">
							<p>
								${user} - Administrator <small>於2016建立</small>
							</p></li>
						<!-- Menu Body -->
						<li class="user-body">
							<div class="row">
								<div class="col-xs-4 text-center">
									<a href="#">部門</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">權限列表</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">個人設定</a>
								</div>
							</div> <!-- /.row -->
						</li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">檢視相關工作</a>
							</div>
							<div class="pull-right">
								<a href="${serverCtx}/logout" class="btn btn-default btn-flat">登出</a>
							</div>
						</li>
					</ul></li>
				<!-- Control Sidebar Toggle Button -->
				<li><a href="#" data-toggle="control-sidebar"><i
						class="fa fa-gears"></i></a></li>
			</ul>
		</div>
	</nav>
</header>