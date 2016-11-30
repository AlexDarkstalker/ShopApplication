package com.luxoft.shop.view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDialogUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonDelete;
    private JTextField textField1;
    private JList productsList;
    private JList orderList;
    private JList transactionList;
    private JSpinner numOfProduct;
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdd();
            }
        });
        productsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        productsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(productsList.getSelectedValuesList().size() == 0)
                    addButton.setEnabled(false);
                else
                    addButton.setEnabled(true);
            }
        });
    }

    private void onAdd() {
        int num = (Integer) this.numOfProduct.getValue();
        List<String> strings = productsList.getSelectedValuesList();
        DefaultListModel dlm = new DefaultListModel();
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

    private void outputToList(JList jlist,  DefaultListModel dlm) {
        jlist.setModel(dlm);
    }

    private DefaultListModel createModel(List<String> strings) {
        DefaultListModel<String> dlm= new DefaultListModel<>();
        for(String s:strings)
            dlm.addElement(s);
        return dlm;
    }

    public void showProducts(List<String> strings) {
        outputToList(this.productsList, createModel(strings));
    }

    public void showOrders(List<String> strings) {
        outputToList(this.transactionList, createModel(strings));
    }
}
