package actions;

public class Start implements ActionListener {
   private StartMode mode;
   private StringBuilder sb;
    
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
        
        if (Storage.getSaveFilePath().trim().length() == 0) {
            SelectSavePath selectSavePath = new SelectSavePath(Storage.getCurDir());
            selectSavePath.actionPerformed(e);
            if (Storage.getSaveFilePath().trim().length() == 0) {
                Storage.setRun(false);
                JOptionPane.showMessageDialog(Storage.getRootPane(), "Select the Path files save...");
                return;
            }
        }
        
}
