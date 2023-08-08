import javax.swing.*;
import java.io.*;

public class main {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        
        int choice = fileChooser.showOpenDialog(null);
        
        if (choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            processFile(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }
    
    public static void processFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fileName = file.getName();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                wordCount += countWords(line);
                charCount += line.length();
            }
            
            System.out.println("Summary Report:");
            System.out.println("File Name: " + fileName);
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
        } catch (IOException e) {
            System.err.println("An error occurred while processing the file.");
            e.printStackTrace();
        }
    }
    
    public static int countWords(String line) {
        String[] words = line.trim().split("\\s+");
        return words.length;
    }
}