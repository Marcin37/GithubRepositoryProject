package com.githubinfo.GithubInfo.pojo;

import lombok.Getter;
import lombok.Setter;

public class Commit {
    @Getter
    @Setter
    private String sha;
    public Commit(){}

    public Commit(String sha) {
        this.sha = sha;
    }
}
