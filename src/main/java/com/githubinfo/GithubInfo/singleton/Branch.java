package com.githubinfo.GithubInfo.singleton;

import lombok.Getter;
import lombok.Setter;

public class Branch {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Commit commit;
    public Branch(){}

    public Branch(String name, Commit commit) {
        this.name = name;
        this.commit = commit;
    }
}
