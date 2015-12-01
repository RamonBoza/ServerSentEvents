(function () {
  'use strict';

  angular
    .module('angular')
    .controller('MainController', MainController);

  /** @ngInject */
  function MainController($scope) {

    // the last received msg
    $scope.msg = {};

    var handleCallback = function (msg) {
      $scope.$apply(function () {
        $scope.msg = JSON.parse(msg.data);
      });
    }

    var source = new EventSource('http://localhost:12000/stats');
    source.addEventListener('message',handleCallback,false);

  }
})();
