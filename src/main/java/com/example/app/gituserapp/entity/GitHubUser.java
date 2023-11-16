package com.example.app.gituserapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class GitHubUser {


    private long id;

    @Id
    private String login;
    @JsonProperty("avatar_url")
    // to properly map the avatarurl
    private String avatarUrl;
    @Column(unique = true)
    private String name;
    private String company;
    @JsonProperty("public_repos")
    private String publicRepo;

}
