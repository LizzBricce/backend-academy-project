package doo.gym.academyproject.B_useCases.service.request;

import doo.gym.academyproject.A_Entities.Contents;

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