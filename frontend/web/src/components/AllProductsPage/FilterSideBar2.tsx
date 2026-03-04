import { useState } from "react";
import { FiChevronLeft, FiChevronRight } from "react-icons/fi";
import { mockCategories } from "@/data";

const FilterSideBar2 = () => {
  // collapsed button
  const [collapsed, setCollapsed] = useState(false);

  return (
    <aside
      className={`
        border-r border-gray-200 bg-white h-screen 
        transition-all duration-300 relative
      ${collapsed ? "w-16" : "w-64"}
      `}
    >
      {/* COLLAPSE BUTTON */}
      <button
        onClick={() => setCollapsed(!collapsed)}
        className="absolute -right-3 top-6 bg-white shadow p-1.5 rounded-full hover:bg-gray-100 transition"
      >
        {collapsed ? <FiChevronRight size={18} /> : <FiChevronLeft size={18} />}
      </button>

      {/* CONTENT */}
      <div
        className={`
          overflow-hidden transition-all duration-300
          ${collapsed ? "opacity-0 max-h-0" : "opacity-100 max-h-screen"}
        `}
      >
        <h2 className="font-semibold text-lg p-4 pb-2">Filters</h2>
        <div className="px-4 pb-6 space-y-6">
          {mockCategories.map((category) => (
            <div key={category.label}>
              {/* CATEGORY CHECKBOX */}
              <label className="flex items-center gap-2 font-medium cursor-pointer">
                <input type="checkbox" checked={false} />
                {category.label}
              </label>

              {/* SUBCATEGORY CHECKBOXES */}
              <div className="ml-5 mt-2 space-y-1">
                {category.subcategories.map((subcategory) => (
                  <label
                    key={subcategory}
                    className="flex items-center gap-2 text-sm cursor-pointer"
                  >
                    <input type="checkbox" checked={false} />
                    {subcategory}
                  </label>
                ))}
              </div>
            </div>
          ))}
        </div>
      </div>
    </aside>
  );
};

export default FilterSideBar2;