package com.xl.l4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextReader {
   /**
    * Class reads contents of csv file and returns row/column based
    * List<List<String>> (based on transposition status)
    * Map<String,List<String>> (always column based)
    * Methods:
    * transpose - translate row-based lists to column-based
    * readMap - create column-based map with column header as key
    * getRowCount - returns number of rows in fileList
    * getColumnCount - returns number of columns in fileList
    * addRow / addColumn - adds row/column to fileList (if added row has more entries, it is cropped to appropriate size | if it has fewer - null values are added)
    * isFileOk - boolean to check if all rows has the same length (Prints numbers of lines with length different than 1st row)
    * 
    */

   private List<List<String>> fileList = new ArrayList<List<String>>();
   private boolean isTransposed = false;
   private Map<String, List<String>> fileMap = new HashMap<String, List<String>>();

   TextReader(File file, String sep) {
      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
         String lineVal;
         while ((lineVal = br.readLine()) != null) {
            List<String> row = Arrays.asList(lineVal.split(sep));
            fileList.add(row);
         }
         readMap();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   TextReader(File file) {
      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
         String lineVal;
         while ((lineVal = br.readLine()) != null) {
            List<String> row = Arrays.asList(lineVal.split(","));
            fileList.add(row);
         }
//    	 System.out.println(fileList.get(0).size());
         readMap();
//         System.out.println(fileList.size());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void transpose() {
      if (isFileOk() == false) {
      } else {
         List<List<String>> columnList = new ArrayList<List<String>>();
         for (int i = 0; i < fileList.get(0).size(); i++) {
            List<String> column = new ArrayList<String>();
            for (int j = 0; j < fileList.size(); j++) {
               column.add(fileList.get(j).get(i));
            }
            columnList.add(column);
         }
         this.fileList = columnList;
         this.isTransposed = ((this.isTransposed == false) ? true : false);
      }
   }

   private void readMap() {
      if (isTransposed) {
         if (!fileMap.isEmpty()) {
            fileMap = new HashMap<String, List<String>>();
         }
         for (List<String> l : fileList) {
            fileMap.put(l.get(0), l.subList(1, l.size()));
         }
      } else {
         for (int i = 0; i < fileList.get(0).size(); i++) {
            List<String> tmp = new ArrayList<String>();
            for (int j = 1; j < fileList.size(); j++) {
               tmp.add(fileList.get(j).get(i));
            }
            fileMap.put(fileList.get(0).get(i), tmp);
         }
      }
   }

   private boolean isFileOk() {
      Integer val = fileList.get(0).size();
      boolean check = true;
      int lineCount = 1;
      for (List<String> l : fileList) {
         if (!val.equals(l.size())) {
            check = false;
            System.err.printf("%s%d%n%s%n", "File is corrupted on line ", lineCount, "Check file and try again");
         }
         lineCount++;
      }
      return check;
   }

   public List<List<String>> getFileList() {
      return fileList;
   }

   public List<String> getRow(int i) {
      try {
         return fileList.get(i);
      } catch (Exception e) {
         System.err.printf("%s%s", "Provide a value between 0 and ", fileList.size() - 1);
         return null;
      }

   }

   public Map<String, List<String>> getFileMap() {
      return this.fileMap;
   }

   public List<String> getFileMapList(String key) {
      return this.fileMap.get(key);
   }

   public int getColumnCount() {
      return fileMap.size();
   }

   public int getRowCount() {
      if (isTransposed) {
         return this.fileList.get(0).size();
      } else {
         return this.fileList.size();
      }

   }

   public void addRow(List<String> addL) {
      if (addL.size() > getColumnCount()){
         addL = addL.subList(0, getColumnCount() - 1);
      } else if (addL.size() < getColumnCount()){
         while (addL.size() < getColumnCount()){
            addL.add("");
         }
      }
      
      if (!isTransposed) {
         this.fileList.add(addL);
      } else {
         transpose();
         this.fileList.add(addL);
         transpose();
      }
      readMap();
   }

   public void addColumn(List<String> addL) {
      if (addL.size() > getRowCount()) {
         addL = addL.subList(0, getRowCount() - 1);
      } else if (addL.size() < getRowCount()){
         while (addL.size() < getRowCount()){
            addL.add("");
         }
      }
      if (isTransposed) {
         this.fileList.add(addL);
      } else {
         transpose();
         this.fileList.add(addL);
         transpose();
      }
      readMap();
   }

   public Map<String, Integer> getFileSize() {
      Map<String, Integer> fs = new HashMap<String, Integer>();
      fs.put("Row", getRowCount());
      fs.put("Column", getColumnCount());
      return fs;
   }

   public String getStringRow(List<String> r) {
      return r.toString().replace("[", "").replace("]", "").replace(", ", ",");
   }

   public boolean isTransposed() {
      return this.isTransposed;
   }

   @Override
   public String toString() {
      String contents = "";
      int i = 1;
      for (List<String> l : fileList) {
         contents += String.format("%s%s%s%n", i, ". ", l.toString());
         i++;
      }
      return contents;
   }

}

