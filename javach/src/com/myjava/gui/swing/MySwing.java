package com.myjava.gui.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MySwing extends javax.swing.JFrame {
    private JButton jButton1;

    /**
    * Auto-generated main method to display this JFrame
    */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MySwing inst = new MySwing();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public MySwing() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            getContentPane().setLayout(null);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            {
                jButton1 = new JButton();
                getContentPane().add(jButton1);
                FlowLayout jButton1Layout = new FlowLayout();
                jButton1.setLayout(null);
                jButton1.setText("\u6211\u7684\u6309\u94ae");
                jButton1.setBounds(179, 40, 102, 24);
                jButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        System.out.println("jButton1.actionPerformed, event=" + evt);
                        //TODO add your code for jButton1.actionPerformed
                    }
                });
            }
            pack();
            this.setSize(475, 400);
        } catch (Exception e) {
            //add your error handling code here
            e.printStackTrace();
        }
    }

}
