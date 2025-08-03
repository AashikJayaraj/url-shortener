package com.webutil.urlshortener.Repository;

import com.webutil.urlshortener.Entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortUrlRepo extends JpaRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByShortUrl(String shortUrl);
}
