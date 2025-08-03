package com.webutil.urlshortener.Controller;

import com.webutil.urlshortener.Dto.ShortUrlDto;
import com.webutil.urlshortener.Entity.ShortUrl;
import com.webutil.urlshortener.Service.ShortUrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@RestController
public class ShortUrlController {

    @Autowired
    ShortUrlService shortUrlService;

    //URL to obtain long url and convert it into short url
    @PostMapping("/{userId}/shortUrl")
    public ResponseEntity<String> getShortUrl(@PathVariable String userId, @RequestBody ShortUrlDto shortUrlDto,
                                              HttpServletRequest request) throws NoSuchAlgorithmException {
        String shortUrl = shortUrlService.convertToShortUrl(Long.valueOf(userId),shortUrlDto);
        String fullShortUrl = request.getScheme() + "://" +
                request.getServerName() + ":" +
                request.getServerPort() + "/" +
                shortUrl;
        return new ResponseEntity<>(fullShortUrl, HttpStatus.OK);
    }

    @GetMapping("/{shortUrl}")
    public void redirectToUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        try {
            ShortUrl longUrl = shortUrlService.getLongUrl(shortUrl);
            response.sendRedirect(longUrl.getOriginalUrl());
        } catch (Exception e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST," No such URL Found");
        }
    }

}
