import React from "react";
import { useLocation } from "react-router-dom";

function RateDetail() {
    const location = useLocation();

    const params = new URLSearchParams(location.search);
    const rate = JSON.parse(decodeURIComponent(params.get("rate")));

    if (!rate) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <div class="card mb-5">
                <div class="card-header">
                    <h1>{rate.country}</h1>
                </div>
                <div class="card-body">
                    <div className="row custom-div">
                        <div className="col-3">
                            <h5 className="border mb-5 ms-5">Move:</h5>
                            <h5 className="border mb-5 ms-5">Amount:</h5>
                            <h5 className="border mb-5 ms-5">Valid from:</h5>
                            <h5 className="border mb-5 ms-5">Currency:</h5>
                            <h5 className="border mb-5 ms-5">Buying rate:</h5>
                            <h5 className="border mb-5 ms-5">Selling rate:</h5>
                            <h5 className="border mb-5 ms-5">Midpoint rate:</h5>
                            <h5 className="border mb-5 ms-5">Currency buying rate:</h5>
                            <h5 className="border mb-5 ms-5">Currency selling rate:</h5>
                            <h5 className="border mb-5 ms-5">Currency midpoint rate:</h5>
                            <h5 className="border mb-5 ms-5">Version:</h5>
                            <h5 className="border mb-5 ms-5">CB midpoint rate:</h5>
                            <h5 className="border mb-5 ms-5">EUCB midpoint rate:</h5>
                        </div>
                        <div className="col-6">
                            <h5 className="border mb-5 ms-5">{rate.move}</h5>
                            <h5 className="border mb-5 ms-5">{rate.amount}</h5>
                            <h5 className="border mb-5 ms-5">{rate.validFrom}</h5>
                            <h5 className="border mb-5 ms-5">{rate.name}</h5>
                            <h5 className="border mb-5 ms-5">{rate.valBuy}</h5>
                            <h5 className="border mb-5 ms-5">{rate.valSell}</h5>
                            <h5 className="border mb-5 ms-5">{rate.valMid}</h5>
                            <h5 className="border mb-5 ms-5">{rate.currBuy}</h5>
                            <h5 className="border mb-5 ms-5">{rate.currSell}</h5>
                            <h5 className="border mb-5 ms-5">{rate.currMid}</h5>
                            <h5 className="border mb-5 ms-5">{rate.version}</h5>
                            <h5 className="border mb-5 ms-5">{rate.cnbMid}</h5>
                            <h5 className="border mb-5 ms-5">{rate.ecbMid}</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default RateDetail;
