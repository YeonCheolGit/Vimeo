package com.example.vimeo.service;

import com.example.vimeo.advice.exception.WrongURL;
import com.example.vimeo.model.VimeoForm;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@Service
public class OembedService {

    private final Gson gson;
    private ResponseService responseService;

    // 올바른 Vimeo URL: e.g. https://vimeo.com/20097015
    private final String urlRegex = "^https://vimeo.com/[0-9]+$";
    private final String baseUrl = "https://vimeo.com/api/oembed.json?url=";

    // Vimeo 파싱 API request 합니다.
    public VimeoForm requestURI(String url) {
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(url);

        if (matcher.find() == false)
            throw new WrongURL("잘못된 URL 입력 입니다.");

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + url, String.class);

        if (response.getStatusCode() == HttpStatus.OK)
            return gson.fromJson(response.getBody(), (Type) VimeoForm.class);

        return null;
    }
}
