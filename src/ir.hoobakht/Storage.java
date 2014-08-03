package ir.hoobakht;


import org.jdom2.Element;

import javax.swing.*;
import java.util.HashMap;
import java.util.regex.Matcher;

public class Storage {

    private static String openFilePath = "";
    private static String saveFilePath = "F:/";
    private static MainFrame mainFrame;
    private static String curDir = System.getProperty("user.dir");
    private static String fileSeparator = System.getProperty("file.separator");
    private static String line = System.getProperty("line.separator");
    private static boolean run = false;
    private static String extension = "xml";
    private static HashMap<String, Element> elements = new HashMap<>();
    private static String rootFolderName = "Data";


    public static String getOpenFilePath() {
        return openFilePath;
    }

    public static void setOpenFilePath(String openFilePath) {
        Storage.openFilePath = openFilePath;
        String[] partName = openFilePath.split(Matcher.quoteReplacement(Storage.getFileSeparator()));
        if (partName.length == 0) {
            Storage.openFilePath = "";
            Storage.rootFolderName = "";
            JOptionPane.showMessageDialog(Storage.getRootPane(), "Invalid Path selected ...");
            return;
        } else if (partName.length < 2) {
            Storage.rootFolderName = partName[0];
        } else if (partName.length >= 2) {
            Storage.rootFolderName = partName[partName.length - 1];
        }
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static JRootPane getRootPane() {
        return mainFrame.getRootPane();
    }
   
   public static void setMainFrame(MainFrame mainFrame) {
        Storage.mainFrame = mainFrame;
    }

    public static String getCurDir() {
        return curDir;
    }
    
    public static void setCurDir(String curDir) {
        Storage.curDir = curDir;
    }

    public static String getFileSeparator() {
        return fileSeparator;
    }
    public static String getLine() {
        return line;
    }

    public static boolean isRun() {
        return run;
    }
     public static void setRun(boolean run) {
        Storage.run = run;
    }

    public static String getExtension() {
        return extension;
    }
    
     public static void setExtension(String extension) {
        Storage.extension = extension;
    }

    public static Element getElement(String key) {
        return elements.get(key);
    }

    public static void setExtension(String extension) {
        Storage.extension = extension;
    }

    public static Element getElement(String key) {
        return elements.get(key);
    }

    public static String getRootFolderName() {
        return rootFolderName;
    }

    public static void setRootFolderName(String rootFolderName) {
        Storage.rootFolderName = rootFolderName;
    }
}
