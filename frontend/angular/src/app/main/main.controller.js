(function () {
  'use strict';

  angular
    .module('angular')
    .controller('MainController', MainController);

  /** @ngInject */
  function MainController($scope, $log) {

    // the last received msg
    $scope.msg = {};

    function handleCallback(msg) {
      $scope.$apply(function () {
        $log.info(msg);
        $scope.msg = JSON.parse(msg.data);
      });
    }

    function errorCallback(msg) {
      $log.error(msg);
    }

    function openCallback(msg) {
      $log.info(msg);
    }

    var source = new EventSource("http://localhost:12000/stats");
    source.addEventListener("message", handleCallback);
    source.addEventListener("error", errorCallback);
    source.addEventListener("open", openCallback);

  }
})();
