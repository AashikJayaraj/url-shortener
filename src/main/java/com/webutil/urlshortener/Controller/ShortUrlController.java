package com.webutil.urlshortener.Controller;

import com.webutil.urlshortener.Dto.ShortUrlDto;
import com.webutil.urlshortener.Entity.ShortUrl;
import com.webutil.urlshortener.Service.ShortUrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.NoSuchAlgorithmException;

@RestController
public class ShortUrlController {

    @Autowired
    ShortUrlService shortUrlService;

    //URL to obtain long url and convert it into short url
    @GetMapping("/user/{userId}/shortUrl")
    public ResponseEntity<String> getShortUrl(@PathVariable String userId, @RequestBody ShortUrlDto shortUrlDto) throws NoSuchAlgorithmException {
        String shortUrl = shortUrlService.convertToShortUrl(Long.valueOf(userId),shortUrlDto);
        return new ResponseEntity<>(shortUrl, HttpStatus.OK);
    }

    public void redirectToUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        ShortUrl longUrl = shortUrlService.getLongUrl(shortUrl);
        response.sendRedirect(longUrl.getOriginalUrl());
    }

}
