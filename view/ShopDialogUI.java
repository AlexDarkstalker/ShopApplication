package com.luxoft.shop.view;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class ShopDialogUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonDelete;
    private JTextField textField1;
    private JList productsList;
    private JList orderList;
    private JList transactionList;
    private JSpinner spinner1;
    private JButton addButton;

    public ShopDialogUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ShopDialogUI dialog = new ShopDialogUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void outputProducts(DefaultListModel dlm) {
        this.productsList.setModel(dlm);
    }

    public void showProducts(List<String> strings) {
        DefaultListModel<String> dlm= new DefaultListModel<>();
        for(String s:strings)
            dlm.addElement(s);
        outputProducts(dlm);
    }
}
