document.addEventListener('alpine:init', () => {
            Alpine.data('initData', () => ({
                            cart: {
                                items: [],
                                totalAmount: 0
                            },
                            orderForm: {
                                customer: {
                                    name: "John",
                                    email: "john.doe@mail.com",
                                    phone: "9999999999"
                                },
                                deliveryAddress: {
                                    addressLine1: "Vast Metro",
                                    addressLine2: "Harold Street",
                                    city: "Oregon",
                                    state: "TS",
                                    zipCode: "41656",
                                    country: "US"
                                }
                            },
                            init() {
                                console.log("cart.js:init() alpine function");
                                updateCartItemCount();
                                this.loadCart();
                                console.log("cart.js:init() updating totalAmount value");
                                this.cart.totalAmount = getCartTotal();
                            },
                            loadCart() {
                                this.cart = getCart();
                            },
                            removeCart() {
                                deleteCart();
                            },
                            updateItemQuantity(code, quantity) {
                                updateProductQuantity(code, quantity);
                                this.loadCart();
                                this.cart.totalAmount = getCartTotal();
                            },
                            createOrder() {
                                let order = Object.assign({}, this.orderForm, {items : this.cart.items});
                                console.log("Order ", order);
                                $.ajax ({
                                                url: 'http://localhost:8082/api/orders',
                                                type: "POST",
                                                dataType: "json",
                                                contentType: "application/json",
                                                data : JSON.stringify(order),
                                                success: (resp) => {
                                                    //console.log("Order Resp:", resp)
                                                    this.removeCart();
                                                    //alert("Order placed successfully")
                                                    console.log("Order created and existing card cleared");
                                                    window.location = "/orders/"+resp.orderNumber;
                                                }, error: (err) => {
                                                    console.log("Order Creation Error:", err)
                                                    alert("Order creation failed")
                                                }
                                            });
                            }
                        })
                      )
                    }
                   );