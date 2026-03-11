import { v4 as uuidv4 } from 'uuid';
import { Request, Response, NextFunction } from 'express';

function correlationMiddleware(req: Request, res: Response, next: NextFunction) {
  const id = req.headers['x-correlation-id'] || uuidv4();
  res.setHeader('x-correlation-id', String(id));
  (req as any).context = { correlationId: id };
  next();
}

export default correlationMiddleware;