<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>egou商城_用户中心</title>
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
				<h2 class="h2 h2_r2"><em title="个人资料">个人资料</em></h2>
				<form id="jvForm" action="profile.do" method="post">
					<input type="hidden" name="returnUrl" value="${returnUrl}"/>
					<input type="hidden" name="processUrl" value="${processUrl}"/>
					<ul class="uls form">
					<li id="errorName" class="errorTip" style="display:none">${error}</li>
					<li>
						<label for="username">用 户 名：</label>
						<span class="word">stone</span>
					</li>
					<li>
						<label for="username">邮　　箱：</label>
						<span class="word">2853888@qq.com</span>
					</li>
					<li>
						<label for="realName">真实姓名：</label>
						<span class="bg_text"><input type="text" id="realName" name="realName" maxLength="32" value="stone"/></span>
						<span class="pos"><span class="tip okTip">&nbsp;</span></span>
					</li>
					<li>
						<label for="gender">性　　别：</label>
						<span class="word"><input type="radio" name="gender" checked="checked"/>保密<input type="radio" name="gender" />男<input type="radio" name="gender" />女</span>
					</li>
					<li>
						<label for="residence">居 住 地：</label>
						<span class="word">
							<select name="province"  id="province" onchange="changeProvince(this.value)">
								<option value="" selected>省/直辖市</option>
								<option value=""></option>
							</select>
							<select name="" id="city">
								<option value="" selected>城市</option>
								<option value=""></option>
							</select>
							<select name="">
								<option value="" selected>县/区</option>
								<option value=""></option>
							</select>
						</span>
					</li>
					<li><label for="address">详细地址：</label>
						<span class="bg_text"><input type="text" id="address" name="address" maxLength="32" value="广州市天河区"/></span>
						<span class="pos"><span class="tip errorTip">用户名为4-20位字母、数字或中文组成，字母区分大小写。</span></span>
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