<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<title>egou商城-商品详情页</title>
<%@include file="../common/res.jsp" %>

<style type="text/css">
.changToRed {
	border: 2px  solid #e4393c;
	padding: 2px 4px;
	float: left;
	margin-right: 4px;
	text-decoration: none;
}
.changToWhite {
	border: 1px solid #ccc;
	padding: 2px 4px;
	float: left;
	margin-right: 4px;
	text-decoration: none;
}
.not-allow {
	cursor: not-allowed;
	color: #999;
	border: 1px dashed #ccc;
	padding: 2px 4px;
	float: left;
	margin-right: 4px;
	text-decoration: none;
}
</style>
</head>
<script type="text/javascript">
$(function(){
	//初始化点击第一个颜色
	$("#colors a:first").trigger("click");
	//给A标签绑定事件   -
	$("#sub").click(function(){
		//件数  1
		var num = $("#num").val();
		num--;
		if(num == 0){
			//alert();
			return;
		}
		//赋值
		$("#num").val(num);
	});
	//+
	$("#add").click(function(){
		//件数  8
		var num = $("#num").val();
		num++;
		//num 9      9
		if(num > buyLimit){
			alert("此商品只能买" + buyLimit + "件");
			return;
		}
		//赋值
		$("#num").val(num);
	});
});
//全局变量
//颜色ID
var colorId;
//SkuId
var skuId;
//限购
var buyLimit;

//点击颜色  ￥128.00  id 颜色ID
function colorToRed(target,id){
	//赋值
	colorId = id;
	//先清理其它颜色
	$("#colors a").each(function(){
		$(this).attr("class","changToWhite");
	});
	//先清理尺码  都变成不可点
	$("#sizes a").each(function(){
		$(this).attr("class","not-allow");
	});
	
	$(target).attr("class","changToRed");
	//控制尺码 
	var flag = 0;
	//
	<c:forEach items="${detailItem.skus}" var="sku">
	  //判断SKu中与当前选择的颜色ID一样的,获取出所有尺码   
		if(id == '${sku.colorId}'){
			//四次  S  L  XL  XXL
			if(flag == 0){
				$("#" + '${sku.size}').attr("class","changToRed");
				flag = 1;
				//赋值
				//巴巴价
				$("#price").html("￥" + '${sku.skuPrice}');
				//市场价
				$("#mprice").html("￥" + '${sku.marketPrice}');
				//运费
				$("#fee").html('${sku.deliveFee}');
				//库存
				$("#stock").html('${sku.stockInventory}');
				//skuId
				skuId = '${sku.id}';
				//
				//限购
				buyLimit = '${sku.skuUpperLimit}';
				
			}else{
				$("#" + '${sku.size}').attr("class","changToWhite");
			}
		}
	</c:forEach>
	
}
//点击尺码
function sizeToRed(target,id){
	
	var cc = $(target).attr("class");
	if(cc == "not-allow"){
		return ;
	}
	//先清理尺码  都变成不可点
	$("#sizes a").each(function(){
		var c = $(this).attr("class");
		if(c != "not-allow"){
			$(this).attr("class","changToWhite");
		}
	});
	//尺码变红
	$(target).attr("class","changToRed");
	
	<c:forEach items="${pItem.skus}" var="sku">
	  //判断SKu中与当前选择的颜色ID一样的,获取出所有尺码   
		if(colorId == '${sku.colorId}' && id == '${sku.size}'){
				//赋值
				//巴巴价
				$("#price").html("￥" + '${sku.skuPrice}');
				//市场价
				$("#mprice").html("￥" + '${sku.marketPrice}');
				//运费
				$("#fee").html('${sku.deliveFee}');
				//库存
				$("#stock").html('${sku.stockInventory}');
				//skuId
				skuId = '${sku.id}';
				//
				//限购
				buyLimit = '${sku.skuUpperLimit}';
		}
	</c:forEach>
}


//加入购物车
function addCart(skuId,skuPrice,deliveFee,productId,productName,imgUrl,skuUpperLimit){
	//alert("添加购物车成功!");
	window.location.href = "/cart/addProductToCart?skuId="+skuId+"&skuPrice="+skuPrice+"&deliveFee="+deliveFee+"&productId="+productId+"&productName="+encodeURI(productName)+"&imgUrl="+imgUrl+"&amount="+$("#num").val()+"&skuUpperLimit="+skuUpperLimit;
	//window.location.href = "/cart/addProductToCart/"+skuId+"/"+skuPrice+"/"+deliveFee+"/"+productId+"/'"+productName+"'/'"+imgUrl+"'/"+$("#num").val();
}
//立即购买
function buy(productId,productName){
	//window.location.href='/shopping/buyCart/' + skuId + "/" + $("#num").val() + "/" + buyLimit + "/" + productId+"/"+productName;
	//:/shopping/buyCart.thtml?skuId=500&amount=2&buyLimit=6&productId=265
	//skuId  productId  件数   限购
}
</script>

