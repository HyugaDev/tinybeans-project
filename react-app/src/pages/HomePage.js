import React, { useEffect, useState } from "react";
import { ProductCard } from "../components/ProductCard.js";
import axios from "axios";
import { BASE_URL } from "../constants/constant.js";


function Home() {
  const [products, setProducts] = useState([]);

  const getProducts = async (url) => {
    
    const response = await axios.get(url,{  timeout: 30000,
      headers: {
          'Content-Type': 'application/json'
      }});
    setProducts(response.data);
  };

  useEffect(() => {
    getProducts(`${BASE_URL}/product`);
  }, []);

  return (
    <div className="container">
      <h2 className="h1 py-5 text-left text-success">Select a product</h2>
      <div className="row justify-content-center">
        {products &&
          products.map((item) => {
            return (
              <div
                className="col-lg-4 mb-4 d-flex align-items-center justify-content-center"
                key={item.id}
              >
                <ProductCard Item={item} />
              </div>
            );
          })}
      </div>
    </div>
  );
}

export default Home;
