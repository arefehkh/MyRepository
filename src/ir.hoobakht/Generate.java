package ir.hoobakht;

import org.jdom2.Document;
import org.jdom2.Element;
import resource.Constants;

public class Generate {

    public Element createRoot() {
        Element root = new Element("XP_Diag");
        root.setAttribute("Ename", Constants.ROOT_ENAME);
        root.setAttribute("Fname", Constants.ROOT_FNAME);
        root.setAttribute("Pic", Constants.ROOT_PIC);
        root.setAttribute("info", Constants.ROOT_INFO);
        root.setAttribute("type", Constants.ROOT_TYPE);
        return root;
    }

    public Document createDocument(Element rootElement) {
        Document doc = new Document(rootElement);
        return doc;
    }

   public Element createECU(String Ename) {
        Element part = new Element("Part");
        part.setAttribute("Ename", Ename);
        part.setAttribute("Fname", Ename);
        part.setAttribute("type", Constants.ECU_TYPE);
        part.setAttribute("info", Ename + ".xml");
        part.setAttribute("Pic", Constants.PANEL_PIC);
        return part;
    }


}
