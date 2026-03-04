import type { Product } from "@/types";

export const mockPopularProducts: Product[] = [
  // Electronics
  {
    id: "1",
    name: "Omega Wireless Headphones",
    price: 199,
    rating: 4.8,
    image: "/images/headphones.png",
    category: "electronics",
    subCategory: "audio",
  },
  {
    id: "2",
    name: "Omega Smartwatch X3",
    price: 149,
    rating: 4.6,
    image: "/images/smartwatch.png",
    category: "electronics",
    subCategory: "wearables",
  },
  {
    id: "3",
    name: "Omega Bluetooth Speaker",
    price: 89,
    rating: 4.7,
    image: "/images/speakers.png",
    category: "electronics",
    subCategory: "audio",
  },
  {
    id: "4",
    name: "Omega Noise-Cancelling Earbuds",
    price: 129,
    rating: 4.5,
    image: "/images/earbuds.png",
    category: "electronics",
    subCategory: "audio",
  },
];