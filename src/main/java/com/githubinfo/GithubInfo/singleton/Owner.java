package com.githubinfo.GithubInfo.singleton;

import lombok.Getter;
import lombok.Setter;

public class Owner {
    @Getter
    @Setter
    private String login;
    public Owner(){
    }

    public Owner(String login) {
        this.login = login;
    }
}
