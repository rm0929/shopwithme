# Catalog Service Specification

## Purpose

Manages the product catalog for ShopWithMe e-commerce. Handles CRUD operations, filtering, and pagination.

## Technology Stack

| Component | Technology |
|-----------|------------|
| Runtime | Java 21 |
| Framework | Spring Boot 4 |
| API | REST, OpenAPI 3 |
| Storage | JSON file or PostgreSQL |
| Build | Maven |

## Design Decisions

### Interface-Based Repository

`IProductRepository` allows swapping storage (JSON vs PostgreSQL) without changing service or controller code. Implementations are selected via Spring profiles.

### Profile-Based Configuration

- **json**: Excludes JPA/DataSource; uses file storage. No database required.
- **postgres**: Full JPA, connects to PostgreSQL. Seeds from `products.json` on first run.

### Centralized Error Handling

`GlobalExceptionHandler` maps exceptions to RFC 7807 ProblemDetail responses. Consistent error format across all endpoints.

### Product Model

E-commerce oriented: brand, category, pricing, variants, inventory, SEO. Aligns with schema.org and common marketplace practices.

## Deployment

### Docker (recommended)

```bash
cd infra/compose
docker compose up
```

Containers: `shopwithme-catalog`, `shopwithme-postgres`.

### Local

```bash
# JSON storage
CATALOG_STORAGE=json ./mvnw spring-boot:run

# PostgreSQL (requires DB)
CATALOG_STORAGE=postgres ./mvnw spring-boot:run
```

## Configuration

| Key | Env Var | Default |
|-----|---------|---------|
| Storage profile | `CATALOG_STORAGE` | `json` |
| Port | — | 8081 |
| DB host | `POSTGRES_HOST` | localhost |
| DB credentials | `POSTGRES_*` | See .env.example |
| CORS origins | `CATALOG_CORS_ALLOWED_ORIGINS` | localhost:3000, localhost:5173 |

## Health Check

`GET /api/v1/health` returns `{"status":"ok","service":"catalog"}`. Used by Docker healthcheck and load balancers.
