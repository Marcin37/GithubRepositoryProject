package com.githubinfo.GithubInfo.service;

import com.githubinfo.GithubInfo.pojo.Branch;
import com.githubinfo.GithubInfo.pojo.Repository;
import com.githubinfo.GithubInfo.pojo.RepositoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class RepositoryService {

    private WebClient webClient;


    @Autowired
    public RepositoryService() {
    }

    public List<RepositoryView> getAllRepositories(String user,String headers) throws HttpMediaTypeNotAcceptableException, WebClientResponseException {
        if (headers.equals("application/xml"))
            throw new HttpMediaTypeNotAcceptableException("Message");
        webClient=buildWebClient(headers);
        String url = "https://api.github.com/users/" + user + "/repos";
        Mono<List<Repository>> response = webClient.get().uri(url).retrieve().bodyToMono(new ParameterizedTypeReference<List<Repository>>() {});
        List<Repository> repositories = response.block();
        assert repositories != null;
        return getFinalRepositories(repositories);
    }

    private List<RepositoryView> getFinalRepositories(List<Repository> repositories) {
        List<RepositoryView> finalRepositories = new LinkedList<RepositoryView>();
        for (Repository r : repositories) {
            r.setBranches(getBranches(r));
            RepositoryView repositoryView=new RepositoryView(r.getName(),r.getOwner(),r.getBranches());
            finalRepositories.add(repositoryView);
        }
        return finalRepositories;
    }

    public List<Branch> getBranches(Repository repository) {
        String branchUrl = repository.getBranches_url().substring(0, repository.getBranches_url().length() - 9);
        Mono<List<Branch>> response = webClient.get().uri(branchUrl).retrieve().bodyToMono(new ParameterizedTypeReference<List<Branch>>() {
        });
        return response.block();
    }

    private WebClient buildWebClient(String headers) {
        return WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, headers)
                .build();
    }
}
