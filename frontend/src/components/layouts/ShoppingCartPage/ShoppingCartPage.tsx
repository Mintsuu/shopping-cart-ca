import GenericTable from "@/components/GenericTable/GenericTable";
import { ShoppingCartItem } from "@/types/ShoppingCart.types";
import {
  ActionIcon,
  Box,
  Group,
  NumberInput,
  Text,
  Title,
} from "@mantine/core";
import { IconEdit, IconTrash } from "@tabler/icons-react";
import { useState } from "react";

function ShoppingCartPage() {
  const [cartItems, setCartItems] = useState<ShoppingCartItem[]>([
    {
      id: 1,
      product: {
        id: 1000,
        category: "Vegetables",
        name: "Bok Choy from China",
        stock: 7,
        unitPrice: 5.6,
        image: "",
      },
      quantity: 4,
    },
    {
      id: 2,
      product: {
        id: 1001,
        category: "Vegetables",
        name: "Kailan From Malaysia",
        stock: 4,
        unitPrice: 3.2,
        image: "",
      },
      quantity: 18,
    },
  ]);
  const handleInputChange = (cartItemId: number, value: number) => {
    const newValues = [...cartItems];
    // newValues[index].quantity = value;
    newValues.map((item) => {
      if (item.id === cartItemId) {
        item.quantity = value;
      }
      return item;
    });
    setCartItems(newValues);
  };

  return (
    <Box>
      <GenericTable
        columnData={[
          {
            accessor: "id",
            sortable: true,
            width: 100,
            render: (record) => {
              const cartItem = record as ShoppingCartItem;
              return cartItem.product.id;
            },
          },
          {
            accessor: "pic",
            sortable: true,
            render: (record) => {
              const cartItem = record as ShoppingCartItem;
              return cartItem.product.image;
            },
          },
          {
            accessor: "name",
            sortable: true,
            render: (record) => {
              const cartItem = record as ShoppingCartItem;
              return cartItem.product.name;
            },
          },
          {
            accessor: "category",
            sortable: true,
            render: (record) => {
              const cartItem = record as ShoppingCartItem;
              return cartItem.product.category;
            },
          },
          {
            accessor: "quantity",
            sortable: true,
            width: 100,
            render: (record) => {
              const cartItem = record as ShoppingCartItem;
              return (
                <NumberInput
                  clampBehavior="strict"
                  defaultValue={cartItem.quantity}
                  onChange={(value) =>
                    handleInputChange(cartItem.id, Number(value))
                  }
                />
              );
            },
          },
          {
            accessor: "unitPrice",
            sortable: true,
            width: 100,
            render: (record) => {
              const cartItem = record as ShoppingCartItem;
              return `$${cartItem.product.unitPrice.toFixed(2)}`;
            },
          },
          {
            accessor: "totalPrice",
            sortable: true,
            width: 100,
            render: (record) => {
              const cartItem = record as ShoppingCartItem;
              return `$${(
                cartItem.quantity * cartItem.product.unitPrice
              ).toFixed(2)}`;
            },
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
        tableData={cartItems}
      />
      <Group justify="flex-start">
        <Title order={2} fw={700}>
          Grand Total:
        </Title>
        <Text size="lg">
          $
          {cartItems
            .reduce(
              (grandTotal, currItem) =>
                currItem.quantity * currItem.product.unitPrice + grandTotal,
              0
            )
            .toFixed(2)}
        </Text>
      </Group>
    </Box>
  );
}

export default ShoppingCartPage;
