import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { BASE_URL } from "../constants/constant.js";

const Confirmation = () => {
  const date = new Date();
  const { id } = useParams();

  const [order, setOrder] = useState([]);

  const getOrders = async (url) => {
    
    const response = await axios.get(url,{  timeout: 30000,
      headers: {
          'Content-Type': 'application/json'
      }});
    setOrder(response.data);
  };

  useEffect(() => {
    getOrders(`${BASE_URL}/orders/${id}`);
  }, []);

  const getFullDate = () => {
    return `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;
  };

  return (
    <>{
      order &&
      <div className="container py-5 h-100">
        <div className="row d-flex justify-content-center align-items-center h-100">
          <div className="col-lg-8 col-xl-6">
            <div className="card border-top border-bottom border-3">
              <div className="card-body p-5">
                <p className="lead fw-bold mb-5">Purchase Reciept</p>

                <div className="row">
                  <div className="col mb-3">
                    <p className="small text-muted mb-1">Date</p>
                    <p>{getFullDate()}</p>
                  </div>
                  <div className="col mb-3">
                    <p className="small text-muted mb-1">Order No.</p>
                    <p>{id}</p>
                  </div>
                </div>

                <div className="p-2 d-flex justify-content-center align-items-center">
                  <div
                    className="d-flex justify-content-center align-items-center"
                    style={{ width: "100vw" }}
                  >
                    <img className="img-fluid" src={order[0].photoUrl} />
                  </div>
                </div>

                <div className="mx-n5 px-5 py-4">
                  <div className="row">
                    <div className="col-md-8 col-lg-9">
                      <p>{order[0].name}</p>
                    </div>
                    <div className="col-md-4 col-lg-3">
                      <p>${order[0].price}</p>
                    </div>
                  </div>
                </div>

                <div className="row my-4">
                  <div className="col-md-4 offset-md-8 col-lg-3 offset-lg-9">
                    <p className="lead fw-bold mb-0">
                      ${order[0].price}
                    </p>
                  </div>
                </div>

                <p className="lead fw-bold mb-4 pb-2">
                  Your product is on the way!
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    }</>
  );
};

export default Confirmation;
