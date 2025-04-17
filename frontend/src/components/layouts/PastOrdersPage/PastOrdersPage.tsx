import GenericTable from "@/components/GenericTable/GenericTable";

function PastOrdersPage() {
  const sampleData = [
    {
      id: 10284,
      order_date: "10/01/2025",
      fulfilment_date: "21/01/2025",
      status: "Completed",
      payment_method: "Credit Card",
    },
    {
      id: 10852,
      order_date: "12/01/2025",
      fulfilment_date: "26/01/2025",
      status: "Completed",
      payment_method: "Credit Card",
    },
    {
      id: 12857,
      order_date: "24/03/2025",
      fulfilment_date: "27/03/2025",
      status: "Completed",
      payment_method: "Credit Card",
    },
  ];
  return (
    <div>
      <GenericTable
        tableData={sampleData}
        columnData={[
          { accessor: "id", sortable: true },
          { accessor: "order_date", sortable: true },
          { accessor: "fulfilment_date", sortable: true },
          { accessor: "status", sortable: true },
          { accessor: "payment_method", sortable: true },
        ]}
      />
    </div>
  );
}

export default PastOrdersPage;
