define(['angular'], function(angular) {    
	
	var ctrl = ['$scope', '$stateParams', function($scope, $stateParams){
		 $scope.orderNo = $stateParams.orderNo;
		 $scope.money = $stateParams.money;
		 $scope.eatTime = $stateParams.eatTime;
	}];
	
	return ctrl;
	
});
