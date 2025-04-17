import {
  Badge,
  Button,
  Group,
  Image,
  Input,
  Paper,
  SimpleGrid,
  Stack,
  Text,
  Title,
  useMantineTheme,
} from "@mantine/core";
import Product from "./Product";
import { IconSearch } from "@tabler/icons-react";

function ProductList() {
  const theme = useMantineTheme();
  return (
    <Stack>
      <Group>
        <Input
          placeholder="Search products..."
          leftSection={<IconSearch size={16} />}
          w="100%"
          size="lg"
        />
      </Group>
      <SimpleGrid cols={4}>
        {[...new Array(50)].map((_) => (
          <Product />
        ))}
      </SimpleGrid>
    </Stack>
  );
}

export default ProductList;
