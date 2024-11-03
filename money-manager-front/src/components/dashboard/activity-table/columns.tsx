"use client"

import { Button } from "@/components/ui/button"
import { ColumnDef } from "@tanstack/react-table"

// This type is used to define the shape of our data.
// You can use a Zod schema here if you want.
export type Activity = {
  id: string
  date: Date
  description: string
  value: number,
  type: "expense" | "revenue"
}

export const columns: ColumnDef<Activity>[] = [
  {
    accessorKey: "date",
    header: "Data",
    cell: ({row}) => {
      const aDate = row.getValue("date") as Date;
      const formatedDate = aDate.getDate() + "/" + (aDate.getMonth() + 1) + "/" + aDate.getFullYear();
      return <p>{formatedDate}</p>
    }
  },
  {
    accessorKey: "description",
    header: "Descrição",
  },
  {
    accessorKey: "value",
    header: "Valor",
    cell: ({row}) => {
      const aValue = row.getValue("value") as number;

      const aType = row.getValue("type")
      const formatedValue = aValue.toLocaleString("pt-BR", {minimumFractionDigits: 2, maximumFractionDigits: 2})

      const valueClass = (aType === "revenue") ? "text-emerald-500" : "text-red-500"
      return <p className={valueClass}>R$ {formatedValue}</p>
    }
  },  
  {
    accessorKey: "type",
    header: "Tipo",
    cell: ({row}) => {
      const aType = row.getValue("type")
      const formatedType = (aType === "revenue") ? "Entrada" : "Saída"
      const valueClass = (aType === "revenue") ? "text-emerald-500" : "text-red-500"
      return <p className={valueClass}>{formatedType}</p>
    }
  },
  {
    id: "action",
    header: "Ações",
    cell: ({row}) => {
      return <Button variant={"secondary"}>Remover</Button>
    },
  }
]
