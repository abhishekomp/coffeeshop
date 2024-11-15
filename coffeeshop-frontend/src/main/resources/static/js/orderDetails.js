document.addEventListener('alpine:init', () => {
    Alpine.data('initData', (orderNumber) => ({
        orderNumber: orderNumber,
        orderDetails: {
            items: [],
            customer: {},
            deliveryAddress: {}
        },
        init() {
            console.log("inside orderDetails.js:init() alpine function");
            //updateCartItemCount();
            this.getOrderDetails(this.orderNumber);
        },
        getOrderDetails(orderNumber) {
            console.log("inside orderDetails.js:getOrderDetails with orderNumber: ", orderNumber);
            $.getJSON("http://localhost:8082/api/orders/"+ orderNumber, (data) => {
                console.log("Get Order Response:", data);
                this.orderDetails = data;
            });
        }
    }))
}); // This is just a sample script. Paste your real code (javascript or HTML) here.