package com.ideal.gestion_note.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideal.gestion_note.model.Student;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;

public class StudentService {

    private static final String BASE_URL = "http://localhost:8085/api/etudiant";
    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Student> findAll() {
        HttpResponse<String> response = Unirest.get(BASE_URL).asString();

        if (response.isSuccess()) {
            try {
                return mapper.readValue(response.getBody(), new TypeReference<>() {
                });
            } catch (Exception e) {
                throw new RuntimeException("Erreur de parsing JSON (findAll)", e);
            }
        } else {
            throw new RuntimeException(response.getBody());
        }
    }

    public Student create(Student etudiant) {
        HttpResponse<String> response = Unirest.post(BASE_URL)
                .header("Content-Type", "application/json")
                .body(etudiant)
                .asString();

        if (response.isSuccess()) {
            try {
                return mapper.readValue(response.getBody(), Student.class);
            } catch (Exception e) {
                throw new RuntimeException("Erreur de parsing JSON (create)", e);
            }
        } else {
            throw new RuntimeException(response.getBody());
        }
    }

    public void update(String numEt, Student etudiant) {
        HttpResponse<String> response = Unirest.put(BASE_URL + "/" + numEt)
                .header("Content-Type", "application/json")
                .body(etudiant)
                .asString();

        if (response.isSuccess()) {
            try {
                mapper.readValue(response.getBody(), Student.class);
            } catch (Exception e) {
                throw new RuntimeException("Erreur de parsing JSON (update)", e);
            }
        } else {
            throw new RuntimeException(response.getBody());
        }
    }

    public void delete(String numEt) {
        HttpResponse<String> response = Unirest.delete(BASE_URL + "/" + numEt).asString();

        if (!response.isSuccess()) {
            throw new RuntimeException(response.getBody());
        }
    }
}