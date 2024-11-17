document.addEventListener('alpine:init', () => {
    Alpine.data('initData', (pageNo) => ({
        pageNo: pageNo,
        orders: {
            data: []
        },
        init() {
            console.log("inside orders.js:init() alpine function");
            this.getOrders(this.pageNo);
        },
        getOrders(pageNo) {
            console.log("inside orders.js:getOrders with pageNo: ", pageNo);
            $.getJSON("http://localhost:8082/api/orders?page="+pageNo, (data) => {
                console.log("Get Order(s) response:", data);
                for (let i = 0; i < data.length; i++) {
                  // Runs 5 times, with values of step 0 through 4.
                  console.log("order created on: ", data[i].createdAt);
                }
                this.orders = data;
            });
        }
    }))
});