package com.githubinfo.GithubInfo.controller;

import com.githubinfo.GithubInfo.singleton.RepositoryView;
import com.githubinfo.GithubInfo.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class RepositoryController {

    private final RepositoryService repositoryService;

    @Autowired
    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/allRepositories")
    public List<RepositoryView> getAllRepositories(@RequestParam String user, @RequestHeader(HttpHeaders.CONTENT_TYPE) String headers) {
        try{
            return repositoryService.getAllRepositories(user,headers);
        }catch (WebClientResponseException webClientResponseException){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Non-existing github user", webClientResponseException);
        }
        catch (HttpMediaTypeNotAcceptableException httpMediaTypeNotAcceptableException){
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "Content type application/xml is not allowed", httpMediaTypeNotAcceptableException);
        }

    }


}
