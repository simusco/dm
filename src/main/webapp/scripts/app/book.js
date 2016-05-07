requirejs.config({
	paths: {
		angular: '../venders/angular.min',
		uiRouter: '../venders/angular-ui-router',
		angularResource: '../venders/angular-resource'
    },
    shim: {
        'angular': {
            exports: 'angular'
        },
        'uiRouter': {
        	deps: ['angular'],
            exports: 'uiRouter'
        },
        'angularResource': {
        	deps: ['angular'],
            exports: 'angularResource'
        }
    }
});

require( [
          'angular',
          'uiRouter',
          'angularResource',
          'modules/BookModule'
          ], function(angular) {
	
	angular.bootstrap(document, ["BookModule"])
	
});