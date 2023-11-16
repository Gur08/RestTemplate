package com.example.app.gituserapp.repo;

import com.example.app.gituserapp.entity.GitHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<GitHubUser,String> {

//    public Optional<GitHubUser> findGitHubUserByLogin(String login);

@Query("SELECT u from GitHubUser u where u.login = :login")
//:login is same as string login if they are different we have to use param to specify the parameter
    Optional<GitHubUser> getGitHubUserByLogin(@Param("login") String login);

}
