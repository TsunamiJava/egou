<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>收货地址_用户中心</title>
<%@include file="../common/res.jsp" %>
</head>
<body>
<%@include file="../common/header.jsp" %>
<%@include file="../common/cart_header.jsp" %>
<div class="w mt ofc">
	<%@include file="../common/buyer_left.jsp" %>	
	<div class="r wr profile">

		<div class="confirm">
			<div class="tl"></div><div class="tr"></div>
			<div class="ofc">

				<h2 class="h2 h2_r2"><em title="个人资料">收货地址</em></h2>

				<h3 class="h3_r">已存收货地址列表</h3>

				<table cellspacing="0" summary="" class="tab tab6">
				<thead>
				<tr>
				<th>收货人</th>
				<th>所在地区</th>
				<th>街道地址</th>
				<th>电话/手机</th>
				<th>操作</th>
				</tr>                                                          
				</thead>
				<tbody>
					<tr class="here">
						<td>stone</td>
						<td>广州市天河区</td>
						<td>XXX街道XXX号XX房</td>
						<td>13788888888</td>
						<td><a href="javascript:void(0);" title="修改" onclick="modify('1')" class="blue">[修改]</a><a href="javascript:void(0);" title="删除" onclick="del(this)" class="blue">[删除]</a></td>
					</tr>
					<tr>
						<td>fangsq</td>
						<td>广州市白云区</td>
						<td>XXX街道XXX号XX房</td>
						<td>13788888999</td>
						<td><a href="javascript:void(0);" title="修改" onclick="modify('1')" class="blue">[修改]</a><a href="javascript:void(0);" title="删除" onclick="del(this)" class="blue">[删除]</a></td>
					</tr>
				</tbody>
				</table>

				<h3 class="h3_r">新增/修改收货地址<span>手机、固定电话选填一项，其余均为必填</span></h3>

				<form id="jvForm" method="post">
					<ul class="uls form">
					<li id="errorName" class="errorTip" style="display:none">${error}</li>
					<li>
						<label for="username"><samp>*</samp>收货人姓名：</label>
						<span class="bg_text"><input type="text" id="username" name="username" vld="{required:true}" maxLength="100" /></span>
						<span class="pos"><span class="tip okTip">&nbsp;</span></span>
					</li>
					<li>
						<label for="residence"><samp>*</samp>地　　址：</label>
						<span class="word">
						<select name="">
							<option value="" selected>省/直辖市</option>
							<option value=""></option>
						</select><select name="">
							<option value="" selected>城市</option>
							<option value=""></option>
						</select><select name="">
							<option value="" selected>县/区</option>
							<option value=""></option>
						</select></span>
					</li>
					<li>
						<label for="nick"><samp>*</samp>街道地址：</label>
						<span class="bg_text"><input type="text" id="nick" name="nick" maxLength="32"/></span>
						<span class="pos"><span class="tip errorTip">用户名为4-20位字母、数字或中文组成，字母区分大小写。</span></span>
					</li>
					<li>
						<label for="telphone"><samp>*</samp>联系电话：</label>
						<span class="bg_text"><input type="text" id="telphone" name="telphone" maxLength="32"/></span>
						<span class="pos"><span class="tip warningTip">用户名为4-20位字母、数字或中文组成，字母区分大小写。</span></span>
					</li>
					<li>
						<label for="statusAddr">&nbsp;</label>
						<span><input type="checkbox" name="statusAddr" />设为默认收货地址</span>
					</li>
					<li><label for="">&nbsp;</label><input type="submit" value="保存" class="hand btn66x23" /></li>
					</ul>
				</form>
			</div>
		</div>

	</div>
</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>
