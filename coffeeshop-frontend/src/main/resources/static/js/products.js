document.addEventListener('alpine:init', () => {
    Alpine.data('initData', (pageNo) => ({
            count: 0,
            pageNo: pageNo,
            products:   {
                data: []
            },
            init() {
                this.count = 25;
                console.log("Page No:", this.pageNo);
                this.loadProducts(this.pageNo);
            },
            loadProducts(pageNo) {
               console.log("inside products.js:loadProducts with pageNo", pageNo);
               $.getJSON("http://localhost:8081/api/coffeeShop?page="+pageNo, (resp)=> {
                    console.log("Products Resp:", resp);
                    this.products = resp;
               });
            },
            addToCart(product) {
                console.log("inside products.js:addToCart ran");
                addProductToCart(product);
            }
        }))
});