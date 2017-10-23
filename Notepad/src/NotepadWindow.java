import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class NotepadWindow extends JFrame implements ActionListener {
   private static final long serialVersionUID = 1L;

   private File file;

   private JPanel container;
   private JPanel txtPanel;
   private JTextArea txtArea;
   private JMenuBar navBar;
   private JMenu fileMenu;
   private JMenuItem undoBtn;
   private JMenuItem redoBtn;
   private JMenuItem openBtn;
   private JMenuItem saveBtn;
   private JMenuItem closeBtn;
   private JMenu editMenu;
   private JMenuItem cutBtn;
   private JMenuItem copyBtn;
   private JMenuItem pasteBtn;
   private JMenuItem selectAllBtn;
   protected UndoManager undoManager;

   public NotepadWindow() {
      super("Notepad");
      openGUI();
   }

   private void openGUI() {
      container = new JPanel();
      txtPanel = new JPanel();
      txtArea = new JTextArea();
      JScrollPane txtScroll = new JScrollPane(txtArea);
      txtScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      txtScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      navBar = new JMenuBar();
      fileMenu = new JMenu("File");
      undoBtn = new JMenuItem("Undo");
      redoBtn = new JMenuItem("Redo");
      openBtn = new JMenuItem("Open");
      saveBtn = new JMenuItem("Save");
      closeBtn = new JMenuItem("Close");
      editMenu = new JMenu("Edit");
      cutBtn = new JMenuItem("Cut");
      copyBtn = new JMenuItem("Copy");
      pasteBtn = new JMenuItem("Paste");
      selectAllBtn = new JMenuItem("Select All");

      undoBtn.setEnabled(false);
      redoBtn.setEnabled(false);

      undoManager = new UndoManager();
      txtArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
         public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
            updateButtons();
         }
      });

      fileMenu.add(openBtn);
      fileMenu.add(saveBtn);
      fileMenu.addSeparator();
      fileMenu.add(closeBtn);

      editMenu.add(undoBtn);
      editMenu.add(redoBtn);
      editMenu.addSeparator();
      editMenu.add(cutBtn);
      editMenu.add(copyBtn);
      editMenu.add(pasteBtn);
      editMenu.addSeparator();
      editMenu.add(selectAllBtn);

      navBar.add(fileMenu);
      navBar.add(editMenu);

      txtPanel.setLayout(new BorderLayout());
      txtPanel.add(txtScroll, BorderLayout.CENTER);
      setJMenuBar(navBar);
      container.setLayout(new BorderLayout());
      container.add(txtPanel, BorderLayout.CENTER);
      add(container);

      /* Button ActionListeners */
      openBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            file = new File(openFile());
            setFile(file);
            setTxtArea(readFile());
            setTitle(file.getName());
         }
      });
      saveBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            final File f;
            if (getFile() == null) {
               setFile(new File(saveFile()));
            }
            f = getFile();
            if (!f.exists()) {
               try {
                  f.createNewFile();
                  writeFile(getTxtArea());
               } catch (IOException e) {
                  e.printStackTrace();
               }
            } else {
               writeFile(txtArea.getText());
            }
            setTitle(file.getName());
         }

      });
      closeBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            dispose();
         }
      });

      cutBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            StringSelection stringSelection = new StringSelection(
                  String.copyValueOf(txtArea.getSelectedText().toCharArray()));
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
            txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(), ""));
         }
      });
      copyBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            StringSelection stringSelection = new StringSelection(
                  String.copyValueOf(txtArea.getSelectedText().toCharArray()));
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
         }
      });
      pasteBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
               Robot r = new Robot();
               r.keyPress(KeyEvent.VK_CONTROL);
               r.keyPress(KeyEvent.VK_V);
               r.keyRelease(KeyEvent.VK_CONTROL);
               r.keyRelease(KeyEvent.VK_V);
            } catch (Exception e) {
            }
         }
      });
      selectAllBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtArea.selectAll();
         }
      });
      undoBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            undoMgr().undo();
            updateButtons();
         }
      });
      redoBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            undoMgr().redo();
            updateButtons();
         }
      });

      /* Keyboard Shortcut Listeners */
      txtArea.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            // if ((key == KeyEvent.VK_C) && ((e.getModifiers() &
            // KeyEvent.CTRL_MASK) != 0)) {
            // System.out.println("woot!");
            // StringSelection stringSelection = new StringSelection(
            // String.copyValueOf(txtArea.getSelectedText().toCharArray()));
            // Clipboard clpbrd =
            // Toolkit.getDefaultToolkit().getSystemClipboard();
            // clpbrd.setContents(stringSelection, null);
            // }
            // if ((key == KeyEvent.VK_X) && ((e.getModifiers() &
            // KeyEvent.CTRL_MASK) != 0)) {
            // StringSelection stringSelection = new StringSelection(
            // String.copyValueOf(txtArea.getSelectedText().toCharArray()));
            // Clipboard clpbrd =
            // Toolkit.getDefaultToolkit().getSystemClipboard();
            // clpbrd.setContents(stringSelection, null);
            // txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(),
            // ""));
            // }
            // if ((key == KeyEvent.VK_V) && ((e.getModifiers() &
            // KeyEvent.CTRL_MASK) != 0)) {
            // try {
            // Robot r = new Robot();
            // r.keyPress(KeyEvent.VK_CONTROL);
            // r.keyPress(KeyEvent.VK_V);
            // r.keyRelease(KeyEvent.VK_CONTROL);
            // r.keyRelease(KeyEvent.VK_V);
            // } catch (Exception ex) {
            // }
            // }
            if ((key == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
               if (undoManager.canUndo()) {
                  undoMgr().undo();
                  updateButtons();
               }
            }
            if ((key == KeyEvent.VK_Y) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
               if (undoManager.canRedo()) {
                  undoMgr().redo();
                  updateButtons();
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

   private void setTxtArea(String txt) {
      this.txtArea.setText(txt);
   }

   private String getTxtArea() {
      return this.txtArea.getText();
   }

   private void setFile(File f) {
      this.file = f;
   }

   private File getFile() {
      return this.file;
   }

   private UndoManager undoMgr() {
      return this.undoManager;
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      // TODO Auto-generated method stub

   }

   public void updateButtons() {
      undoBtn.setText(undoManager.getUndoPresentationName());
      redoBtn.setText(undoManager.getRedoPresentationName());
      undoBtn.setEnabled(undoManager.canUndo());
      redoBtn.setEnabled(undoManager.canRedo());
   }

   private String openFile() {
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

   private String saveFile() {
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

   private String readFile() {
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

   private void writeFile(String text) {
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
