define([
        'angular',
        '../controllers/BookViewController',
        '../controllers/ConsoleViewController',
        '../controllers/SuccessViewController'
        ], function(
		angular, 
		BookViewController,
		ConsoleViewController,
		SuccessViewController
        ) {
	
	var module = angular.module('BookModule',['ui.router','ngResource']);
	module.config(function($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.when("", "/book");
		
		$stateProvider.state('book', {
	      url: "/book",
	      templateUrl: "book.html"
	    }).state('success', {
	      url: "/success?orderNo&money&eatTime",
	      templateUrl: "success.html"
	    }).state('console', {
	      url: "/console",
	      templateUrl: "console.html"
	    });
	});
	module.controller('BookViewController', BookViewController);
	module.controller('ConsoleViewController', ConsoleViewController);
	module.controller('SuccessViewController', SuccessViewController);
	
	return module;
});