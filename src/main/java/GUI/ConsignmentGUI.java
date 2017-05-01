package GUI;

import Constractor.Record;
import Database.RecordDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by mash4 on 4/30/2017.
 */
public class ConsignmentGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField consgnorNametextField;
    private JTextField phonetextField;
    private JTable consignmenttable;
    private JRadioButton addNewConsignorRadioButton;
    private JButton submitButton;
    private JRadioButton addConsignmentRadioButton;
    private JTextField consgnmtIDtextField;
    private JLabel consLable;
    private JLabel phoneLable;
    private JLabel itemsTextFiled;
    private JTextField artitstextField;
    private JTextField textField1;

    public ConsignmentGUI(){
        setTitle("Consignment Project !!!!!!");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addNewConsignorRadioButton.isSelected()){
                    String  name = consgnorNametextField.getText();
                    if(name.trim().length() == 0){
                        JOptionPane.showMessageDialog(ConsignmentGUI.this, "Please type a consignor name !!!");
                        return;
                    }
                    String phone = phonetextField.getText();
                    if(phone.trim().length() <= 0 || phone.trim().length() >= 4){
                        JOptionPane.showMessageDialog(ConsignmentGUI.this, "Please ,  consignor's phone number must be 0-4 numbers !!!");
                    }
                    Record record = new Record(name, phone);
                    RecordDB r = new RecordDB();
                    r.crearNewConsgrTable(record);
                }

                //Adding a consignment - adding records
                if(addConsignmentRadioButton.isSelected()){
                    int items ;
                    try{
                        items =  Integer.parseInt(consgnmtIDtextField.getText());
                        if(items <= 0){
                            JOptionPane.showMessageDialog(ConsignmentGUI.this,
                                    "Please enter a positive number !!!");
                            return;
                        }

                    }catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(ConsignmentGUI.this, "Please type a whole number ");
                    }
                    RecordDB r = new RecordDB();




                }

            }
        });
        addNewConsignorRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(addNewConsignorRadioButton.isSelected()){
                    addConsignmentRadioButton.setEnabled(false);
                    consLable.setVisible(true);
                    phoneLable.setVisible(true);
                    consgnorNametextField.setVisible(true);
                    phonetextField.setVisible(true);
                    itemsTextFiled.setVisible(false);
                    consgnmtIDtextField.setVisible(false);
                }
                else{
                    addConsignmentRadioButton.setEnabled(true);
                    itemsTextFiled.setVisible(true);
                    consgnmtIDtextField.setVisible(true);
                }
            }
        });
        addConsignmentRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(addConsignmentRadioButton.isSelected()){
                    itemsTextFiled.setVisible(true);
                    consgnmtIDtextField.setVisible(true);
                    addNewConsignorRadioButton.setEnabled(false);
                    consLable.setVisible(false);
                    phoneLable.setVisible(false);
                    consgnorNametextField.setVisible(false);
                    phonetextField.setVisible(false);


                }
                else {
                    addNewConsignorRadioButton.setEnabled(true);
                    consLable.setVisible(true);
                    phoneLable.setVisible(true);
                    consgnorNametextField.setVisible(true);
                    phonetextField.setVisible(true);
                }
            }
        });
    }
}
