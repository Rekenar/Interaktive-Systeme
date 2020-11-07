package at.ias.mvc;

import at.ias.mvc.interfaces.Observer;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class View2 extends JFrame implements Observer {

    private JPanel contentPane;
    private Model model;
    private JComboBox comboBox;

    /**
     * Create the frame.
     */
    public View2(Model model) {
        setTitle("View 2");
        this.model = model;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 100, 450, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        Object[] items = {
                new ImageIcon("D:\\Programme\\GitHub\\Interaktive-Systeme\\Blatt 3\\Example_MVC\\src\\at\\ias\\mvc\\sad.png"),
                new ImageIcon("D:\\Programme\\GitHub\\Interaktive-Systeme\\Blatt 3\\Example_MVC\\src\\at\\ias\\mvc\\happy.png"),
                new ImageIcon("D:\\Programme\\GitHub\\Interaktive-Systeme\\Blatt 3\\Example_MVC\\src\\at\\ias\\mvc\\angry.png"),
                new ImageIcon("D:\\Programme\\GitHub\\Interaktive-Systeme\\Blatt 3\\Example_MVC\\src\\at\\ias\\mvc\\very_happy.png"),
        };
        comboBox = new JComboBox(items);
        comboBox.setEnabled(false);
        contentPane.add(comboBox,BorderLayout.CENTER);

    }

    @Override
    public void notifyUpdate() {
        if(model.getConsumption() < 25 && model.getConsumption() >13){
            comboBox.setSelectedIndex(1);
        }else if(model.getConsumption() <=13){
            comboBox.setSelectedIndex(3);
        }else if(model.getConsumption() >=25 && model.getConsumption() < 37){
            comboBox.setSelectedIndex(0);
        }else if(model.getConsumption() >=38){
            comboBox.setSelectedIndex(2);
        }
    }
}
