package com.sebright;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class SolveQuadraticApp implements ActionListener {
    private JButton btnSolve;
    private JPanel panelMain;
    private JTextField a_textField;
    private JLabel title;
    private JTextField b_textField;
    private JTextField c_textField;
    private JLabel numSols;
    private JLabel labelDeterminant;
    private JLabel labelSol1;
    private JLabel labelSol2;
    private JLabel label_a;
    private JLabel label_f_x;
    private JLabel label_not_numberformat;

    public static final String TEXT_LABEL_A = "a";
    public static final String TEXT_LABEL_A_ERROR = "a (cannot be ZERO!)";

    public static final double DEFAULT_A = 1;
    public static final double DEFAULT_B = 2;
    public static final double DEFAULT_C = 1;

    public SolveQuadraticApp() {
        btnSolve.addActionListener(this);
        hideSolutionViews();
        label_not_numberformat.setVisible(false);
        setupDefaultValuesAndDisplaySolutions();
    }

    private void setupDefaultValuesAndDisplaySolutions() {
        a_textField.setText(String.valueOf(DEFAULT_A));
        b_textField.setText(String.valueOf(DEFAULT_B));
        c_textField.setText(String.valueOf(DEFAULT_C));
        calculateAndDisplaySolutions(DEFAULT_A, DEFAULT_B, DEFAULT_C);
    }

    private void showNumberFormatError() {
        label_not_numberformat.setVisible(true);
        label_not_numberformat.setText("a, b and c must all be numbers!");
        label_not_numberformat.setForeground(Color.RED);
    }

    private final JLabel[] solutionLabels = {
            label_f_x, numSols, labelDeterminant, labelSol1, labelSol2
    };

    private void showSolutionViews() {
        for (JLabel solutionLabel : solutionLabels) {
            solutionLabel.setVisible(true);
        }
    }

    private void hideSolutionViews() {
        for (JLabel solutionLabel : solutionLabels) {
            solutionLabel.setVisible(false);
        }
    }

    private void calculateAndDisplaySolutions(double a, double b, double c) throws MitternachtsFormula.A_isZeroException {
        MitternachtsFormula mitternachtsFormula = new MitternachtsFormula(a, b, c);
        displaySolutions(mitternachtsFormula);
    }

    private void displaySolutions(MitternachtsFormula mitternachtsFormula) {
        showSolutionViews();
        BigDecimal[] solutions = mitternachtsFormula.solve();
        int numSols = solutions.length;
        BigDecimal D = mitternachtsFormula.getDeterminant().stripTrailingZeros();
        String formula = mitternachtsFormula.formula();

        this.numSols.setText(String.valueOf(numSols));
        labelDeterminant.setText(String.valueOf(D));

        if (numSols >= 1) {
            String sol1;
            if(numSols == 1)
                sol1 = "<html>" +"x<sub>1</sub> = x<sub>2</sub> =" + solutions[0]+ "</html>";
            else sol1 = "<html>" +"x<sub>1</sub> =" + solutions[0]+ "</html>";
            labelSol1.setText(sol1);
            if (numSols == 2) {
                labelSol2.setText("<html>" +"x<sub>2</sub> = " + solutions[1]+ "</html>");
            } else {
                labelSol2.setVisible(false);
            }
            formula = "<html>" + formula + "<br>= " + mitternachtsFormula.binomial(solutions) + "</html>";
        } else {
            labelSol1.setText("No solutions possible because of negative determinant");
            labelSol2.setVisible(false);
        }
        label_f_x.setText(formula);
    }

    public static void main(String[] args) {
        showInputPane();
    }

    private static void showInputPane() {
        JFrame frame = new JFrame("Solve Quadratic");
        frame.setSize(600, 400);
        frame.setContentPane(new SolveQuadraticApp().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make appear in center
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            label_not_numberformat.setVisible(false);
            double a = Double.parseDouble(a_textField.getText());
            double b = Double.parseDouble(b_textField.getText());
            double c = Double.parseDouble(c_textField.getText());
            try {
                label_a.setText(TEXT_LABEL_A);
                calculateAndDisplaySolutions(a, b, c);
            } catch (MitternachtsFormula.A_isZeroException a_isZeroException) {
                label_a.setText(TEXT_LABEL_A_ERROR);
                hideSolutionViews();
            }
        } catch (NumberFormatException numberFormatException) {
            showNumberFormatError();
            hideSolutionViews();
        }
    }
}
