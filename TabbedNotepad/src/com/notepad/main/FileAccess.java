package com.notepad.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileAccess extends JFrame {
   private static final long serialVersionUID = 1L;

   private File file;

   public FileAccess() {
   }

   public FileAccess(File f) {
      this.file = f;
   }

   public void setFile(File f) {
      this.file = f;
   }

   public File getFile() {
      return this.file;
   }

   public String openFile() {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
      int result = fileChooser.showOpenDialog(this);
      if (result == JFileChooser.APPROVE_OPTION) {
         File selectedFile = fileChooser.getSelectedFile();
         return selectedFile.getAbsolutePath();
      } else {
         return null;
      }
   }

   public String saveFile() {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
      int result = fileChooser.showSaveDialog(this);
      if (result == JFileChooser.APPROVE_OPTION) {
         File selectedFile = fileChooser.getSelectedFile();
         return selectedFile.getAbsolutePath();
      } else {
         return null;
      }
   }

   public String readFile() {
      BufferedReader br;
      StringBuilder sb = new StringBuilder();
      try {
         br = new BufferedReader(new FileReader(this.file));
         String ln = "";
         while ((ln = br.readLine()) != null) {
            sb.append(String.format("%s%n", ln));
         }
         br.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return sb.toString();
   }

   public void writeFile(String text) {
      try {
         FileWriter fw = new FileWriter(this.file);
         fw.write(text);
         fw.flush();
         fw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

}
