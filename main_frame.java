//working
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.*;


public class main_frame extends JFrame implements ActionListener {   
    JFrame frame;
    JRadioButton rb1,rb2;
    JPanel panel;
    JButton button;
    JTextField t2;
    JTextArea t1,t3;
    JLabel t4;
    // private String plainText;
    public String encryption(String text, int key){
        String encryptedText = "";

        boolean check = false;  // to check we are going up or down
        int j = 0;
        int row = key;
        int col = text.length();
        char[][] a = new char[row][col];

        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1) 
                check = !check;

            a[j][i] = text.charAt(i);

            if (check)
                j++;
            else
                j--;
        }
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if(a[i][k] != 0)
                encryptedText += a[i][k];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) 
                System.out.print(a[i][k]+ "    ");
            System.out.println();
        }
        return encryptedText;
    }
    public static String decryption(String text, int key){
        String decryptedText = "";

        boolean check = false;  // to check we are going up or down
        int j  = 0;
        int row = key;
        int col = text.length();
        char[][] a = new char[row][col];

        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1) 
                check = !check;

            a[j][i] = '*';

            if (check)
                j++;
            else
                j--;
        }

        int index = 0;
        check = false;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if(a[i][k] == '*' && index < col){
                    a[i][k] = text.charAt(index++);
                }
            }
        }

        j = 0;
        // for (int i = 0; i < row; i++) {
        //     for (int k = 0; k < col; k++) 
        //         System.out.print(a[i][k]+ "    ");
        //     System.out.println();
        // }
        
        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1) 
                check = !check;

            decryptedText += a[j][i];

            if (check)
                j++;
            else
                j--;
        }
        return decryptedText;
    }
    public main_frame(){ 
        
        // Create a new JFrame
        frame = new JFrame("Cryptography");
        frame.setSize(480, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a new JPanel
        panel = new JPanel();
        panel.setLayout(null);
        
        // Create a new JLabel
        JLabel label = new JLabel("Choose any Technique to Encrypt your Data/Message:");
        label.setBounds(50,50,350,30);
        panel.add(label);
        
        // Create two new JRadioButtons and add them to a ButtonGroup
        rb1 = new JRadioButton("Rail Fence Technique");
        rb1.setBounds(100,100,250,30);
        //rb1.addActionListener(this);
        rb2 = new JRadioButton("Simple Columnar Transposition Technique");
        rb2.setBounds(100,130,300,30);
        //rb2.addActionListener(this);
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        panel.add(rb1);
        panel.add(rb2);
        
        // Create a new JButton
        button = new JButton("Confirm");
        button.setBounds(150,180,100,30);
        button.addActionListener(this);
        panel.add(button);
        
        // Add the JPanel to the JFrame
        frame.add(panel);
        
        // Display the JFrame
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        if(rb1.isSelected() && obj==button){
            JFrame f = new JFrame("Rail Fence Technique");
            f.setSize(500,600);
            f.setVisible(true);
            //panel
            JPanel p=new JPanel();
            f.add(p);
            
            p.setLayout(null);
            //label 
            JLabel l1=new JLabel("Enter Text : ");
            l1.setBounds(100,50,100,30);
            JLabel l2=new JLabel("Enter Key : ");
            l2.setBounds(100,170,100,30);
            JLabel l3=new JLabel("Encrypted Data : ");
            l3.setBounds(100,310,100,30);
            p.add(l1);
            p.add(l2);
            p.add(l3);
            //TextField
            t1=new JTextArea(80, 150);
            t1.setBounds(100,90,250,80);
            t2=new JTextField(150);
            /*t2.getDocument().addDocumentListener(new DocumentListener(){
                public void insertUpdate(DocumentEvent e){
                    validateInput();
                }
                public void removeUpdate(DocumentEvent e){
                    validateInput();
                }
                public void changedUpdate(DocumentEvent e){
                    validateInput();
                }
                private void validateInput(){
                    String text = t2.getText();
                    text=text.replaceAll("[^\\d]","");
                    t2.setText(text);
                }    
            });*/
            t2.setBounds(100,210,250,30);
            t3 =new JTextArea(80,150);
            t3.setBounds(100,360,250,80);

            p.add(t1);
            p.add(t2);
            p.add(t3);
            //button
            JButton b1=new JButton("ENCRYPT");
            b1.setBounds(160,260,100,30);
            p.add(b1);

            b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String text=t1.getText();
                String Rkey=t2.getText();
                int key = Integer.parseInt(Rkey);

                // rf.text=plainText;
                // rf.key=keyInput;

                // String output=rf.encryption(textInput,keyInput);
                // t3.setText(output);  

                // rf.main_method();
                String encryptedText = "";
            
                boolean check = false;  // to check we are going up or down
                int j = 0;
                int row = key;
                int col = text.length();
                char[][] a = new char[row][col];
            
                 for (int i = 0; i < col; i++) {
                     if (j == 0 || j == key - 1) 
                         check = !check;
            
                      a[j][i] = text.charAt(i);
            
                    if (check)
                        j++;
                    else
                            j--;
                    }
                    for (int i = 0; i < row; i++) {
                        for (int k = 0; k < col; k++) {
                            if(a[i][k] != 0)
                            encryptedText += a[i][k];
                        }
                    }
            
                    for (int i = 0; i < row; i++) {
                        for (int k = 0; k < col; k++) 
                            System.out.print(a[i][k]+ "    ");
                        System.out.println();
                    }
                    t3.setText(encryptedText);
                }
        
            }); 

           
            /*b1.addActionListener(this);
            
            

        else if(rb2.isSelected() && obj==button){
            JFrame f = new JFrame("Columnar Transposition Technique");
            f.setSize(500,600);
            f.setVisible(true);
            //panel
            JPanel p=new JPanel();
            f.add(p);
            
            p.setLayout(null);
            //label 
            JLabel l1=new JLabel("Enter Text : ");
            l1.setBounds(100,50,100,30);
            JLabel l2=new JLabel("Enter Key : ");
            l2.setBounds(100,170,100,30);
            JLabel l3=new JLabel("Encrypted Data : ");
            l3.setBounds(100,310,100,30);
            p.add(l1);
            p.add(l2);
            p.add(l3);
            //TextField
            t1=new JTextArea(80, 150);
            t1.setBounds(100,90,250,80);
            t2=new JTextField(150);
            
            t2.setBounds(100,210,250,30);
            t3 =new JTextArea(80,150);
            t3.setBounds(100,360,250,80);

            p.add(t1);
            p.add(t2);
            p.add(t3);
            //button
            JButton b1=new JButton("ENCRYPT");
            b1.setBounds(160,260,100,30);

            b1.addActionListener(this);
            
            if(obj==b1){
                //RailFence rf=new RailFence();
                String textInput=t1.getText();
                String Rkey=t2.getText();
                int keyInput = Integer.parseInt(Rkey);
                // rf.text=plainText;
                // rf.key=keyInput;
                String output=encryption(textInput,keyInput);
                t3.setText(output);         
                // rf.main_method();
            }
            // p.add(t3);*/

        }
    }
    
    public static void main(String[] args) {
        new main_frame();
    }
}
