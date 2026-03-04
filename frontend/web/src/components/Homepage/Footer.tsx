import { motion } from "framer-motion";
import { Link } from "react-router";

const Footer = () => {
  return (
    <footer className="w-full bg-background pt-20 pb-10 mt-10 border-t border-card/40">
      <motion.div
        initial={{ opacity: 0, y: 20 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        transition={{ duration: 0.6 }}
        className="max-w-6xl mx-auto px-6 grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-12"
      >
        {/* Brand */}
        <div className="flex flex-col gap-3">
          <h2 className="text-3xl font-extrabold bg-gradient-to-r from-primary to-secondary bg-clip-text text-transparent">
            OmegaStore
          </h2>
          <p className="text-text-light text-sm leading-relaxed">
            Premium products, instant delivery, and world-class experience. Your
            trusted e-commerce destination.
          </p>
        </div>

        {/* Quick Links */}
        <div>
          <h3 className="text-lg font-semibold text-text mb-4">Quick Links</h3>
          <ul className="flex flex-col gap-2 text-text-light">
            <li className="hover:text-primary cursor-pointer">
              <Link to="/">Home</Link>
            </li>
            <li className="hover:text-primary cursor-pointer">
              <Link to="./products">Products</Link>
            </li>
            <li className="hover:text-primary cursor-pointer">Categories</li>
            <li className="hover:text-primary cursor-pointer">Deals</li>
          </ul>
        </div>

        {/* Support */}
        <div>
          <h3 className="text-lg font-semibold text-text mb-4">Support</h3>
          <ul className="flex flex-col gap-2 text-text-light">
            <li className="hover:text-primary cursor-pointer">Help Center</li>
            <li className="hover:text-primary cursor-pointer">Track Order</li>
            <li className="hover:text-primary cursor-pointer">Return Policy</li>
            <li className="hover:text-primary cursor-pointer">Contact Us</li>
          </ul>
        </div>

        {/* Social & Payments */}
        <div className="flex flex-col gap-4">
          <h3 className="text-lg font-semibold text-text mb-2">
            Stay Connected
          </h3>

          <div className="flex gap-4 text-2xl text-text-light">
            <span className="hover:text-primary cursor-pointer">🐦</span>
            <span className="hover:text-primary cursor-pointer">📸</span>
            <span className="hover:text-primary cursor-pointer">🎥</span>
            <span className="hover:text-primary cursor-pointer">🎵</span>
          </div>

          <h4 className="text-lg font-semibold text-text mt-6">We Accept</h4>
          <div className="flex gap-3 text-3xl">
            <span>💳</span>
            <span>💲</span>
            <span>🏦</span>
          </div>
        </div>
      </motion.div>

      {/* Bottom Bar */}
      <div className="text-center text-text-light text-sm mt-12">
        © {new Date().getFullYear()} OmegaStore. All rights reserved.
      </div>
    </footer>
  );
};

export default Footer;