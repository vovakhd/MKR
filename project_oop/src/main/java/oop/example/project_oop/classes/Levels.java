package oop.example.project_oop.classes;

import com.opencsv.exceptions.CsvException;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.text.DecimalFormat;

@Setter
@Getter
@Entity
public class Levels extends Lessons {
    private String level;
    private String levelProgress;
    private int lessonsNumber;
    public double calculateLevelProgress(String userColumn, String targetLevel) {
        double totalProgress = 0.0;
        int totalLessons = 0;
        try {
            List<String[]> words = readCSV();
            // Знаходження індексу колонки користувача в рядках CSV
            int userColumnIndex = -1;
            String[] header = words.get(0);
            for (int i = 0; i < header.length; i++) {
                if (header[i].equals(userColumn)) {
                    userColumnIndex = i;
                    break;
                }
            }
            if (userColumnIndex == -1) {
                throw new CsvException("User column not found in CSV.");
            }
            for (String[] word : words) {
                String currentLevel = word[0];
                int userIndicator;
                try {
                    userIndicator = Integer.parseInt(word[userColumnIndex]);
                } catch (NumberFormatException e) {
                    continue;
                }
                if (currentLevel.equals(targetLevel)) {
                    totalLessons++;
                    totalProgress += (userIndicator >= 5) ? 1 : 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Розрахунок прогресу для рівня
        if (totalLessons > 0) {
            double averageProgress = (totalProgress / totalLessons) * 100;
            // Округлення до 2 знаків після коми
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedAverageProgress = decimalFormat.format(averageProgress);
            formattedAverageProgress = formattedAverageProgress.replace(',', '.');
            return Double.parseDouble(formattedAverageProgress);
        } else {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Levels levels = new Levels();
        try {
            double averageProgress = levels.calculateLevelProgress("user@mail", "A");
            System.out.println("Level progress: " + averageProgress + "%");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}