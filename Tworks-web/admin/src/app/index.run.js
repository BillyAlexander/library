(function() {
  'use strict';

  angular
    .module('adminLibrary')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log, $rootScope, $state, Domain, Uploads) {

    $log.debug('runBlock end');

    $rootScope.general_variables = {
      current_year: new Date().getFullYear(),
      copyright: " Portafolio © " + new Date().getFullYear(),
      uploads: Uploads
    };
    
    $rootScope.messages = {
      empty_records: 'No existen registros',
      check_your_zip_code: 'Consulta tu código postal'
    };
    
    $rootScope.placeholder = {
      address1: 'Calle principal E11-09',
      address2: 'Calle secundaria',
      address3: 'Edificio, casa o referencia'
    };
    
    $rootScope.state = $state;	
  }

})();
