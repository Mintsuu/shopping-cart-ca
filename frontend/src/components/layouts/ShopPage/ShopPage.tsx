import AppShellContent from "@/features/AppShellLayout/components/AppShellContent";
import AppShellHeader from "@/features/AppShellLayout/components/AppShellHeader";
import AppShellSidebarNav from "@/features/AppShellLayout/components/AppShellSidebarNav";
import { NavbarLink } from "@/types/AppShellSidebarNav.types";
import { AppShell } from "@mantine/core";
import { useDisclosure } from "@mantine/hooks";

function ShopPage() {
  const [opened, { toggle }] = useDisclosure();
  const sampleDashboardCategories: NavbarLink[] = [
    {
      label: "Shopping Cart",
      link: "/shop/cart",
    },
    {
      label: "View Orders",
      link: "/shop/orders",
    },
  ];
  const sampleCategories: NavbarLink[] = [
    {
      label: "View all",
      link: "/shop/products",
    },
    {
      label: "Vegetables",
      link: "/shop/products",
    },
    {
      label: "Frozen Meats",
      link: "/shop/products",
    },
    {
      label: "Fruits",
      link: "/shop/products",
    },
    {
      label: "Cereal",
      link: "/shop/products",
    },
    {
      label: "Bread",
      link: "/shop/products",
    },
    {
      label: "Party Supplies",
      link: "/shop/products",
    },
    {
      label: "Baking Supplies",
      link: "/shop/products",
    },
  ];
  return (
    <AppShell
      header={{ height: 59 }}
      navbar={{ width: 299, breakpoint: "sm", collapsed: { mobile: !opened } }}
    >
      <AppShellHeader opened={opened} toggle={toggle} />
      <AppShellSidebarNav
        defaultSection="View all"
        navSection={[
          {
            sectionHeader: "Dashboard",
            links: [...sampleDashboardCategories],
          },
          { sectionHeader: "Product Categories", links: [...sampleCategories] },
        ]}
      />
      <AppShellContent />
    </AppShell>
  );
}

export default ShopPage;
