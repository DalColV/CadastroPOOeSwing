import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

class MainFrame extends JFrame {
    private final ProductRegister catalog;
    private final JTextArea textArea;

    public MainFrame() {
        catalog = new ProductRegister();
        setTitle("Product Catalog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBackground(new Color(0xE1DFDF));

        JLabel nameLabel = new JLabel("Product Name:");
        JTextField nameField = new JTextField();
        nameField.setBackground(new Color(0xD7D2E5));
        JLabel descLabel = new JLabel("Product Description:");
        JTextField descField = new JTextField();
        descField.setBackground(new Color(0xD7D2E5));
        JLabel priceLabel = new JLabel("Product Price:");
        JTextField priceField = new JTextField();
        priceField.setBackground(new Color(0xD7D2E5));
        JButton addButton = new JButton("Add Product");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String description = descField.getText();
                double price = Double.parseDouble(priceField.getText());
                catalog.addProduct(new Product(name, description, price));
                freshTextArea();
            }
        });
        addButton.setBackground(new Color(0xA2A0A0));

        JButton newProductButton = new JButton("Add New Product");
        newProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                descField.setText("");
                priceField.setText("");
            }
        });

        newProductButton.setBackground(new Color(0xA2A0A0));

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(descLabel);
        panel.add(descField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(addButton);
        panel.add(newProductButton);



        add(panel, BorderLayout.NORTH);

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton listButton = new JButton("Sort Products By Price");
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                catalog.sortProductsByPrice();
                freshTextArea();
            }
        });
        add(listButton, BorderLayout.SOUTH);
        listButton.setBackground(new Color(0xA2A0A0));


        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void freshTextArea() {
        textArea.setText("");
        for (Product product : catalog.listProducts()) {
            textArea.append(product.toString() + "\n");
        }
    }
}