angular.module('starter.controller', ['starter.service'])
	.controller('SignInCtrl', function($scope, $state, $http,$ionicPopup,$rootScope) {

        $scope.showConfirm = function() {
             var confirmPopup = $ionicPopup.confirm({
               title: 'Consume Ice Cream',
               template: 'Are you sure you want to eat this ice cream?'
             });
             confirmPopup.then(function(res) {
               if(res) {
                 console.log('You are sure');
               } else {
                 console.log('You are not sure');
               }
             });
           };
        
		$scope.login = function() {
			$rootScope.storename=$scope.storename;
			$state.go('login');
		}
		$scope.generate = function() {
			alert($scope.username+"==="+$rootScope.storename);
			$http({
		        method: 'post',
		        url: 'user/createStore.action',
		        data:{username:$scope.username,storename:$scope.storename}
		    }).then(function successCallback(response) {
		           alert(response.data.success);
		           $state.go('generate');
		        }, function errorCallback(response) {
		            // 请求失败执行代码
		    });
		}
		$scope.bus_login = function() {

			$state.go('bus_login');
		}
		$scope.bus_revise = function() {

			$state.go('bus_revise');
		}
		$scope.tabs = function() {

			$state.go('tabs.home');
		}
		$scope.logistics = function() {

			$state.go('tabs.logistics');
		}
		$scope.address = function() {

			$state.go('tabs.address');
		}
		$scope.courier = function() {

			$state.go('tabs.courier');
		}
		$scope.productadd = function() {

			$state.go('tabs.productadd');
		}
		$scope.productmanagement = function() {

			$state.go('tabs.productmanagement');
		}
		$scope.productclassadd = function() {

			$state.go('tabs.productclassadd');
		}
		$scope.couponadd = function() {

			$state.go('tabs.couponadd');
		}
		$scope.gradeadd = function() {

			$state.go('tabs.gradeadd');
		}
		$scope.sendmessage = function() {

			$state.go('tabs.sendmessage');
		}
		$scope.cost_list = function() {

			$state.go('tabs.cost_list');
		}
		$scope.authentication = function() {

			$state.go('tabs.authentication');
		} 
		$scope.take = function() {

			$state.go('tabs.take');
		} 
		$scope.record = function() {

			$state.go('tabs.record');
		} 
		$scope.ad_add = function() {

			$state.go('tabs.ad_add');
		} 

			
	})