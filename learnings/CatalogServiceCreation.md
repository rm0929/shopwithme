# How to Build a Microservice from Scratch

A step-by-step guide for beginners. No prior Spring Boot or microservice experience required.

---

## Part 1: What is a Microservice?

Imagine a big online store. Instead of one giant application doing everything (products, orders, users, payments), we split it into **small services**. Each service does one job and talks to others over HTTP.

- **Catalog Service** → manages products
- **Order Service** → manages orders
- **User Service** → manages accounts

Why? Smaller pieces are easier to build, test, and change. One team can work on catalog while another works on orders.

---

## Part 2: What You Need

- **Java 17+** — [Download](https://adoptium.net/) if you don't have it
- **Maven** — comes with the project (mvnw script)
- **A text editor** — VS Code, IntelliJ, or Cursor
- **Docker** (optional) — for running the database

---

## Part 3: Understanding Spring Boot

Spring Boot is a framework that makes building web services fast. You focus on business logic; Spring handles the boring stuff (HTTP, database, config).

### Key Ideas

1. **@RestController** — marks a class as "this handles HTTP requests"
2. **@GetMapping, @PostMapping** — maps URL paths to methods
3. **@Service** — business logic layer
4. **@Repository** — data access layer
5. **Dependency Injection** — Spring creates objects and wires them together

---

## Part 4: Project Structure

```
backend/services/catalog/
├── pom.xml                    # Maven dependencies
├── src/main/java/.../
│   ├── CatalogApplication.java    # Entry point
│   ├── controllers/               # HTTP endpoints
│   ├── services/                  # Business logic
│   │   └── interfaces/            # Contracts (good practice)
│   ├── repository/                # Data access
│   │   └── interfaces/
│   ├── models/                    # Data structures
│   ├── config/                    # Configuration
│   └── exception/                 # Error handling
└── src/main/resources/
    ├── application.properties     # Config
    └── data/products.json         # Seed data
```

---

## Part 5: Step-by-Step — Build Your First Endpoint

### Step 1: Create the model (what is a product?)

```java
public class Product {
    private String id;
    private String name;
    private Double price;
    // getters and setters
}
```

### Step 2: Create the repository (where do products live?)

Define an **interface** so you can switch storage (JSON, database) later:

```java
public interface IProductRepository {
    List<Product> findAll();
    Optional<Product> findById(String id);
    Product save(Product product);
}
```

Implement it. For JSON storage:

```java
@Repository
@Profile("json")
public class ProductJsonRepository implements IProductRepository {
    private List<Product> products = new ArrayList<>();
    // load from file in @PostConstruct
    // implement each method
}
```

### Step 3: Create the service (business logic)

```java
public interface IProductService {
    List<Product> getAllProducts();
}

@Service
public class ProductService implements IProductService {
    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;  // Spring injects the right implementation
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
```

### Step 4: Create the controller (HTTP layer)

```java
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
}
```

### Step 5: Run it

```bash
cd backend/services/catalog
./mvnw spring-boot:run
```

Visit http://localhost:8081/api/v1/products — you should see JSON.

---

## Part 6: Patterns We Used

| Pattern | Why |
|---------|-----|
| **Interface over class** | Swap implementations (JSON vs PostgreSQL) without changing callers |
| **Profiles** | `@Profile("json")` loads that bean only when that profile is active |
| **Global exception handler** | One place for 404, 400, 500 responses instead of try/catch everywhere |
| **Validation** | `@Valid` on request bodies, `@NotBlank` on fields |

---

## Part 7: Building Your Own Microservice

1. **Copy the catalog structure** — controllers, services, repository, models
2. **Change the domain** — replace Product with your entity (Order, User, etc.)
3. **Define your API** — what endpoints? GET, POST, PUT, DELETE?
4. **Choose storage** — JSON file for quick start, PostgreSQL for production
5. **Add validation** — required fields, format checks
6. **Add error handling** — custom exceptions, GlobalExceptionHandler

---

## Part 8: Useful Commands

```bash
# Run locally (JSON storage)
CATALOG_STORAGE=json ./mvnw spring-boot:run

# Run with Docker (PostgreSQL)
cd infra/compose && docker compose up

# Build JAR
./mvnw package -DskipTests

# Run tests
./mvnw test
```

---

## Part 9: Next Steps

- Read the Catalog Service code — it's a working example
- Try adding a new endpoint (e.g. search by name)
- Add a second storage (e.g. MongoDB) with `@Profile("mongo")`
- Build a second microservice (e.g. Cart Service) that calls the Catalog API

---

*This guide was created for the ShopWithMe catalog service. Use it as a template for other microservices.*
