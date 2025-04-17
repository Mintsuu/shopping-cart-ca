import { AppShell, Box, Text } from "@mantine/core";
import { IconLogout } from "@tabler/icons-react";
import classes from "./AppShellSidebarNav.module.css";
import { Link } from "react-router";
import { useState } from "react";
import { NavbarLink } from "@/types/AppShellSidebarNav.types";

type AppShellSidebarNavProps = {
  navSection: {
    sectionHeader: string;
    links: NavbarLink[];
  }[];
  defaultSection?: string;
};

function AppShellSidebarNav({ ...props }: AppShellSidebarNavProps) {
  const [active, setActive] = useState(props.defaultSection);
  const navbarCategories = props.navSection.map((category) => (
    <>
      <Text py="md" fw={500} size="xs" color="dimmed">
        {category.sectionHeader}
      </Text>
      {category.links.map((link) => (
        <Link
          to={link.link}
          className={classes.link}
          data-active={link.label === active || undefined}
          key={link.label}
          onClick={() => setActive(link.label)}
        >
          <span>{link.label}</span>
        </Link>
      ))}
    </>
  ));

  return (
    <AppShell.Navbar>
      <Box m="md" className={classes.navbarMain}>
        {navbarCategories}
      </Box>

      <Box m="md" className={classes.footer}>
        <a
          href="#"
          className={classes.link}
          onClick={(event) => event.preventDefault()}
        >
          <IconLogout className={classes.linkIcon} stroke={1.5} />
          <span>Logout</span>
        </a>
      </Box>
    </AppShell.Navbar>
  );
}

export default AppShellSidebarNav;
