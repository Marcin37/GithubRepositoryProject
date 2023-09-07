package com.githubinfo.GithubInfo.controller;

import com.githubinfo.GithubInfo.pojo.RepositoryView;
import com.githubinfo.GithubInfo.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final RepositoryService repositoryService;

    @Autowired
    public RestController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/allRepositories")
    public List<RepositoryView> getAllRepositories(@RequestParam String user, @RequestHeader(HttpHeaders.CONTENT_TYPE) String headers) {
        return repositoryService.getAllRepositories(user,headers);
    }
}
