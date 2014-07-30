package actions;
import ir.hoobakht.Storage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SelectSavePath implements ActionListener {
   private String pathFile;

 public SelectSavePath(String path) {
        pathFile = path;
    }
    
  @Override
    public void actionPerformed(ActionEvent e) {
       File file;
        JFileChooser fileChooser = new JFileChooser(pathFile);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showSaveDialog(Storage.getMainFrame().getRootPane()) == JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            Storage.setSaveFilePath(file.getAbsolutePath());
        }

    }

   
}
