controllers.controller('loginCtrl', function($scope,$base64,$rootScope,$resource,$location){
        var url=$rootScope.restapi+'login'; 
        
        if($rootScope.isValidUser)
              $location.path('/home');
        
        $scope.login = function() {
            
            
            var auth = $base64.encode($scope.username+":"+$scope.password);
            console.log("Authorization: Basic "+auth);

            
            var res= $resource(url,{},{query: {method: 'GET',headers: { "Authorization": "Basic " + auth}}} );
            res.query(function(data) {
            //$scope.contactlist = data; 
            console.log(data);
            if(data[0]==1)
            {
               $rootScope.isValidUser=true;
               $location.path('/home');
           }
            else
            {
                swal("Error", "Please check the credentials you have entered", "warning");
                $rootScope.isValidUser=false;
            }
            });
            
        };
        
        
       
        
        });  
      