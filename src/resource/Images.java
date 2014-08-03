package resource;


import javax.swing.*;

public class images {

    public ImageIcon getY_Png() {
       final ImageIcon Y_Png = new ImageIcon(getClass().getResource("/image/y.png"));
        return Y_Png;
    }

    public ImageIcon getO_Png() {
        final ImageIcon O_Png = new ImageIcon(getClass().getResource("/image/o.png"));
        return O_Png;
    }

    public ImageIcon getP_Png() {
        final ImageIcon P_Png = new ImageIcon(getClass().getResource("/image/p.png"));
        return P_Png;
    }
}
