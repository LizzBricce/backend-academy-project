package doo.gym.academyproject.UseCase.service;

import doo.gym.academyproject.UseCase.service.util.JSONFormatting;
import org.springframework.stereotype.Service;

/**
 * Classe responsavel por encaminhar o texto recebido para ser formatado e devolve ele formatado
 */
@Service
public class JSONProcessingService {
    public String processAPIResponse(String responseText) {
        JSONFormatting jf = new JSONFormatting(responseText);
        jf.processJSON();
        return jf.getClearText();
    }
}
