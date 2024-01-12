# WebShopService API contract

---
## Article Endpoints:
### GET /webshop/articles
- Returns a list of all articles.  

### Authentication:

No authentication required.

### Request Parameters:

No request parameters required.

### Responses:

**200 OK**

If the request is successful, the endpoint will return HTTP status code 200, and a JSON array of objects representing all articles.

Example: 

```json
[
    {
        "id": 1,
        "name": "Banana",
        "cost": 10,
        "description": "A yellow fruit"
    },
    {
        "id": 2,
        "name": "Apple",
        "cost": 15,
        "description": "A red fruit"
    }
]
```

**401 Unauthorized**

If the user is not authenticated, the endpoint will return HTTP status code 401.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500

---
### GET /webshop/articles/{id}
- Returns a specific article by its ID.  

### Authentication:

No authentication required.

### Request Parameters:

- id (integer): The ID of the article to be returned.

### Responses:

**200 OK**

If the request is successful and the article with the specified ID exists, the endpoint will return HTTP status code 200, and a JSON object representing the article.  
Example:

```json
{
    "id": 1,
    "name": "Banana",
    "cost": 10,
    "description": "A yellow fruit"
}
```

**401 Unauthorized**

If the user is not authenticated, the endpoint will return HTTP status code 401.  

**404 Not Found**

If the article with the specified ID does not exist, the endpoint will return HTTP status code 404.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500

---
### POST /webshop/articles

- Creates a new article.

### Authentication:

Requires admin role.

### Request Body:

Accepts a JSON object with the following properties:

- `name` (string): The name of the article.
- `cost` (integer): The cost of the article.
- `description` (string): The description of the article.

Example:

```json
{
    "name": "Banana",
    "cost": 10,
    "description": "A yellow fruit"
}
```
### Responses:

**201 Created**

If the article is successfully created, the endpoint will return HTTP status code 201, and a JSON object representing the new article.

Example: 

```json
{
    "id": 1,
    "name": "Banana",
    "cost": 10,
    "description": "A yellow fruit"
}
```
**400 Bad Request**

If the request body is not valid, the endpoint will return HTTP status code 400.  

**401 Unauthorized**

If the user is not authenticated or does not have the admin role, the endpoint will return HTTP status code 401

---

### PATCH /webshop/articles/{id}
- Updates a specific article by its ID.

### Authentication:
Requires admin role.  

### Request Parameters:
id (integer): The ID of the article to be updated.

### Request Body:
Accepts a JSON object with the following properties: 

- `name` (string, optional): The new name of the article.
- `cost` (integer, optional): The new cost of the article.
- `description` (string, optional): The new description of the article.

Example:

```json
{
    "name": "Banana",
    "cost": 10,
    "description": "A yellow fruit"
}
```

### Responses:

**200 OK**

If the request is successful and the article with the specified ID exists and is updated, the endpoint will return HTTP status code 200, and a JSON object representing the updated article.  

Example:

```json
{
"id": 1,
"name": "Orange",
"cost": 15,
"description": "A juicy fruit"
}
```

**400 Bad Request**

If the request body is not valid, the endpoint will return HTTP status code 400.  

**401 Unauthorized**

If the user is not authenticated or does not have the admin role, the endpoint will return HTTP status code 401.  

**404 Not Found**

If the article with the specified ID does not exist, the endpoint will return HTTP status code 404.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500.

---
### DELETE /webshop/articles/{id}
- Deletes a specific article by its ID. 

### Authentication:
Requires admin role.  

### Request Parameters:
id (integer): The ID of the article to be deleted.

### Responses:

**200 OK**

If the request is successful and the article with the specified ID is deleted, the endpoint will return HTTP status code 200, and a message indicating the deletion was successful.  

**401 Unauthorized**

If the user is not authenticated or does not have the admin role, the endpoint will return HTTP status code 401.  

**404 Not Found**

If the article with the specified ID does not exist, the endpoint will return HTTP status code 404.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500

---

## Auth Endpoints:

### POST /webshop/auth/register
- Registers a new user. 

#### Authentication:
No authentication required.  

#### Request Body:
Accepts a JSON object with the following properties:  

- `username` (string): The username of the user.
- `password` (string): The password of the user.

Example:

```json
{
    "username": "newUser",
    "password": "password123"
}
```
#### Responses:
**200 OK**

If the user is successfully registered, the endpoint will return HTTP status code 200, and a JSON object representing the new user.  

Example:

```json
{
"id": 1,
"username": "newUser",
"password": "password123"
}
```

**400 Bad Request**

If the request body is not valid, or the username already exists, the endpoint will return HTTP status code 400.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500

---
### POST /webshop/auth/login
- Logs in a user.

#### Authentication:
No authentication required.  

#### Request Body:
Accepts a JSON object with the following properties:  
- `username` (string): The username of the user.
- `password` (string): The password of the user.

