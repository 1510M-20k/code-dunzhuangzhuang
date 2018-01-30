angular.module('starter.service', [])
	
	.factory('toast',  function($ionicPopup){
		
		 return {
		     showAlert:function(msg){
            	 var alertPopup = $ionicPopup.alert({
				
				       template: msg
				     });
        	}
		  }

	})