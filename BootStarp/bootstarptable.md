列参数
- value :
- row : 这一条json数据,可以按key值拿取
- index : 一个数字,表示是当前显示表格的第几行
```javascript
...
{
  title:"操作",
  formatter:function(value,row,index){
    return "<a id="update" value="">更新</a>|<a id="update" value="">删除</a>";
  },
  events:etevents
}.
...

window.etevents = {
  'click #update':function(event,value,row,index){
    alert(row.name);
    $.post("stu","id=row.id",function(msg){

    },"json");
  },
  'click #update':function(event,value,row,index) {
    //event是当前事件
  }
}
```

**这里的ROW,$.post()查到的数据都是在row里面, ==无论显示与否!!!==**,这是福利!!!
例如.rowid可以得到值
```javascript
var table="";
    	function queryData(){
    		table1=$("#tb").bootstrapTable({
    			url:"stu",
    			pagination:true,
    			sidePagination:"server",
    			pageSize:5,
    			pageList:[3,4,6],
    			queryParamsType:"undefined",//limit{offset limit} undefined:{pageNumber pageSize}
    			queryParams:function(msg){

    				var newParams = {
    					method:"querySome",
    					pageNumber:msg.pageNumber,
    					pageSize:msg.pageSize,
    					name:$("#stuname").val(),
    					schid:$("#schid").val()
    				};
    				console.log(newParams);
    				return newParams;
    			},
    			columns:[      
    			 	{
    			 		field:"name",//是json的key值
    			 		title:"名字"
    			 	},
    			 	{
    			 		field:"age",
    			 		title:"年龄"
    			 	},
    			 	{
    			 		field:"email",
    			 		title:"邮箱"
    			 	},
    			 	{
    			 		field:"birth",
    			 		title:"出生日期"
    			 	},
    			 	{

    			 		title:"操作",
    			 		formatter:function(value,row,index){
    			 			return "<a id='update' >更新</a> |"
    			 			+" <a id='update' >删除</a>";
    			 		},
    			 		events:etevents
    			 	}
    			 ]
    		});
    	}

    window.etevents={
    	'click #update':function(event,value,row,index){
    		 alert("要更新的数据是:"+row.id);
    		/*  $.post("stu","method=queryStuById&id="+row.id,function(msg){
    			 //给模态框中的属性赋值
    			//显示模态框

    		 },"json"); */
    		 $("#myModal").modal("show");
    	}

    }
```

> newParams最终传递的值是类似于一个`XX?key=value&key=value`的形式