Example:

```json
{
    "username": "existingUser",
    "password": "password123"
}
```
#### Responses:

**200 OK**  

If the user is successfully logged in, the endpoint will return HTTP status code 200, and a JSON object representing the logged-in user and a JWT token.  

Example:

```json
{
  "user": {
    "id": 1,
    "username": "existingUser",
    "password": "password123"
  },
  "jwt": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}
```

**400 Bad Request**

If the request body is not valid, or the username does not exist, or the password is incorrect, the endpoint will return HTTP status code 400.  

**500 Internal Server Error**  

If there is a server error while processing the request, the endpoint will return HTTP status code 500.


---

## Cart Endpoints:
### GET /webshop/cart
- Returns a list of all carts.

### Authentication:
Requires user role.  

### Request Parameters:
No request parameters required.  

### Responses:

**200 OK**  

If the request is successful, the endpoint will return HTTP status code 200, and a JSON array of objects representing all shopping carts.  

Example:

```json
[
  {
    "id": 1, 
    "user": {
      "id": 1, 
      "username": "user1"
    }, 
    "cartItems": [
      {
        "id": 1, 
        "article": {
          "id": 1, 
          "name": "Banana", 
          "cost": 10, 
          "description": "A yellow fruit"
        }, 
        "quantity": 2
      }
    ], 
    "totalCost": 20
  }, 
  {
    "id": 2,
    "user": {
      "id": 2,
      "username": "user2"
    },
    "cartItems": [],
    "totalCost": 0
  }
]
```

**401 Unauthorized**

If the user is not authenticated or does not have the user role, the endpoint will return HTTP status code 401.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500

---
### GET /webshop/cart/{id}
- Returns a specific cart by its ID.  

### Authentication:
Requires user role.  

### Request Parameters:
- `id` (integer): The ID of the shopping cart to be returned.

### Responses:

**200 OK**  

If the request is successful and the shopping cart with the specified ID exists, the endpoint will return HTTP status code 200, and a JSON object representing the shopping cart.  

Example:

```json
{
  "id": 1,
  "user": {
    "id": 1,
    "username": "user1"
  },
  "cartItems": [
    {
      "id": 1,
      "article": {
        "id": 1,
        "name": "Banana",
        "cost": 10,
        "description": "A yellow fruit"
      },
      "quantity": 2
    }
  ],
  "totalCost": 20
}
```

**401 Unauthorized**

If the user is not authenticated or does not have the user role, the endpoint will return HTTP status code 401.  404 Not Found  If the shopping cart with the specified ID does not exist, the endpoint will return HTTP status code 404.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500.

---
### POST /webshop/cart/{id}
- Adds an article to a cart. Requires an AddToCartRequest object in the request body.

### Authentication:
Requires user role.  

### Request Parameters:
- `id` (integer): The ID of the shopping cart where the article will be added.

### Request Body:
Accepts a JSON object with the following properties:  
- `articleId` (integer): The ID of the article to be added.
- `quantity` (integer): The quantity of the article to be added.

Example:

```json
{
  "articleId": 1,
  "quantity": 2
}
```
### Responses:

**200 OK**  

If the request is successful and the article is added to the shopping cart, the endpoint will return HTTP status code 200, and a JSON object representing the updated shopping cart.  

Example:

```json
{
  "id": 1,
  "user": {
    "id": 1,
    "username": "user1"
  },
  "cartItems": [
    {
      "id": 1,
      "article": {
        "id": 1,
        "name": "Banana",
        "cost": 10,
        "description": "A yellow fruit"
      },
      "quantity": 2
    }
  ],
  "totalCost": 20
}
```

**400 Bad Request**

If the request body is not valid, the endpoint will return HTTP status code 400. 

**401 Unauthorized**

If the user is not authenticated or does not have the user role, the endpoint will return HTTP status code 401. 

**404 Not Found**

If the shopping cart with the specified ID does not exist, the endpoint will return HTTP status code 404.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500


---
### PATCH /webshop/cart/{cartId}/articles/{articleId}/quantity/{quantity}
- Updates the quantity of a specific article in a cart.  

### Authentication:
Requires user role.

### Request Parameters:
- `cartId` (integer): The ID of the shopping cart where the article will be updated.
- `articleId` (integer): The ID of the article to be updated.
- `quantity` (integer): The new quantity of the article.

### Responses:

**200 OK**

If the request is successful and the quantity of the article in the shopping cart is updated, the endpoint will return HTTP status code 200, and a JSON object representing the updated shopping cart.  

Example:

```json
{
  "id": 1,
  "user": {
    "id": 1,
    "username": "user1"
  },
  "cartItems": [
    {
      "id": 1,
      "article": {
        "id": 1,
        "name": "Banana",
        "cost": 10,
        "description": "A yellow fruit"
      },
      "quantity": 3
    }
  ],
  "totalCost": 30
}
```

