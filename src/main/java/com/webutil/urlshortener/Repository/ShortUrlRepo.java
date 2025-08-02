package com.webutil.urlshortener.Repository;

import com.webutil.urlshortener.Entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepo extends JpaRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByShortUrl(String shortUrl);
}
