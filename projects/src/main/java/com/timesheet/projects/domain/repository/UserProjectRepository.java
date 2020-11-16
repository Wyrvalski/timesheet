package com.timesheet.projects.domain.repository;

import com.timesheet.projects.domain.model.UserProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public interface UserProjectRepository extends JpaRepository<UserProjectEntity, Integer> {

    @Modifying
    @Query(value = "UPDATE projects_user_hours SET hour = :hour WHERE id = :id",nativeQuery = true)
    void updateHour(@Param("hour") String hour, @Param("id") int id);

    @Query(value = "SELECT * FROM projects_user_hours WHERE id = :id", nativeQuery = true)
    UserProjectEntity findByIdHour(@Param("id") int id);
}
