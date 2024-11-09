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
                            }
                        })
                      )
                    }
                   );