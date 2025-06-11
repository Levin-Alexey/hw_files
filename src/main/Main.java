package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\levin\\Games\\";
        StringBuilder log = new StringBuilder();

        String[] dirs = {
                "src", "res", "savegames", "temp",
                "src\\main", "src\\test",
                "res\\drawables", "res\\vectors", "res\\icons"
        };

        for (String dir : dirs) {
            File directory = new File(basePath + dir);
            if (directory.mkdir()) {
                log.append("Директория создана: ").append(directory.getPath()).append("\n");
            } else {
                log.append("Не удалось создать директорию: ").append(directory.getPath()).append("\n");
            }
        }

        File mainJava = new File(basePath + "src\\main\\Main.java");
        File utilsJava = new File(basePath + "src\\main\\Utils.java");
        File tempTxt = new File(basePath + "temp\\temp.txt");

        try {
            if (mainJava.createNewFile()) {
                log.append("Файл создан: ").append(mainJava.getPath()).append("\n");
            }
            if (utilsJava.createNewFile()) {
                log.append("Файл создан: ").append(utilsJava.getPath()).append("\n");
            }
            if (tempTxt.createNewFile()) {
                log.append("Файл создан: ").append(tempTxt.getPath()).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла: ").append(e.getMessage()).append("\n");
        }

        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл temp.txt: " + e.getMessage());
        }

        System.out.println("Установка завершена. Проверь файл temp.txt для лога.");
    }
}