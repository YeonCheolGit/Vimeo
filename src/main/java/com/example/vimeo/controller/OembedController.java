package com.example.vimeo.controller;


import com.example.vimeo.model.VimeoForm;
import com.example.vimeo.model.response.SingleResult;
import com.example.vimeo.service.OembedService;
import com.example.vimeo.service.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class OembedController {

    private OembedService oembedService;
    private ResponseService responseService;

    // 클라이언트에서 Vimeo 파싱 요청 받습니다.
    @GetMapping(value = "/oembed")
    public ResponseEntity<SingleResult<VimeoForm>> post(@RequestParam String url) {
        VimeoForm vimeoForm = oembedService.requestURI(url); // Vimeo 파싱 API request 합니다.
        return new ResponseEntity<>(responseService.getSingleResult(vimeoForm), HttpStatus.OK);
    }
}
