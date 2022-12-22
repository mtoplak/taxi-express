import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";
import Home from "../Home";
import PageNotFound from "../PageNotFound/PageNotFound";
import Prijava from "../user/Prijava";
import Registracija from "../user/Registracija";
import Dodaj from "../Taksisti/Dodaj";
import Vsi from "../Taksisti/Vsi";
import Izbrisi from "../Taksisti/Izbrisi";
import Spremeni from "../Taksisti/Spremeni";
import Vse from "../TaksiSluzbe.js/Vse";
import IzbrisiTS from "../TaksiSluzbe.js/Izbrisi";
import SpremeniTS from "../TaksiSluzbe.js/Spremeni";
import DodajTS from "../TaksiSluzbe.js/Dodaj";
import Filtri from "../Filtri";

function Routing() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/prijava" element={<Prijava />} />
      <Route path="/registracija" element={<Registracija />} />
      <Route path="/Dodaj taksista" element={<Dodaj />} />
      <Route path="/Izbriši taksista" element={<Izbrisi />} />
      <Route path="/Spremeni taksista" element={<Spremeni />} />
      <Route path="/Vsi taksisti" element={<Vsi />} />
      <Route path="/Vse taksi službe" element={<Vse />} />
      <Route path="/Izbriši taksi službo" element={<IzbrisiTS />} />
      <Route path="/Spremeni taksi službo" element={<SpremeniTS />} />
      <Route path="/Dodaj taksi službo" element={<DodajTS />} />
      <Route path="/Iskanje s filtri" element={<Filtri />} />
      <Route path="*" element={<PageNotFound />} />
    </Routes>
  );
}

export default Routing;
