<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>成功提交订单</title>
<%@include file="../common/res.jsp" %>
</head>
<body>
<%@include file="../common/header.jsp" %>

<ul class="ul step st3_3">
<li title="1.我的购物车">1.我的购物车</li>
<li title="2.填写核对订单信息">2.填写核对订单信息</li>
<li title="3.成功提交订单" class="here">3.成功提交订单</li>
</ul>

<div class="w ofc case">

	<div class="confirm">
		<div class="tl"></div><div class="tr"></div>
		<div class="ofc">
			
			<p class="okMsg">您的订单已成功提交，完成支付后，我们将立即发货！</p>

			<table cellspacing="0" class="tab tab5" summary="">
			<tbody><tr>
			<th>您的订单号</th>
			<td><var class="blue"><b>20151029114530088</b></var></td>
			<th>应付现金</th>
			<td><var class="red"><b>￥689.01</b></var>&nbsp;元</td>
			<th>支付方式</th>
			<td>在线支付</td>
			</tr>
			<tr>
			<th>配送方式</th>
			<td>快递</td>
			<th>预计到货时间</th>
			<td>2015年10月22日</td>
			<th></th>
			<td></td>
			</tr>
			</table>
		</div>
	</div>
</div>
</body>
</html>