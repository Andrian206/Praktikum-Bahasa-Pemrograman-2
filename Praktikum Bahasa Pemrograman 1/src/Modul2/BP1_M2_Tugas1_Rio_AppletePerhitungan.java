package Modul2;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class BP1_M2_Tugas1_Rio_AppletePerhitungan extends Applet {
    private Label label1, label2, label3, label4;
    private TextField textField1, textField2, textField3;
    private Button button1, button2, button3, button4;
    @Override
    public void init() {
        setLayout(null); 

        label1 = new Label("Kalkulator Sederhana");
        label1.setBounds(100, 10, 120, 20);
        add(label1);

        label2 = new Label("Bilangan 1");
        label2.setBounds(30, 50, 70, 20);
        add(label2);

        textField1 = new TextField();
        textField1.setBounds(150, 50, 156, 20);
        add(textField1);

        label3 = new Label("Bilangan 2");
        label3.setBounds(30, 80, 70, 20);
        add(label3);

        textField2 = new TextField();
        textField2.setBounds(150, 80, 156, 20);
        add(textField2);
        
        label4 = new Label("Hasil");
        label4.setBounds(30, 110, 70, 20);
        add(label4);

        textField3 = new TextField();
        textField3.setBounds(150, 110, 156, 20);
        textField3.setEditable(false);
        add(textField3);

        button1 = new Button("+");
        button1.setBounds(30, 140, 65, 30);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                calculate('+');
            }
        });
        add(button1);

        button2 = new Button("-");
        button2.setBounds(100, 140, 65, 30);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                calculate('-');
            }
        });
        add(button2);

        button3 = new Button("x");
        button3.setBounds(170, 140, 65, 30);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                calculate('*');
            }
        });
        add(button3);

        button4 = new Button("/");
        button4.setBounds(240, 140, 65, 30);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                calculate('/');
            }
        });
        add(button4);
    }
    private void calculate(char operator) {
        try {
            float bil1 = Float.parseFloat(textField1.getText());
            float bil2 = Float.parseFloat(textField2.getText());
            float hasil = 0;

            switch (operator) {
                case '+':
                    hasil = bil1 + bil2;
                    break;
                case '-':
                    hasil = bil1 - bil2;
                    break;
                case '*':
                    hasil = bil1 * bil2;
                    break;
                case '/':
                    if (bil2 != 0) {
                        hasil = bil1 / bil2;
                    } else {
                        textField3.setText("Hasil tidak terdefinisi");
                        return;
                    }
                    break;
            }
            textField3.setText(String.valueOf(hasil));
        } catch (NumberFormatException e) {
            textField3.setText("Input tidak valid");
        }
    }
}
