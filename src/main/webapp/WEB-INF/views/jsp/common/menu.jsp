<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<!-- sidebar: style can be found in sidebar.less -->
<section class="sidebar">
	<!-- search form -->
	<form action="#" method="get" class="sidebar-form">
		<div class="input-group">
			<input type="text" name="q" class="form-control" placeholder="查詢..">
			<span class="input-group-btn">
				<button type="submit" name="search" id="search-btn"
					class="btn btn-flat">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
	</form>

	<!-- /.search form -->
	<!-- sidebar menu: : style can be found in sidebar.less -->
	<ul class="sidebar-menu">
		<li class="header">功能選單</li>
		<c:forEach items="${menus}" var="nxMenu">
			<li class="treeview">
				<c:choose>
					<c:when test="${nxMenu.hyperlink!=null}">
						<a href="javascript:void(0)">
					</c:when>
					<c:otherwise>
						<a href="${nxMenu.hyperlink}">
					</c:otherwise>
				</c:choose> 
				<i class="${nxMenu.icon}"></i> 
				<span>${nxMenu.name}</span>
				<i class="fa fa-angle-left pull-right"></i>
				</a>
				<c:if test="${fn:length(nxMenu.children) gt 0}">
					<ul class="treeview-menu">
						<c:forEach items="${nxMenu.children}" var="childMenu">
							<li contextUrl="${childMenu.hyperlink}" entityClass="${childMenu.entityClass}">
								<a onclick="getMenuContent(this);" href="javascript:void(0);">
									<i class="${childMenu.icon}"></i>${childMenu.name}
								</a>
							</li>
						</c:forEach>
					</ul>
					
				</c:if>
			</li>
		</c:forEach>
	</ul>
</section>
<!-- /.sidebar -->