(function() {
  'use strict';

  angular
    .module('adminLibrary')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }

})();
