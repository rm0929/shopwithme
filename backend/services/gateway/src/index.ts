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
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
// app.use(morgan("dev"));
// app.use(correlationMiddleware);

// checks health of gateway
app.get('/health', (_, res) => res.json({ status: 'ok' }));

//routes
import catalogRouter from './routes/catalog';

app.use('/api/v1/catalog', catalogRouter);


app.listen(PORT, () => {
  console.log(`Gateway listening on port :${PORT}`);
});
