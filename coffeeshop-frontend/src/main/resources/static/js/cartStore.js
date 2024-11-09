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

/*const addToCart = function(product) {
    console.log("inside cartStore.js:addToCart ran");
}*/

