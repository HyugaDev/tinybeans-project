import React from "react";
import { Link } from "react-router-dom";

export function ProductCard({ Item }) {
  return (
    <div className="card" style={{ width: "26rem", border:"none" }}>
      <img src={Item.photoUrl} alt="..." />
      <div className="card-body">
        <div className="d-flex justify-content-between">
          <h4 className="card-title">{Item.name}</h4>
          <p className="h4">${Item.price}</p>
        </div>
        <p className="card-text text-justify">{Item.description}</p>
        <Link to={`/transaction/${Item.id}`} className="btn btn-success btn-lg w-100" >
          Buy
        </Link>
      </div>
    </div>
  );
}
