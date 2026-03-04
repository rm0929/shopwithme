import { useEffect, useState } from "react";
import type { Product } from "@/types";
import { ProductCard } from "@/components/Homepage";
import { mockPopularProducts } from "@/data";
import { motion } from "framer-motion";

const ProductGrid = () => {
  const [products, setProducts] = useState<Product[] | null>(null);

  useEffect(() => {
    // simulate API delay
    const timer = setTimeout(() => {
      setProducts(mockPopularProducts);
    }, 800);

    return () => clearTimeout(timer);
  }, []);

  return (
    <section className="w-full py-10 bg-background">
      <div className="max-w-6xl mx-auto px-6">
        {/* Title */}
        <motion.h2
          initial={{ opacity: 0, y: 20 }}
          whileInView={{ opacity: 1, y: 0 }}
          viewport={{ once: true }}
          transition={{ duration: 0.6 }}
          className="text-4xl font-bold text-text mb-12 text-center"
        >
          Popular Products
        </motion.h2>

        {/* Loading State */}
        {!products && (
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-8">
            {[1, 2, 3, 4].map((n) => (
              <div
                key={n}
                className="h-72 bg-card/50 rounded-2xl animate-pulse"
              />
            ))}
          </div>
        )}

        {/* Loaded Grid */}
        {products && (
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-8">
            {products.map((product) => (
              <motion.div
                key={product.id}
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{}}
              >
                <ProductCard product={product} />
              </motion.div>
            ))}
          </div>
        )}
      </div>
    </section>
  );
};

export default ProductGrid;