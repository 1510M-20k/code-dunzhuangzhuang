// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
angular.module('starter', ['ionic', 'starter.controller'])

.run(function($ionicPlatform) {
		$ionicPlatform.ready(function() {
			if(window.cordova && window.cordova.plugins.Keyboard) {
				// Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
				// for form inputs)
				cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);

				// Don't remove this line unless you know what you are doing. It stops the viewport
				// from snapping when text inputs are focused. Ionic handles this internally for
				// a much nicer keyboard experience.
				cordova.plugins.Keyboard.disableScroll(true);
			}
			if(window.StatusBar) {
				StatusBar.styleDefault();
			}
		});
	})
	.config(function($stateProvider, $urlRouterProvider, $httpProvider, $ionicConfigProvider) {
		$ionicConfigProvider.platform.ios.tabs.style('standard');
		$ionicConfigProvider.platform.ios.tabs.position('bottom');
		$ionicConfigProvider.platform.android.tabs.style('standard');
		$ionicConfigProvider.platform.android.tabs.position('standard');

		$ionicConfigProvider.platform.ios.navBar.alignTitle('center');
		$ionicConfigProvider.platform.android.navBar.alignTitle('left');

		$ionicConfigProvider.platform.ios.backButton.previousTitleText('').icon('ion-ios-arrow-thin-left');
		$ionicConfigProvider.platform.android.backButton.previousTitleText('').icon('ion-android-arrow-back');

		$ionicConfigProvider.platform.ios.views.transition('ios');
		$ionicConfigProvider.platform.android.views.transition('android');

		$httpProvider.defaults.transformRequest = function(obj) {
			var str = [];
			for(var p in obj) {
				str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			}
			return str.join("&");
		};
		$httpProvider.defaults.headers.post = {
			'Content-Type': 'application/x-www-form-urlencoded'
		}

		$stateProvider
			.state('store', {
				url: '/store',
				templateUrl: "templates/store.html",
				controller: 'SignInCtrl'
			})
			
			.state('login', {
				url: '/login',
				templateUrl: "templates/login.html",
				controller: 'SignInCtrl'
			})
			.state('generate', {
				url: '/generate',
				templateUrl: "templates/generate.html",
				controller: 'SignInCtrl'
			})
			.state('bus_login', {
				url: '/bus_login',
				templateUrl: "templates/bus_login.html",
				controller: 'SignInCtrl'
			})
			.state('bus_revise', {
				url: '/bus_revise',
				templateUrl: "templates/bus_revise.html",
				controller: 'SignInCtrl'
			})
			.state('tabs', {
				url: '/tabs',
				templateUrl: "templates/tabs.html",
				controller: 'SignInCtrl'
			})
			.state('template', {
				url: '/template',
				templateUrl: "templates/template.html",
				
			})
            
		.state('tabs.home', {
				url: '/home',
				views: {
					'home-tab': {
						templateUrl: 'templates/home.html'
					}

				}
			})
			.state('tabs.order', {
				url: '/order',
				views: {
					'order-tab': {
						templateUrl: 'templates/order.html'
					}

				}
			})
			.state('tabs.product', {
				url: '/product',
				views: {
					'product-tab': {
						templateUrl: 'templates/product.html'
					}

				}
			})
			.state('tabs.stores', {
				url: '/stores',
				views: {
					'stores-tab': {
						templateUrl: 'templates/stores.html'
					}

				}
			})
			.state('tabs.check', {
				url: '/check',
				views: {
					'home-tab': {
						templateUrl: 'templates/check.html'
					}
				}
			})
			.state('tabs.user_management', {
				url: '/user_management',
				views: {
					'home-tab': {
						templateUrl: 'templates/user_management.html'
					}
				}
			})
			.state('tabs.sendmessage', {
				url: '/sendmessage',
				views: {
					'home-tab': {
						templateUrl: 'templates/sendmessage.html'
					}
				}
			})
			.state('tabs.distribution', {
				url: '/distribution',
				views: {
					'home-tab': {
						templateUrl: 'templates/distribution.html'
					}
				}
			})
			.state('tabs.cost_list', {
				url: '/cost_list',
				views: {
					'home-tab': {
						templateUrl: 'templates/cost_list.html'
					}
				}
			})
			.state('tabs.store_settings', {
				url: '/store_settings',
				views: {
					'home-tab': {
						templateUrl: 'templates/store_settings.html'
					}
				}
			})
			.state('tabs.coupon', {
				url: '/coupon',
				views: {
					'home-tab': {
						templateUrl: 'templates/coupon.html'
					}
				}
			})
			.state('tabs.account', {
				url: '/account',
				views: {
					'home-tab': {
						templateUrl: 'templates/account.html'
					}
				}
			})
			.state('tabs.grade', {
				url: '/grade',
				views: {
					'home-tab': {
						templateUrl: 'templates/grade.html'
					}
				}
			})

		.state('tabs.details', {
				url: '/details',
				views: {
					'order-tab': {
						templateUrl: "templates/details.html"
					}
				}
			})
			.state('tabs.logistics', {
				url: '/logistics',
				views: {
					'order-tab': {
						templateUrl: "templates/logistics.html",
						controller: 'SignInCtrl'
					}
				}
			})
			.state('tabs.address', {
				url: '/address',
				views: {
					'order-tab': {
						templateUrl: "templates/address.html",
						controller: 'SignInCtrl'
					}
				}
			})
			.state('tabs.courier', {
				url: '/courier',
				views: {
					'order-tab': {
						templateUrl: "templates/courier.html",
						controller: 'SignInCtrl'
					}
				}
			})
			.state('tabs.productadd', {
				url: '/productadd',
				views: {
					'product-tab': {
						templateUrl: "templates/product_add.html",
						controller: 'SignInCtrl'
					}
				}
			})
			.state('tabs.productmanagement', {
				url: '/productmanagement',
				views: {
					'product-tab': {
						templateUrl: "templates/product_management.html",
						controller: 'SignInCtrl'
					}
				}
			})
			.state('tabs.productclassadd', {
				url: '/productclassadd',
				views: {
					'product-tab': {
						templateUrl: "templates/product_classadd.html",
						controller: 'SignInCtrl'
					}
				}
			})
			.state('tabs.couponadd', {
				url: '/couponadd',
				views: {
					'home-tab': {
						templateUrl: "templates/coupon_add.html",
						controller: 'SignInCtrl'
					}
				}
			})
			.state('tabs.gradeadd', {
				url: '/gradeadd',
				views: {
					'home-tab': {
						templateUrl: "templates/grade_add.html",
						controller: 'SignInCtrl'
					}
				}
			})
            .state('tabs.authentication', {
				url: '/authentication',
				views: {
					'home-tab': {
						templateUrl: "templates/account_authentication.html",
						controller: 'SignInCtrl'
					}
				}
			})
             .state('tabs.take', {
				url: '/take',
				views: {
					'home-tab': {
						templateUrl: "templates/account_take.html",
						controller: 'SignInCtrl'
					}
				}
			})
             .state('tabs.record', {
				url: '/record',
				views: {
					'home-tab': {
						templateUrl: "templates/account_record.html",
						controller: 'SignInCtrl'
					}
				}
			})
            /* .state('tabs.check', {
				url: '/check',
				views: {
					'home-tab': {
						templateUrl: "templates/check.html",
						controller: 'SignInCtrl'
					}
				}
			})*/
              .state('tabs.account_settings', {
				url: '/account_settings',
				views: {
					'home-tab': {
						templateUrl: "templates/account_settings.html",
					
					}
				}
			})
              .state('tabs.advertisement', {
				url: '/advertisement',
				views: {
					'home-tab': {
						templateUrl: "templates/advertisement.html",
					
					}
				}
			}) 
			 .state('tabs.ad_add', {
				url: '/ad_add',
				views: {
					'home-tab': {
						templateUrl: "templates/ad_add.html",
					    controller: 'SignInCtrl'
					}
				}
			}) 
			 .state('tabs.change_password', {
				url: '/change_password',
				views: {
					'home-tab': {
						templateUrl: "templates/change_password.html",
					    controller: 'SignInCtrl'
					}
				}
			}) 
			 .state('tabs.sendannouncement', {
				url: '/sendannouncement',
				views: {
					'home-tab': {
						templateUrl: "templates/sendannouncement.html",
					    controller: 'SignInCtrl'
					}
				}
			}) 
			 .state('tabs.reservation', {
				url: '/reservation',
				views: {
					'home-tab': {
						templateUrl: "templates/reservation.html",
					    controller: 'SignInCtrl'
					}
				}
			}) 
		$urlRouterProvider.otherwise('/store');

	})