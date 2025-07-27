package com.webutil.urlshortener.Repository;

import com.webutil.urlshortener.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
