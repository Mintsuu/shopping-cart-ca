import { Paper, Stack, Group, Badge, Image, Text, Button } from "@mantine/core";
import { useHover } from "@mantine/hooks";

function Product() {
  return (
    <Paper maw={300} shadow="md" p="md" m="md">
      <Stack gap={0}>
        <Image
          fit="contain"
          radius="md"
          w={250}
          mx="auto"
          src="https://media.istockphoto.com/id/1055079680/vector/black-linear-photo-camera-like-no-image-available.jpg?s=612x612&w=0&k=20&c=P1DebpeMIAtXj_ZbVsKVvg-duuL0v9DlrOZUvPG6UJk="
        />
        <Group align="flex-start" justify="flex-start">
          <Stack gap={0}>
            <Badge size="xs" variant="light" color="green">
              Vegetables
            </Badge>
            <Text fw={500} size="md" ta="center">
              Chinese Bokchoy from China
            </Text>
            <Text fw={700}>$5.50</Text>
            <Text size="xs" c="dimmed">
              12x units remaining
            </Text>
          </Stack>
          <Button variant="light" fullWidth color="orange">
            Add to cart
          </Button>
        </Group>
      </Stack>
    </Paper>
  );
}

export default Product;
