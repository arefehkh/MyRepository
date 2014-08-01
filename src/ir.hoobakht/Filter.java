package ir.hoobakht;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {

    private String extention;
    private boolean sensitive;

    public Filter(String ext, boolean case_sensitive) {
        if (case_sensitive) {
            sensitive = true;
            extention = ext.trim();
        } else {
            sensitive = false;
            extention = ext.trim().toLowerCase();
        }
    }
    @Override
    public boolean accept(File dir, String name) {

        if(new File(name).isDirectory()) {
            return true;
        }

        String[] filePart = name.split("\\.");

        if (filePart.length < 2) {
            return false;
        }

        String fext = filePart[filePart.length - 1];

        if (sensitive) {
            if (extention.equals(fext)) {
                return true;
            }
        } else {
            if (extention.equals(fext.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