**400 Bad Request**

If the request body is not valid, the endpoint will return HTTP status code 400.  

**401 Unauthorized**

If the user is not authenticated or does not have the user role, the endpoint will return HTTP status code 401.  

**404 Not Found**

If the shopping cart with the specified ID does not exist, or the article with the specified ID does not exist in the cart, the endpoint will return HTTP status code 404.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500

---
### DELETE /webshop/cart/{cartId}/articles/{articleId}
- Removes a specific article from a cart.

### Authentication:
Requires user role.

### Request Parameters:
- `cartId` (integer): The ID of the shopping cart where the article will be removed.
- `articleId` (integer): The ID of the article to be removed.

### Responses:

**200 OK**

If the request is successful and the article is removed from the shopping cart, the endpoint will return HTTP status code 200, and a JSON object representing the updated shopping cart.

Example:

```json
{
  "id": 1,
  "user": {
    "id": 1,
    "username": "user1"
  },
  "cartItems": [],
  "totalCost": 0
}
```

**400 Bad Request**

If the request body is not valid, the endpoint will return HTTP status code 400.  

**401 Unauthorized**

If the user is not authenticated or does not have the user role, the endpoint will return HTTP status code 401.  

**404 Not Found**

If the shopping cart with the specified ID does not exist, or the article with the specified ID does not exist in the cart, the endpoint will return HTTP status code 404.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500



---


## History Endpoints:
### GET /webshop/history
- Returns a list of all history records.  

### Authentication:
Requires admin role.

### Request Parameters:
No request parameters required.

### Responses:

**200 OK**

If the request is successful, the endpoint will return HTTP status code 200, and a JSON array of objects representing all purchase history records.  

Example:

```json
[
  {
    "id": 1,
    "user": {
      "id": 1,
      "username": "user1"
    },
    "purchasedArticles": [
      {
        "id": 1,
        "name": "Banana",
        "cost": 10,
        "description": "A yellow fruit"
      }
    ],
    "totalCost": 10
  },
  {
    "id": 2,
    "user": {
      "id": 2,
      "username": "user2"
    },
    "purchasedArticles": [],
    "totalCost": 0
  }
]
```

**401 Unauthorized**

If the user is not authenticated or does not have the user role, the endpoint will return HTTP status code 401.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500


---
### GET /webshop/history/currentUserHistory
- Returns a list of all purchased articles for the current user.

### Authentication:
Requires user role.

### Request Parameters:
No request parameters required.

### Responses:

**200 OK**

Example:

```json
[
  {
    "id": 1,
    "user": {
      "id": 1,
      "username": "user1"
    },
    "purchasedArticles": [
      {
        "id": 1,
        "name": "Banana",
        "cost": 10,
        "description": "A yellow fruit"
      }
    ],
    "totalCost": 10
  },
  {
    "id": 2,
    "user": {
      "id": 1,
      "username": "user1"
    },
    "purchasedArticles": [],
    "totalCost": 0
  }
]
```

**401 Unauthorized**

If the user is not authenticated or does not have the user role, the endpoint will return HTTP status code 401.

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500



---
### POST /webshop/history/purchase
- Performs a purchase transaction for the current user.  

### Authentication:
Requires user role.

### Request Parameters:
No request parameters required.

### Request Body:
No request body required.

### Responses:

**200 OK**

If the request is successful and the purchase transaction is completed, the endpoint will return HTTP status code 200, and a message indicating the purchase was successful.  

**400 Bad Request**

If the user's cart is empty, the endpoint will return HTTP status code 400.

**401 Unauthorized**

If the user is not authenticated or does not have the user role, the endpoint will return HTTP status code 401.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500.  


---

## User Endpoints:
### GET /webshop/user
- Returns a list of all users.

### Authentication:
Requires admin role.

### Request Parameters:
No request parameters required.

### Responses:

**200 OK**

If the request is successful, the endpoint will return HTTP status code 200, and a JSON array of objects representing all users.

Example:

```json
[
  {
    "id": 1,
    "username": "user1",
    "cart": {
      "id": 1,
      "cartItems": [
        {
          "id": 1,
          "article": {
            "id": 1,
            "name": "Banana",
            "cost": 10,
            "description": "A yellow fruit"
          },
          "quantity": 2
        }
      ],
      "totalCost": 20
    }
  },
  {
    "id": 2,
    "username": "user2",
    "cart": {
      "id": 2,
      "cartItems": [],
      "totalCost": 0
    }
  }
]
```

**401 Unauthorized**

If the user is not authenticated or does not have the admin role, the endpoint will return HTTP status code 401.  

**500 Internal Server Error**

If there is a server error while processing the request, the endpoint will return HTTP status code 500

---
