/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors: {
        primary: "var(--primary)",
        "primary-light": "var(--primary-light)",
        "primary-dark": "var(--primary-dark)",
        secondary: "var(--secondary)",
        "secondary-light": "var(--secondary-light)",

        background: "var(--background)",
        card: "var(--card)",

        text: "var(--text)",
        "text-light": "var(--text-light)",
      },
    },
  },
  plugins: [],
};