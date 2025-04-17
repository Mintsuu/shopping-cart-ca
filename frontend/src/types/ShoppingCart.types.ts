import { ProductInfo } from "./Product.types";

export type ShoppingCartItem = {
  id: number;
  product: ProductInfo;
  quantity: number;
};
