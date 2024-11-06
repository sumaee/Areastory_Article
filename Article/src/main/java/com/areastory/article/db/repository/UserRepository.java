package com.areastory.article.db.repository;

import com.areastory.article.db.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
}
