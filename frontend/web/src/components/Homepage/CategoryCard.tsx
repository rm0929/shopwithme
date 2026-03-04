import type { ReactNode } from "react";
import { motion } from "framer-motion";

interface CategoryCardProps {
  icon: ReactNode;
  label: string;
  delay?: number;
}

const CategoryCard = ({ icon, label, delay = 0 }: CategoryCardProps) => {
  return (
    <motion.div
      initial={{ opacity: 0, y: 30 }}
      whileInView={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.6, delay }}
      viewport={{ once: true }}
      whileHover={{ y: -6, scale: 1.03 }}
      className="
        bg-card/60 backdrop-blur-xl 
        border border-card/50 
        rounded-2xl p-6 shadow-lg 
        cursor-pointer hover:shadow-xl
        flex flex-col items-center gap-3
        transition
      "
    >
      <div className="text-4xl">{icon}</div>
      <p className="text-lg font-semibold text-text">{label}</p>
    </motion.div>
  );
};

export default CategoryCard;