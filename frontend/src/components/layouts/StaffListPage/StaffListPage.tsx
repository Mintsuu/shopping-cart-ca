import GenericTable from "@/components/GenericTable/GenericTable";
import { UserAccountDetails } from "@/types/User.types";
import { ActionIcon, Box, Group } from "@mantine/core";
import { IconEdit, IconTrash } from "@tabler/icons-react";

function StaffListPage() {
  const sampleUserList: UserAccountDetails[] = [
    {
      id: 1,
      firstName: "Mark",
      lastName: "Jacobs",
      address: "321 Street Near Me Singapore 548172",
      email: "mark@gmail.com",
      handPhoneNo: "91247821",
      role: "customer",
    },
    {
      id: 2,
      firstName: "Mary",
      lastName: "James",
      address: "582 Not Near Me Singapore 458197",
      email: "mary@gmail.com",
      handPhoneNo: "91246721",
      role: "staff",
    },
    {
      id: 3,
      firstName: "Paul",
      lastName: "Winters",
      address: "742 Telok Something Rd Singapore 758271",
      email: "paul@gmail.com",
      handPhoneNo: "8417247",
      role: "staff",
    },
    {
      id: 4,
      firstName: "Alfred",
      lastName: "Leer",
      address: "Blk 45 Tampines Not Street Singapore 75426",
      email: "Alfred@gmail.com",
      handPhoneNo: "9214576",
      role: "customer",
    },
  ];
  return (
    <Box>
      <GenericTable
        tableData={sampleUserList}
        columnData={[
          {
            accessor: "id",
            sortable: true,
          },
          {
            accessor: "firstName",
            sortable: true,
          },
          {
            accessor: "lastName",
            sortable: true,
          },
          {
            accessor: "role",
            sortable: true,
          },
          {
            accessor: "address",
            sortable: true,
          },
          {
            accessor: "email",
            sortable: true,
          },
          {
            accessor: "handPhoneNo",
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

export default StaffListPage;
