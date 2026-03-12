import express from 'express';
import cors from 'cors';
import morgan from 'morgan';

import { PORT } from './utils/config';
import correlationMiddleware from './middleware/correlation';


const app = express();

// CORS configuration {NEED UNDERSTANDING}
app.use(cors({
    origin: process.env.CORS_ORIGIN, // Allow all origins for simplicity; adjust as needed for production
    credentials: true,
}
));
app.use(express.json()); // Global JSON parser
app.use(express.urlencoded({ extended: true })); // Middleware to parse URL-encoded bodies
app.use(morgan("dev")); // HTTP request logger middleware for development
app.use(correlationMiddleware); // Middleware to add a unique correlation ID to each request for tracing across services

// checks health of gateway
app.get('/health', (_, res) => res.json({ status: 'ok' }));

//routes
import productCatalogRouter from './routes/productCatalog.routes';

app.use('/apigateway/v1/products', productCatalogRouter); // mount router for product catalog service

app.listen(PORT, () => {
  console.log(`Gateway listening on port :${PORT}`);
});
