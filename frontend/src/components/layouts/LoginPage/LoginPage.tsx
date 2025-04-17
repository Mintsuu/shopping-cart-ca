import Logo from "@/assets/Logo";
import {
  Paper,
  TextInput,
  PasswordInput,
  Button,
  Anchor,
  Text,
  Container,
} from "@mantine/core";
import { useNavigate } from "react-router";

function LoginPage() {
  let navigate = useNavigate();
  return (
    <Container maw="480px" my={40}>
      <Text ta="center">
        <Logo size={62} />
      </Text>
      <Text c="dimmed" size="sm" ta="center" mt={5}>
        Do not have an account yet?{" "}
        <Anchor size="sm" component="button">
          Create account
        </Anchor>
      </Text>

      <Paper withBorder shadow="md" p={30} mt={30} radius="md">
        <TextInput label="Email" placeholder="you@mantine.dev" required />
        <PasswordInput
          label="Password"
          placeholder="Your password"
          required
          mt="md"
        />
        <Button fullWidth mt="xl" onClick={() => navigate("/shop/products")}>
          Sign in
        </Button>
      </Paper>
    </Container>
  );
}

export default LoginPage;
