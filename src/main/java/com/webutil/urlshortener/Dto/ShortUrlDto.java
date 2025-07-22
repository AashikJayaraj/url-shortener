package com.webutil.urlshortener.Dto;

public class ShortUrlDto {
    private String longUrl;

    public ShortUrlDto() {
    }

    public ShortUrlDto(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
