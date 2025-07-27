package com.webutil.urlshortener.Repository;

import com.webutil.urlshortener.Entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepo extends JpaRepository<ShortUrl, Long> {
}
