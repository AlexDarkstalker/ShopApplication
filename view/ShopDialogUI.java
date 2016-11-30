package com.luxoft.shop.view;

import javax.swing.*;

public class ShopDialogUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JList list1;

    public ShopDialogUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        ShopDialogUI dialog = new ShopDialogUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
