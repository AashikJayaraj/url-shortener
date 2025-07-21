package com.webutil.urlshortener.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "url_analytics")
public class UrlAnalytics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shortUrlId;

    private String ipAddress;

    private LocalDateTime accessedAt;

}