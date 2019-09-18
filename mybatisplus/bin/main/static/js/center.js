//$(function() {
//	var timestamp = new Date().getTime();
//	$.ajax({
//		url : "/permission/allTreeList",
//		contentType : "application/json",
//		data : JSON.stringify({
//			timestamp : timestamp
//		}),
//		dataType : "JSON",
//		type : "post",
//		success : function(data) {
//			if (data.data) {
//				initTree(data.data);
//			}
//		}
//	});
//
//});
function initTree(data) {
	$('#mytree').treeview({
		data : data,// 数据源参数
		selectable : true,
		expandIcon : "glyphicon glyphicon-plus",
		collapseIcon : "glyphicon glyphicon-minus",
		emptyIcon : "glyphicon",
		nodeIcon : "glyphicon glyphicon-plus",
		selectedIcon : "glyphicon glyphicon-plus",
		checkedIcon : "glyphicon glyphicon-check",
		uncheckedIcon : "glyphicon glyphicon-unchecked",
		enableLinks : false,
		levels : 0,
		onNodeSelected : function(event, node) {
			$("#userList").show();
			$("#resourceList").hide();
			$("#roleList").hide();
			initDataTables();
			console.log(event, node);
		},
		onNodeUnselected : function(event, node) {
			$("#userList").hide();
		}
	});
}
function itemOnclick(target) {
	// 找到当前节点id
	var nodeid = $(target).attr('data-nodeid');
	var tree = $('#mytree');
	// 获取当前节点对象
	var node = tree.treeview('getNode', nodeid);
	if (node.state.expanded) {
		// 处于展开状态则折叠
		tree.treeview('collapseNode', node.nodeId);
	} else {
		// 展开
		tree.treeview('expandNode', node.nodeId);
	}
}
$(document).ready(function(){
	var timestamp = new Date().getTime();
	$.ajax({
		url : "/permission/allTreeList",
		contentType : "application/json",
		data : JSON.stringify({
			timestamp : timestamp
		}),
		dataType : "JSON",
		type : "post",
		success : function(data) {
			if (data.data) {
				var trs = "<ul>";
				$.each(data.data,function(n,value) {
			 
				 trs += "<li id='"+value.id+"'><h2 class='obtain'>" +value.text+"<i></i></h2>"
				 if(value.nodes){
					 trs += "<div class='secondary'>";
					 $.each(value.nodes,function(n1,value1) {
						 trs += "<h3 id='"+value1.href+"'>"+value1.text+"</h3>";
					 });
					 trs += "</div>";
				 }
				 trs += "</li>";
				 });
				trs += "</ul>";
				$(".navBox").append(trs);
				inits();
			}
		}
	});
});
function inits() {
	var flag = true;
	var liC = document.querySelectorAll(".navBox li h2");
	for (var i = 0; i < liC.length; i++) {
		liC[i].onclick = function() {
			if (flag) {
				flag = false;
				setTimeout(function() {
					flag = true;
				}, 500)
				if (this.className === "obFocus") {
					this.querySelector("i").classList.remove("arrowRot");
					getNext(this).style.height = "0";
					this.classList.add("obtain");
					this.classList.remove("obFocus");
					return
				}
				var sec = getNext(this);
				var sib = siblings(sec.parentNode);
				var otherArr = [];
				var arrowClass = [];
				for (var j = 0; j < sib.length; j++) {
					var sibSec = sib[j].getElementsByTagName('*');
					for (var i = 0; i < sibSec.length; i++) {
						if (sibSec[i].className == "secondary") {
							otherArr.push(sibSec[i])
						}
						if (sibSec[i].className == "arrowRot") {
							arrowClass.push(sibSec[i])
						}
						if (sibSec[i].className == "obFocus") {
							sibSec[i].classList.remove("obFocus");
							sibSec[i].classList.add("obtain");
						}
					}
				}
				for (var i = 0; i < otherArr.length; i++) {
					otherArr[i].style.height = "0";
				}
				if (arrowClass[0]) {
					arrowClass[0].classList.remove("arrowRot");
				}
				var windowW = window.screen.availWidth
				var childNum = sec.querySelectorAll("h3").length;
				if (windowW >= 1000) {
					sec.style.height = (0.45 * childNum) + "rem";
				} else {
					var childHei = sec.querySelector("h3").clientHeight;
					sec.style.height = (childHei * childNum) + "px";
				}
				this.getElementsByTagName("i")[0].classList.add("arrowRot");
				this.classList.remove("obtain");
				this.classList.add("obFocus");
			}
		}
	}
	var seconC = document.querySelectorAll(".secondary h3")
	for (var i = 0; i < seconC.length; i++) {
		seconC[i].onclick = function() {
			for (var i = 0; i < seconC.length; i++) {
				seconC[i].classList.remove("seconFocus");
			}
			this.classList.add("seconFocus");
			showRight($(".seconFocus").attr("id"));// +""+$(".seconFocus").html());
		}
	}
	var obscure = document.querySelector(".navH span");
	var open = document.querySelector("#open");
	var ensconce = document.querySelector("#ensconce");
	obscure.onclick = function() {
		open.style.marginLeft = "-300px";
		setTimeout(function() {
			ensconce.style.display = "block";
		}, 450)// 350)
	}
	var showC = document.querySelector("#ensconce h2");
	showC.onclick = function() {
		open.style.marginLeft = "0px";
		setTimeout(function() {
			ensconce.style.display = "none";
		}, 100)
	}
}
function getByClass(clsName, parent) {
	var oParent = parent ? document.getElementById(parent) : document, boxArr = new Array(), oElements = oParent
			.getElementsByTagName('*');
	for (var i = 0; i < oElements.length; i++) {
		if (oElements[i].className == clsName) {
			boxArr.push(oElements[i]);
		}
	}
	return boxArr;
}
function getNext(node) {
	if (!node.nextSibling)
		return null;
	var nextNode = node.nextSibling;
	if (nextNode.nodeType == 1) {
		return nextNode;
	}
	return getNext(node.nextSibling);
}
function siblings(elem) {
	var r = [];
	var n = elem.parentNode.firstChild;
	for (; n; n = n.nextSibling) {
		if (n.nodeType === 1 && n !== elem) {
			r.push(n);
		}
	}
	return r;
}

