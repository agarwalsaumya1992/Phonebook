var app=angular.module('app',['controllers','ngResource','ngRoute']);
var controllers=angular.module('controllers',['angularUtils.directives.dirPagination','base64']);

app.config(['$routeProvider',
    function($routeProvider) {   
        $routeProvider.
           
        when('/home', {
            templateUrl: 'PRTL_contacts.html'
      
        }).
        when('/help', {
            templateUrl: 'PRTL_help.html'
     , controller: 'contactsCtrl'
        }).
        when('/login', {
            templateUrl: 'PRTL_login.html'
        }).
        otherwise({
            redirectTo: '/login'
        });
    }]);

app.run(function($rootScope,$location){
$rootScope.restapi='http://localhost:8084/PhoneBook/api/';    
$location.path("/login");
$rootScope.isValidUser=false;
 $rootScope.logout = function() {
            $rootScope.isValidUser=false;
        };
});