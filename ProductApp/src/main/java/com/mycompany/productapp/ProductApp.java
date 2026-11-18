/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productapp;

/**
 *
 * @author Student
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductApp extends JFrame implements ActionListener {

    private static final String FILE_NAME = "data.txt";
    private static final String LINE = "******************************************";

    private final JTextField customer = new JTextField(20);
    private final JComboBox<String> product = new JComboBox<>(new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private final JTextField price = new JTextField(20);
    private final JButton process = new JButton("PROCESS");

    public ProductApp() {
        super("Product App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createMenu();
        createForm();

        pack();
        setLocationRelativeTo(null);
    }
    
    private void createForm() {
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        
        formPanel.add(new JLabel("Customer Name"));
        formPanel.add(customer);
        formPanel.add(new JLabel("Select Product"));
        formPanel.add(product);
        formPanel.add(new JLabel("Enter Price"));
        formPanel.add(price);
        
        customer.setToolTipText("Type the customer's name");
        product.setToolTipText("Choose the mattress product");
        price.setToolTipText("Type the product price, e.g. 3500");
        process.setToolTipText("Calculate and save the sale");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));
        buttonPanel.add(process);
        
        process.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });
        
        getContentPane().add(formPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void processSale() {
        String customer = customer.getText().trim();
        String product = (String) product.getSelectedItem();
        
        if (customer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the customer name.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double price;
        try {
            price = Double.parseDouble(price.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (price <= 0) {
            JOptionPane.showMessageDialog(this, "The price must be greater than zero.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        IProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();
        
        String details = "Customer Name " + customer + "\n"
                + "Product: " + product + "\n"
                + "VAT: R " + vat + "\n"
                + "COMMISSION: R " + commission + "\n"
                + "TOTAL: R " + total;
        
        JOptionPane.showMessageDialog(this, details, "Message",
                JOptionPane.INFORMATION_MESSAGE);
        
        saveToFile(details);
    }
    
    private void saveToFile(String details) {
        File text = new File(FILE_NAME);
        boolean newFile = !text.exists() || text.length() == 0;
        
        try (PrintWriter out = new PrintWriter(new FileWriter(text, true))) {
            if (newFile) {
                out.println("DATA LOG");
            }
            out.println(LINE);
            out.println(details);
            out.println(LINE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not save to file: " + e.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        ActionListener listener = new ActionListener();
    }
    
    public static void main(String[] args) {
        ProductApp app = new ProductApp();
        app.setVisible(true);
    }
}