function showRight(node){
	console.log(node);
	if(node === "country"){
		showCountry();
	}else if(node === "province"){
		showProvince();
	}else if(node === "city"){
		showCity();
	}else if(node === "district"){
		showDistrict();
	}else if(node === "countryside"){
		showCountryside();
	}else if(node === "village"){
		showVillage();
	}else if(node === "user"){
		showWorkMember();
	}else if(node === "role"){
		showWorkMember();
	}else if(node === "menus"){
		showWorkMember();
	}
}

function showCountry(){
	$("#countryDiv").show();
	var timestamp = new Date().getTime();
	$("#buttons").attr("data-target","#countryModal");
	$('#table').bootstrapTable('destroy');
	$("#table").bootstrapTable({
				type : "get",
				url : "/base/basic/country/page",
				queryParamsType: "",
				queryParams : function (params) {
                    var temp = {
                    	currentPage : params.pageNumber,
    					pageSize : params.pageSize
                    };
                    return temp;
                },
                pagination: true,
                height: 500,
                singleSelect: true,
                onlyInfoPagination: false,
                smartDisplay: true,
                searchOnEnterKey: true,
                showHeader: true,
                showFooter: true,
		        paginationPreText: '上一页',
		        paginationNextText: '下一页',
		        paginationSuccessivelySize: 5,
				striped : true,
				pageSize: 10,
				pageNumber: 1,
				pageList: [5,10,20,50],
				sidePagination : 'server',
				showRefresh: false,
				clickToSelect: true,
				responseHandler:function (res) {
					console.log(res.data.total);
					console.log(res.data.records);
		            if(res.data.records){
		            	return {
		            	 "total": res.data.total,
		                 "rows": res.data.records
		            	}
		            } else {
		                 return {
		                     "rows" : [],
		                     "total" : 0
		                 };
		             };
		         },
				columns: [{
                    checkbox: true,
                    width: 20,
                    height:35
                },{
					field: 'countryName',
					title: '国家名称',
					width: 120,
					height:35
				}, {
					field: 'countryNumber',
					title: '国家编号',
					width: 120,
					height:35
				}, {
					field: 'abbreviation',
					title: '英文',
					width: 120,
					height:35
				}, {
					field: 'location',
					title: '地理位置',
					width: 120,
					height:35
				}, {
					field: 'phoneCode',
					title: '电话区号',
					width: 120,
					height:35
				}, {
				}, {
					field: 'remake',
					title: '备注',
					width: 120,
					height:35
				}, {
					title : '操作',
					field : 'id',
					width: 180,
					height:35,
					formatter : operation,// 对资源进行操作
					events:{
						 'click #delete': function (e, value, row, index) {
		                     $("#deleteCountryModal").modal();
		                 },
		                 'click #detail': function (e, value, row, index) {
		                     $("#countryModal").modal();
		                 },
		                 'click #edit': function (e, value, row, index) {
		                     $("#deleteCountryModal").modal();
		                 }
					}
				}],
				onLoadSuccess: function () {
					/* showTips("数据加载成功！"); */
                },
                onLoadError: function () {
                    showTips("数据加载失败！");
                },
                onDblClickRow: function (row, $element) {
                    var id = row.id;
                    console.log(id);
                    $("#countryModal").modal();
                },
			});
	
	
	$("#countryForm").validate({
		errorElement : 'span',
        errorClass : 'help-block',
	    rules: {
	      countryName: {
	        required: true,
	        minlength: 2,
	        maxlength: 30,
	        remote: {
	            url: "/base/basic/country/validator",     //后台处理程序
	            type: "post",               //数据发送方式
	            dataType: "json",           //接受数据格式   
	            data: {                     //要传递的数据
	            	countryName: function() {
	                    return $("#countryName").val();
	                }
	            }
	        }
	      }
	    },
	    messages: {
	      countryName: {
	        required: "请输入国家名",
	        minlength: "国家名必需由两位以上中文组成",
	        maxlength: "国家名不得超过30位"
	      }
	    },
	  //自定义错误消息放到哪里
        errorPlacement : function(error, element) {
            element.next().remove();//删除显示图标
            element.after('<span class="glyphicon glyphicon-remove form-control-feedback" style="color:red;" aria-hidden="true"></span>');
            element.closest('.form-group').append(error);//显示错误消息提示
        },
        //给未通过验证的元素进行处理
        highlight : function(element) {
            $(element).closest('.form-group').addClass('has-error has-feedback');
        },
        //验证通过的处理
        success : function(label) {
            var el=label.closest('.form-group').find("input");
            el.next().remove();//与errorPlacement相似
            el.after('<span class="glyphicon glyphicon-ok form-control-feedback" style="color:#00EE00;" aria-hidden="true"></span>');
            label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
            label.remove();
        },
		});
	$.validator.addMethod("countryName",function(value,element,params){
		var countryName = /^[\u4e00-\u9fa5]+$/;
		return this.optional(element)||(countryName.test(value));
	},"*请输入中文！");
}

