package com.example.ExchangeRates.service.api;

import com.example.ExchangeRates.dto.RateDTO;
import com.example.ExchangeRates.data.entity.Rate;

import java.io.IOException;
import java.util.List;

public interface RateService {

    /**
     * Fetch {@link Rate} objects from database and map to {@link RateDTO}'s.
     * @return {@link List} of {@link RateDTO}'s.
     */
    List<RateDTO> getAllRates();

    /**
     * Fetch {@link Rate} objects from provided {@code url}.
     * <p>Method's flow: </p>
     * <ol>
     *     <li>Fetch {@link Rate}'s as {@code JSON} and write as raw {@link String}</li>
     *     <li>Map raw {@link String} to list of {@link RateDTO}'s</li>
     *     <li>Run {@code stream}, where :
     *         <ul>
     *           <li>Map each {@link RateDTO} to a {@link Rate} object</li>
     *           <li>Filter elements to include only those whose records do not exist in the database</li>
     *           <li>Save non-existent {@link Rate}s to the database</li>
     *          </ul>
     *     </li>
     * </ol>
     * @return
     * @throws IOException
     */
    List<RateDTO> fetchFromUrl() throws IOException;
}
