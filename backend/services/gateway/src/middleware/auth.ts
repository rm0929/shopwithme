import { Request, Response, NextFunction } from 'express';
import jwt from 'jsonwebtoken';
import { JWT_SECRET } from '../utils/config';

export function checkJwt(req: Request, res: Response, next: NextFunction) {
  const auth = req.headers['authorization'];
  if (!auth || !String(auth).startsWith('Bearer ')) return res.status(401).json({ error: 'missing_token' });
  const token = String(auth).split(' ')[1];
  try {
    const payload = jwt.verify(token, JWT_SECRET);
    (req as any).user = payload;
    next();
  } catch (err) {
    return res.status(401).json({ error: 'invalid_token' });
  }
}
