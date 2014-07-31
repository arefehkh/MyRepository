package components;

import ir.hoobakht.Storage;
import java.util.regex.Matcher;
public class Utility {

    public static String getParent(String path) {
        String elementName = "";
        String[] pp = path.split(Matcher.quoteReplacement(Storage.getFileSeparator()));
        if (pp.length == 0) {
            elementName = "";
        } else if (pp.length < 2) {
            elementName = pp[0];
        } else if (pp.length >= 2) {
            elementName = pp[pp.length - 2];
        }
     return elementName;   
    }
}
