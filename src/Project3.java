/* File:    Project3.Java
   Author:  Darryl McDaniel
   Date:    September 29th, 2020
   Purpose: This program draws two types of shapes and displays them on a drawing area
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

class Project3 extends JFrame {

    String[] shapeType = {"Rectangle", "Oval"};
    String[] fillType = {"Hollow", "Solid"};
    String[] shapeColor = {"BLACK", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "MAGENTA"};
    JButton btnDraw = new JButton("Draw!");
    JLabel shapeTypeLbl = new JLabel("Shape Type");
    JLabel fillTypeLbl = new JLabel("Fill Type");
    JLabel colorLbl = new JLabel("Color");
    JLabel widthLbl = new JLabel("Width");
    JLabel heightLbl = new JLabel("Height");
    JLabel xLbl = new JLabel("x Coordinate");
    JLabel yLbl = new JLabel("y Coordinate");
    JComboBox shapeTypeBox = new JComboBox(shapeType);;
    JComboBox fillTypeBox = new JComboBox(fillType);
    JComboBox shapeColorBox = new JComboBox(shapeColor);
    JTextField widthField = new JTextField(20);
    JTextField heightField = new JTextField(20);
    JTextField xField = new JTextField(20);
    JTextField yField = new JTextField(20);

    JPanel shapeProperties = new JPanel();
    JPanel drawPanel = new JPanel();
    JPanel drawingArea = new JPanel();


    Project3() {

        Drawing drawArea = new Drawing();

        shapeProperties.setLayout(new GridLayout(7, 2, -120, 5));
        shapeProperties.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        shapeProperties.setSize(200,200);
        shapeProperties.add(shapeTypeLbl);
        shapeProperties.add(shapeTypeBox);
        shapeProperties.add(fillTypeLbl);
        shapeProperties.add(fillTypeBox);
        shapeProperties.add(colorLbl);
        shapeProperties.add(shapeColorBox);
        shapeProperties.add(widthLbl);
        shapeProperties.add(widthField);
        shapeProperties.add(heightLbl);
        shapeProperties.add(heightField);
        shapeProperties.add(xLbl);
        shapeProperties.add(xField);
        shapeProperties.add(yLbl);
        shapeProperties.add(yField);

        add(shapeProperties, BorderLayout.LINE_START);


        drawingArea.setBorder(BorderFactory.createTitledBorder("Shape Drawing"));
        drawingArea.add(drawArea);
        add(drawingArea, BorderLayout.LINE_END);
        drawPanel.add(btnDraw);
        add(drawPanel, BorderLayout.SOUTH);

        btnDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color inputColor = null;
                Boolean inputFillType = null;

                if (shapeColorBox.getSelectedItem() == shapeColor[0]) {
                    inputColor = Color.BLACK;
                }
                if (shapeColorBox.getSelectedItem() == shapeColor[1]) {
                    inputColor = Color.red;
                }
                if (shapeColorBox.getSelectedItem() == shapeColor[2]) {
                    inputColor = Color.orange;
                }
                if (shapeColorBox.getSelectedItem() == shapeColor[3]) {
                    inputColor = Color.yellow;
                }
                if (shapeColorBox.getSelectedItem() == shapeColor[4]) {
                    inputColor = Color.green;
                }
                if (shapeColorBox.getSelectedItem() == shapeColor[5]) {
                    inputColor = Color.BLUE;
                }
                if (shapeColorBox.getSelectedItem() == shapeColor[6]) {
                    inputColor = Color.magenta;
                }

                if(fillTypeBox.getSelectedItem() == fillType[0]){
                    inputFillType = true;
                }
                if(fillTypeBox.getSelectedItem() == fillType[1]){
                    inputFillType = false;
                }

                try {
                    Rectangle inputShape = new Rectangle(Integer.parseInt(xField.getText()), Integer.parseInt(yField.getText()),
                            Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()));

                    if (shapeTypeBox.getSelectedItem() == "Oval") {
                        Shape newShape = new Oval(inputShape, inputColor, inputFillType);
                        drawArea.drawShape(newShape);
                    }
                    if (shapeTypeBox.getSelectedItem() == "Rectangle") {
                        Shape newShape = new Rectangular(inputShape, inputColor, inputFillType);
                        drawArea.drawShape(newShape);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(drawPanel, "Invalid Input");
                }
            }

        });

    }

    public static void main(String[] args) {
        Project3 prjt = new Project3();
        prjt.setTitle("Geometric Drawing");
        prjt.setSize(800, 375);
        prjt.setLocationRelativeTo(null);
        prjt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prjt.pack();
        prjt.setVisible(true);
    }


}
