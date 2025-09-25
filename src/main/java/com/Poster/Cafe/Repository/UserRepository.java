package com.Poster.Cafe.Repository;

import com.Poster.Cafe.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);
    User findByLogin(String login);
    List<User> findByRole(String role);
    User findByPhone(String phone);

}
