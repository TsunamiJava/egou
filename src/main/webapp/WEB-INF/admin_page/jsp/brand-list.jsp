<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="brandList" title="品牌列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/brand/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">id</th>
            <th data-options="field:'name',width:200">名字</th>
            <th data-options="field:'description',width:100">描述</th>
            <th data-options="field:'imgUrl',width:100">图片</th>
            <th data-options="field:'webSite',width:70,align:'right',formatter:TAOTAO.formatPrice">网站</th>
        </tr>
    </thead>
</table>
<div id="brandEditWindow" class="easyui-window" title="编辑品牌" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/brand-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var brandList = $("#brandList");
    	var sels = brandList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增品牌')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个品牌才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个品牌!');
        		return ;
        	}
        	
        	$("#brandEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#brandList").datagrid("getSelections")[0];
        			data.priceView = TAOTAO.formatPrice(data.price);
        			$("#brandeEditForm").form("load",data);
        			
        			// 加载品牌描述
        			$.getJSON('/rest/brand/query/brand/desc/'+data.id,function(_data){
        				if(_data.status == 200){
        					//UM.getEditor('brandeEditDescEditor').setContent(_data.data.brandDesc, false);
        					brandEditEditor.html(_data.data.brandDesc);
        				}
        			});
        			
        			//加载品牌规格
        			$.getJSON('/rest/brand/param/brand/query/'+data.id,function(_data){
        				if(_data && _data.status == 200 && _data.data && _data.data.paramData){
        					$("#brandeEditForm .params").show();
        					$("#brandeEditForm [name=brandParams]").val(_data.data.paramData);
        					$("#brandeEditForm [name=brandParamId]").val(_data.data.id);
        					
        					//回显品牌规格
        					 var paramData = JSON.parse(_data.data.paramData);
        					
        					 var html = "<ul>";
        					 for(var i in paramData){
        						 var pd = paramData[i];
        						 html+="<li><table>";
        						 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
        						 
        						 for(var j in pd.params){
        							 var ps = pd.params[j];
        							 html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
        						 }
        						 
        						 html+="</li></table>";
        					 }
        					 html+= "</ul>";
        					 $("#brandeEditForm .params td").eq(1).html(html);
        				}
        			});
        			
        			TAOTAO.init({
        				"pics" : data.image,
        				"cid" : data.cid,
        				fun:function(node){
        					TAOTAO.changebrandParam(node, "brandeEditForm");
        				}
        			});
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中品牌!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的品牌吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/brand/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除品牌成功!',undefined,function(){
            					$("#brandList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>