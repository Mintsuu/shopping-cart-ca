import { Container, Group, Button, Text, Box } from "@mantine/core";
import { IconBrandGithub } from "@tabler/icons-react";
import { useNavigate } from "react-router";
import Logo from "@/assets/Logo";
function HomePage() {
  let navigate = useNavigate();
  return (
    <Container size={700}>
      <Text
        ta="center"
        fw={900}
        style={{ fontSize: "62px", lineHeight: "1.1" }}
      >
        Welcome to <Logo size={62} />
      </Text>

      <Box my="md">
        <Text color="dimmed">
          You won't see fruits more a-peel-ing than ours! Orange you glad you
          found your new favorite supermarket? You'll be bananas for fresh
          produce!
        </Text>
      </Box>

      <Group align="center" justify="center" my="md">
        <Button
          size="xl"
          variant="gradient"
          gradient={{ from: "teal", to: "lime" }}
          onClick={() => navigate("/login")}
        >
          Login to App
        </Button>

        <Button
          component="a"
          href="https://github.com/Mintsuu/shopping-cart-ca"
          target="_blank"
          size="xl"
          variant="default"
          leftSection={<IconBrandGithub size={20} />}
        >
          GitHub
        </Button>
      </Group>
    </Container>
  );
}

export default HomePage;
