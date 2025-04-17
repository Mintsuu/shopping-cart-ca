import AppShellContent from "@/features/AppShellLayout/components/AppShellContent";
import AppShellHeader from "@/features/AppShellLayout/components/AppShellHeader";
import AppShellSidebarNav from "@/features/AppShellLayout/components/AppShellSidebarNav";
import { NavbarLink } from "@/types/AppShellSidebarNav.types";
import { AppShell } from "@mantine/core";
import { useDisclosure } from "@mantine/hooks";

function AdminPage() {
  const [opened, { toggle }] = useDisclosure();
  const sampleAdminCategories: NavbarLink[] = [
    {
      label: "Staff Control Panel",
      link: "/admin-panel/staff-management",
    },
    {
      label: "Product Control Panel",
      link: "/admin-panel/product-management",
    },
  ];

  return (
    <AppShell
      header={{ height: 59 }}
      navbar={{ width: 299, breakpoint: "sm", collapsed: { mobile: !opened } }}
    >
      <AppShellHeader opened={opened} toggle={toggle} />
      <AppShellSidebarNav
        defaultSection="Staff Control Panel"
        navSection={[
          {
            sectionHeader: "Admin Tools",
            links: [...sampleAdminCategories],
          },
        ]}
      />
      <AppShellContent />
    </AppShell>
  );
}

export default AdminPage;
