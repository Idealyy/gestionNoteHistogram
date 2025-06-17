package com.ideal.gestion_note.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideal.gestion_note.model.MoyenneResume;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class ResumeService {

    private static final String BASE_URL = "http://localhost:8085/api/views/etudiant-moyenne";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static MoyenneResume getResume() {
        HttpResponse<String> response = Unirest.get(BASE_URL).asString();
        if (response.isSuccess()) {
            try {
                return mapper.readValue(response.getBody(), new TypeReference<>() {
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException(response.getBody());
        }
    }
}
