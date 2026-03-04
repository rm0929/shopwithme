import { mockProductsOfMonth } from "@/data";

const HeroSection = () => {
  // get the latest featured product
  const product = mockProductsOfMonth[mockProductsOfMonth.length - 1];

  return (
    <section
      className="
        w-full pt-32 pb-20 
        bg-gradient-to-br 
        from-background via-white to-secondary-light/20
      "
    >
      <div className="max-w-7xl mx-auto flex flex-col md:flex-row items-center px-6">
        {/* LEFT SIDE */}
        <div className="w- space-y-8">
          {/* Top Tag */}
          <div className="inline-flex items-center gap-2 px-4 py-2 bg-card border border-card/50 rounded-full shadow-sm text-text-light">
            <span className="text-sm">{product.tagline}</span>
          </div>

          {/* Headline */}
          <h1 className="text-5xl md:text-6xl font-extrabold text-text leading-tight">
            {product.title.split(" ")[0]} <br />
            <span className="text-text">
              {product.title.replace(product.title.split(" ")[0] + " ", "")}
            </span>
          </h1>

          {/* Sub-content */}
          <div className="flex flex-col gap-2">
            <h3 className="text-3xl font-semibold text-primary">
              {product.featureNumber}
            </h3>

            <p className="text-lg font-semibold text-text">
              {product.featureTitle}
            </p>

            <p className="text-text-light max-w-md">{product.description}</p>
          </div>

          {/* CTA */}
          <button
            className="
              inline-flex items-center gap-3 
              px-8 py-4 
              bg-primary text-white rounded-full 
              shadow-lg hover:bg-primary-dark 
              transition-all text-lg font-medium
            "
          >
            View All Products
            <span className="w-8 h-8 flex items-center justify-center bg-white text-primary rounded-full shadow">
              →
            </span>
          </button>

          {/* Social Icons */}
          <div className="flex gap-4 items-center pt-4 text-text-light">
            <span className="text-sm">Follow us on:</span>

            <div className="flex gap-4 text-xl cursor-pointer">
              <i className="ri-twitter-fill hover:text-primary"></i>
              <i className="ri-tiktok-fill hover:text-primary"></i>
              <i className="ri-youtube-fill hover:text-primary"></i>
              <i className="ri-instagram-fill hover:text-primary"></i>
            </div>
          </div>
        </div>

        {/* RIGHT SIDE PRODUCT IMAGE */}
        <div className="flex-1 relative flex justify-center mt-10 md:mt-0">
          <div className="absolute -top-6 right-20 w-4 h-4 bg-secondary-light/70 rounded-full"></div>
          <div className="absolute top-10 right-40 w-3 h-3 bg-primary-light/70 rounded-full"></div>
          <div className="absolute bottom-20 left-10 w-3 h-3 bg-primary/60 rounded-full"></div>
          <div className="absolute bottom-6 right-16 w-4 h-4 bg-secondary/60 rounded-full"></div>

          <div className="w-[380px] h-[380px] flex items-center justify-center relative overflow-hidden">
            <img
              src={product.image}
              alt="Featured Product"
              className="w-full h-full object-contain drop-shadow-2xl "
            />
          </div>
        </div>
      </div>
    </section>
  );
};

export default HeroSection;