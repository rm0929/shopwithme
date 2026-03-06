import dotenv from 'dotenv';

dotenv.config();

export const PORT = Number(process.env.PORT || 8080);
export const CATALOG_URL = process.env.CATALOG_URL || 'http://localhost:3001';
export const CART_URL = process.env.CART_URL || 'http://localhost:3002';
export const JWT_SECRET = process.env.JWT_SECRET || 'change_me';
