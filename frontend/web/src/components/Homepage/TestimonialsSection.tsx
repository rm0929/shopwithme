import { motion } from "framer-motion";
import { mockTestimonials } from "@/data";

const TestimonialsSection = () => {
  return (
    <section className="w-full py-24 bg-background">
      <div className="max-w-6xl mx-auto px-6">
        {/* Section Title */}
        <motion.h2
          initial={{ opacity: 0, y: 10 }}
          whileInView={{ opacity: 1, y: 0 }}
          viewport={{ once: true }}
          transition={{ duration: 0.35 }}
          className="text-4xl font-bold text-text text-center mb-12"
        >
          Loved by <span className="text-primary">Thousands</span> of Customers
        </motion.h2>

        {/* Testimonials Grid */}
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-10">
          {mockTestimonials.map((t, i) => (
            <motion.div
              key={t.id}
              initial={{ opacity: 0, y: 15 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              transition={{ duration: 0.35, delay: i * 0.08 }} // ⭐ STAGGERED FAST
              whileHover={{ scale: 1.04, y: -3 }}
              className="
                bg-card/60 backdrop-blur-xl
                border border-card/40 
                rounded-2xl p-6 shadow-lg 
                flex flex-col gap-4
                hover:shadow-xl transition
              "
            >
              {/* Avatar */}
              <div className="flex items-center gap-4">
                <img
                  src={t.image}
                  alt={t.name}
                  className="w-14 h-14 rounded-full border border-card/50"
                />
                <div>
                  <h3 className="font-semibold text-text">{t.name}</h3>
                  <p className="text-text-light text-sm">{t.role}</p>
                </div>
              </div>

              {/* Review Text */}
              <p className="text-text-light">{t.review}</p>

              {/* Rating */}
              <div className="text-primary text-xl">
                {"⭐".repeat(t.rating)}
              </div>
            </motion.div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default TestimonialsSection;