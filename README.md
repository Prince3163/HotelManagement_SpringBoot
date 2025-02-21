# Hotel Management - Spring Boot Project

## Overview
This is a Spring Boot-based Hotel Management system that provides APIs for managing hotels, rooms, bookings, and customers.

## API Endpoints & Request Bodies

### 1. Bookings API (`/api/bookings`)

#### **GET** `/search`
```json
{
    "location": "Gandhinagar",
    "checkInDate": "2025-02-13",
    "checkOutDate": "2025-02-17"
}
```

#### **POST**
```json
{
    "roomId": 3,
    "customerId": 4,
    "checkInDate": "2025-02-13",
    "checkOutDate": "2025-02-17"
}
```

#### **PUT**
```json
{
    "hotelId": 5,
    "name": "The Grand ABC",
    "email": "example@gmail.com",
    "location": "Ahmedabad"
}
```

---

### 2. Hotels API (`/api/hotels`)

#### **POST**
```json
{
    "name": "Grand ABC",
    "email": "example@gmail.com",
    "location": "Ahmedabad"
}
```

#### **PUT**
```json
{
    "hotelId": 5,
    "name": "The Grand ABC",
    "email": "example@gmail.com",
    "location": "Ahmedabad"
}
```

---

### 3. Rooms API (`/api/hotels/{hotelId}/rooms`)

#### **POST**
```json
{
    "roomNo": 13,
    "price": 5000.35,
    "roomType": "LUX"
}
```

#### **PUT**
```json
{
    "roomId": 2,
    "roomNo": 13,
    "price": 15000.00,
    "roomType": "DELUX"
}
```

---

### 4. Customers API (`/api/customers`)

#### **POST**
```json
{
    "name": "Prince Patel",
    "email": "prince@mail.com"
}
```

#### **PUT**
```json
{
    "customerId": 1,
    "name": "Prince",
    "email": "prince@mail.com"
}
```

## Technologies Used
- Spring Boot
- Java
- MySQL (or any configured database)
- Hibernate
- Maven
