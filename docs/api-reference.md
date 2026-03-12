# API Reference

For interactive docs and full schemas, use **Swagger UI**: http://localhost:8081/swagger-ui.html

## Base URL

`http://localhost:8081/api/v1`

## Endpoints

### Health

| Method | Path | Description |
|--------|------|-------------|
| GET | `/health` | Service health check |

### Products

| Method | Path | Description |
|--------|------|-------------|
| GET | `/products` | List all. Query: `page`, `size` |
| GET | `/products/{id}` | Get by ID |
| GET | `/products/sku/{sku}` | Get by SKU |
| GET | `/products/slug/{slug}` | Get by slug |
| GET | `/products?category={id}` | Filter by category |
| GET | `/products?status={status}` | Filter by status (ACTIVE, DRAFT, etc.) |
| POST | `/products` | Create product |
| PUT | `/products/{id}` | Update product |
| DELETE | `/products/{id}` | Delete product |

## Response Codes

| Code | Meaning |
|------|---------|
| 200 | Success |
| 201 | Created |
| 204 | No content (delete) |
| 400 | Bad request (validation) |
| 404 | Not found |
| 409 | Conflict (e.g. duplicate SKU) |
| 500 | Server error |

## Product Schema (summary)

```json
{
  "id": "string",
  "sku": "string (required for create)",
  "name": "string (required for create)",
  "slug": "string",
  "description": "string",
  "brand": { "id": "string", "name": "string" },
  "category": { "id": "string", "name": "string", "path": ["string"] },
  "pricing": { "price": "number", "currency": "string", "compareAtPrice": "number" },
  "images": [{ "url": "string", "alt": "string" }],
  "variants": [{ "id": "string", "sku": "string", "price": "number", "attributes": {} }],
  "inventory": { "quantity": "number", "trackInventory": "boolean" },
  "status": "ACTIVE | DRAFT | ARCHIVED | OUT_OF_STOCK",
  "tags": ["string"]
}
```

Full schema and nested structures: see Swagger UI.

## Pagination

`GET /products?page=0&size=20` returns:

```json
{
  "content": [...],
  "page": 0,
  "size": 20,
  "totalElements": 100,
  "totalPages": 5
}
```

## Error Response (RFC 7807)

```json
{
  "type": "about:blank",
  "title": "Validation Error",
  "status": 400,
  "detail": "Validation failed",
  "errors": {
    "sku": "SKU is required",
    "name": "Name is required"
  }
}
```
