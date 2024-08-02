package com.dataaccessexample.repository;

import com.dataaccessexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA Query Methods
    List<User> findByName(String name);
    
    // Custom query method using native SQL query
    @Query(value = "SELECT * FROM users23 WHERE email = :email", nativeQuery = true)
    User findUserByEmailNativeQuery(@Param("email") String email);

   

}
