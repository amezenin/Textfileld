package com.company;


import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.Label;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener{
    private  JFrame F = new JFrame("Pif");
    //textfields
    private  JTextField N1 = new JTextField(10);
    private JTextField N2 = new JTextField(10);
    private JTextField N3 = new JTextField(10);
    private JTextField N4 = new JTextField(10);
    private  JTextField Biomass = new JTextField(15);
    private  JTextField Söödakogus = new JTextField(15);


    //labels
    private JLabel A = new JLabel("Biomass");
    private JLabel B = new JLabel("Söödakoef");
    private JLabel B1 = new JLabel("Sööda %");
    private JLabel B2 = new JLabel("Päevade arv");
    private JLabel C1 = new JLabel("Biomass");
    private JLabel C2 = new JLabel("Söödakogus");

    //nuppud
    private JButton Add = new JButton("Ühe päeva jaoks");
    private JButton Add2 = new JButton("Clear");
    private JButton Add3 = new JButton("Mittu päeva jaoks");

    public Main() {

        //textfield ja Labels
        JPanel P = new JPanel();

        P.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        P.add(A);
        P.add(N1);
        P.add(B);
        P.add(N2);
        P.add(B1);
        P.add(N3);
        P.add(B2);
        P.add(N4);
        P.add(C1);
        Biomass.setEditable(false);
        P.add(Biomass);
        P.add(C2);
        Söödakogus.setEditable(false);
        P.add(Söödakogus);
// panel nuppude jaoks
        JPanel P1 = new JPanel();
        P1.setLayout(new FlowLayout());
        P1.add(Add, BorderLayout.EAST);
        P1.add(Add2, BorderLayout.EAST);
        P1.add(Add3, BorderLayout.EAST);
        Add.addActionListener(this);
        Add2.addActionListener(this);
        Add3.addActionListener(this);

//Frame omadused
        F.setLayout(new BorderLayout());
        F.add(P, BorderLayout.CENTER);
        F.add(P1, BorderLayout.SOUTH);
        F.setVisible(true);
        F.setSize(900,200);

    }



    public void actionPerformed(ActionEvent e){

        if(e.getSource()==Add)
        {

                double bioMassField = Double.parseDouble(N1.getText());
                double feedConversionRatioField = Double.parseDouble(N2.getText());
                double feedAmountField = Double.parseDouble(N3.getText());
                double daysField = Double.parseDouble(N4.getText());
                double S = (bioMassField * feedAmountField / 100); //söödakogus sdelatj metodi dlja nih
                double K = S / feedConversionRatioField; //juurdekasv

                if(daysField == 1) {
                    double B = K + bioMassField; //uus biomass

                    Biomass.setText(String.valueOf(B));
                    Söödakogus.setText(String.valueOf(S));

                }




        }

        if(e.getSource()==Add2)
        {
            N1.setEditable(true);
            N2.setEditable(true);
            N3.setEditable(true);
            N4.setEditable(true);

            N1.setText(null);
            N2.setText(null);
            N3.setText(null);
            N4.setText(null);
            Biomass.setText(null);
            Söödakogus.setText(null);

        }

        if(e.getSource() == Add3) {
            uusaken();

        }

    }

    private void uusaken() {
        StackPane stack = new StackPane();
        javafx.scene.control.Label go = new javafx.scene.control.Label("Uus");
        stack.getChildren().add(go);
        Scene scene = new Scene(stack);
        Stage goStage = new Stage();
        goStage.setScene(scene);
        goStage.show();


    }

    public  static  void main(String args[]){
        new Main();
    }



}
