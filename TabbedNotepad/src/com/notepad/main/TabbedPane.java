package com.notepad.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class TabbedPane extends JFrame {
   private static final long serialVersionUID = 1L;

   private JTabbedPane tp;
   public List<Tab> tabs = new ArrayList<Tab>();
   private Tab tab;

   public TabbedPane() {
      this.tp = new JTabbedPane();
      tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
      addTab();
   }

   public void addTab() {
      Tab tab = new Tab(tp);
      this.tabs.add(tab);
      this.tp.setSelectedIndex(this.tp.getTabCount() - 1);
      this.tab = tab;
      this.tab.getTxtArea().requestFocus();
      tab.getTxtArea().addKeyListener(KEY_LISTENER);
   }

   public void openFile() {
      FileAccess fa = new FileAccess();
      File f = new File(fa.openFile());

      if (isOpen(f.getName()) != -1) {
         tp.setSelectedIndex(isOpen(f.getName()));
         JOptionPane.showMessageDialog(null, "File is already open");
      } else {
         Tab tab = new Tab(tp, f);
         this.tabs.add(tab);
         this.tp.setSelectedIndex(this.tp.getTabCount() - 1);
         this.tab = tab;
         tab.getTxtArea().requestFocus();
      }
   }

   public void setTxtArea(int tab, String txt) {
      this.tabs.get(tab).setContents(txt);
      this.tab.getTxtArea().setText(this.tabs.get(tab).getContents());
   }

   public String getTxtArea(int tab) {
      return this.tabs.get(tab).getContents();
   }

   public JTabbedPane getTabbedPane() {
      return this.tp;
   }

   public int getSelectedTab() {
      return this.tp.getSelectedIndex();
   }

   public File getFile() {
      return tabs.get(getSelectedTab()).getFile();
   }

   public void setFile(File f) {
      tabs.get(getSelectedTab()).setFile(f);
   }

   public void setTitle(int index, String title) {
      tp.setTitleAt(index, title);
   }

   public void closeTab() {
      int currTab = getSelectedTab();
      if (tabs.size() > 1) {
         tp.remove(currTab);
         tabs.remove(currTab);
      } else {
         tp.remove(currTab);
         tabs.remove(currTab);
         addTab();
      }
   }

   public int isOpen(String filename) {
      int foo = -1;
      int i = 0;
      for (Tab t : tabs) {
         if (filename.equals(t.getName())) {
            foo = i;
            break;
         } else {
            foo = -1;
         }
         i++;
      }
      return foo;
   }
   
   
   public KeyListener KEY_LISTENER = new KeyListener() {

      @Override
      public void keyPressed(KeyEvent e) {
         int key = e.getKeyCode();
         if ((key == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            addTab();
         }         
      }

      @Override
      public void keyReleased(KeyEvent arg0) {
         // TODO Auto-generated method stub
         
      }

      @Override
      public void keyTyped(KeyEvent arg0) {
         // TODO Auto-generated method stub
         
      }
   };

}
