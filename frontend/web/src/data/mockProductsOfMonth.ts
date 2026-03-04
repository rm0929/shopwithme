import type { ProductOfMonth } from "@/types";

export const mockProductsOfMonth: ProductOfMonth[] = [
  {
    id: 1,
    tagline: "This Month's Highlight",
    title: "UltraBoost Smartwatch X2",
    featureNumber: "01",
    featureTitle: "Advanced Fitness + Health Tracking",
    description:
      "Track your workouts, monitor heart rate, measure oxygen levels, and sync with all your favorite devices. Built for performance and style.",
    image: "/images/smartwatch.png",
  },
  {
    id: 2,
    tagline: "Just Dropped",
    title: "GalaxyWave Wireless Buds Pro",
    featureNumber: "02",
    featureTitle: "Immersive Sound • 48hr Battery",
    description:
      "Experience studio-quality audio with active noise cancellation and ultra-low latency. Perfect for music, gaming, and calls.",
    image: "/images/earbuds.png",
  },
  {
    id: 3,
    tagline: "Featured Product of the Month",
    title: "ApexPro Max Laptop 2025",
    featureNumber: "03",
    featureTitle: "Unmatched Performance",
    description:
      "Packed with the latest processor and top-tier graphics, ApexPro Max gives creators and gamers the ultimate smooth performance.",
    image: "/images/laptop.png",
  },
];