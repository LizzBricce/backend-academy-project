package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.B_useCases.service.util.JSONFormatting;
import org.springframework.stereotype.Service;

@Service
public class JSONProcessingService {
    public String processAPIResponse(String responseText) {
        JSONFormatting jf = new JSONFormatting(responseText);
        jf.processJSON();
        return jf.getClearText();
    }
}
