#!/bin/bash
# Start catalog service with Docker Compose.
# Run from project root or infra/compose.
set -e
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
cd "$PROJECT_ROOT/infra/compose"
docker compose up -d
echo "Catalog service starting. Wait ~25s, then: curl http://localhost:8081/api/v1/health"
