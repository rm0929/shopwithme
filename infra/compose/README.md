# ShopWithMe Catalog Service

## Quick Start

```bash
docker compose up
```

That's it. No setup required. The service starts with sensible defaults:
- **Catalog Service** → http://localhost:8081
- **PostgreSQL** → localhost:5432
- Products are seeded from `products.json` on first run

## Swagger UI (Interactive API Docs)

Once running, open in your browser:

| URL | Description |
|-----|-------------|
| http://localhost:8081/swagger-ui.html | Interactive API playground - try endpoints, see request/response schemas |
| http://localhost:8081/api-docs | OpenAPI 3.0 JSON spec |

Use Swagger UI to explore endpoints, view models, and test requests without writing curl commands.

## API Reference

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/health` | Health check |
| GET | `/api/v1/products` | List all products. Add `?page=0&size=20` for pagination |
| GET | `/api/v1/products/{id}` | Get product by ID |
| GET | `/api/v1/products/sku/{sku}` | Get product by SKU |
| GET | `/api/v1/products/slug/{slug}` | Get product by slug |
| GET | `/api/v1/products?category=cat_footwear` | Filter by category |
| GET | `/api/v1/products?status=ACTIVE` | Filter by status |
| POST | `/api/v1/products` | Create product (JSON body, see Swagger for schema) |
| PUT | `/api/v1/products/{id}` | Update product |
| DELETE | `/api/v1/products/{id}` | Delete product |

## Verify It's Working

```bash
curl http://localhost:8081/api/v1/health
curl http://localhost:8081/api/v1/products
```

## Storage Modes

**PostgreSQL (default)** — `docker compose up`

**JSON only (no database)** — Run catalog without PostgreSQL:
```bash
docker compose -f docker-compose.yml -f docker-compose.json.yml up
```

## Troubleshooting

- **Port in use**: Stop existing containers first: `docker compose down`
- **Containers**: Named `shopwithme-catalog-1`, `shopwithme-postgres-1`

## Customization

Create `.env` from `.env.example` to override defaults (e.g. `POSTGRES_PASSWORD` for production):

```bash
cp .env.example .env
# Edit .env, then:
docker compose up
```
