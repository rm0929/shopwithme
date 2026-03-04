import { motion } from "framer-motion";

const NewsletterSection = () => {
  return (
    <section className="w-full py-24">
      <div className="max-w-5xl mx-auto px-6">
        <motion.div
          initial={{ opacity: 0, y: 30 }}
          whileInView={{ opacity: 1, y: 0 }}
          viewport={{ once: true }}
          transition={{ duration: 0.6 }}
          className="
            bg-gradient-to-r from-primary-light/30 to-secondary-light/30
            backdrop-blur-xl
            border border-card/40
            rounded-3xl p-10 shadow-xl
            flex flex-col items-center gap-6
            text-center
          "
        >
          {/* Title */}
          <h2 className="text-4xl font-bold text-text">
            Stay Updated With <span className="text-primary">OmegaStore</span>
          </h2>

          {/* Subtitle */}
          <p className="text-text-light text-lg max-w-md">
            Join 50,000+ shoppers and get exclusive offers, early product
            access, and premium discounts straight to your inbox.
          </p>

          {/* Input + Button */}
          <div className="flex flex-col sm:flex-row gap-4 w-full max-w-xl">
            <input
              type="email"
              placeholder="Enter your email"
              className="
                flex-1 px-5 py-3 rounded-xl
                border border-text-light/30
                bg-card/50 backdrop-blur-xl
                text-text
                focus:ring-2 focus:ring-primary focus:outline-none
              "
            />

            <button
              className="
                px-8 py-3 rounded-xl
                bg-primary text-white font-medium
                hover:bg-primary-dark transition
                shadow-md hover:shadow-lg
              "
            >
              Subscribe
            </button>
          </div>
        </motion.div>
      </div>
    </section>
  );
};

export default NewsletterSection;