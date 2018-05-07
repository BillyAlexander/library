(function() {
  'use strict';

  angular
    .module('adminLibrary')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: 'app/main/main.html',
        controller: 'MainController',
        controllerAs: 'main'
      });	  
      /*.state('admin', {
        url: '/admin',
        //abstract: true,
        title: 'Admin',
        templateUrl: 'app/modules/main/views/main.html',
        controller: 'MainController',
        controllerAs: 'MainCtrl'
      })*/	  

    $urlRouterProvider.otherwise('/');
  }

})();
