<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<div class="bar"><div class="bar_w">
	<p class="l">
		<span class="l">
			收藏本网站！广州<a href="#" title="更换">[更换]</a>
		</span>
	</p>
	<ul class="r uls">
	<li class="dev">您好,欢迎来到egou商城！</li>
	<c:choose>
		<c:when test="${buyer==null }">
			<li class="dev"><a href="javascript:void(0)" onclick="login()"  title="登陆">[登陆]</a></li>
			<li class="dev"><a href="javascript:void(0)" onclick="register()" title="免费注册">[免费注册]</a></li>
		</c:when>
		<c:otherwise>
			<li class="dev">欢迎您，${buyer.username }</li>
			<li class="dev"><a href="javascript:void(0)" onclick="logout()" title="退出">[安全退出]</a></li>
		</c:otherwise>
	</c:choose>
	
	<li class="dev"><a href="javascript:void(0)" onclick="myOrder()" title="我的订单">我的订单</a></li>
	<li class="dev"><a href="#" title="在线客服">在线客服</a></li>
	<li class="dev after"><a href="#" title="English">English</a></li>
	</ul>
</div></div>