</head>
<body>
<%@include file="../common/header.jsp" %>
<%@include file="../common/cart_header.jsp" %>


<div class="w ofc mt">
	<div class="l">
		<div class="showPro">
			<div class="big"><a id="showImg" class="cloud-zoom" href="${ctx}/res/img/pic/shoutu.jpg" rel="adjustX:10,adjustY:-1"><img alt="" src="${ctx}/res/img/pic/shoutu.jpg"></a></div>
		</div>
	</div>
	<div class="r" style="width: 640px">
		<ul class="uls form">
			<li><h2>${eproduct.name }</h2></li>
			<li><label>巴  巴 价：</label><span class="word"><b class="f14 red mr">￥${sku.skuPrice+500}</b>(市场价:<del>￥${sku.marketPrice}</del>)</span></li>
			<li><label>商品评价：</label><span class="word"><span class="val_no val3d4" title="4分">4分</span><var class="blue">(已有888人评价)</var></span></li>
			<li><label>运　　费：</label><span class="word">${sku.deliveFee}元</span></li>
			<li><label>库　　存：</label><span class="word" id="stockInventory">${sku.stockInventory}</span><span class="word" >件</span></li>
			<li><label>选择颜色：</label>
				<div id="colors" class="pre spec">
					<c:forEach var="c" items="${colors}">
						<a onclick="colorToRed(this,${c.id})" href="javascript:void(0)" title="${c.name }" class="changToRed"><img width="25" height="25" data-img="1" src="${ctx}/res/img/pic/shoutu.jpg" alt="${c.name }"><i>${c.name }</i></a>
					</c:forEach>
					<%-- <a onclick="colorToRed(this,11)" href="javascript:void(0)" title="亮黑" class="changToWhite"><img width="25" height="25" data-img="1" src="${ctx}/res/img/pic/shoutu.jpg" alt="亮黑 "><i>亮黑</i></a>
					<a onclick="colorToRed(this,18)" href="javascript:void(0)" title="玫瑰金" class="changToWhite"><img width="25" height="25" data-img="1" src="${ctx}/res/img/pic/meigui.jpg" alt="玫瑰金 "><i>玫瑰金</i></a> --%>
				</div>
			</li>
			
			<li><label>我 要 买：</label>
				<a id="sub" class="inb arr" style="border: 1px solid #919191;width: 10px;height: 10px;line-height: 10px;text-align: center;" title="减" href="javascript:void(0);" >-</a>
				<input id="num" type="text" value="1" name="" size="1" readonly="readonly">
				<a id="add" class="inb arr" style="border: 1px solid #919191;width: 10px;height: 10px;line-height: 10px;text-align: center;" title="加" href="javascript:void(0);">+</a></li>
				
				
			<li class="submit"><input type="button" value="" class="hand btn138x40" onclick="buy();"/><input type="button" value="" class="hand btn138x40b" onclick="addCart(${sku.id},${sku.skuPrice},${sku.deliveFee},${eproduct.id},'${eproduct.name }','/res/img/pic/shoutu.jpg',${sku.skuUpperLimit})"/></li>
		</ul>
	</div>
</div>
<div class="w ofc mt">
<%@include file="../common/product_left.jsp" %>
<div class="r wr">
		<h2 class="h2 h2_ch mt"><em>
			<a href="javascript:void(0);" title="商品介绍" rel="#detailTab1" class="here">商品介绍</a>
			<a href="javascript:void(0);" title="规格参数" rel="#detailTab2">规格参数</a>
			<a href="javascript:void(0);" title="包装清单" rel="#detailTab3">包装清单</a></em><cite></cite></h2>
		<div class="box bg_white ofc">
			<div id="detailTab1" class="detail">
				<img src="${ctx}/res/img/pic/abc.png" />
			</div>
			
			<div id="detailTab2" style="display:none">
				<strong>服务承诺：</strong><br>
	京东向您保证所售商品均为正品行货，京东自营商品开具机打发票或电子发票。凭质保证书及京东发票，可享受全国联保服务（奢侈品、钟表除外；奢侈品、钟表由京东联系保修，享受法定三包售后服务），与您亲临商场选购的商品享受相同的质量保证。京东还为您提供具有竞争力的商品价格和<a target="_blank" href="http://www.jd.com/help/kdexpress.aspx">运费政策</a>，请您放心购买！
	<br><br>
	注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！ <br/>
		<strong>权利声明：</strong><br>京东上的所有商品信息、客户评价、商品咨询、网友讨论等内容，是京东重要的经营资源，未经许可，禁止非法转载使用。
	<p><b>注：</b>本站商品信息均来自于合作方，其真实性、准确性和合法性由信息拥有者（合作方）负责。本站不提供任何保证，并不承担任何法律责任。</p>	
				
			</div>

			<div id="detailTab3" class="detail" style="display:none">

	<pre class="f14">
		上衣*1 裤子*1 抹胸*1 包装*1 
	</pre>

			</div>
		</div>

	</div>
</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>