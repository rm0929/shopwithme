import type { Product } from "@/types";
import { motion } from "framer-motion";

interface Props {
  product: Product;
}

const ProductCard = ({ product }: Props) => {
  return (
    <motion.div
      whileHover={{ y: -6, scale: 1.02 }}
      className="
        bg-card rounded-2xl p-4 shadow 
        border border-card/50 
        hover:shadow-xl transition 
        cursor-pointer
      "
    >
      {/* IMAGE */}
      <div className="w-full h-48 bg-gray-100 rounded-xl flex items-center justify-center overflow-hidden">
        <img
          src={product.image}
          alt={product.name}
          className="max-h-full max-w-full object-contain"
        />
      </div>

      {/* TEXT */}
      {/* PRODUCT NAME (fixed height) */}
      <div className="h-12 flex items-start">
        <h3 className="text-lg font-semibold text-text leading-tight">
          {product.name}
        </h3>
      </div>

      <p className="text-primary font-bold text-xl mt-1">${product.price}</p>

      <p className="text-text-light text-sm mt-1">⭐ {product.rating}</p>

      {/* BUTTON */}
      <button
        className="
          mt-3 w-full py-2 rounded-xl bg-primary text-white 
          hover:bg-primary-dark transition font-medium
        "
      >
        Add to Cart
      </button>
    </motion.div>
  );
};

export default ProductCard;