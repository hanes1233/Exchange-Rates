
const API_URL = "http://localhost:8080";

const fetchData = (url, requestOptions) => {
    const apiUrl = `${API_URL}${url}`;

    return fetch(apiUrl, requestOptions)
        .then((response) => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status} ${response.statusText}`);
            }

            if (requestOptions.method !== 'DELETE')
                return response.json();
        })
        .catch((error) => {
            throw error;
        });
};

export const apiGet = (url, params) => {

    const apiUrl = `${url}`;
    const requestOptions = {
        method: "GET",
    };

    return fetchData(apiUrl, requestOptions);
};
