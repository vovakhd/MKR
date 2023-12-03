package oop.example.project_oop.classes;

import com.opencsv.exceptions.CsvException;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;


public class Lessons {
    private String numberOfLesson;
    private String lessonProgress;

    public static double calculateProgress(String userColumn, String targetLevel, int targetLesson) throws IOException, CsvException {
        List<String[]> words = readCSV();

        // Лічильники для вивчених та всіх слів
        int learnedWordsCount = 0;
        int totalWordsCount = 0;

        // Знаходження індексу колонки користувача в рядках CSV
        int userColumnIndex = -1;
        String[] header = words.get(0); // Перший рядок містить заголовки колонок
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
            String level = word[0];
            int lesson;
            int userIndicator;

            try {
                lesson = Integer.parseInt(word[1]);
                userIndicator = Integer.parseInt(word[userColumnIndex]);
            } catch (NumberFormatException e) {
                continue;
            }

            if (level.equals(targetLevel) && lesson == targetLesson) {
                totalWordsCount++;

                if (userIndicator >= 5) {
                    learnedWordsCount++;
                }
            }
        }

        // Розрахунок прогресу у відсотках
        if (totalWordsCount > 0) {
            double progressPercentage = (double) learnedWordsCount / totalWordsCount * 100;
            // Округлення до 2 знаків після коми
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedProgress = decimalFormat.format(progressPercentage);
            // Заміна коми на крапку (для запобігання NumberFormatException)
            formattedProgress = formattedProgress.replace(',', '.');
            return Double.parseDouble(formattedProgress);
        } else {
            return 0.0;  // Якщо немає слів, прогрес дорівнює 0
        }
    }

    // Функція для зчитування даних з CSV-файлу
    public static List<String[]> readCSV() throws IOException, CsvException {
        String file = "vocabulary.csv";
        List<String[]> words = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).build()) {
            String[] headers = csvReader.readNext();
            if (headers == null) {
                throw new CsvException("CSV file is empty or does not contain headers.");
            }
            words.add(headers);
            words.addAll(csvReader.readAll());
        }
        return words;
    }

    public void setNumberOfLesson(String numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    public void setLessonProgress(String lessonProgress) {
        this.lessonProgress = lessonProgress;
    }

    public String getNumberOfLesson() {
        return numberOfLesson;
    }

    public String getLessonProgress() {
        return lessonProgress;
    }
}
