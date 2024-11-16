const BOOKSTORE_STATE_KEY = "BOOKSTORE_STATE";

/*window.onload = function() {
  console.log("inside cartStore.js:onload ran");
};*/

const getCart = function() {
    let cart = localStorage.getItem(BOOKSTORE_STATE_KEY);
    if(!cart){
        console.log("Creating a new cart")
        cart = JSON.stringify({items:[], totalAmount:0});
        localStorage.setItem(BOOKSTORE_STATE_KEY, cart);
    }
    return JSON.parse(cart);
}

const addProductToCart = function(product) {
    console.log("inside cartStore.js:addProductToCart ran");
    let cart = getCart();
    //console.log("TypeOf cart in addProductToCart:", typeof cart);
    let cartItem = cart.items.find(item => item.code === product.code);
    if(cartItem) {
        cartItem.quantity = parseInt(cartItem.quantity) + 1;
    } else {
        cart.items.push(Object.assign({}, product, {quantity: 1}));
    }
    //console.log("TypeOf cart in addProductToCart before setting to localStorage:", typeof cart);
    localStorage.setItem(BOOKSTORE_STATE_KEY, JSON.stringify(cart));
    updateCartItemCount();
}

function updateCartItemCount(){
    let cart = getCart();
    let count = 0;
    cart.items.forEach(item => {
        count = count + parseInt(item.quantity);
    });
    $('#cart-item-count').text('(' + count + ')');
}

const deleteCart = function() {
    localStorage.removeItem(BOOKSTORE_STATE_KEY)
    updateCartItemCount();
}

function getCartTotal() {
    console.log("inside function getCartTotal()");
    let cart = getCart();
    let totalAmount = 0;
    cart.items.forEach(item => {
        console.log("item.price: ", item.price);
        totalAmount = totalAmount + (item.price * item.quantity);
    });
    console.log("inside function getCartTotal(). totalAmount: ", totalAmount);
    totalAmount = Math.round((totalAmount + Number.EPSILON) * 100) / 100;
    console.log("inside function getCartTotal(). totalAmount(after fix): ", totalAmount);
    return totalAmount;
}

const updateProductQuantity = function(code, quantity) {
    let cart = getCart();
    if(quantity < 1) {
        cart.items = cart.items.filter(itemModel => itemModel.code !== code);
    } else {
        let cartItem = cart.items.find(itemModel => itemModel.code === code);
        if (cartItem) {
            cartItem.quantity = parseInt(quantity);
        } else {
            console.log("Product code is not already in Cart, ignoring")
        }
    }
    localStorage.setItem(BOOKSTORE_STATE_KEY, JSON.stringify(cart));
    updateCartItemCount();
}

/*const addToCart = function(product) {
    console.log("inside cartStore.js:addToCart ran");
}*/

