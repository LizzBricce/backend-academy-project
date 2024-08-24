package doo.gym.academyproject.C_interfaceAdaptors.utils;

import doo.gym.academyproject.A_entity.TrainingDetails;

public class SeparateTraining {
    public static TrainingDetails splitTraining(String clearText) {
        if (clearText == null || clearText.isEmpty()) {
            throw new IllegalArgumentException("resposta da API vazia");
        }

        String[] lines = clearText.split("\\n");

        if (lines.length < 3) {
            throw new IllegalArgumentException("reposta da API invalida");
        }

        StringBuilder trainingA = new StringBuilder();
        StringBuilder trainingB = new StringBuilder();
        StringBuilder trainingC = new StringBuilder();

        String currentSection = "";

        for (String line : lines) {
            if (line.startsWith("**Treino")) {
                currentSection = line;
            } else {
                if (currentSection.equals("**Treino A")) {
                    trainingA.append(line).append("\n");
                } else if (currentSection.equals("**Treino B")) {
                    trainingB.append(line).append("\n");
                } else if (currentSection.equals("**Treino C")) {
                    trainingC.append(line).append("\n");
                }
            }
        }

        String trainingAStr = trainingA.toString().trim();
        String trainingBStr = trainingB.toString().trim();
        String trainingCStr = trainingC.toString().trim();

        return new TrainingDetails(trainingAStr, trainingBStr, trainingCStr);
    }
}
