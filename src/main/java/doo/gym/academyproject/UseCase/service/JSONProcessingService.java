package doo.gym.academyproject.UseCase.service;

import doo.gym.academyproject.UseCase.service.util.JSONFormatting;
import org.springframework.stereotype.Service;

@Service
public class JSONProcessingService {
    public String processAPIResponse(String responseText) {
        JSONFormatting jf = new JSONFormatting(responseText);
        jf.processJSON();
        return jf.getClearText();
    }
}
