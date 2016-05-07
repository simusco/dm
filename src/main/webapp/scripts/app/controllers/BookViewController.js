define(['angular'], function(angular) {    
	
	function validateParams(order){
		
		if(order.phone == null || order.phone == ''){
			alert('请填写你的联系电话');
			return false;
		}
		
		if(order.members == null || order.members == ''){
			alert('请选择吃饭人数');
			return false;
		}
		
		if(order.hot == null || order.hot == ''){
			alert('请选择味道');
			return false;
		}
		
		if(order.eat_time == null || order.eat_time == ''){
			alert('请输入到店吃饭时间');
			return false;
		}
		
		if(order.menuIds.length == 0){
			alert('忘记选择菜品了！！');
			return false;
		}
		
		if(order.menuIds.length < 6){
			if(!confirm("你的菜品比较少确认选择这些菜？")){
				return false;
			}
		}
		
		if(order.meat_weight == null || order.meat_weight == ''){
			alert('请选择荤菜重量');
			return false;
		}
		
		if(order.greens_weight == null || order.greens_weight == ''){
			alert('请选择素菜重量');
			return false;
		}
		
		return true;
	}
	
	var ctrl = ['$scope','$resource', '$state', '$location',function($scope, $resource, $state, $location){
		
		var Book = $resource('/dm/book', {}, {'update': { method:'PUT' }});
		$scope.order = {};
		
		(function(){
			Book.get({}, function(resp){
				var code = resp.code;
				var msg = resp.msg;
				var data = resp.result;
				
				var hmenuList = [];
				var smenuList = [];
				
				for(var i=0;i<data.length;i++){
					if(data[i].type == 'H'){
						hmenuList.push(data[i]);
					}else{
						smenuList.push(data[i]);
					}
				}
				
				$scope.hmenuList = hmenuList;
				$scope.smenuList = smenuList;
			});
		})();
		
		$scope.selectMenu = function(menu){
			menu.checked = menu.checked ? false : true;
		}
		
		$scope.submit = function(){
			var menuIds = [];
			for(var i=0;i<$scope.hmenuList.length;i++){
				if($scope.hmenuList[i].checked)
					menuIds.push($scope.hmenuList[i].id);
			}
			
			for(var i=0;i<$scope.smenuList.length;i++){
				if($scope.smenuList[i].checked)
					menuIds.push($scope.smenuList[i].id);
			}
			
			$scope.order.menuIds = menuIds;
			
			//check
			if(!validateParams($scope.order)){return;}
			
			//submit
			Book.save($scope.order, function(resp){
				var code = resp.code;
				var msg = resp.msg;
				var data = resp.result;
				
				if(code == '1000'){
					alert("提交订单成功");
					var money = data.meat_weight * 3.6 + data.greens_weight * 1.4;
					$state.go('success',{orderNo:data.order_no, money:money, eatTime: data.eat_time});
				}
			});
		}
	}];
	
	return ctrl;
	
});