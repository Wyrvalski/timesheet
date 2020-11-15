package com.timesheet.projects.domain.repository;

import com.timesheet.projects.domain.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

  @Query(value = "SELECT * FROM projects.users WHERE email = :email", nativeQuery = true)
  UserInfoEntity findByEmailUser(@Param("email") String email);

}