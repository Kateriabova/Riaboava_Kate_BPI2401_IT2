package forthlab;

import java.io.*;
import java.nio.file.*;

public class FileCopy {
    
    public static void copyTextFile(String sourcePath, String destinationPath) throws IOException, FileNotFoundException, SecurityException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        
        try {
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                throw new FileNotFoundException("Исходный файл не существует: " + sourcePath);
            }
            if (sourceFile.isDirectory()) {
                throw new IOException("Исходный путь является директорией: " + sourcePath);
            }
            File destFile = new File(destinationPath);
            if (destFile.exists()) {
                if (destFile.isDirectory()) {
                    throw new IOException("Целевой путь является директорией: " + destinationPath);
                }
            }
            
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourcePath)));
            } catch (FileNotFoundException e) {
                if (e.getMessage().contains("Отказано в доступе") || e.getMessage().contains("Access denied")) {
                    throw new SecurityException("Нет прав на чтение файла: " + destinationPath);
                } else {
                    throw e;
                } 
            } catch (SecurityException e) {
                throw new SecurityException("Нет прав на чтение файла: " + sourcePath);
            }

            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destinationPath)));
            } catch (FileNotFoundException e) {
                if (e.getMessage().contains("Отказано в доступе") || e.getMessage().contains("Access denied")) {
                    throw new SecurityException("Нет прав на запись в файл: " + destinationPath);
                } else {
                    throw e;
                } 
            }catch (SecurityException e) {
                throw new SecurityException("Нет прав на запись в файл: " + destinationPath);
            }
            
            String line;
            while ((line = reader.readLine()) != null) {
                
                try {
                    writer.write(line);
                    writer.newLine();
                    
                    // Проверяем ошибки записи с помощью flush()
                    writer.flush();
                    
                } catch (IOException writeError) {
                    throw new IOException("Ошибка записи: " + writeError.getMessage(), writeError);
                }
            }
            
            System.out.println("Текстовый файл успешно скопирован");
            
        } catch (FileNotFoundException e) {
            throw e;
        } catch (SecurityException e) {
            throw e;
        } catch (IOException e) {
            if (e.getMessage().contains("чита") || e.getMessage().contains("read") || e.getMessage().contains("input")) {
                throw new IOException("Ошибка чтения файла " + sourcePath + ": " + e.getMessage(), e);
            } else if (e.getMessage().contains("записи") || e.getMessage().contains("write") || e.getMessage().contains("output")) {
                throw new IOException("Ошибка записи файла " + destinationPath + ": " + e.getMessage(), e);
            } else {
                throw new IOException("Ошибка при копировании файла: " + e.getMessage(), e);
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии " + sourcePath + ": " + e.getMessage());
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии " + destinationPath + ": " + e.getMessage());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Введите названия файлов для копирования и записи");
            return; 
        }
        
        String sourceFile = args[0];
        String destinationFile = args[1];
        
        try {
            File destFile = new File(destinationFile);
            if (destFile.exists()) {
                System.out.println("Файл уже существует. Перезаписать? (y/n)");
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                String response = consoleReader.readLine();
                
                if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("yes")) {
                    System.out.println("Копирование отменено пользователем.");
                    return;
                }
            }
            
            copyTextFile(sourceFile, destinationFile);
            
        } catch (SecurityException e) {
            System.err.println("Ошибка доступа: " + e.getMessage());
            
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден - " + e.getMessage());
            
        } catch (IOException e) {
            String errorMessage = e.getMessage();
            if (errorMessage.contains("чтени") || errorMessage.contains("read")) {
                System.err.println("Ошибка чтения файла: " + e.getMessage());
            } else if (errorMessage.contains("записи") || errorMessage.contains("write")) {
                System.err.println("Ошибка записи файла: " + e.getMessage());
            } else {
                System.err.println("Ошибка ввода-вывода: " + e.getMessage());
            }
        } finally {
            System.out.println("Копирование завершено");
        }
    }
}