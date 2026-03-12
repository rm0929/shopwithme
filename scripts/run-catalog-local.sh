#!/bin/bash
# Run catalog locally with JSON storage (no Docker).
# Requires Java 17+.
set -e
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR/../backend/services/catalog"
CATALOG_STORAGE=json ./mvnw spring-boot:run
