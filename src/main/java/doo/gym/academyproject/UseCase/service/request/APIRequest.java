package doo.gym.academyproject.UseCase.service.request;

import doo.gym.academyproject.Entity.Contents;

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