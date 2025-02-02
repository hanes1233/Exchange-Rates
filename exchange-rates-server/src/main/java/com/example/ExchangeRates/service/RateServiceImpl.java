package com.example.ExchangeRates.service;

import com.example.ExchangeRates.data.entity.Rate;
import com.example.ExchangeRates.data.repository.RateRepository;
import com.example.ExchangeRates.dto.RateDTO;
import com.example.ExchangeRates.mapper.RateMapper;
import com.example.ExchangeRates.service.api.RateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;
    private final RateMapper rateMapper;
    private final ObjectMapper objectMapper;

    @Value("${external.api.url}")
    private String apiUrl;

    @Override
    public List<RateDTO> getAllRates() {
        List<Rate> rates = rateRepository.findAll();
        return rates.stream().map(rateMapper::mapToRateDTO).toList();
    }

    @Override
    public List<RateDTO> fetchFromUrl() throws IOException {
        String jsonRates = fetchJsonFromUrl(apiUrl).toString();

        List<RateDTO> rateDTOS = objectMapper
                .readValue(jsonRates, objectMapper.getTypeFactory().constructCollectionType(List.class, RateDTO.class));

        rateDTOS.stream()
                .map(rateMapper::mapToRate)
                .filter(rate -> !rateRepository.existsByCountry(rate.getCountry()))
                .forEach(rateRepository::save);
        return rateDTOS;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONArray fetchJsonFromUrl(String url) throws IOException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONArray(jsonText);
        } catch (IOException | JSONException ex) {
            throw new IOException("Error reading JSON from url: " + url, ex);
        }
    }
}