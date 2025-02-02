import React from "react";
import { apiGet } from "../utils/api";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function Form() {
    const [rates, setRates] = useState([]);

    useEffect(() => {
        apiGet("/api/v1?usedb=true").then((data) => { setRates(data) });
    }, []);

    const handleIcon = (name) => {
        return `./icons/${name}.png`;
    }


    if (rates == undefined) {
        return (<div>Loading...</div>)
    }

    return (
        <>
            <table className="table table-bordered table-striped rate-table">
                <thead className="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Country</th>
                        <th>Short name</th>
                        <th>Move</th>
                        <th>Amount</th>
                        <th>Valid from</th>
                        <th>Currency</th>
                        <th>Buying rate</th>
                        <th>Selling rate</th>
                        <th>Midpoint rate</th>
                        <th>Currency buying rate</th>
                        <th>Currency selling rate</th>
                        <th>Currency midpoint rate</th>
                        <th>Version</th>
                        <th>CB midpoint rate</th>
                        <th>EUCB midpoint rate</th>
                    </tr>
                </thead>
                <tbody>
                    {rates.map((rate, index) => (
                        <tr key={index + 1} className="text white">
                            <td><img src={handleIcon(rate.country.toLowerCase())} width={24} /></td>
                            <td>
                                <Link
                                    to={`/rates/show/${rate.country}?rate=${encodeURIComponent(JSON.stringify(rate))}`}
                                >
                                    {rate.country}
                                </Link>
                            </td>
                            <td>{rate.shortName}</td>
                            <td>{rate.move}</td>
                            <td>{rate.amount}</td>
                            <td>{rate.validFrom}</td>
                            <td>{rate.name}</td>
                            <td>{rate.valBuy}</td>
                            <td>{rate.valSell}</td>
                            <td>{rate.valMid}</td>
                            <td>{rate.currBuy}</td>
                            <td>{rate.currSell}</td>
                            <td>{rate.currMid}</td>
                            <td>{rate.version}</td>
                            <td>{rate.cnbMid}</td>
                            <td>{rate.ecbMid}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    )
}

export default Form;