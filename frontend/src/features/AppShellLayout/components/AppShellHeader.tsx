import Logo from "@/assets/Logo";
import { AppShell, Burger, Group } from "@mantine/core";

type AppShellHeaderProps = {
  opened: boolean;
  toggle: () => void;
};

function AppShellHeader({ ...props }: AppShellHeaderProps) {
  return (
    <AppShell.Header>
      <Group h="99%" px="md">
        <Burger
          opened={props.opened}
          onClick={props.toggle}
          hiddenFrom="sm"
          size="sm"
        />
        <Logo size={23} />
      </Group>
    </AppShell.Header>
  );
}

export default AppShellHeader;
