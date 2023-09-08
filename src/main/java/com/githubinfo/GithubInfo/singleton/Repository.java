package com.githubinfo.GithubInfo.singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Repository {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Owner owner;
    @Getter
    @Setter
    private String branches_url;
    @Getter
    @Setter
    private List<Branch> branches;
    @Getter
    @Setter
    private boolean fork;


    public Repository() {
    }

    public Repository(String name, Owner owner,String branches_url, List<Branch> branch,boolean fork) {
        this.name = name;
        this.owner = owner;
        this.branches_url = branches_url;
        this.branches = branch;
        this.fork=fork;
    }
}
