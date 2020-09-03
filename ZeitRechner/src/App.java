import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    private JTextField textField1;
    private JPanel panelMain;
    private JLabel error_label;
    private JCheckBox jahrtausendeCheckBox;
    private JCheckBox jahrhunderteCheckBox;
    private JCheckBox jahrzehnteCheckBox;
    private JCheckBox jahreCheckBox;
    private JCheckBox monateCheckBox;
    private JCheckBox tageCheckBox;
    private JCheckBox stundenCheckBox;
    private JCheckBox minutenCheckBox;
    private JCheckBox sekundenCheckBox;
    private JLabel resJT;
    private JLabel resJH;
    private JLabel resJZ;
    private JLabel resJ;
    private JLabel resMon;
    private JLabel resT;
    private JLabel resStu;
    private JLabel resMin;
    private JLabel resSek;
    private JButton unselectAllUnitsButton;
    private JButton selectAllUnitsButton;

    private List<UnitSelectionItem> unitSelectionItems() {
        return Arrays.asList(
                new UnitSelectionItem(jahrtausendeCheckBox, resJT, ZeitRechner.TIME.YEAR_1000),
                new UnitSelectionItem(jahrhunderteCheckBox, resJH, ZeitRechner.TIME.YEAR_100),
                new UnitSelectionItem(jahrzehnteCheckBox, resJZ, ZeitRechner.TIME.YEAR_10),
                new UnitSelectionItem(jahreCheckBox, resJ, ZeitRechner.TIME.YEAR),
                new UnitSelectionItem(monateCheckBox, resMon, ZeitRechner.TIME.MONTH),
                new UnitSelectionItem(tageCheckBox, resT, ZeitRechner.TIME.DAY),
                new UnitSelectionItem(stundenCheckBox, resStu, ZeitRechner.TIME.HOUR),
                new UnitSelectionItem(minutenCheckBox, resMin, ZeitRechner.TIME.MINUTE),
                new UnitSelectionItem(sekundenCheckBox, resSek, ZeitRechner.TIME.SECOND)
        );
    }

    private ArrayList<UnitSelectionItem> getSelectedUnitSelectionsItems() {
        ArrayList<UnitSelectionItem> selected = new ArrayList<>();
        for (UnitSelectionItem unitSelectionItem : unitSelectionItems()) {
            if (unitSelectionItem.checkBox.isSelected()) selected.add(unitSelectionItem);
        }
        return selected;
    }


    private List<UnitSelectionItem> getNotSelectedItems() {
        ArrayList<UnitSelectionItem> notSelected = new ArrayList<>();
        for (UnitSelectionItem unitSelectionItem : unitSelectionItems()) {
            if (!unitSelectionItem.checkBox.isSelected()) notSelected.add(unitSelectionItem);
        }
        return notSelected;
    }

    public static void main(String[] args) {
        showInputPane();
    }

    private void displayCurrentText(String keyAction) {
        System.out.println(keyAction + " :" + textField1.getText());
    }

    public App() {
        error_label.setVisible(false);
        selectAllCheckBoxesAndSetLabelTextToEmptyAndSetClickListeners();
        setListenerOnInputTextField();
        setButtonListeners();
        showDefaultValue();
    }

    private void showDefaultValue() {
        textField1.setText("999555000");
        attemptCalculationOrHandlePossibleError();
    }

    private void setButtonListeners() {
        selectAllUnitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (UnitSelectionItem item : unitSelectionItems()) {
                    item.checkBox.setSelected(true);
                }
                attemptCalculationOrHandlePossibleError();
            }
        });

        unselectAllUnitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (UnitSelectionItem item : unitSelectionItems()) {
                    if (!item.checkBox.equals(sekundenCheckBox)) item.checkBox.setSelected(false);
                }
                attemptCalculationOrHandlePossibleError();
            }
        });
    }

    private void setListenerOnInputTextField() {
        textField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                displayCurrentText("typed");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                displayCurrentText("pressed");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                displayCurrentText("released");
                attemptCalculationOrHandlePossibleError();
            }
        });
    }

    private void selectAllCheckBoxesAndSetLabelTextToEmptyAndSetClickListeners() {
        for (UnitSelectionItem item : unitSelectionItems()) {
            item.checkBox.setSelected(true);
            item.resultLabel.setText(null);
            item.checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    attemptCalculationOrHandlePossibleError();
                }
            });
        }
    }

    private void attemptCalculationOrHandlePossibleError() {
        String text = textField1.getText();
        try {
            BigInteger sec = getSecondsFromInput(text);
            error_label.setVisible(false);
            calculateAndDisplaySolutions(sec);
        } catch (NumberFormatException numberFormatException) {
            if (!text.isEmpty()) {
                error_label.setVisible(true);
            } else {
                error_label.setVisible(false);
            }
        }
    }

    private void calculateAndDisplaySolutions(BigInteger sec) {
        ZeitRechner zeitRechner = new ZeitRechner(sec);
        ArrayList<BigInteger> solutions = zeitRechner.popAll(getSelectedTimeUnits());
        ArrayList<UnitSelectionItem> selectedUnitSelectionItems = getSelectedUnitSelectionsItems();
        for (int i = 0; i < selectedUnitSelectionItems.size(); i++) {
            BigInteger sol = solutions.get(i);
            JLabel resLabel = selectedUnitSelectionItems.get(i).resultLabel;
            resLabel.setText(sol.toString());
        }
        showZeroForAllUnselectedItems();
    }

    private void showZeroForAllUnselectedItems() {
        for (UnitSelectionItem notSelectedItem : getNotSelectedItems()) {
            notSelectedItem.resultLabel.setText(String.valueOf(0));
        }
    }

    private ArrayList<BigInteger> getSelectedTimeUnits() {
        ArrayList<BigInteger> selectedTimeUnits = new ArrayList<>();
        for (UnitSelectionItem selectedUnit : getSelectedUnitSelectionsItems()) {
            selectedTimeUnits.add(selectedUnit.timeUnit);
        }
        return selectedTimeUnits;
    }

    private BigInteger getSecondsFromInput(String input) throws NumberFormatException {
        return new BigInteger(input);
    }

    private static void showInputPane() {
        JFrame frame = new JFrame("Zeit Rechner");
        frame.setSize(600, 400);
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make appear in center
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static class UnitSelectionItem {
        JCheckBox checkBox;
        JLabel resultLabel;
        BigInteger timeUnit;

        public UnitSelectionItem(JCheckBox checkBox, JLabel resultLabel, BigInteger timeUnit) {
            this.checkBox = checkBox;
            this.resultLabel = resultLabel;
            this.timeUnit = timeUnit;
        }

        public JCheckBox getCheckBox() {
            return checkBox;
        }

        public void setCheckBox(JCheckBox checkBox) {
            this.checkBox = checkBox;
        }

        public JLabel getResultLabel() {
            return resultLabel;
        }

        public void setResultLabel(JLabel resultLabel) {
            this.resultLabel = resultLabel;
        }

        public BigInteger getTimeUnit() {
            return timeUnit;
        }

        public void setTimeUnit(BigInteger timeUnit) {
            this.timeUnit = timeUnit;
        }
    }
}
