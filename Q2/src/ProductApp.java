import javax.swing.*;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {
    private final JTextField txtName = new JTextField();
    private final JTextField txtPrice = new JTextField();
    private final JComboBox<String> cmbProduct = new JComboBox<>(
        new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});

    public ProductApp() {
        super("Product App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem miProcess = new JMenuItem("Process");
        JMenuItem miClear = new JMenuItem("Clear");
        JMenuItem miExit = new JMenuItem("Exit");
        file.add(miExit);
        edit.add(miProcess);
        edit.add(miClear);
        bar.add(file);
        bar.add(edit);
        setJMenuBar(bar);

        JButton btnProcess = new JButton("PROCESS");

        add(new JLabel("Customer Name:"));  add(txtName);
        add(new JLabel("Select Product:")); add(cmbProduct);
        add(new JLabel("Enter Price:"));    add(txtPrice);
        add(new JLabel());                  add(btnProcess);

        btnProcess.addActionListener(e -> process());
        miProcess.addActionListener(e -> process());
        miClear.addActionListener(e -> clear());
        miExit.addActionListener(e -> System.exit(0));

        setSize(400, 220);
        setLocationRelativeTo(null);
    }

    private void process() {
        try {
            String name = txtName.getText().trim();
            String product = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText().trim());
            if (name.isEmpty()) throw new IllegalArgumentException();

            IProductCalculations calc = new ProductCalculations(price);
            String msg = "Customer Name: " + name
                + "\nProduct: " + product
                + "\nVAT: R " + calc.GetVat()
                + "\nCOMMISSION: R " + calc.GetCommission()
                + "\nTOTAL: R " + calc.GetTotal();
            JOptionPane.showMessageDialog(this, msg);
            saveToFile(msg);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Enter a customer name and a valid numeric price.");
        }
    }

    private void saveToFile(String msg) {
        try (FileWriter fw = new FileWriter("data.txt", true)) {
            fw.write("DATA LOG\n" + "*".repeat(30) + "\n" + msg + "\n" + "*".repeat(30) + "\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not write to data.txt");
        }
    }

    private void clear() {
        txtName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