function showProvince(){
	$("#countryDiv").show();
	$("#buttons").attr("data-target","#provinceModal");
    $('#provinceModal').on('show.bs.modal', function (event) {
    	initCountrySelect();
     })
	$("#table").bootstrapTable('destroy');
	var timestamp = new Date().getTime();
	$("#table").bootstrapTable({
				type : "get",
				url : "/base/basic/province/page",
				queryParamsType: "",
				queryParams : function (params) {
                    var temp = {
                    	currentPage : params.pageNumber,
    					pageSize : params.pageSize
                    };
                    return temp;
                },
                pagination: true,
                height: 500,
                singleSelect: true,
                onlyInfoPagination: false,
                smartDisplay: true,
                searchOnEnterKey: true,
                showHeader: true,
                showFooter: true,
		        paginationPreText: '上一页',
		        paginationNextText: '下一页',
		        paginationSuccessivelySize: 5,
				striped : true,
				pageSize: 10,
				pageNumber: 1,
				pageList: [5,10,20,50],
				sidePagination : 'server',
				showRefresh: false,
				clickToSelect: true,
				responseHandler:function (res) {
					console.log(res.data.total);
					console.log(res.data.records);
		            if(res.data.records){
		            	return {
		            	 "total": res.data.total,
		                 "rows": res.data.records
		            	}
		            } else {
		                 return {
		                     "rows" : [],
		                     "total" : 0
		                 };
		             };
		         },
				columns: [{
                    checkbox: true,
                    width: 20,
                    height:35
                },{
					field: 'provinceName',
					title: '名称',
					width: 120,
					height:35
				}, {
					field: 'provinceNumber',
					title: '编号',
					width: 120,
					height:35
				}, {
					field: 'provinceType',
					title: '类型',
					width: 120,
					height:35
				}, {
					title : '操作',
					field : 'id',
					width: 180,
					height:35,
					formatter : operation,// 对资源进行操作
					events:{
						 'click #delete': function (e, value, row, index) {
		                     $("#provinceModal").modal();
		                 },
		                 'click #detail': function (e, value, row, index) {
		                     $("#provinceModal").modal();
		                 },
		                 'click #edit': function (e, value, row, index) {
		                     $("#provinceModal").modal();
		                 }
					}
				}],
				onLoadSuccess: function () {
                },
                onLoadError: function () {
                    showTips("数据加载失败！");
                },
                onDblClickRow: function (row, $element) {
                    var id = row.ID;
                     $("#myModal").modal();
                },
			});
}

