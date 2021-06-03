controllers.controller('contactsCtrl', function($scope,$resource,$rootScope,$location){
        var url=$rootScope.restapi+'contacts';       
        
       
        
        $scope.getContacts = function() {
            var res= $resource(url);
            res.query( function(data) {
            $scope.contactlist = data; 
            });
        };
            
        
        $scope.reset = function() {
          $scope.contact=null;
          $scope.buttontype="save";
           $scope.getContacts();
          
          
        
      };
      
      
       if(!$rootScope.isValidUser)
              $location.path('/login');
          else
               $scope.reset();
        
       

           $scope.saveContact = function() {
            var res= $resource(url);
            var payload=$scope.contact;
            res.save(payload, function(data) {
            if(data["0"]=="1")
            {
            
             swal("Saved", "Your Contact was saved successfully", "success");
            $scope.reset();
             }
            else
            
            swal("Error", "There was and error in saving your contact", "warning");
            });
            
         }; 
       
       
       $scope.deleteContact = function(contactid) {
          
            
       var res =$resource(url+'/delete/:id',{id:'@id'});               
         
         
            swal({
                title: "Are you sure?",
                text: "Once deleted, you will not be able to recover this contact!",
                icon: "warning",
                 buttons: true, 
                })
                .then((flagDel) => {
                    if(flagDel)
                    {
                         res.delete({id:contactid}, function(data) {
                         if(data["0"]=="1")
                        {
                         swal("Deleted", "Your Contact was deleted successfully", "success");
                        $scope.reset();
                         }
                        else
                        swal("Error", "There was and error in deleting your contact", "warning");
                        });
                    } 
                });
              
               
            
             console.log("This is a message from monarch");
       };
       
        $scope.pickContact = function(contactitem) {
            $scope.buttontype="update";
            //var contactitemcopy = Object.assign({}, contactitem);  //assign doesnt work in IE
            var contactitemcopy = JSON.parse(JSON.stringify(contactitem));
            $scope.contact=contactitemcopy;   
       };
       
        $scope.updateContact = function() {
            var res =$resource(url+'/update');
            var payload=$scope.contact;
            
            res.save(payload, function(data) {
            if(data["0"]=="1")
            {
           
             swal("Updated", "Your Contact was updated successfully", "success");
            $scope.reset();
             }
            else
            
            swal("Error", "There was and error in updating your contact", "warning");
            });
       };
       
       
       $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    }

    //$scope.patternphone = /^\+?\d{2}[- ]?\d{10}$/;
    $scope.patternphone =  /^[0-9+-]+$/;
});

    