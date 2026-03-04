import {
  FiSearch,
  FiGrid,
  FiShoppingCart,
  FiUser,
  FiMapPin,
  FiPackage,
} from "react-icons/fi";

import { Link } from "react-router-dom";

export default function Navbar() {
  const departments = [
    {
      name: "Electronics",
      sub: [
        {
          title: "Computers",
          items: ["Laptops", "Monitors", "Keyboards", "Mice"],
        },
        { title: "Audio", items: ["Headphones", "Earbuds", "Speakers"] },
        { title: "Gaming", items: ["Consoles", "Controllers", "VR Headsets"] },
      ],
    },
    {
      name: "Books",
      sub: [
        { title: "Fiction", items: ["Thriller", "Fantasy", "Romance"] },
        { title: "Education", items: ["Engineering", "Coding", "Medical"] },
        { title: "Comics", items: ["Manga", "Superhero"] },
      ],
    },
    {
      name: "Food",
      sub: [
        { title: "Snacks", items: ["Chips", "Nuts", "Popcorn"] },
        { title: "Groceries", items: ["Rice", "Spices", "Oil"] },
        { title: "Nutrition", items: ["Protein Bars", "Supplements"] },
      ],
    },
    {
      name: "Pet",
      sub: [
        { title: "Dog", items: ["Leashes", "Beds", "Bowls"] },
        { title: "Cat", items: ["Litter", "Scratchers"] },
        { title: "Food", items: ["Dry Food", "Wet Food"] },
      ],
    },
    {
      name: "Fashion",
      sub: [
        { title: "Men", items: ["Shirts", "Pants", "Sweatshirts"] },
        { title: "Women", items: ["Tops", "Bags", "Jewelry"] },
        { title: "Footwear", items: ["Sneakers", "Sandals"] },
      ],
    },
    {
      name: "Home",
      sub: [
        { title: "Furniture", items: ["Sofas", "Chairs", "Beds"] },
        { title: "Kitchen", items: ["Cookware", "Appliances"] },
        { title: "Decor", items: ["Wall Art", "Clocks", "Lights"] },
      ],
    },
    {
      name: "Fitness",
      sub: [
        { title: "Equipment", items: ["Dumbbells", "Bands", "Mats"] },
        { title: "Clothing", items: ["Shorts", "T-Shirts"] },
        { title: "Supplements", items: ["Protein", "Creatine", "Pre-Workout"] },
      ],
    },
  ];

  return (
    <header className="w-full bg-white sticky top-0 z-[100] rounded">
      {/* TOP BAR */}
      <div className="w-full bg-white/80 backdrop-blur-lg shadow-sm border-b border-gray-100">
        <div className="max-w-7xl mx-auto px-6 py-3 flex items-center justify-between gap-6">
          <Link to="/">
            {/* LOGO */}
            <div className="text-2xl font-bold text-primary tracking-tight">
              OmegaStore
            </div>
          </Link>

          {/* SEARCH BAR */}
          <div className="flex items-center bg-white rounded-xl w-full max-w-xl shadow border border-gray-200">
            {/* Category dropdown icon */}
            <Link to="/products">
              <div className="flex items-center px-3 border-r border-gray-200 cursor-pointer hover:bg-gray-50 rounded-l-xl">
                <FiGrid size={18} className="text-gray-500" />
              </div>
            </Link>

            {/* Input */}
            <input
              type="text"
              placeholder="Search products…"
              className="px-4 py-2 w-full bg-transparent text-sm focus:outline-none"
            />

            {/* Search button */}
            <button className="px-4 py-2 bg-primary text-white rounded-r-xl hover:bg-primary-dark transition flex items-center justify-center">
              <FiSearch size={18} />
            </button>
          </div>

          {/* RIGHT ICON GROUP */}
          <div className="flex items-center gap-5">
            {/* Location */}
            <button className="p-2 rounded-lg hover:bg-gray-100 transition">
              <FiMapPin size={20} className="text-gray-700" />
            </button>

            {/* Account */}
            <button className="p-2 rounded-lg hover:bg-gray-100 transition">
              <FiUser size={20} className="text-gray-700" />
            </button>

            {/* Orders */}
            <button className="p-2 rounded-lg hover:bg-gray-100 transition">
              <FiPackage size={20} className="text-gray-700" />
            </button>

            {/* Cart */}
            <button className="relative p-2 rounded-lg hover:bg-gray-100 transition">
              <FiShoppingCart size={22} className="text-gray-800" />
              <span className="absolute -top-1 -right-1 bg-primary text-white text-xs px-1.5 py-0.5 rounded-full">
                0
              </span>
            </button>
          </div>
        </div>
      </div>

      {/* CATEGORY BAR */}

      <div className="bg-card/80 backdrop-blur-lg border-t border-b border-white/20 shadow-md">
        <div className="max-w-7xl mx-auto px-6 py-3 flex items-center gap-6">
          {departments.map((dept) => (
            <div key={dept.name} className="relative group">
              {/* Hover Button */}
              <button
                className="
            text-text font-medium transition-all 
            px-3 py-1.5 rounded-xl
            hover:bg-white/60 hover:shadow-sm
            hover:text-primary
          "
              >
                {dept.name}
              </button>

              {/* Underline animation */}
              <div
                className="
            absolute left-1/2 -bottom-1 w-0 group-hover:w-full 
            group-hover:left-0 h-[2px] 
            bg-primary transition-all duration-300 rounded-full
          "
              />

              {/* MEGA MENU */}
              <div
                className="
            absolute left-0 mt-3 w-[650px] opacity-0 invisible group-hover:opacity-100 
            group-hover:visible transition-all duration-200 translate-y-2 group-hover:translate-y-0
            bg-card rounded-2xl p-6 shadow-xl border border-white/20
            grid grid-cols-3 gap-6 z-50
          "
              >
                {dept.sub.map((col) => (
                  <div key={col.title}>
                    <h3 className="font-semibold text-primary mb-2">
                      {col.title}
                    </h3>
                    <ul className="space-y-1">
                      {col.items.map((item) => (
                        <li
                          key={item}
                          className="text-text-light hover:text-primary cursor-pointer text-sm transition"
                        >
                          {item}
                        </li>
                      ))}
                    </ul>
                  </div>
                ))}
              </div>
            </div>
          ))}
        </div>
      </div>
    </header>
  );
}