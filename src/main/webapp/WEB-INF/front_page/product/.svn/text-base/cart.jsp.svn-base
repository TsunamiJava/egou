<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的购物车</title>
<%@include file="../common/res.jsp" %>
<script type="text/javascript">
//结算
function closeBuy(){
 	window.location.href = "/buyer/closeBuy";
}
function clearCart(){
	window.location.href = "/cart/clear";
}
</script>
</head>
<body>
<%@include file="../common/header.jsp" %>
<ul class="ul step st3_1">
<li title="1.我的购物车" class="here">1.我的购物车</li>
<li title="2.填写核对订单信息">2.填写核对订单信息</li>
<li title="3.成功提交订单">3.成功提交订单</li>
</ul>
<div class="w ofc case">
	<div class="confirm">
		<div class="tl"></div><div class="tr"></div>
		<div class="ofc pb40">

			<div class="page">
				<b class="l f14 blue pt48">
					我挑选的商品：
				</b>
			</div>
			<table cellspacing="0" class="tab tab4" summary="">
			<thead>
			<tr>
			<th class="wp">商品</th>
			<th>单价（元）</th>
			<th>数量</th>
			<th>操作</th>
			</tr>     
			</thead>
			<tbody>
				<c:forEach var="item" items="${ buyCart.items}">
				<tr>
					<td class="nwp pic">
						<ul class="uls">
							<li>
								<a class="pic" title="${item.product.name }" href="javascript:void(0)"><img alt="${item.product.name }" src="${item.img.url }"></a>
								<dl>
									<dt><a title="${item.product.name }" href="javascript:void(0)">${item.product.name }</a></dt>
									<dd><span class="red">【赠品】</span>
										<p class="box_d bg_gray2 gray"><a title="瑜伽丝带" href="#">瑜伽丝带</a><br></p>
									</dd>
								</dl>
							</li>
						</ul>
					</td>
					<td>￥${item.sku.skuPrice }</td>
					<td><a onclick="subProductAmount(492,9)" class="inb arr" title="减" href="javascript:void(0);">-</a><input type="text" id="num492" readonly="readonly" value="${item.amount }" name="" size="1" class="txts"><a onclick="addProductAmount(492,9)" class="inb arr" title="加" href="javascript:void(0);">+</a></td>
					<td class="blue"><a title="删除" href="/cart/deleteItem?skuId=${item.sku.id }">删除</a></td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
			<div class="page">
				<span class="l">
					<input type="button" onclick="window.open('/product/detail.thtml?id=274')" class="hand btn100x26c" title="继续购物" value="继续购物">
					<input type="button" onclick="clearCart()" class="hand btn100x26c" title="清空购物车" value="清空购物车">
				</span>
				<span class="r box_gray">
					<dl class="total">
						<dt>购物车金额小计：<cite>(共<var id="productAmount">${buyCart.productAmount }</var>个商品)</cite></dt>
						<dd><em class="l">商品金额：</em>￥<var id="productPrice">${buyCart.productPrice }</var>元</dd>
						<dd><em class="l">运费：</em>￥<var id="fee">${buyCart.fee }</var>元</dd>
						<dd class="orange"><em class="l">应付总额：</em>￥<var id="totalPrice">${buyCart.productPrice+buyCart.fee}</var>元</dd>
						<dd class="alg_c"><input type="button" onclick="closeBuy()" class="hand btn136x36a" value="结算" id="settleAccountId"></dd>
					</dl>
				</span>
			</div>
		</div>
	</div>
</div>
<div class="w ofc case" style="display: none;">
	<div class="confirm">
		<div class="tl"></div><div class="tr"></div>
		<div class="ofc pb40" style="text-align: center;height: 200px;margin-top: 80px">
       		 <a href="http://localhost:8080" style="color: red;font-size: 30px;">去首页</a>挑选喜欢的商品
		</div>
	</div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
</html>