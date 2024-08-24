package doo.gym.academyproject.C_interfaceAdaptors.controllers;

import doo.gym.academyproject.A_entity.Contents;

public class APIRequest{
    private Contents contents;

    public APIRequest(String prompt) {
        this.contents = new Contents("user", prompt);
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }
}
