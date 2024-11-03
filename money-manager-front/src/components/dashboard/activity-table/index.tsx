import { Activity, columns } from "./columns"
import { DataTable } from "./data-table"

const data: Activity[] = [
  {
    id: "1",
    date: new Date("07-25-2023"),
    description: "Conta de luz",
    value: 250.95,
    type: "expense"
  },
  {
    id: "2",
    date: new Date("07-25-2023"),
    description: "Conta de internet",
    value: 90.95,
    type: "expense"
  },
  {
    id: "3",
    date: new Date("07-25-2023"),
    description: "Aluguel",
    value: 1000.05,
    type: "expense"
  },
  {
    id: "4",
    date: new Date("07-25-2023"),
    description: "Salario",
    value: 3000,
    type: "revenue"
  },

]
function getData(): Activity[] {
  // Fetch data from your API here.
  return data;
}

export async function ActivityTable() {
  const data = await getData()

  return (
    <div className="container mx-auto">
      <DataTable columns={columns} data={data} />
    </div>
  )
}
