package doo.gym.academyproject.UseCase.service.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONFormatting {

    private String responseText;
    private String clearText;

    public JSONFormatting(String responseText) {
        this.responseText = responseText;
    }

    public void processJSON() {
        try {
            JSONObject obj = new JSONObject(responseText);
            JSONArray candidates = obj.getJSONArray("candidates");
            if (candidates.length() > 0) {
                //canditades é oq envolve a resposta da API
                //aq ele ta vendo dentro de cantidates e tirando as parts que nao sao o "text"
                //que é oq a gente quer
                JSONObject candidate = candidates.getJSONObject(0);
                JSONObject content = candidate.getJSONObject("content");
                JSONArray parts = content.getJSONArray("parts");
                //depois ele faz um string builder so com oq tem dentro de parts(que é o text)
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < parts.length(); i++) {
                    JSONObject part = parts.getJSONObject(i);
                    if (part.has("text")) {
                        sb.append(part.getString("text")).append("\n\n");
                    }
                }
                clearText = sb.toString().trim(); //converte o string builder em string
            } else {
                throw new IllegalArgumentException("erro ao formatar JSON");
            }
        } catch (JSONException e) {
            throw new RuntimeException("erro ao formatar  JSON: " + e.getMessage());
        }
    }

    public String getClearText() {
        return clearText;
    }
}