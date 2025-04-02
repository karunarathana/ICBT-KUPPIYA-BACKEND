package com.ICBTKUPPIYA.RestController.repo;

import com.ICBTKUPPIYA.RestController.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
   @Query(value = "SELECT * FROM t_user WHERE user_name = :userName", nativeQuery = true)
   Optional<UserEntity> findByUserName(String userName);
}
