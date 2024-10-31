import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";


export function InsertActivityForm() {
  return (
    <div className="flex space-x-2 p-8">
      <Input type="date" className="max-w-[10rem]"/>
      <Input type="text" placeholder="Descrição"/>
      <Input type="number" className="w-max" placeholder="Valor"/>

      <Select>
        <SelectTrigger className="w-80">
          <SelectValue placeholder="Tipo" />
        </SelectTrigger>
        <SelectContent>
          <SelectItem value="0">Entrada</SelectItem>
          <SelectItem value="1">Saída</SelectItem>
        </SelectContent>
      </Select>
      <Button>Adicionar</Button>
    </div>
  )
}