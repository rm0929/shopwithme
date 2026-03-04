import { FeatureCard } from "@/components/Homepage";
import { motion } from "framer-motion";
import { useCounter } from "@/hooks";
import { mockFeaturedCards } from "@/data";

const FeatureHighlightsSection = () => {
  const orders = useCounter(10000, 2000); // animated counter

  return (
    <section className="w-full py-24 bg-background">
      <div className="max-w-6xl mx-auto px-6">
        {/* Section Title */}
        <motion.h2
          initial={{ opacity: 0, y: 20 }}
          whileInView={{ opacity: 1, y: 0 }}
          viewport={{ once: true }}
          transition={{ duration: 0.6 }}
          className="text-4xl font-bold text-text mb-12 text-center"
        >
          Why Shop With <span className="text-primary">OmegaStore?</span>
        </motion.h2>

        {/* CARD GRID */}
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8">
          {mockFeaturedCards.map((card, index) => (
            <FeatureCard
              key={card.id}
              icon={card.icon}
              title={card.title}
              description={card.description}
              delay={index * 0.1}
            >
              {/* SPECIAL CASE: Animated Counter */}
              {card.isCounter && (
                <p className="text-3xl font-bold text-primary mt-2">
                  {orders.toLocaleString()}+
                </p>
              )}
            </FeatureCard>
          ))}
        </div>
      </div>
    </section>
  );
};

export default FeatureHighlightsSection;