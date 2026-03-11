import dotenv from 'dotenv';

dotenv.config();

export const PORT = Number(process.env.PORT || 8080);
// Keep all the URLs for each service
export const CATALOG_URL = process.env.CATALOG_URL || 'http://localhost:8001';

export const JWT_SECRET = process.env.JWT_SECRET || 'change_me';
