package com.githubinfo.GithubInfo.pojo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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


    public Repository() {
    }

    public Repository(String name, Owner owner,String branches_url, List<Branch> branch) {
        this.name = name;
        this.owner = owner;
        this.branches_url = branches_url;
        this.branches = branch;
    }
}