function showCity(){
	$("#countryDiv").show();
	$('#table').bootstrapTable('destroy');
	var timestamp = new Date().getTime();
	$("#table").bootstrapTable({
				type : "get",
				url : "/base/basic/city/page",
				queryParamsType: "",
				queryParams : function (params) {
                    var temp = {
                    	currentPage : params.pageNumber,
    					pageSize : params.pageSize
                    };
                    return temp;
                },
                pagination: true,
                height: 500,
                singleSelect: true,
                onlyInfoPagination: false,
                smartDisplay: true,
                searchOnEnterKey: true,
                showHeader: true,
                showFooter: true,
		        paginationPreText: '上一页',
		        paginationNextText: '下一页',
		        paginationSuccessivelySize: 5,
				striped : true,
				pageSize: 10,
				pageNumber: 1,
				pageList: [5,10,20,50],
				sidePagination : 'server',
				showRefresh: false,
				clickToSelect: true,
				responseHandler:function (res) {
					console.log(res.data.total);
					console.log(res.data.records);
		            if(res.data.records){
		            	return {
		            	 "total": res.data.total,
		                 "rows": res.data.records
		            	}
		            } else {
		                 return {
		                     "rows" : [],
		                     "total" : 0
		                 };
		             };
		         },
				columns: [{
                    checkbox: true,
                    width: 20,
                    height:35
                },{
					field: 'cityName',
					title: '名称',
					width: 120,
					height:35
				}, {
					field: 'cityNumber',
					title: '编号',
					width: 120,
					height:35
				}, {
					field: 'cityType',
					title: '类型',
					width: 120,
					height:35
				}, {
					title : '操作',
					field : 'id',
					width: 180,
					height:35,
					formatter : operation,// 对资源进行操作
					events:{
						 'click #delete': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 },
		                 'click #detail': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 },
		                 'click #edit': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 }
					}
				}],
				onLoadSuccess: function () {
                },
                onLoadError: function () {
                    showTips("数据加载失败！");
                },
                onDblClickRow: function (row, $element) {
                    var id = row.ID;
                     $("#myModal").modal();
                },
			});
}

