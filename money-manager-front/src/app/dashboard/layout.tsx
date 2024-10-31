import { BadgeDollarSign } from "lucide-react";
import React from "react";

export default function DashboardLayout({children}: { children: React.ReactNode }) {
  return (
    <>
      <div className="container flex gap-4 bg-slate-800 items-center m-auto h-20 rounded-xl shadow-xl">
        <BadgeDollarSign className="text-emerald-400" size={48}/>
        <h1 className="uppercase text-slate-100 font-bold text-3xl">Money Manager</h1>
      </div>
      <div className="container items-center gap-4 w-md m-auto mt-2 rounded-xl shadow-xl bg-slate-50 h-48">
        {children}
      </div>

    </>
  )
}