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
    }}
