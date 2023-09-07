package com.githubinfo.GithubInfo.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class RepositoryView{

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Owner owner;
    @Getter
    @Setter
    private List<Branch> branches;

    public RepositoryView(){}

    public RepositoryView(String name, Owner owner, List<Branch> branches) {
        this.name = name;
        this.owner = owner;
        this.branches = branches;
    }
}
