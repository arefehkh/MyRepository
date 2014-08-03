package ir.hoobakht;

import actions.Exit;
import actions.SelectPath;
import actions.Start;
import components.RHButton;
import data.StartMode;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainFrame extends JFrame {

    private JEditorPane editorPane;
    private JMenuBar mainMenu;
    private JMenu mnuFile;
    private JMenu mnuAbout;
    private JMenuItem miStart;
    private JMenuItem miSelectPath;
    private JMenuItem miCheck;
    private JMenuItem miSave;
    private JMenuItem miClose;
    private JMenuItem miExit;
    private JMenuItem miAbout;
    private RHButton btnSart;
    private RHButton btnSelectPath;
    private RHButton btnCheck;
    private RHButton btnSave;
    private RHButton btnClose;
    private RHButton btnExit;
    private JPanel panelButtons;
    private JPanel panelEditor;
    private JScrollPane scrollPane;
    
    public MainFrame() throws HeadlessException {
        super("XP Diag XML Writer");
        initComponent();
    }

    public static void main(String[] args) {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException |
                        InstantiationException |
                        IllegalAccessException |
                        UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }

