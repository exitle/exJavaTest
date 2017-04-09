package com.notepad.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Tab extends JFrame implements ActionListener {
   private static final long serialVersionUID = 1L;

   private String name;
   private String contents;
   private File file;
   private JTextArea txtArea = new JTextArea();
   protected UndoManager undoManager;

   public Tab(JTabbedPane tp) {
      this.name = "New" + (tp.getTabCount() + 1);
      this.file = null;
      this.contents = "";
      this.txtArea.setText("");
      Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
      this.txtArea.setFont(font);
      tp.addTab(name, makeTabPanel());
      addActionListener(this.txtArea);
   }

   public Tab(JTabbedPane tp, File f) {
      FileAccess fa = new FileAccess(f);
      this.name = f.getName();
      this.contents = fa.readFile();
      this.file = fa.getFile();
      this.txtArea.setText(contents);
      tp.addTab(name, makeTabPanel());
      addActionListener(this.txtArea);
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getContents() {
      return contents;
   }

   public void setContents(String contents) {
      this.contents = contents;
   }

   public File getFile() {
      return file;
   }

   public void setFile(File file) {
      this.file = file;
   }

   public JTextArea getTxtArea() {
      return txtArea;
   }

   public void setTxtArea(JTextArea txtArea) {
      this.txtArea = txtArea;
   }

   protected JComponent makeTabPanel() {
      JScrollPane txtScroll = new JScrollPane(this.txtArea);
      txtScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      txtScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      return txtScroll;
   }

   public UndoManager undoMgr() {
      return this.undoManager;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub

   }

   public void addActionListener(JTextArea txtArea) {

      undoManager = new UndoManager();
      txtArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
         public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
         }
      });

      txtArea.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
               if (undoManager.canUndo()) {
                  try {
                     undoMgr().undo();
                  } catch (Exception ex) {
                  }
               }
            }
            if ((key == KeyEvent.VK_Y) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
               if (undoManager.canRedo()) {
                  try {
                     undoMgr().redo();
                  } catch (Exception ex) {
                  }
               }
            }
            if ((key == KeyEvent.VK_A) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
               txtArea.selectAll();
            }
         }

         @Override
         public void keyReleased(KeyEvent arg0) {
         }
      });

   }

}
