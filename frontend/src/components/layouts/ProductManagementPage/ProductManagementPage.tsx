import GenericTable from "@/components/GenericTable/GenericTable";
import { ProductInfo } from "@/types/Product.types";
import { ActionIcon, Box, Group } from "@mantine/core";
import { IconEdit, IconTrash } from "@tabler/icons-react";

function ProductManagementPage() {
  const sampleProductList: ProductInfo[] = [
    {
      id: 1,
      name: "Laptop Pro X1",
      unitPrice: 1499.99,
      stock: 50,
      category: "Electronics",
      image: "",
    },
    {
      id: 2,
      name: "Wireless Optical Mouse",
      unitPrice: 24.5,
      stock: 200,
      category: "Electronics",
      image: "",
    },
  ];
  return (
    <Box>
      <GenericTable
        tableData={sampleProductList}
        columnData={[
          {
            accessor: "id",
            sortable: true,
          },
          {
            accessor: "image",
          },
          {
            accessor: "name",
            sortable: true,
          },
          {
            accessor: "unitPrice",
            sortable: true,
            render: (record) => <>${Number(record.unitPrice).toFixed(2)}</>,
          },
          {
            accessor: "stock",
            sortable: true,
            render: (record) => <>{record.stock}x</>,
          },
          {
            accessor: "category",
            sortable: true,
          },
          {
            accessor: "Actions",
            render: () => (
              <Group>
                <ActionIcon variant="light" color="orange">
                  <IconEdit
                    style={{ width: "70%", height: "70%" }}
                    stroke={1.5}
                  />
                </ActionIcon>
                <ActionIcon variant="light" color="red">
                  <IconTrash
                    style={{ width: "70%", height: "70%" }}
                    stroke={1.5}
                  />
                </ActionIcon>
              </Group>
            ),
          },
        ]}
      />
    </Box>
  );
}

export default ProductManagementPage;
