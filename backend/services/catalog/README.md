# Catalog Service

Product catalog microservice for ShopWithMe e-commerce. Manages products with support for JSON or PostgreSQL storage.

## Quick Start

**Option A: Docker (recommended)**
```bash
cd infra/compose
docker compose up
```

**Option B: Local with JSON (no database)**
```bash
CATALOG_STORAGE=json ./mvnw spring-boot:run
```

Service runs at http://localhost:8081

## Swagger UI

Interactive API documentation — explore and test all endpoints:

| URL | Description |
|-----|-------------|
| http://localhost:8081/swagger-ui.html | Interactive playground |
| http://localhost:8081/api-docs | OpenAPI 3.0 JSON spec |

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/health` | Health check |
| GET | `/api/v1/products` | List products. `?page=0&size=20` for pagination |
| GET | `/api/v1/products/{id}` | Get by ID |
| GET | `/api/v1/products/sku/{sku}` | Get by SKU |
| GET | `/api/v1/products/slug/{slug}` | Get by slug |
| GET | `/api/v1/products?category={id}` | Filter by category |
| GET | `/api/v1/products?status=ACTIVE` | Filter by status |
| POST | `/api/v1/products` | Create product (see Swagger for body schema) |
| PUT | `/api/v1/products/{id}` | Update product |
| DELETE | `/api/v1/products/{id}` | Delete product |

## Request/Response Examples

**Create product (POST /api/v1/products):**
```json
{
  "sku": "MY-SKU-001",
  "name": "Product Name",
  "slug": "product-name",
  "description": "Full description",
  "pricing": { "price": 29.99, "currency": "USD" },
  "status": "ACTIVE"
}
```

**Validation:** `sku` and `name` are required. Duplicate SKU returns 409 Conflict.

## Storage Options

| Profile | Command | Use case |
|---------|---------|----------|
| `json` | `CATALOG_STORAGE=json ./mvnw spring-boot:run` | Local dev, no DB |
| `postgres` | Docker Compose or set env vars | Production |

## Configuration

| Property | Env Var | Default |
|----------|---------|---------|
| Storage | `CATALOG_STORAGE` | `json` |
| Port | `server.port` | 8081 |
| CORS origins | `CATALOG_CORS_ALLOWED_ORIGINS` | localhost:3000, localhost:5173 |

## Verify

```bash
curl http://localhost:8081/api/v1/health
curl http://localhost:8081/api/v1/products
```
