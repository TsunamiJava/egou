<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录_egou商城</title>
<%@include file="../common/res.jsp" %>
</head>
<body>
<%@include file="../common/header.jsp" %>
<div class="w loc">
	<div class="h-title" id="logo">
		<div class="h-logo l"><img src="${ctx}/res/img/pic/logo-1.png"/></div>
	</div>
</div>
<div class="sign">
	<div class="l ad420x205"><a href="#" title="title"><img src="${ctx}/res/img/pic/smallimage-4.jpg" width="400" height="400"/></a></div>
	<div class="r">
		<h2 title="登录egou商城">登录egou商城</h2>
		<form id="jvForm" action="/shopping/login" method="post">
			<ul class="uls form">
			<li id="errorName" class="errorTip" <c:if test="${empty error }">style="display:none"</c:if>>${error}</li>
			<li><label for="username">用户名：</label>
				<span class="bg_text">
					<input type="text" id="username" name="username" maxLength="100" />
				</span>
			</li>
			<li><label for="password">密　码：</label>
				<span class="bg_text">
					<input type="password" id="password" name="password" maxLength="32" />
				</span>
			</li>
			<li><label for="captcha">验证码：</label>
				<span class="bg_text small">
					<input type="text" id="captcha" name="captcha" maxLength="7"/>
				</span>
				<img src="/captcha.svl" onclick="this.src='/captcha.svl?d='+new Date()" class="code" alt="换一张" /><a href="javascript:void(0);" onclick="$('.code').attr('src','/captcha.svl?d='+new Date())" title="换一张">换一张</a></li>
			<li><label for="">&nbsp;</label><input type="submit" value="登 录" class="hand btn66x23"/><a href="#" title="忘记密码？">忘记密码？</a></li>
			</ul>
		</form>
	</div>
</div>
</body>
</html>