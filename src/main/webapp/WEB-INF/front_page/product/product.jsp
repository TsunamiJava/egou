<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<title>egou-电子商城</title>
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script src="/res/js/com.js"></script>
<script type="text/javascript">
	//登陆
	function login() {
		window.location.href = "../buyer/login.jsp";
	}
</script>
</head>
<body>

<%@include file="../common/header.jsp" %>
<%@include file="../common/cart_header.jsp" %>

	<div class="w ofc">
		<%@include file="../common/product_left.jsp" %>
		<div class="r wr">
			<h2 class="h2 h2_r rel">
				<samp></samp>
				<em title="热卖推荐">&nbsp;&nbsp;&nbsp;热卖推荐</em>
			</h2>
			<div class="box bg_white">
				<ul class="uls i_150x150 x4_150x150">
					<li><a href="productDetail.jsp" title="富一代" target="_blank"
						class="pic"><img src="/res/img/pic/yujia5.jpg"
							alt="瑜伽垫印花男女加宽加厚" /></a>
						<dl>
							<dt>
								<a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新"
									target="_blank">瑜伽垫印花男女加宽加厚</a>
							</dt>
							<dd class="h40">瑜伽垫印花男女加宽加厚</dd>
							<dd class="orange">￥120 ~ ￥150</dd>
							<dd>
								<a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a>
							</dd>
						</dl></li>
					<li><a href="productDetail.jsp" title="瑜伽垫印" target="_blank"
						class="pic"><img src="	/res/img/pic/yujia6jpg.jpg"
							alt="瑜伽垫印花男女！" /></a>
						<dl>
							<dt>
								<a href="productDetail.jsp" title="瑜伽垫印花男女！"
									target="_blank">瑜伽垫印花男女加宽加厚...</a>
							</dt>
							<dd class="h40">瑜伽垫印花男女！</dd>
							<dd class="orange">￥122 ~ ￥140</dd>
							<dd>
								<a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a>
							</dd>
						</dl></li>
					<li><a href="productDetail.jsp" title="珈服套装" target="_blank"
						class="pic"><img src="/res/img/pic/yujia7.jpg"
							alt="珈服套装女健身舞蹈宽松！" /></a>
						<dl>
							<dt>
								<a href="productDetail.jsp" title="珈服套装女健身舞蹈宽松" target="_blank">珈服套装女健身舞蹈宽松...
								</a>
							</dt>
							<dd class="h40">珈服套装女健身舞蹈宽松！</dd>
							<dd class="orange">￥142 ~ ￥153</dd>
							<dd>
								<a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a>
							</dd>
						</dl></li>
					<li><a href="productDetail.jsp" title="初学者健身垫" target="_blank"
						class="pic"><img src="	/res/img/pic/yujia8.jpg"
							alt="初学者健身垫" /></a>
						<dl>
							<dt>
								<a href="productDetail.jsp" title="初学者健身垫" target="_blank">初学者健身垫...</a>
							</dt>
							<dd class="h40">加厚10mm加长初学者健身垫</dd>
							<dd class="orange">￥132 ~ ￥150</dd>
							<dd>
								<a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a>
							</dd>
						</dl></li>
				</ul>
			</div>

			<h2 class="h2 h2_filter mt">
				<em title="商品筛选">商品筛选</em><cite><a href="javascript:void(0);"
					id="filterRest" title="重置筛选条件">重置筛选条件</a></cite>
			</h2>
			<ul class="uls filter">
				<li><label>已选条件：</label>
					<p class="sel">
						<a href="javascript:void(0);"> <em>品牌：</em>安踏（ANTA） <cite
							title="关闭此筛选条件">X</cite></a>
					</p></li>
				<li><b>品牌：</b>
					<p>
						<a href="/searchProducts?brandId=-1" title="不限" class="here">不限</a> 
						<c:forEach var="b" items="${brands }">
						<a
							href="/searchProducts?brandId=${b.id}"
							title="${b.name }">${b.name }</a> 
						</c:forEach>
					</p></li>
				<li><b>价格：</b>
					<p>
						<a href="javascript:void(0);" title="不限" class="here">不限</a> <a
							href="javascript:void(0);" title="1-99">0-79</a> <a
							href="javascript:void(0);" title="100-199">80-199</a> <a
							href="javascript:void(0);" title="200-499">200-299</a> <a
							href="javascript:void(0);" title="200-499">300-499</a> <a
							href="javascript:void(0);" title="200-499">500-599</a> <a
							href="javascript:void(0);" title="200-499">600以上</a>
					</p></li>
				<li><b>类型：</b>
					<p>
						<a href="/searchProducts?typeId=-1" title="不限" class="here">不限</a>
						<c:forEach var="t" items="${types }">
						 <a
							href="/searchProducts?typeId=${t.id }"
							title="${t.name }">${t.name }</a> 
						</c:forEach>
					</p></li>
				<li><b>材质：</b>
					<p>
						<span><a href="javascript:void(0);" title="不限" class="here">不限</a></span>
						<c:forEach var="f" items="${features }">
						<span>
						<a href="/searchProducts?featureId=${f.id }" title="${f.name }">${f.name }</a></span> 
						</c:forEach>
					</p></li>

				<li><b>适用人群：</b>
					<p>
						<a href="javascript:void(0);" title="不限" class="here">不限</a> <a
							href="javascript:void(0);" title="男士">男士</a> <a
							href="javascript:void(0);" title="女士">女士</a> <a
							href="javascript:void(0);" title="儿童">儿童</a> <a
							href="javascript:void(0);" title="中性">中性</a>
					</p></li>
			</ul>
			<div class="sort_type">
				<a href="javascript:void(0);" title="销量" class="sales">销量</a> <a
					href="javascript:void(0);" title="价格" class="price">价格</a> <a
					href="javascript:void(0);" title="上架时间" class="time">上架时间</a>
			</div>
			<div class="mt ofc">
				<ul class="uls i_150x150 x4_150x150b">
				<c:forEach var="item" items="${page.items }">
					<li><a href="productDetail.jsp" title="${item.product.name }" target="_blank"
						class="pic"><img src="${item.mainImg.url }" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt>
								<a href="/showProductDetail?productId=${item.product.id}" title="${item.product.name }" target="_blank">${item.product.name }</a>
							</dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">${item.product.name }
							<dd class="orange">￥148.00</dd>
							<dd>北京有货</dd>
							<dd>
								<a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a>
							</dd>
						</dl> <img src="/res/img/pic/hot.gif" alt="热门" class="type" /></li>
					</c:forEach>
				</ul>
				<div class="page pb15">
					<span class="r inb_a page_b"> <span id="previousNo"
						class="inb" title="上一页"><samp>&lt;&lt;</samp>上一页</span><a
						href="javascript:void(0);" id="previous" title="上一页"
						style="display: none"><samp>&lt;&lt;</samp>上一页</a>
						<c:forEach var="index" begin="1" end="${page.pageInfo.pages }">
							<c:choose>
								<c:when test="${index==page.pageInfo.pageNum }">
									<span
						title="第1页" class="inb current">${index }</span>
								</c:when>
								<c:otherwise>
									<a href="showIndex?pageNum=${index }" title="第${index }页">${index }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<!--<span
						 title="第1页" class="inb current">1</span> a href="#" title="第1页">1</a
						<a href="#" title="第2页">2</a><a href="#" title="第3页">3</a><a
						href="#" title="第4页">4</a><a href="#" title="第5页">5</a><span
						class="break">...</span><a href="#" title="第16页">16</a> --><span
						id="nextNo" class="inb" title="下一页" style="display: none">下一页<samp>&gt;&gt;</samp></span><a
						href="javascript:void(0);" id="next" title="下一页">下一页<samp>&gt;&gt;</samp></a>共<var
							id="pageTotal" class="orange">0</var>页 到第<input type="text"
						id="number" name="number" class="txts" size="3" />页 <input
						type="button" id="skip" class="hand btn60x20" value='确定' />
					</span>
				</div>
			</div>
		</div>
	</div>
<%@include file="../common/footer.jsp" %>
</body>
</html>