# WebShopService API contract

--- 

## Article Endpoints
### GET /webshop/articles
- Returns a list of all articles.  

### GET /webshop/articles/{id}
- Returns a specific article by its ID.  

### POST /webshop/articles
- Adds a new article. Requires an Article object in the request body.  

### PATCH /webshop/articles/{id}
- Updates a specific article by its ID. Requires an Article object in the request body.  

### DELETE /webshop/articles/{id}
- Deletes a specific article by its ID. 



---

## Auth Endpoints

### POST /webshop/auth/register
- Registers a new user. Requires a RegistrationPayload object in the request body.  

### POST /webshop/auth/login
- Logs in a user. Requires a RegistrationPayload object in the request body.  


---

## Cart Endpoints
### GET /webshop/cart
- Returns a list of all carts.  

### GET /webshop/cart/{id}
- Returns a specific cart by its ID.  

### POST /webshop/cart/{id}
- Adds an article to a cart. Requires an AddToCartRequest object in the request body.  

### PATCH /webshop/cart/{cartId}/articles/{articleId}/quantity/{quantity}
- Updates the quantity of a specific article in a cart.  

### DELETE /webshop/cart/{cartId}/articles/{articleId}
- Removes a specific article from a cart.  

---


## History Endpoints

### GET /webshop/history
- Returns a list of all history records.  

### GET /webshop/history/currentUserHistory
- Returns a list of all purchased articles for the current user.  

### POST /webshop/history/purchase
- Performs a purchase transaction for the current user.  

---

## User Endpoints

### GET /webshop/user
- Returns a list of all users.

---
