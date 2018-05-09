var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(){
    	alert("inside refresh cart");
       $http.get('/music/rest/cart/' + $scope.cartId).success(function (data){
    	   alert(JSON.stringify(data));
           $scope.cart = data;
       });
    };

    $scope.clearCart = function(){
        $http.delete('/music/rest/cart/' + $scope.cartId).success($scope.refresahCart());
    };

    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId){
    	alert("inside add to cart");
        $http.post('/music/rest/cart/add/' + productId).success(function (){
            alert('Product successfully added to the cart!');
        });
    };

    $scope.removeFromCart = function(productId){
        $http.post('/music/rest/cart/remove/' + productId).success(function(data){
           $scope.refreshCart();
        });
    };

    var grandTotal = 0;
    $scope.calGrandTotal = function(){
       

        for (var i = 0; i < $scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});