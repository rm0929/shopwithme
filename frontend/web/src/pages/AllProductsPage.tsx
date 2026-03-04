import { FilterSideBar2 } from "@/components/AllProductsPage";
import { Footer, Navbar } from "@/components/HomePage";

const AllProductsPage = () => {
  return (
    <>
      <Navbar />
      {/* <FilterSidebar /> */}
      <FilterSideBar2 />
      <Footer />
    </>
  );
};

export default AllProductsPage;