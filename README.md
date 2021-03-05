- [Introduction](#introduction)
- [Requirement](#requirement)
- [Notes](#notes)
- [Expectations](#expectations)
- [Problem Statement](#problem-statement)
- [Project Setup](#project-setup)
- [API Example](#api-example)
  - [Create a new Listing](#create-a-new-listing)
  - [Show All Listings](#show-all-listings)
  - [Show Listing](#show-listing)
  - [Update A Listing](#update-a-listing)
  - [Delete A Listing](#delete-a-listing)
  - [Add Special price to Listing](#add-special-price-to-listing)
  - [Delete a Special price](#delete-a-special-price)
  - [Calculate Reservation Cost](#calculate-reservation-cost)

## Introduction

As a software engineer, you have to provide a reliable **backend** system to clients.
Your task here is to implement few endpoints `list/show/create` for a small **Airbnb** like rest api.

## Requirement

1. We value a **clean**, **simple** working solution.
2. The solution must be production ready.
3. Good understanding of project architecture and design patterns.
4. Good understanding of **REST API's**.

## Notes

- The Source code must be pushed in the provided project repository.
- (Optional) Deploy as a public api to your own host.

## Expectations

- This challenge should take around 4 to 6 hours to complete.
- Your code should be modular, each module should focus on doing one thing and do it well.
- Avoid over-engineering.

## Problem Statement

_For reference only._

![Diagram](assets/uml.png)

Following this diagram we want to implement a small api service that our frontend users can consume.
this restfull api should give us the ability to create new listings "homes" and assign them special prices for
weekends and holidays. it must also allow our clients to calculate a checkout cost for any listing.

1. Must be a **RESTful** HTTP API
2. Must implement 4 endpoints with path, method, request and response body as specified

   - One **CRUD** endpoint to `list/show/create/delete` a listing [see sample](#create-a-new-listing)
   - One endpoint to `add` a special price to a listing [see sample](#add-special-price-to-listing)
   - One endpoint to `delete` a special price [see sample](#create-a-new-listing)
   - One endpoint to `get` the checkout cost for any given listing [see sample](#calculate-reservation-cost)
     - Checkout cost can be calculated on any given listing.
     - An error response should be sent if a user tries to select a past date as checkin or checkout.
     - `checkin` date should be always before `checkout` date.
     - `clients` can not book a `listing` for more then **28** days.
     - `total` = total_nights - discount + cleaning_fee [see sample](#calculate-reservation-cost)
     - `discount` [see sample](#calculate-reservation-cost):
        - if checkout lenght >= 7 -> discount = base_price * #days * (1 - weekly_discount)
        - if checkout lenght >= 30 -> discount = base_price * #days * (1 - monthly_discount)

3. A Database must be used (in memory database or Docker Compose with database + backend).
4. All responses should be in a **JSON** format no matter in success or failure situations.
5. Create a db script to automatically import demo data during the server starting up

## Project Setup

- You should provide the project skelton, included `routes`,`models`,`migration`,`controllers`,`tests`.
- You should provide instrucctions on how to run the tests and the app.

## API Example

### Create a new Listing

- Method: `POST`
- URL path: `/api/listings`
- Request body:

  ```json
  {
    "name": "Black Raven",
    "description": "Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed.",
    "adults": 3,
    "children": 2,
    "is_pets_allowed": true,
    "base_price": 195.62,
    "cleaning_fee": 95.82,
    "image_url": "http://dummyimage.com/126x173.bmp/cc0000/ffffff",
    "weekly_discount": 0.77,
    "monthly_discount": 0.61
  }
  ```

- Response:

  Header: `HTTP 200`
  Body:

  ```json
  {
    "id": "d290f1ee-6c54-4b01-90e6-d701748f0851",
    "owner_id": "d701748f-6c54-4b01-90e6-d701748f0822",
    "name": "Black Raven",
    "slug": "black-raven",
    "description": "Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed.",
    "adults": 3,
    "children": 2,
    "is_pets_allowed": true,
    "base_price": 195.62,
    "cleaning_fee": 95.82,
    "image_url": "http://dummyimage.com/126x173.bmp/cc0000/ffffff",
    "weekly_discount": 0.77,
    "monthly_discount": 0.61,
    "special_prices": []
  }
  ```

- Tips:

  If you find this **json** format strange to you, read about json api specs
  [link to jsonapi.org!](https://jsonapi.org).

**[⬆ back to top](#introduction)**

### Show All Listings

- Method: `GET`
- URL path: `/api/listings`

- Response:

  Header: `HTTP 200`
  Body:

  ```json
  [
    {
      "id": "28eed9aa-c27d-4217-ab21-ad65ead3a2aa",
      "owner_id": "59f6d752-97cf-414e-a794-42794ac7511a",
      "name": "Warner",
      "slug": "revolutionize-warner",
      "description": "Maecenas ut massa quis augue luctus tincidunt.",
      "adults": 10,
      "children": 2,
      "is_pets_allowed": true,
      "base_price": 95.38,
      "cleaning_fee": 4.33,
      "image_url": "http://dummyimage.com/241x240.jpg/ff4444/ffffff",
      "weekly_discount": 0.13,
      "monthly_discount": 0.23,
      "special_prices": []
    },
    {
      "id": "b3a6e269-d0fa-4408-89b1-fe2e48963177",
      "owner_id": "e0b227da-dc6e-402c-8172-9d950ece4707",
      "name": "Burrows White",
      "slug": "burrows-white",
      "description": "Phasellus in felis. Donec semper sapien a libero. Nam dui. ",
      "adults": 9,
      "children": 2,
      "is_pets_allowed": false,
      "base_price": 160.51,
      "cleaning_fee": 31.45,
      "image_url": "http://dummyimage.com/149x114.png/ff4444/ffffff",
      "weekly_discount": 0.77,
      "monthly_discount": 0.36,
      "special_prices": [
        {
          "date": "2019-10-12",
          "base_price": 40.51
        },
        {
          "date": "2019-10-13",
          "base_price": 80
        }
      ]
    }
  ]
  ```

**[⬆ back to top](#introduction)**

### Show Listing

- Method: `GET`
- URL path: `/api/listings/:uuid`

- Response:

  Header: `HTTP 200`
  Body:

  ```json
  {
    "id": "d290f1ee-6c54-4b01-90e6-d701748f0851",
    "owner_id": "d701748f-6c54-4b01-90e6-d701748f0822",
    "name": "Black Raven",
    "slug": "black-raven",
    "description": "Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed.",
    "adults": 3,
    "children": 2,
    "is_pets_allowed": true,
    "base_price": 195.62,
    "cleaning_fee": 95.82,
    "image_url": "http://dummyimage.com/126x173.bmp/cc0000/ffffff",
    "weekly_discount": 0.77,
    "monthly_discount": 0.61,
    "special_prices": []
  }
  ```

**[⬆ back to top](#introduction)**

### Update A Listing

- Method: `PUT`
- URL path: `/api/listings/:uuid`
- Request body:

  ```json
  {
    "name": "Black Raven",
    "description": "Morbi porttitor lorem id ligula",
    "adults": 3,
    "children": 2,
    "is_pets_allowed": true,
    "base_price": 195.62,
    "cleaning_fee": 95.82,
    "image_url": "http://dummyimage.com/126x173.bmp/cc0000/ffffff",
    "weekly_discount": 0,
    "monthly_discount": 0.61
  }
  ```

- Response:

  Header: `HTTP 200`
  Body:

  ```json
  {
    "id": "d290f1ee-6c54-4b01-90e6-d701748f0851",
    "owner_id": "d701748f-6c54-4b01-90e6-d701748f0822",
    "name": "Black Raven",
    "slug": "black-raven",
    "description": "Morbi porttitor lorem id ligula",
    "adults": 3,
    "children": 2,
    "is_pets_allowed": true,
    "base_price": 195.62,
    "cleaning_fee": 95.82,
    "image_url": "http://dummyimage.com/126x173.bmp/cc0000/ffffff",
    "weekly_discount": 0,
    "monthly_discount": 0.61,
    "special_prices": []
  }
  ```

**[⬆ back to top](#introduction)**

### Delete A Listing

- Method: `DELETE`
- URL path: `/api/listings/:uuid`

- Response:

  Header: `HTTP 200`
  Body:

  ```json
  {
    "id": "d290f1ee-6c54-4b01-90e6-d701748f0851"
  }
  ```

**[⬆ back to top](#introduction)**

### Add Special price to Listing

- Method: `POST`
- URL path: `/api/listings/:uuid/special-prices`
- Request body:

  ```json
  {
    "date": "2019-12-06",
    "price": 95.82
  }
  ```

- Response:
  Header: `HTTP 200`
  Body:

  ```json
  {
    "id": "d290f1ee-6c52-4b02-90e6-d701748f9854",
    "date": "2019-12-06",
    "price": 95.82
  }
  ```

### Delete a Special price

- Method: `DELETE`
- URL path: `/api/listings/:uuid/special-prices/:uuid`

- Response:
  Header: `HTTP 200`
  Body:

  ```json
  {
    "id": "d290f1ee-6c52-4b02-90e6-d701748f9854"
  }
  ```

  **[⬆ back to top](#introduction)**

### Calculate Reservation Cost

- Method: `GET`
- URL path: `/api/listings/:uuid/checkout`

- Request body:

  ```json
  {
    "checkin": "2019-12-06",
    "checkout": "2019-12-10"
  }
  ```

- Response:
  Header: `HTTP 200`
  Body:

  ```json
  {
    "nights_count": 4,
    "nights_cost": 95.82,
    "discount": 13.82,
    "cleaning_fee": 3.82,
    "total": 85.82
  }
  ```

**[⬆ back to top](#introduction)**
