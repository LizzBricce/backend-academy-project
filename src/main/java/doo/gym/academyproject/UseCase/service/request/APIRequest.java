package doo.gym.academyproject.UseCase.service.request;

import doo.gym.academyproject.Entity.Contents;

/**
 * Constroi a requisição que vai ser enviada com o uso do modelo definido em Contents
 * e inserindo os dados que a api precisa
 * "user" como role define o que vai ser recebido, nesse caso o prompt que é um texto
 */
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