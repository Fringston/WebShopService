# WebShopService API contract

---
## Article Endpoints:
### GET /webshop/articles
- Returns a list of all articles.  

### Authentication:

No authentication required.

### Request Parameters

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

Exemple: 

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

#### Authentication
No authentication required.  

#### Request Body
Accepts a JSON object with the following properties:  
- username (string): The username of the user.
- password (string): The password of the user.

Example:

```json
{
    "username": "existingUser",
    "password": "password123"
}
```
#### Responses

**200 OK**  If the user is successfully logged in, the endpoint will return HTTP status code 200, and a JSON object representing the logged in user and a JWT token.  

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

**500 Internal Server**

Error  If there is a server error while processing the request, the endpoint will return HTTP status code 500.


---

## Cart Endpoints:
### GET /webshop/cart
- Returns a list of all carts.
---
### GET /webshop/cart/{id}
- Returns a specific cart by its ID.  
---
### POST /webshop/cart/{id}
- Adds an article to a cart. Requires an AddToCartRequest object in the request body.  
---
### PATCH /webshop/cart/{cartId}/articles/{articleId}/quantity/{quantity}
- Updates the quantity of a specific article in a cart.  
---
### DELETE /webshop/cart/{cartId}/articles/{articleId}
- Removes a specific article from a cart.  

---


## History Endpoints:
### GET /webshop/history
- Returns a list of all history records.  
---
### GET /webshop/history/currentUserHistory
- Returns a list of all purchased articles for the current user.  
---
### POST /webshop/history/purchase
- Performs a purchase transaction for the current user.  

---

## User Endpoints:
### GET /webshop/user
- Returns a list of all users.

---
