import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { usePostData } from "../hooks/usePostHook";
import { loadStripe } from "@stripe/stripe-js";
import { CardElement, Elements, useElements, useStripe } from "@stripe/react-stripe-js";
import axiosInstance from "../lib/axios";
import axios from "axios";
import { BASE_URL } from "../constants/constant.js";

const PUBLISH_KEY = "pk_test_51PH9pL2M65FTRRLcMccCrl5WjPWftwrmPzq2NNGDP8qmZ5RLwc9Ohts4ownPBa9irjQM8H8hX5X9eyStHc2bAokx00nWFBaK2w"


const Transaction = () => {
  const { id } = useParams();
  const stripePromise = loadStripe(PUBLISH_KEY)
  const [product, setProduct] = useState();

  const getProduct = async (url) => {
    
    const response = await axios.get(url,{  timeout: 30000,
      headers: {
          'Content-Type': 'application/json'
      }});
    setProduct(response.data);
  };

  useEffect(() => {
    getProduct(`${BASE_URL}/product/${id}`);
  }, []);


  return (
    <div className="container">
       <h2 className="h1 py-3 text-center text-success">Proceed payment</h2>
      {product && <section className="p-4 p-md-5">
        <div className="row d-flex justify-content-center">
          <div className="d-flex align-items-center justify-content-center">
            <Elements stripe={stripePromise}>
              <FormTransaction data={product}/>
            </Elements>
            </div>
          </div>
      </section>}
    </div>
  );
};

const FormTransaction = ({data}) => {
  const stripe = useStripe()
  const elements = useElements()
  const [intent, setIntent] = useState(null)
  const navigate = useNavigate()
  
  const { postData } = usePostData(`/transaction/stripe/${data.price}`)
  
  const getIntent = async () => {
    setIntent(await postData());
  }

  useEffect(() => {
    getIntent()
  }, [])


  const [formData, setFormData] = useState({
    address: "",
    city: "",
    state: "",
    zip: "",
    cardholderName: "",
    cardNumber: "",
    expiry: "",
    cvv: "",
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    if (name === "expiry" && formData.expiry.length > 3) return false;
    if (name === "cvv" && formData.cvv.length > 2) return false;
    if (name === "cardNumber" && formData.cardNumber.length > 15) return false;
    setFormData({
      ...formData,
      [name]: value,
    });
  };
  
  const handleFormSubmit = async (e) => {
    e.preventDefault();
    if (!stripe || !elements) return;

    const payload = await stripe.confirmCardPayment(intent, {
      payment_method: {
        card: elements.getElement(CardElement),
      },
    });

    if (payload.error) {
      console.error(`Payment failed ${payload.error.message}`)
    } else {
      const response = await axiosInstance.post(`/orders`, {
        items: [data],
        subTotal: data.price,
        finalPrice: data.price,
        discount: 0,
        paymentId: payload.paymentIntent.id
      })
      navigate(`/confirmation/${response.data}`)
    }

  };

  return (
    <div className="card rounded-2" style={{ border: "none" }}>
      <div className="card-body p-4">
        <form action="">
          <p className="fw-bold mb-4">MAKE PAYMENT:</p>

          <div data-mdb-input-init className="form-outline mb-4">
            <input
              type="text"
              className="form-control form-control-lg"
              value={formData.address}
              placeholder="20 Cooper Square"
              onChange={handleInputChange}
              name="address"
            />

          </div>

          <div className="row mb-4">
            <div className="col-8">
              <div data-mdb-input-init className="form-outline">
                <input
                  type="text"
                  className="form-control form-control-lg"
                  value={formData.city}
                  placeholder="New York"
                  onChange={handleInputChange}
                  name="city"
                />
              </div>
            </div>
            <div className="col-4">
              <div data-mdb-input-init className="form-outline">
                <input
                  type="text"
                  className="form-control form-control-lg"
                  placeholder="NY"
                  name="state"
                  value={formData.state}
                  onChange={handleInputChange}
                />
              </div>
            </div>
          </div>

          <div data-mdb-input-init className="form-outline mb-4">
            <input
              type="text"
              className="form-control form-control-lg"
              value={formData.cardholderName}
              placeholder="Anna Doe"
              onChange={handleInputChange}
              name="cardholderName"
            />

          </div>

          <div className="row mb-4">
            <CardElement />
          </div>

          <button
            data-mdb-button-init
            data-mdb-ripple-init
            className="btn btn-success btn-lg btn-block w-100"
            onClick={handleFormSubmit}
          >
            Make Payment
          </button>
        </form>
      </div>
    </div>
  )

}

export default Transaction;
