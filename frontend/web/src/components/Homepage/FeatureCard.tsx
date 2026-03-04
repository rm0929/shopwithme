import { motion } from "framer-motion";
import type { ReactNode } from "react";

interface FeatureCardProps {
  icon: ReactNode;
  title: string;
  description: string;
  delay?: number;
  children?: ReactNode;
}

const FeatureCard = ({
  icon,
  title,
  description,
  children,
}: FeatureCardProps) => {
  return (
    <motion.div
      initial={{ opacity: 0, y: 30 }}
      whileInView={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.1 }}
      viewport={{ once: true }}
      whileHover={{ y: -6, scale: 1.02 }}
      className="
        bg-card/60 backdrop-blur-xl 
        border border-card/40 
        rounded-2xl p-6 shadow-lg 
        flex flex-col items-start gap-3 
        hover:shadow-xl transition 
      "
    >
      <div className="text-3xl">{icon}</div>

      <h3 className="text-xl font-semibold text-text">{title}</h3>

      <p className="text-text-light">{description}</p>

      {children}
    </motion.div>
  );
};

export default FeatureCard;