function showDistrict(){
	$("#countryDiv").show();
	$('#table').bootstrapTable('destroy');
	var timestamp = new Date().getTime();
	$("#table").bootstrapTable({
				type : "get",
				url : "/base/basic/district/page",
				queryParamsType: "",
				queryParams : function (params) {
                    var temp = {
                    	currentPage : params.pageNumber,
    					pageSize : params.pageSize
                    };
                    return temp;
                },
                pagination: true,
                height: 500,
                singleSelect: true,
                onlyInfoPagination: false,
                smartDisplay: true,
                searchOnEnterKey: true,
                showHeader: true,
                showFooter: true,
		        paginationPreText: '上一页',
		        paginationNextText: '下一页',
		        paginationSuccessivelySize: 5,
				striped : true,
				pageSize: 10,
				pageNumber: 1,
				pageList: [5,10,20,50],
				sidePagination : 'server',
				showRefresh: false,
				clickToSelect: true,
				responseHandler:function (res) {
					console.log(res.data.total);
					console.log(res.data.records);
		            if(res.data.records){
		            	return {
		            	 "total": res.data.total,
		                 "rows": res.data.records
		            	}
		            } else {
		                 return {
		                     "rows" : [],
		                     "total" : 0
		                 };
		             };
		         },
				columns: [{
                    checkbox: true,
                    width: 20,
                    height:35
                },{
					field: 'districtName',
					title: '名称',
					width: 120,
					height:35
				}, {
					field: 'districtNumber',
					title: '编号',
					width: 120,
					height:35
				}, {
					field: 'districtType',
					title: '类型',
					width: 120,
					height:35
				}, {
					title : '操作',
					field : 'id',
					width: 180,
					height:35,
					formatter : operation,// 对资源进行操作
					events:{
						 'click #delete': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 },
		                 'click #detail': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 },
		                 'click #edit': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 }
					}
				}],
				onLoadSuccess: function () {
                },
                onLoadError: function () {
                    showTips("数据加载失败！");
                },
                onDblClickRow: function (row, $element) {
                    var id = row.ID;
                     $("#myModal").modal();
                },
			});
}

function showCountryside(){
	$("#countryDiv").show();
	$('#table').bootstrapTable('destroy');
	var timestamp = new Date().getTime();
	$("#table").bootstrapTable({
				type : "get",
				url : "/base/basic/countryside/page",
				queryParamsType: "",
				queryParams : function (params) {
                    var temp = {
                    	currentPage : params.pageNumber,
    					pageSize : params.pageSize
                    };
                    return temp;
                },
                pagination: true,
                height: 500,
                singleSelect: true,
                onlyInfoPagination: false,
                smartDisplay: true,
                searchOnEnterKey: true,
                showHeader: true,
                showFooter: true,
		        paginationPreText: '上一页',
		        paginationNextText: '下一页',
		        paginationSuccessivelySize: 5,
				striped : true,
				pageSize: 10,
				pageNumber: 1,
				pageList: [5,10,20,50],
				sidePagination : 'server',
				showRefresh: false,
				clickToSelect: true,
				responseHandler:function (res) {
					console.log(res.data.total);
					console.log(res.data.records);
		            if(res.data.records){
		            	return {
		            	 "total": res.data.total,
		                 "rows": res.data.records
		            	}
		            } else {
		                 return {
		                     "rows" : [],
		                     "total" : 0
		                 };
		             };
		         },
				columns: [{
                    checkbox: true,
                    width: 20,
                    height:35
                },{
					field: 'countrysideName',
					title: '名称',
					width: 120,
					height:35
				}, {
					field: 'countrysideNumber',
					title: '编号',
					width: 120,
					height:35
				}, {
					field: 'countrysideType',
					title: '类型',
					width: 120,
					height:35
				}, {
					title : '操作',
					field : 'id',
					width: 180,
					height:35,
					formatter : operation,// 对资源进行操作
					events:{
						 'click #delete': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 },
		                 'click #detail': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 },
		                 'click #edit': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 }
					}
				}],
				onLoadSuccess: function () {
                },
                onLoadError: function () {
                    showTips("数据加载失败！");
                },
                onDblClickRow: function (row, $element) {
                    var id = row.ID;
                    $("#myModal").modal();
                },
			});
}

