<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="brandAddForm" class="brandForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>品牌名称:</td>
	            <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>品牌图片:</td>
	            <td>
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" name="imgUrl"/>
	            </td>
	        </tr>
	        <tr>
	            <td>品牌描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="description"></textarea>
	            </td>
	        </tr>
	       <tr>
	            <td>品牌链接地址:</td>
	            <td><input class="easyui-textbox" type="text" name="webSite" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	    </table>
	    <input type="hidden" name="brandParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var brandAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		brandAddEditor = KindEditor.create("#brandAddForm [name=description]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			TAOTAO.changebrandParam(node, "brandAddForm");
		}});
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#brandAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//ajax的post方式提交表单
		//$("#brandAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("/brand/save",$("#brandAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增品牌成功!');
			}else{
				$.messager.alert('提示','新增品牌失败!');
			}
		});
	}
	
	function clearForm(){
		$('#brandAddForm').form('reset');
		brandAddEditor.html('');
	}
</script>
