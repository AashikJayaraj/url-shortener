package com.webutil.urlshortener.Controller;

import com.webutil.urlshortener.Dto.ShortUrlDto;
import com.webutil.urlshortener.Service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortUrlController {

    @Autowired
    ShortUrlService shortUrlService;

    //URL to obtain long url and conver it into short url
    @GetMapping("/user/{userId}/shortUrl")
    public ResponseEntity<String> getShortUrl(@PathVariable String userId, @RequestBody ShortUrlDto shortUrlDto){
        String shortUrl = shortUrlService.convertToShortUrl(Long.valueOf(userId),shortUrlDto);
        return new ResponseEntity<>(shortUrl, HttpStatus.OK);
    }

    /*Placeholder function for url redirect
    public String redirectToUrl(){
    }
     */
}