function showVillage(){
	$("#countryDiv").show();
	$('#table').bootstrapTable('destroy');
	var timestamp = new Date().getTime();
	$("#table").bootstrapTable({
				type : "get",
				url : "/base/basic/village/page",
				queryParamsType: "",
				queryParams : function (params) {
                    var temp = {
                    	currentPage : params.pageNumber,
    					pageSize : params.pageSize
                    };
                    return temp;
                },
                pagination: true,
                height: 500,
                singleSelect: true,
                onlyInfoPagination: false,
                smartDisplay: true,
                searchOnEnterKey: true,
                showHeader: true,
                showFooter: true,
		        paginationPreText: '上一页',
		        paginationNextText: '下一页',
		        paginationSuccessivelySize: 5,
				striped : true,
				pageSize: 10,
				pageNumber: 1,
				pageList: [5,10,20,50],
				sidePagination : 'server',
				showRefresh: false,
				clickToSelect: true,
				responseHandler:function (res) {
					console.log(res.data.total);
					console.log(res.data.records);
		            if(res.data.records){
		            	return {
		            	 "total": res.data.total,
		                 "rows": res.data.records
		            	}
		            } else {
		                 return {
		                     "rows" : [],
		                     "total" : 0
		                 };
		             };
		         },
				columns: [{
                    checkbox: true,
                    width: 20,
                    height:35
                },{
					field: 'villageName',
					title: '名称',
					width: 120,
					height:35
				}, {
					field: 'villageNumber',
					title: '编号',
					width: 120,
					height:35
				}, {
					field: 'villageType',
					title: '类型',
					width: 120,
					height:35
				}, {
					title : '操作',
					field : 'id',
					width: 180,
					height:35,
					formatter : operation,// 对资源进行操作
					events:{
						 'click #delete': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 },
		                 'click #detail': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 },
		                 'click #edit': function (e, value, row, index) {
		                     $("#myModal").modal();
		                 }
					}
				}],
				onLoadSuccess: function () {
                },
                onLoadError: function () {
                    showTips("数据加载失败！");
                },
                onDblClickRow: function (row, $element) {
                    var id = row.ID;
                    $("#myModal").modal();
                },
			});
}

// 删除、编辑操作
function operation(value, row, index) {
	var id = value;
    var result = "";
    result += "<a id='detail' href='#' style='margin: 0 30px 0 0;color:#1acbfc;' title='查看'><span class='glyphicon glyphicon-eye-open'></span></a>";
    result += "<a id='edit' href='#' style='margin: 0 30px 0 0;color:blue;' title='编辑'><span class='glyphicon glyphicon-wrench'></span></a>";
    result += "<a id='delete' href='#' style='margin: 0 30px 0 0;color:red;' title='删除'><span class='glyphicon glyphicon-trash'></span></a>";

    return result;
}

function projectDetail(projectId){
	console.log(projectId);
}

function taskDetail(taskId){
	console.log(taskId);
}
function createMember(){
	
}

function registCountry(){
		$.ajax({
			type : "POST",
		    url:'/base/basic/country/regist',
		    data:$('#countryForm').serialize(),
			dataType : "json",
		    cache:false,// false是不缓存，true为缓存
		    async:true,// true为异步，false为同步
		    beforeSend:function(){
		        // 请求前
		    },
		    success:function(result){
		        if(result.code=="100000"){
					$("#countryModal").modal("hide");
					$('<div>').appendTo('body').addClass('alert alert-success').html(result.message).show().delay(1500).fadeOut();
					$("table").bootstrapTable('refresh');
		        }
		    },
		    complete:function(){
		        // 请求结束时
		    },
		    error:function(){
		        // 请求失败时
		    }
		});
		return false;
}

