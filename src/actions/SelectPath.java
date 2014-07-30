import ir.hoobakht.Storage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SelectPath implements ActionListener {

    public SelectPath(string path) {
        pathFile = path;
    }


    private String pathFile;

    @Override
    public void actionPerformed(ActionEvent e) {
        File file;
        JFileChooser fileChooser = new JFileChooser(pathFile);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            Storage.setOpenFilePath(file.getAbsolutePath());
        
    }
}
