package com.example.app.gituserapp.api;

import com.example.app.gituserapp.entity.GitHubUser;
import com.example.app.gituserapp.exception.UserNotFoundException;
import com.example.app.gituserapp.repo.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class GitHubController {
    private final UserRepo repo;
    private final RestTemplate template;

    public GitHubController(UserRepo repo, RestTemplate template) {

        this.repo = repo;
        this.template =template;
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<GitHubUser> getUser(@PathVariable String userName){
        if (null == userName){
            throw new UserNotFoundException("User doesn't exist");
        }
        Optional<GitHubUser> optionalUser = repo.getGitHubUserByLogin(userName);
        GitHubUser hubUser = optionalUser.orElse((null));
        if (hubUser== null) {
//            GitHubUser user = template.getForObject("https://api.github.com/users/"+userName,GitHubUser.class);
            ResponseEntity<GitHubUser> forEntity = template.getForEntity("https://api.github.com/users/"
                    + userName, GitHubUser.class);
            if (null!=forEntity){
               repo.save(forEntity.getBody());

            }
        }
return ResponseEntity.status(200).body(repo.findById(userName).get());
    }

}

