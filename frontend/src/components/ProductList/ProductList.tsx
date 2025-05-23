import { SimpleGrid, Skeleton, Stack } from "@mantine/core";
import Product from "./Product";
import useProductList from "./useProductList.hook";
import ComponentLoader from "@/components/ComponentLoader/ComponentLoader";

function ProductList() {
  const { isLoading, productList } = useProductList();

  if (isLoading) return <ComponentLoader />;
  if (!productList || productList.length === 0)
    return [...new Array(16)].map((_, index) => (
      <Skeleton height={300} key={index} />
    ));
  return (
    <Stack>
      <SimpleGrid cols={4}>
        {productList.map((product) => (
          <Product {...product} />
        ))}
      </SimpleGrid>
    </Stack>
  );
}

export default ProductList;
