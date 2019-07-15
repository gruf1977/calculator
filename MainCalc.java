package Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.*;




public class MainCalc extends JFrame
{

    public static float operand;
    public static String znak;
    private static JTextField pole;


    //JButton[] button = new JButton[10];
    public MainCalc() {
        super("Calculator");
        createGUI();
    }

    public static void createGUI()
    {

        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(250, 250));


        JTextField pole = new JTextField();
        pole.setHorizontalAlignment(JTextField.RIGHT);
        pole.setFont(new Font("Dialog", Font.PLAIN, 25));


//создание панели таблицы с кнопками
        JPanel gridNumbers = new JPanel();
        JPanel gridSymb = new JPanel();
        JPanel gridDown = new JPanel();
        GridLayout layoutNums = new GridLayout(4, 3, 1, 1);

        gridNumbers.setLayout(layoutNums);
        GridLayout layoutSymb = new GridLayout(4, 1, 1, 1);


        GridLayout layoutDown = new GridLayout(1, 2, 1, 1);
        gridDown.setLayout(layoutDown);

        gridSymb.setLayout(layoutSymb);
        JButton[] button = new JButton[10];
        JLabel label = new JLabel("");
        for (int i=0; i<=9; i++){

            button[i] = new JButton(String.valueOf(i));
           button[i].setFont(new Font("Dialog", Font.PLAIN, 20));


}
        JButton buttonToska = new JButton(" . ");
        buttonToska.setFont(new Font("Dialog", Font.PLAIN, 20));


        JButton buttonC = new JButton(" C ");
        buttonC.setBackground(Color.cyan);
        buttonC.setForeground(Color.red);

        JButton buttonPlus = new JButton(" + ");
        buttonPlus.setFont(new Font("Dialog", Font.PLAIN, 20));
        buttonPlus.setBackground(Color.orange);


        JButton buttonMinus = new JButton(" - ");
        buttonMinus.setFont(new Font("Dialog", Font.PLAIN, 20));
        buttonMinus.setBackground(Color.orange);
        JButton buttonUmnozh = new JButton(" * ");
        buttonUmnozh.setFont(new Font("Dialog", Font.PLAIN, 20));
        buttonUmnozh.setBackground(Color.orange);
        JButton buttonDelen = new JButton(" / ");
        buttonDelen.setFont(new Font("Dialog", Font.PLAIN, 20));
        buttonDelen.setBackground(Color.orange);
        JButton buttonRaven = new JButton(" = ");
        buttonRaven.setBackground(Color.orange);
        buttonRaven.setFont(new Font("Dialog", Font.PLAIN, 20));

        JButton buttonStepen = new JButton(" степень ");
        buttonStepen.setBackground(Color.orange);
        buttonStepen.setFont(new Font("Dialog", Font.PLAIN, 18));






        gridDown.add(buttonRaven);

        gridDown.add(buttonStepen);

        buttonStepen.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e)
            {
                if (numeralOrNot(pole.getText())) {
                    operand =Float.parseFloat(pole.getText());
                    znak = "stepen";
                    pole.setText("");
                }
            }

        });



        gridSymb.add(buttonPlus);
        buttonPlus.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e)
            {
                if (numeralOrNot(pole.getText())) {

                    operand =Float.parseFloat(pole.getText());
                    znak = "plus";
                    pole.setText("");
                }

            }

        });
        gridSymb.add(buttonMinus);
        buttonMinus.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e)
            {
                if (numeralOrNot(pole.getText())) {
                    operand =Float.parseFloat(pole.getText());
                    znak = "minus";
                    pole.setText("");
                }
            }

        });
        gridSymb.add(buttonUmnozh);
        buttonUmnozh.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e)
            {
                if (numeralOrNot(pole.getText())) {
                    operand =Float.parseFloat(pole.getText());
                    znak = "umnozh";
                    pole.setText("");
                }
            }

        });
        gridSymb.add(buttonDelen);
        buttonDelen.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e)
            {
                if (numeralOrNot(pole.getText())) {
                    operand =Float.parseFloat(pole.getText());
                    znak = "delen";

                    pole.setText("");
                }
            }

        });


        for (int i=1; i<=9; i++){
            gridNumbers.add(button[i]);
            button[i].addActionListener(new ActionListener() {
                // @Override
                public void actionPerformed(ActionEvent e)
                {

                    pole.setText(pole.getText() + e.getActionCommand());
                }

            });

        }
        gridNumbers.add(button[0]);

        gridNumbers.add(buttonToska);

        gridNumbers.add(buttonC);


        button[0].addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e)
            {
                pole.setText(pole.getText() + e.getActionCommand());
            }

        });


        buttonToska.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e)
            {
                if (!pole.getText().contains("."))
                       pole.setText(pole.getText() + ".");
            }

        });



        buttonC.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e)
            {
                pole.setText("");
                znak = "";
            }

        });

        buttonRaven.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e) {
               float b=0f;
                if (numeralOrNot(pole.getText())) {
                    b = Float.parseFloat(pole.getText());


                if (znak == "minus") {
                    operand = operand - b;


                } else if (znak == "plus") {
                    operand = operand + b;
                    znak = "";
                } else if (znak == "stepen") {
                    double op = operand;
                    double st = b;


                    op = Math.pow(op, st);
                    operand = (float)Math.round(op);
                    znak = "";


                }

                else if (znak == ("delen")) {
                    if (b != 0 ) {
                        operand = operand / b;

                    }
                    else {
                        JOptionPane.showOptionDialog(null, "Ошибка: на ноль делить нельзя",
                                "Калькулятор: Ошибка!",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    }

                } else if (znak == ("umnozh")) {
                    operand = operand * b;

                } else {
                    operand = operand;

                }
                    znak = "";
                pole.setText(operand + "");

            }
        }
        });



//размещние панелей

        Container container = frame.getContentPane();
        container.setFont(new Font("Dialog", Font.PLAIN, 20));
        container.add(pole, "North");
        container.add(gridNumbers, "Center");
        container.add(gridSymb, "East");
        container.add(gridDown, "South");
        frame.pack();
        frame.setVisible(true);



    }


  //  Для проверки double чисел

    private static boolean numeralOrNot(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int commaCount = 0;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '.') {
                commaCount++;
            }
            if ((!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.' && str.charAt(i) != '-') || commaCount > 1) {
                return false;
            }
        }

        return true;
    }
public void messErr(){
    JOptionPane.showMessageDialog(MainCalc.this,
            "<html><h2>Текст</h2><i>На ноль делить нельзя!</i>");
}

    public static void main(String[] args)
    {

        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();

            }
        });
    }
}