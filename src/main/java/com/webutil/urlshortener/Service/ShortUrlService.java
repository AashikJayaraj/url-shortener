package com.webutil.urlshortener.Service;

import com.webutil.urlshortener.Dto.ShortUrlDto;
import com.webutil.urlshortener.Entity.ShortUrl;
import com.webutil.urlshortener.Entity.User;
import com.webutil.urlshortener.Repository.ShortUrlRepo;
import com.webutil.urlshortener.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Service
public class ShortUrlService {

    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Autowired
    ShortUrlRepo shortUrlRepo;
    @Autowired
    UserRepo userRepo;
    public String convertToShortUrl(Long userId, ShortUrlDto shortUrlDto) throws NoSuchAlgorithmException {
        String longUrl = shortUrlDto.getLongUrl();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(longUrl.getBytes(StandardCharsets.UTF_8));
        String shortUrl = encode(hash);
        User user = userRepo.getById(userId);
        ShortUrl entry = new ShortUrl(longUrl,shortUrl, LocalDateTime.now(),LocalDateTime.now().plusYears(1),user);
        shortUrlRepo.save(entry);
        return  shortUrl;
    }

    private static String encode(byte[] hash){
        StringBuilder sb = new StringBuilder();
        int value = 0;
        for (int i = 0; i < hash.length && sb.length() < 8; i++) {
            value = (value << 8) | (hash[i] & 0xFF);
            while (value >= 62 && sb.length() < 8) {
                sb.append(BASE62.charAt(value % 62));
                value /= 62;
            }
        }
        if (sb.length() < 8) {
            sb.append(BASE62.charAt(value % 62));
        }
        return sb.substring(0, 8);
    }
}
