import {
  Hero,
  Navbar,
  FeatureHighlightsSection,
  ProductGrid,
  CategorySection,
  NewsLetterSection,
  TestimonialsSection,
  Footer,
} from "@/components/Homepage";

const HomePage = () => {
  return (
    <>
      <Navbar />
      <Hero />
      <FeatureHighlightsSection />
      <ProductGrid />
      <CategorySection />
      <NewsLetterSection />
      <TestimonialsSection />
      <Footer />
    </>
  );
};

export default HomePage;