function registProvince(){
	$.ajax({
		type : "POST",
	    url:'/base/basic/province/regist',
	    data:$('#provinceForm').serialize(),
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
				$("#provinceModal").modal("hide");
				$('<div>').appendTo('body').addClass('alert alert-success').html(result.message).show().delay(1500).fadeOut();
				$("table").bootstrapTable('refresh');
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
	return false;
}

function registCity(){
	$.ajax({
		type : "POST",
	    url:'/base/basic/city/regist',
	    data:$('#cityForm').serialize(),
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
				$("#cityModal").modal("hide");
				$('<div>').appendTo('body').addClass('alert alert-success').html(result.message).show().delay(1500).fadeOut();
				$("table").bootstrapTable('refresh');
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
	return false;
}

function registDistrict(){
	$.ajax({
		type : "POST",
	    url:'/base/basic/district/regist',
	    data:$('#districtForm').serialize(),
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
				$("#districtModal").modal("hide");
				$('<div>').appendTo('body').addClass('alert alert-success').html(result.message).show().delay(1500).fadeOut();
				$("table").bootstrapTable('refresh');
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
	return false;
}

function registCountryside(){
	$.ajax({
		type : "POST",
	    url:'/base/basic/countryside/regist',
	    data:$('#countrysideForm').serialize(),
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
				$("#countrysideModal").modal("hide");
				$('<div>').appendTo('body').addClass('alert alert-success').html(result.message).show().delay(1500).fadeOut();
				$("table").bootstrapTable('refresh');
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
	return false;
}

function registVillage(){
	$.ajax({
		type : "POST",
	    url:'/base/basic/village/regist',
	    data:$('#villageForm').serialize(),
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
				$("#villageModal").modal("hide");
				$('<div>').appendTo('body').addClass('alert alert-success').html(result.message).show().delay(1500).fadeOut();
				$("table").bootstrapTable('refresh');
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
	return false;
}

function initCountrySelect(){
	$.ajax({
		type : "GET",
	    url:'/base/basic/country/select',
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
	        	if (result.data) {
					$.each(result.data,function (index, item) {
						$("#countryId").append("<option value='"+item.id+"'>"+item.countryName+"</option>")
						if(index == 0){
							$("#countryId").val(item.id);
						}
					});
				}
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
}

function initProvinceSelect(){
	$.ajax({
		type : "GET",
	    url:'/base/basic/province/select',
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
	        	if (result.data) {
					$.each(result.data,function (index, item) {
						$("#provinceId").append("<option value='"+item.id+"'>"+item.countryName+"</option>")
						if(index == 0){
							$("#provinceId").val(item.id);
						}
					});
				}
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
}
function initCitySelect(){
	$.ajax({
		type : "GET",
	    url:'/base/basic/city/select',
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
	        	if (result.data) {
					$.each(result.data,function (index, item) {
						$("#cityId").append("<option value='"+item.id+"'>"+item.countryName+"</option>")
						if(index == 0){
							$("#cityId").val(item.id);
						}
					});
				}
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
}
function initCountrysideSelect(){
	$.ajax({
		type : "GET",
	    url:'/base/basic/countryside/select',
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
	        	if (result.data) {
					$.each(result.data,function (index, item) {
						$("#countrysideId").append("<option value='"+item.id+"'>"+item.countryName+"</option>")
						if(index == 0){
							$("#countrysideId").val(item.id);
						}
					});
				}
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
}

function initDistrictSelect(){
	$.ajax({
		type : "GET",
	    url:'/base/basic/district/select',
		dataType : "json",
	    cache:false,// false是不缓存，true为缓存
	    async:true,// true为异步，false为同步
	    beforeSend:function(){
	        // 请求前
	    },
	    success:function(result){
	        if(result.code=="100000"){
	        	if (result.data) {
					$.each(result.data,function (index, item) {
						$("#districtId").append("<option value='"+item.id+"'>"+item.countryName+"</option>")
						if(index == 0){
							$("#districtId").val(item.id);
						}
					});
				}
	        }
	    },
	    complete:function(){
	        // 请求结束时
	    },
	    error:function(){
	        // 请求失败时
	    }
	});
}



function showTips(message){
	$('<div>').appendTo('body').addClass('alert alert-success').html(message).show().delay(1500).fadeOut();
}