package com.notepad.main;

import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;

public class NotepadWindow extends JFrame implements ActionListener {
   private static final long serialVersionUID = 1L;

   private JPanel container;
   private JMenuBar navBar;
   private TabbedPane tabbedPane;
   private JMenu fileMenu;
   private JMenuItem undoBtn;
   private JMenuItem redoBtn;
   private JMenuItem newBtn;
   private JMenuItem openBtn;
   private JMenuItem saveBtn;
   private JMenuItem closeBtn;
   private JMenu editMenu;
   private JMenuItem cutBtn;
   private JMenuItem copyBtn;
   private JMenuItem pasteBtn;
   private JMenuItem selectAllBtn;

   public NotepadWindow() {
      super("Notepad");
      notepadGUI();
   }

   private void notepadGUI() {
      container = new JPanel();
      tabbedPane = new TabbedPane();

      // NavigationBar
      navBar = new JMenuBar();
      setJMenuBar(navBar);
      // NavBar 'File' menu
      fileMenu = new JMenu("File");
      navBar.add(fileMenu);
      newBtn = new JMenuItem("New");
      openBtn = new JMenuItem("Open");
      saveBtn = new JMenuItem("Save");
      closeBtn = new JMenuItem("Close");
      fileMenu.add(newBtn);
      fileMenu.addSeparator();
      fileMenu.add(openBtn);
      fileMenu.add(saveBtn);
      fileMenu.addSeparator();
      fileMenu.add(closeBtn);
      // NavBar 'Edit' menu
      editMenu = new JMenu("Edit");
      navBar.add(editMenu);
      undoBtn = new JMenuItem("Undo");
      redoBtn = new JMenuItem("Redo");
      cutBtn = new JMenuItem("Cut");
      copyBtn = new JMenuItem("Copy");
      pasteBtn = new JMenuItem("Paste");
      selectAllBtn = new JMenuItem("Select All");
//      undoBtn.setEnabled(false);
//      redoBtn.setEnabled(false);
      editMenu.add(undoBtn);
      editMenu.add(redoBtn);
      editMenu.addSeparator();
      editMenu.add(cutBtn);
      editMenu.add(copyBtn);
      editMenu.add(pasteBtn);
      editMenu.addSeparator();
      editMenu.add(selectAllBtn);

      container.setLayout(new BorderLayout());
      container.add(tabbedPane.getTabbedPane(), BorderLayout.CENTER);
      add(container);

      newBtn.addActionListener(NEW_LISTENER);
      openBtn.addActionListener(OPEN_LISTENER);
      saveBtn.addActionListener(SAVE_LISTENER);
      closeBtn.addActionListener(CLOSE_LISTENER);
      undoBtn.addActionListener(UNDO_LISTENER);
      redoBtn.addActionListener(REDO_LISTENER);
      cutBtn.addActionListener(CUT_LISTENER);
      copyBtn.addActionListener(COPY_LISTENER);
      pasteBtn.addActionListener(PASTE_LISTENER);
      selectAllBtn.addActionListener(SELECT_ALL_LISTENER);
      container.addKeyListener(KEY_LISTENER);
      
   }
   
   public JTextArea setStartupFocus(){
      return tabbedPane.tabs.get(0).getTxtArea();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub

   }

   public ActionListener NEW_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         tabbedPane.addTab();
      }
   };
   public ActionListener OPEN_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         tabbedPane.openFile();
      }
   };
   public ActionListener SAVE_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         FileAccess fa = new FileAccess();
         if (tabbedPane.getFile() == null) {
            tabbedPane.setFile(new File(fa.saveFile()));
            System.out.println(tabbedPane.getFile());
         }
         fa.setFile(tabbedPane.getFile());
         if (!fa.getFile().exists()) {
            try {
               fa.getFile().createNewFile();
               fa.writeFile(tabbedPane.tabs.get(tabbedPane.getSelectedTab()).getTxtArea().getText());
            } catch (IOException ex) {
               ex.printStackTrace();
            }
         } else {
            fa.writeFile(tabbedPane.tabs.get(tabbedPane.getSelectedTab()).getTxtArea().getText());
         }
         tabbedPane.tabs.get(tabbedPane.getSelectedTab()).setName(fa.getFile().getName());
         tabbedPane.tabs.get(tabbedPane.getSelectedTab()).setFile(fa.getFile());
         tabbedPane.setTitle(tabbedPane.getSelectedTab(), fa.getFile().getName());

      }
   };
   public ActionListener CLOSE_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         tabbedPane.closeTab();
      }
   };
   public ActionListener CUT_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         StringSelection stringSelection = new StringSelection(
               String.copyValueOf(tabbedPane.tabs.get(tabbedPane.getSelectedTab()).getTxtArea().getSelectedText().toCharArray()));
         Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
         clpbrd.setContents(stringSelection, null);
         tabbedPane.tabs.get(tabbedPane.getSelectedTab()).getTxtArea().setText(tabbedPane.tabs.get(tabbedPane.getSelectedTab()).getTxtArea().getText().replace(tabbedPane.tabs.get(tabbedPane.getSelectedTab()).getTxtArea().getSelectedText(), ""));
      }
   };
   public ActionListener COPY_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         StringSelection stringSelection = new StringSelection(
               String.copyValueOf(tabbedPane.tabs.get(tabbedPane.getSelectedTab()).getTxtArea().getSelectedText().toCharArray()));
         Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
         clpbrd.setContents(stringSelection, null);
      }
   };
   public ActionListener PASTE_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);
         } catch (Exception ex) {
         }
      }
   };
   public ActionListener UNDO_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         UndoManager undoManager = tabbedPane.tabs.get(tabbedPane.getSelectedTab()).undoMgr();
         if (undoManager.canUndo()) {
            try {
               undoManager.undo();
            } catch (Exception ex) {
            }
         }
      }
   };
   public ActionListener REDO_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         UndoManager undoManager = tabbedPane.tabs.get(tabbedPane.getSelectedTab()).undoMgr();
         if (undoManager.canRedo()) {
            try {
               undoManager.redo();
            } catch (Exception ex) {
            }
         }
      }
   };
   public ActionListener SELECT_ALL_LISTENER = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         tabbedPane.tabs.get(tabbedPane.getSelectedTab()).getTxtArea().selectAll();
      }
   };
   
   public KeyListener KEY_LISTENER = new KeyListener() {

      @Override
      public void keyPressed(KeyEvent e) {
         int key = e.getKeyCode();
         if ((key == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            tabbedPane.addTab();
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
