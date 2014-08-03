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
     private void initComponent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        Storage.setMainFrame(this);

        miStart = new JMenuItem("Start");
        miStart.addActionListener(new Start(StartMode.WriteXML));

        miSelectPath = new JMenuItem("Select Path");
        miSelectPath.addActionListener(new SelectPath(Storage.getCurDir()));

        miCheck = new JMenuItem("Check Folders");
        miCheck.addActionListener(new Start(StartMode.CheckFolder));

        miSave = new JMenuItem("Save");
        miClose = new JMenuItem("Close");
        miExit = new JMenuItem("Exit");

        miExit.addActionListener(new Exit());
        miAbout = new JMenuItem("About");

        mnuFile = new JMenu("File");
        mnuFile.add(miStart);
        mnuFile.add(miSelectPath);
        mnuFile.add(miCheck);
        mnuFile.add(miSave);
        mnuFile.add(miClose);
        mnuFile.add(miExit);

        mnuAbout = new JMenu("About");
        mnuAbout.add(miAbout);

        mainMenu = new JMenuBar();
        mainMenu.add(mnuFile);
        mainMenu.add(mnuAbout);
        setJMenuBar(mainMenu);

        panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelButtons.setSize(300, 300);

        btnSart = new RHButton();
        btnSart.setText("Start");
        btnSart.addActionListener(new Start(StartMode.WriteXML));

        btnSelectPath = new RHButton();
        btnSelectPath.setText("Select Path");
        btnSelectPath.addActionListener(new SelectPath(System.getProperty("user.dir")));

        btnCheck = new RHButton();
        btnCheck.setText("Folders");
        btnCheck.addActionListener(new Start(StartMode.CheckFolder));

        btnSave = new RHButton();
        btnSave.setText("Save");

        btnClose = new RHButton();
        btnClose.setText("Close");

        btnExit = new RHButton();
        btnExit.setText("Exit");
        btnExit.addActionListener(new Exit());

        panelButtons.add(btnSart);
        panelButtons.add(btnSelectPath);
        panelButtons.add(btnCheck);
        panelButtons.add(btnSave);
        panelButtons.add(btnClose);
        panelButtons.add(btnExit);

        panelEditor = new JPanel();
        panelEditor.setBorder(new TitledBorder("Editor"));
        panelEditor.setLayout(new BorderLayout(15, 15));

        editorPane = new JEditorPane();
        editorPane.setEditable(true);
        editorPane.setEnabled(true);
        editorPane.setFocusable(true);
        editorPane.setDragEnabled(true);
        getEditorPane().setPreferredSize(new Dimension(900, 470));

        scrollPane = new JScrollPane(getEditorPane());

        panelEditor.add(scrollPane);

        getContentPane().add(panelButtons);
        getContentPane().add(panelEditor);

    }
    public JEditorPane getEditorPane() {
        return editorPane;
    }
}

