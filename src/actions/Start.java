package actions;

import components.Utility;
import data.StartMode;
import ir.hoobakht.Generate;
import ir.hoobakht.Storage;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class Start implements ActionListener {

    private StartMode mode;
    private StringBuilder sb;
    private int dirIndex;
    private int fileIndex;
    private Generate generate;
    private Element root;
    
    public Start(StartMode mode) {
        this.mode = mode;
    }

    private void linkDir(File[] files) throws Exception {
        for (File file : files) {
            if (file.isDirectory()) {
                String parentElement = Utility.getParent(file.getPath());
                if (!parentElement.equals(Storage.getRootFolderName())) {
                    Storage.getElement(parentElement).addContent(Storage.getElement(file.getName()));
                } else {
                    root.addContent(Storage.getElement(file.getName()));
                }
                linkDir(file.listFiles());
            }
        }
    }
     private void listDir(File[] files) throws Exception {
        for (File file : files) {
            if (file.isDirectory()) {
                listDir(file.listFiles());
            } else {
                String elementName = Utility.getParent(file.getPath());
                Storage.getElement(elementName).addContent(generate.createECU(file.getName()));
            }
        }
    }
     private void createPath(File[] files) throws Exception {
        for (File file : files) {
            if (file.isDirectory()) {
                Storage.setElement(file.getName(), generate.createPanel(file.getName()));
                createPath(file.listFiles());
            }
        }
    }
     private void checkDir(File[] files) throws Exception {
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append(++dirIndex).append(" - ")
                        .append(file.getName()).append(Storage.getLine());
                checkDir(file.listFiles());
            } else {
                sb.append("         ->").append(++fileIndex)
                        .append(" ").append(file.getName()).append(Storage.getLine());
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Storage.setRun(true);
        sb = new StringBuilder();

        if (Storage.getOpenFilePath().trim().length() == 0) {
            SelectPath selectPath = new SelectPath(Storage.getCurDir());
            selectPath.actionPerformed(e);
            if (Storage.getOpenFilePath().trim().length() == 0) {
                Storage.setRun(false);
                JOptionPane.showMessageDialog(Storage.getRootPane(), "Select the Path files to open ...");
                return;
            }
        }
        
    File file = new File(Storage.getOpenFilePath());
        dirIndex = 0;
        fileIndex = 0;

        try {
            if (mode == StartMode.CheckFolder) {
                checkDir(file.listFiles());
                Storage.getMainFrame().getEditorPane().setText(sb.toString());
            } else if (mode == StartMode.WriteXML) {
                generate = new Generate();
                root = generate.createRoot();
                Document doc = generate.createDocument(root);
                createPath(file.listFiles());
                listDir(file.listFiles());
                linkDir(file.listFiles());
                XMLOutputter output = new XMLOutputter(Format.getPrettyFormat());
                output.output(doc, new FileWriter(Storage.getSaveFilePath() ,
                        Storage.getFileSeparator() +
                        "test_XP_Diag.xml"));
                JOptionPane.showMessageDialog(Storage.getRootPane(),
                        "XML File Writting is over successfully ...");
            }
        } catch (Exception ex) {
            Storage.setRun(false);
            JOptionPane.showMessageDialog(Storage.getRootPane(), ex);
        }
        Storage.setRun(false);
    }    
}
