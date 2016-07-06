<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/taglib.jsp" %>
<%@ page import="com.nx.kernel.model.NxEntityState" %>


<!-- Content Wrapper. Contains page content -->
<div id ='content-wrapper'>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>My Work Item</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Tables</a></li>
			<li class="active">Simple</li>
		</ol>
	</section>
	
	
	<!-- Main content -->
	<section class="content">
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">待處理工作</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>工作序號</th>
                    <th>主旨</th>
                    <th>流程狀態</th>
                    <th>動作</th>
                    <th>時間</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td><a href="javascript:void(0)">Workflow-00000001</a></td>
                    <td>S02-當事人主管簽核</td>
                    <td><span class="label label-success">Waitting Approve</span></td>
                    <td>
                      <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">簽核</a>
              		  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">退件</a>
			
                    </td>
                     <td>
                      2016-01-01 17:30:00
                    </td>
                  </tr>
                  <tr>
                    <td><a href="javascript:void(0)">Workflow-00000002</a></td>
                    <td>S01-申請人送出</td>
                    <td>
                    	<span class="label label-info">Processing</span>
                    </td>
                    <td>
                      <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">簽核</a>
              		  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">退件</a>
			
                    </td>
                     <td>
                      2016-01-01 17:30:00
                    </td>
                  </tr>
                  <tr>
                    <td><a href="javascript:void(0)">Workflow-00000003</a></td>
                    <td>S01-申請人送出</td>
                    <td>
                    	<span class="label label-info">Processing</span>
                    </td>
                    <td>
                      <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">簽核</a>
              		  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">退件</a>
			
                    </td>
                     <td>
                      2016-01-01 17:30:00
                    </td>
                  </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.table-responsive -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">過濾條件</a>
              <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-right">檢視所有待處理工作</a>
            </div>
            <!-- /.box-footer -->
          </div>
          
          <!-- /.box -->
        </div>
        <!-- /.col -->
	</section>
	<section class="content-header">
		<h1>My Saved Report</h1>
	</section>
	
	
	<!-- Main content -->
	<section class="content">
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">我儲存的報表</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>序號</th>
                    <th>報表名稱</th>
                    <th>建立時間</th>
                    <th>動作</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td><a href="javascript:void(0)">report-00000001</a></td>
                    <td>我的所有待處理清單</td>
                    <td>2016-01/31</td>
                    <td>
              		  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">匯出Excel</a>
              		  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">匯出XML</a>
              		  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">匯出JSON</a>
                    </td>
                  </tr>
                  <tr>
                    <td><a href="javascript:void(0)">report-00000002</a></td>
                    <td>系統功能列表匯出</td>
                    <td>2016-01/31</td>
                    <td>
              		  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">匯出Excel</a>
              		  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">匯出XML</a>
              		  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-left">匯出JSON</a>
                    </td>
                  </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.table-responsive -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">過濾條件</a>
              <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-right">檢視所有待處理工作</a>
            </div>
            <!-- /.box-footer -->
          </div>
          
          <!-- /.box -->
        </div>
        <!-- /.col -->
	</section>
	<!-- /.content -->
	<script src="${serverCtx }/resources/nx/js/useropreation.js"></script>
</div>
<!-- /.content-wrapper -->