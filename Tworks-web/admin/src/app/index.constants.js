/* global malarkey:false, moment:false */
(function() {
  'use strict';
  
  //var origin = window.location.origin;
  //var port = 8090;
  
  //console.log(origin,port);
  
  var Domain = '';
  var Host = '';  
  var Uploads = '';  
  var DomainPublic = '';  

  if (location.host === 'localhost:3000') {
    Domain = "http://admin.portafolio.levelaptesting.com/";
    Host = "http://admin.portafolio.levelaptesting.com:8090/portafolio-ws/";
    Uploads = "http://admin.portafolio.levelaptesting.com/uploads/";
    DomainPublic = "http://portafolio.levelaptesting.com/";
  }


  
  angular
    .module('adminLibrary')
    .constant('malarkey', malarkey)
    .constant('Host', Host)
    .constant('DomainPublic', DomainPublic)
    .constant('Uploads', Uploads)	
    .constant('Domain', Domain)	
    .constant('moment', moment);

})();
