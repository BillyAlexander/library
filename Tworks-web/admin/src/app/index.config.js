(function() {
  'use strict';

  angular
    .module('adminLibrary')
    .config(config);

  /** @ngInject */
  function config($logProvider, $httpProvider, $translateProvider, toastrConfig, uibDatepickerPopupConfig, blockUIConfig) {
    /*//Error server Interceptor
    $httpProvider.defaults.withCredentials = true; //Request Cookies
    $httpProvider.interceptors.push('error_request_interceptor');*/
    
    //translate
    $translateProvider.useStaticFilesLoader({
      prefix : 'app/i18n/',
      suffix : '.json'
    });
    
    $translateProvider.preferredLanguage('es_EC');
    
    // Enable log
    $logProvider.debugEnabled(true);

    // Set options third-party lib
    toastrConfig.allowHtml = true;
    toastrConfig.timeOut = 3000;
    toastrConfig.positionClass = 'toast-top-right';
    toastrConfig.preventDuplicates = false;
    toastrConfig.progressBar = true;
    
    //https://stackoverflow.com/questions/33497362/how-to-configure-angular-ui-bootstrap-directives-globally
    uibDatepickerPopupConfig.currentText= 'Hoy';
    uibDatepickerPopupConfig.clearText= 'Limpiar';
    uibDatepickerPopupConfig.closeText= 'Cerrar';
    uibDatepickerPopupConfig.placement = 'auto bottom';
    
    blockUIConfig.templateUrl = 'app/templates/block-ui-overlay.html';
    blockUIConfig.requestFilter = function(config) {
      
      var message;
      
      switch(config.method) {
        case 'GET':
          message = 'Cargando ...';
          break;
          
        case 'POST':
          message = 'Cargando ...';
          break;
          
        case 'DELETE':
          message = 'Borrando ...';
          break;
          
        case 'PUT':
          message = 'Actualizando ...';
          break;
      }
      
      return message;
      
    };
    
    //LightboxProvider.fullScreenMode = true;
    
    // Activate WOW.js plugin for animation on scrol
    //new WOW().init();
  }

})();
