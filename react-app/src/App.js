import React from "react";
import Home from "./pages/HomePage.js";
import Transaction from "./pages/TransactionPage.js";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Confirmation from "./pages/Confirmation.js";

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="" element={<Home />} />
        <Route exact path="/transaction/:id" element={<Transaction />} />
        <Route exact path="/confirmation/:id" element={<Confirmation />} />
      </Routes>
    </Router>
  );
}

export default App;
