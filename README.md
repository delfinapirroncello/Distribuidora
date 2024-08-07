# Distribuidora

Este es un proyecto de ejemplo para una aplicación de distribuidora desarrollada con Spring Boot. La aplicación permite gestionar clientes, productos y pedidos.

## Características

- **Gestión de Clientes**: Crear, actualizar, eliminar y listar clientes.
- **Gestión de Productos**: Crear, actualizar, eliminar y listar productos.
- **Gestión de Pedidos**: Crear y listar pedidos con múltiples productos y clientes asociados.
- **Documentación REST**: Endpoints RESTful para interactuar con los recursos de la aplicación.

## Requisitos

- Java 17 o superior
- Maven
- Postman

## Endpoints
### Clientes
- **GET /clientes**: Lista todos los clientes.
- **POST /clientes/create**: Crea un nuevo cliente.
- **PUT /clientes/{id}**: Actualiza un cliente existente.
- **DELETE /clientes/{id}**: Elimina un cliente.
- **GET /clientes/{id}**: Obtiene un cliente por su ID.

### Productos
- **GET /productos**: Lista todos los productos.
- **POST /productos/create**: Crea un nuevo producto.
- **PUT /productos/{id}**: Actualiza un producto existente.
- **DELETE /productos/{id}**: Elimina un producto.
- **GET /productos/{id}**: Obtiene un producto por su ID.

### Pedidos
- **GET /pedidos**: Lista todos los pedidos.
- **POST /pedidos/create**: Crea un nuevo pedido.

## Ejemplos de Uso con Postman

### Crear un Cliente

- **URL**: `POST /clientes/create`
- **Body**:
  ```json
  {
    "id": "1",
    "nombre": "Juan Perez",
    "email": "juanperez@gmail.com",
    "telefono": "3453451234"
  }
  ```

### Crear un Producto
- **URL**: POST /productos/create
- **Body**:
```json
  {
   "nombre": "Producto A",
   "precio": 100.0,
   "disponible": true
  }
```

### Crear un Pedido
- **URL**: POST /pedidos/create
- **Body**:
```json
  {
    "clienteId": 1,
    "productosIds": [1, 2, 3]
  }
```
