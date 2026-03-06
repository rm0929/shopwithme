import { Router } from 'express';
import { createProxyMiddleware } from 'http-proxy-middleware'; // Proxy middleware to forward requests to the catalog service
import { CATALOG_URL } from '../utils/config';

const router = Router();

router.use(
  '/',
  createProxyMiddleware({
    target: CATALOG_URL, // Forward requests to the catalog service
    changeOrigin: true, // Change the origin of the host header to the target URL
    pathRewrite: { '^/api/v1/categories': '/v1/categories' }, // Rewrite the path to match the catalog service's expected endpoint
  })
);

export default router;
