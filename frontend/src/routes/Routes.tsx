import App from "@/app/App";
import AdminPage from "@/components/layouts/AdminPage/AdminPage";
import HomePage from "@/components/layouts/HomePage/HomePage";
import ListingPage from "@/components/layouts/ShopPage/ShopPage";
import LoginPage from "@/components/layouts/LoginPage/LoginPage";
import ShoppingCartPage from "@/components/layouts/ShoppingCartPage/ShoppingCartPage";
import PastOrdersPage from "@/components/layouts/PastOrdersPage/PastOrdersPage";
import ProductList from "@/features/ProductList/components/ProductList";
import StaffListPage from "@/components/layouts/StaffListPage/StaffListPage";
import ProductManagementPage from "@/components/layouts/ProductManagementPage/ProductManagementPage";
import { JSX } from "react";

type RouteInfo = {
  title: string;
  path: string;
  element: JSX.Element;
  children?: RouteInfo[];
  defaultPage?: boolean;
};

export const mainRoutes: RouteInfo[] = [
  {
    title: "Welcome",
    path: "/",
    element: <App />,
  },
  {
    title: "",
    path: "/home",
    element: <HomePage />,
  },
  {
    title: "Login",
    path: "/login",
    element: <LoginPage />,
  },
];

export const adminRoutes: RouteInfo[] = [
  {
    title: "",
    path: "/admin-panel",
    element: <AdminPage />,
    children: [
      {
        title: "Staff Management",
        path: "staff-management",
        element: <StaffListPage />,
      },
      {
        title: "Product Management",
        path: "product-management",
        element: <ProductManagementPage />,
      },
    ],
  },
];

export const shopRoutes: RouteInfo[] = [
  {
    title: "",
    path: "/shop",
    element: <ListingPage />,
    children: [
      {
        title: "Product List",
        path: "products",
        element: <ProductList />,
        defaultPage: true,
      },
      {
        title: "Shopping Cart",
        path: "cart",
        element: <ShoppingCartPage />,
      },
      {
        title: "Old Orders",
        path: "orders",
        element: <PastOrdersPage />,
      },
    ],
  },
];
