import { Router } from 'express';
import { createProxyMiddleware } from 'http-proxy-middleware'; //reverse proxy to forward requests to the catalog service
import { CATALOG_URL } from '../utils/config';

const router = Router();

router.use(
  '/',
  createProxyMiddleware({
    target: CATALOG_URL,
    changeOrigin: true,
    pathRewrite: { '^/api/v1/catalog': '/v1/catalog' },
  })
);

export default router;
