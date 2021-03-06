package com.timesheet.auth.domain.repository;

import com.timesheet.auth.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomUserRepository extends JpaRepository<UserEntity, Long> {

  @Query(value = "SELECT * FROM auth.user WHERE email = :email", nativeQuery = true)
  Optional<UserEntity> findByEmail(@Param("email") String email);

  @Query(value = "SELECT * FROM auth.user WHERE email = :email", nativeQuery = true)
  UserEntity findByEmailCustomUser(@Param("email") String email);
}