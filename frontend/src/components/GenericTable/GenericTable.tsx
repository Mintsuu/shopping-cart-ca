import {
  DataTable,
  DataTableColumn,
  type DataTableSortStatus,
} from "mantine-datatable";
import sortBy from "lodash/sortBy";
import { useEffect, useState } from "react";

type GenericTableProps = {
  tableData: any[];
  columnData: DataTableColumn[];
};

function GenericTable({ ...props }: GenericTableProps) {
  const [sortStatus, setSortStatus] = useState<DataTableSortStatus>({
    columnAccessor: "name",
    direction: "asc",
  });

  useEffect(() => {
    const data = sortBy(props.tableData, sortStatus.columnAccessor);
    setRecords(sortStatus.direction === "desc" ? data.reverse() : data);
  }, [sortStatus]);

  const [records, setRecords] = useState(sortBy(props.tableData, "name"));
  return (
    <DataTable
      highlightOnHover
      striped
      emptyState
      minHeight={150}
      columns={props.columnData}
      records={records}
      sortStatus={sortStatus}
      onSortStatusChange={setSortStatus}
    />
  );
}

export default GenericTable;
