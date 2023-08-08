package com.example.filter_exercise.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class FilterController {

    /*
        Filter 예시
        http://localhost:8080/xss?script=<script>black<script>
     */
    @GetMapping("/xss")
    public String test(@RequestParam String script) {;
        log.info("[Controller] Xss Filtering Result :[{}]",script);
        return "XSS";
    }

    /*
        OncePerRequestFilter 예시
        http://localhost:8080/will-redirect
        http://localhost:8080/will-forward
     */
    @GetMapping("/will-redirect")
    public void willRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/redirected");
    }

    @GetMapping("/redirected")
    public String redirected() {
        return "redirected";
    }

    @GetMapping("/will-forward")
    public void willForward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/forwarded").forward(request, response);
    }

    @GetMapping("/forwarded")
    public String forwarded() {
        return "forwarded";
    }
}