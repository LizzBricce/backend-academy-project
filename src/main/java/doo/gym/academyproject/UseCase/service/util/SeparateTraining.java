package doo.gym.academyproject.UseCase.service.util;

import doo.gym.academyproject.Entity.Training;

/**
 * SeparateTraining separa o texto que ja foi 'limpo' para facilitar a exibição em 3 partes, A, B, e C
 *
 *
 */
public class SeparateTraining {

    public static Training splitTraining(String clearText) {
        if (clearText == null || clearText.isEmpty()) {
            throw new IllegalArgumentException("resposta da API nula");
        }

        String[] lines = clearText.split("\\n");
        StringBuilder trainingA = new StringBuilder();
        StringBuilder trainingB = new StringBuilder();
        StringBuilder trainingC = new StringBuilder();

        StringBuilder currentTraining = null;

        for (String line : lines) {
            if (line.startsWith("Treino A")) {
                currentTraining = trainingA;
            } else if (line.startsWith("Treino B")) {
                currentTraining = trainingB;
            } else if (line.startsWith("Treino C")) {
                currentTraining = trainingC;
            }

            if (currentTraining != null && !line.startsWith("Treino")) {
                currentTraining.append(line).append("\n");
            }
        }

        return new Training(
                trainingA.toString().trim(),
                trainingB.toString().trim(),
                trainingC.toString().trim()
        );
    }
}
