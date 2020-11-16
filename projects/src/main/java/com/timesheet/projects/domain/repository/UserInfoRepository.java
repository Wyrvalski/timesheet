package com.timesheet.projects.domain.repository;

import com.timesheet.projects.domain.model.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

  @Query(value = "SELECT * FROM projects.users WHERE email = :email", nativeQuery = true)
  UserInfoEntity findByEmailUser(@Param("email") String email);

  List<UserInfoEntity> findAll();

}