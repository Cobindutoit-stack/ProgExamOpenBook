package q2;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Estate agent report GUI (Q.2.1 - Q.2.6).
 * Calculation and validation are delegated to the EstateAgent class.
 */
public class EstateAgentGUI extends JFrame {

    // Q.2.1 - form components
    private final String[] locations = { "Cape Town", "Durban", "Pretoria" };
    private final JComboBox<String> cmbLocation = new JComboBox<>(locations);
    private final JTextField txtName = new JTextField(15);
    private final JTextField txtPrice = new JTextField(15);
    private final JTextField txtCommission = new JTextField(15);
    private final JTextArea txtReport = new JTextArea(6, 20);

    private final EstateAgent estateAgent = new EstateAgent();

    public EstateAgentGUI() {
        setTitle("Estate Agent Report");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        buildMenu();
        buildForm();

        pack();
        setLocationRelativeTo(null); // centre on screen
    }

    /** Q.2.2 - builds the File and Tools menus and wires up the actions. */
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process Report");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem saveItem = new JMenuItem("Save Report");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        toolsMenu.add(saveItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Q.2.3 - Exit closes the application
        exitItem.addActionListener(e -> System.exit(0));
        processItem.addActionListener(e -> processReport());
        clearItem.addActionListener(e -> clearForm());
        saveItem.addActionListener(e -> saveReport());
    }

    /** Q.2.1 - lays out the labels, input fields and report text area. */
    private void buildForm() {
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        inputPanel.add(new JLabel("AGENT LOCATION:"));
        inputPanel.add(cmbLocation);
        inputPanel.add(new JLabel("ESTATE AGENT NAME:"));
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("PROPERTY PRICE:"));
        inputPanel.add(txtPrice);
        inputPanel.add(new JLabel("COMMISSION PERCENTAGE:"));
        inputPanel.add(txtCommission);

        txtReport.setEditable(false);
        JPanel reportPanel = new JPanel(new BorderLayout(5, 5));
        reportPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        reportPanel.add(new JLabel("ESTATE AGENT REPORT:"), BorderLayout.NORTH);
        reportPanel.add(new JScrollPane(txtReport), BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(reportPanel, BorderLayout.CENTER);
    }

    /** Q.2.4 - validates the input, calculates the commission and shows the report. */
    private void processReport() {
        Data data = new Data(
                (String) cmbLocation.getSelectedItem(),
                txtName.getText().trim(),
                txtPrice.getText().trim(),
                txtCommission.getText().trim());

        // Q.2.7 - only valid data is accepted
        if (!estateAgent.ValidateData(data)) {
            JOptionPane.showMessageDialog(this,
                    "Invalid data. Location and name cannot be empty, and\n"
                  + "price and commission must be numbers greater than zero.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double commission = estateAgent.CalculateCommission(
                data.getPropertyPrice(), data.getCommissionPercentage());

        txtReport.setText(
                "AGENT LOCATION: " + data.getAgentLocation() + "\n"
              + "AGENT NAME: " + data.getAgentName() + "\n"
              + "PROPERTY PRICE: R " + Double.parseDouble(data.getPropertyPrice()) + "\n"
              + "COMMISSION PERCENTAGE: " + Double.parseDouble(data.getCommissionPercentage()) + "%\n"
              + "CALCULATED COMMISSION: R " + commission);
    }

    /** Q.2.6 - resets the text fields, combo box and text area. */
    private void clearForm() {
        cmbLocation.setSelectedIndex(0);
        txtName.setText("");
        txtPrice.setText("");
        txtCommission.setText("");
        txtReport.setText("");
    }

    /** Q.2.5 - saves the report to report.txt. */
    private void saveReport() {
        if (txtReport.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Process a report before saving.",
                    "Nothing to Save", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String stars = "*".repeat(36);
        try (PrintWriter out = new PrintWriter(new FileWriter("report.txt"))) {
            out.println("ESTATE AGENT REPORT");
            out.println(stars);
            out.println(txtReport.getText());
            out.println(stars);
            JOptionPane.showMessageDialog(this, "Report saved to report.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save the report: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EstateAgentGUI().setVisible(true));
    }
}
