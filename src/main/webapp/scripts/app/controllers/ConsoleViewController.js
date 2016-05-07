define(['angular'], function(angular) {    
	
	function loadOrder(BookConsole, $scope){
		BookConsole.get({}, function(resp){
			var code = resp.code;
			var msg = resp.msg;
			var data = resp.result;
			
			$scope.orders = data;
			
			var audio = document.getElementById('order_audio');
			var flag = false;
			
			for(var i=0;i<data.length;i++){
				if(data[i].processed != 'Y'){
					audio.play();
					flag = true;
					break;
				}
			}
			
			if(!flag){
				audio.pause();
			}
		});
	}
	
	var ctrl = ['$scope','$resource', '$state', '$interval',function($scope, $resource, $state, $interval){
		
		var BookConsole = $resource('/dm/book/console', {}, {'update': { method:'PUT' }});
		
		(function(){
			loadOrder(BookConsole, $scope);
			
			//定时加载
			$interval(function(){
				loadOrder(BookConsole, $scope);
			}, 1000 * 10);
		})();
		
		$scope.toggle = function(id){
			var ele = document.getElementById(id);
			var clazz = ele.getAttribute('class');
			
			if(clazz.indexOf(' collapse') == -1){
				clazz = 'panel-collapse collapse';
			}else{
				clazz = 'panel-collapse';
			}
			
			ele.setAttribute('class', clazz);
		}
		
		$scope.make = function(id){
			$resource('/dm/book/make/'+id, {}, {'update': { method:'PUT' }}).save({}, function(resp){
				var code = resp.code;
				var msg = resp.msg;
				var data = resp.result;
				
				if(code == '1000'){
					alert('订单开始制作了！');
					
					var os = $scope.orders;
					for(var i=0;i<os.length;i++){
						if(os[i].id == id){
							os[i].processed = 'Y';
						}
					}
				}
			});
		}
	}];
	
	return ctrl;
	
});