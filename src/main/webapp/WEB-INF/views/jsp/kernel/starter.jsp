<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <meta charset="utf-8">
    <title>NX Flow Admin Starter| Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
     <!DOCTYPE html>
     <!--${serverCtx}=====
    ${kernelServerCtx}=====
    ${webServerCtx}=====
    ${serverResourcesCtx } -->
    
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/bootstrap/css/bootstrap.min.css"">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/font-awesome-4.6.1/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/ionicons-2.0.1/css/ionicons.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/adminLTE/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${serverResourcesCtx}/plugins/iCheck/square/blue.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${serverResourcesCtx}/plugins/adminLTE/css/skins/_all-skins.min.css">
    
    <%@ include file="/WEB-INF/tags/common.jsp" %>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="${serverResourcesCtx}/plugins/html5shiv/html5shiv.min.js"></script>
        <script src="${serverResourcesCtx}/plugins/respond/respond.min.js"></script>
    <![endif]-->
    
    </head>
  <!-- ADD THE CLASS fixed TO GET A FIXED HEADER AND SIDEBAR LAYOUT -->
  <!-- the fixed layout is not compatible with sidebar-mini -->
 	
  <body class="hold-transition skin-blue fixed sidebar-mini">
   <!-- Site wrapper -->
    <div class="wrapper">

      <header class="main-header">
        <!-- Logo -->
        <a href="#" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>測試</b>X</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>測試NX</b>FlowSystem</span>
        </a>