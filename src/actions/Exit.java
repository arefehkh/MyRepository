package actions;


import ir.hoobakht.Storage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Storage.isRun()) {
            JOptionPane.showMessageDialog(Storage.getMainFrame().getRootPane(), "Only after the end of the Process can exit ...");
        } else {
            System.exit(0);
        }
    }
}
