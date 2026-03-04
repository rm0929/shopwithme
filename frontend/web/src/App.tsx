import { Route, Routes } from "react-router";
import { HomePage, AllProductsPage } from "@/pages";

function App() {
  return (
    <Routes>
      {/* Landing Route */}
      <Route path="/" element={<HomePage />} />

      {/* Other routes */}
      <Route path="/products" element={<AllProductsPage />} />

      {/* Protected Routes */}
    </Routes>
  );
}

export default App;