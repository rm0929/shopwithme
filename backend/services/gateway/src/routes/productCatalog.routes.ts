import { Router } from 'express';
import { createProxyMiddleware } from 'http-proxy-middleware'; // HTTP reverse proxy middleware
import { CATALOG_URL } from '../utils/config';

const router = Router();

router.use(
  '/',
  createProxyMiddleware({  // proxy service that routes the request to the correct middleware
    target: CATALOG_URL,  // Forward requests to the catalog service
    changeOrigin: true,
    pathRewrite: { '^/apigateway/v1': '/api/v1' }, // request recieved at /apigateway/v1/products will be forwarded to catalog service at /api/v1/products
  })
);

export default router;