controllers.controller('loginCtrl', function($scope,$base64,$rootScope,$resource,$location){
        var url=$rootScope.restapi; 
        
        if($rootScope.isValidUser)
              $location.path('/home');
        
        $scope.loginUser = function() {
            
  

            
            var res= $resource(url+'login');
            var payload=$scope.logins;
            
            
            payload.pass=$base64.encode($scope.logins.pass);
            console.log("payload:"+JSON.stringify(payload));
            res.save(payload,function(data) {
             
            console.log(data);
            
            
            if(data["statusCode"]=="1")
            {
               $rootScope.isValidUser=true;
               $location.path('/home');
               $rootScope.lid=data["loginId"];
           }
            else
            {
                $scope.loginerror=data["statusMsg"];
//                swal("Error", data["statusMsg"], "warning");
                $rootScope.isValidUser=false;
            }
            });
            
        };
        
         $scope.registerUser = function() {
             
             
            
            
            var res= $resource(url+'login/register');
            var payload=$scope.register;
            payload.pass=$base64.encode($scope.register.pass);
            console.log("payload:"+JSON.stringify(payload));
            res.save(payload, function(data) {
                console.log(data);
            if(data["0"]=="1")
            {
            
             swal("Saved", "User created Successfully. Login with your credentials now", "success");
            $scope.reset();
             }
            else
            $scope.registererror="There was and error in saving your contact";
//            swal("Error", "There was and error in saving your contact", "warning");
            });
            
         }; 
        
    
        
        });  
      