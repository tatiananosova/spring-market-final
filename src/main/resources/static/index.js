angular.module('app', []).controller('indexController', function ($scope, $http, $location) {
    const mainUri = 'http://localhost:8086';
    const contextPath = mainUri + '/api/v1';

    $scope.saveProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath + '/products', $scope.NewProduct)
            .then(function (resp){
                $scope.NewProduct = null
                $scope.fillTable();
            })
    };

    $scope.deleteProductById = function(id) {
        $http.get(contextPath + '/products/' + id + '/delete')
            .then(function (resp){
                $scope.fillTable($scope.ProductsPage.number + 1);
            })
    };

    $scope.addProductToCart = function(id) {
        $http.put(contextPath + '/cart/' + id)
            .then(function (resp){
                $scope.fillCart();
            })
    }

    $scope.fillCart = function () {
        $http.get(contextPath + '/cart/')
            .then(function (response) {
                $scope.sumCart();
                $scope.ProductsInCart = response.data;
            })
    }

    $scope.sumCart = function () {
        $http.get(contextPath + '/cart/cost')
            .then(function (response) {
                $scope.sum = response.data;
            })
    }

    $scope.fillTable = function(pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                'title': $scope.filter ? $scope.filter.title : null,
                'cost': $scope.filter ? $scope.filter.cost : null,
                'page-number': pageIndex
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;

            let minPageIndex = pageIndex - 1;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 1;
            if (maxPageIndex > $scope.ProductsPage.totalPages) {
                maxPageIndex = $scope.ProductsPage.totalPages;
            }

            $scope.ProductsArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
        });
    };

    $scope.getCategories = function () {
        $http.get(contextPath + '/categories')
            .then(function (response) {
                $scope.Categories = response.data;
            });
    };

    $scope.generatePagesIndexes = function(startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.getCurrentUser = function () {
        $http.get(contextPath + '/users/current')
            .then(function (response) {
                $scope.User = response.data;
            });
    };

    $scope.fillTable();
    $scope.getCategories();
    $scope.fillCart();
    $scope.getCurrentUser();
});