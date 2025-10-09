import javax.swing.*; // Libreria Swing para componentes GUI
import java.awt.*; // Libreria AWT para elementos visuales básicos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearYMostrarGUI();
            }
        });
    }

    private static void crearYMostrarGUI() {
        JFrame ventana = new JFrame("Mi Primera Ventana GUI");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //dimenciones de la ventana
        ventana.setSize(400, 400);
        ventana.getContentPane().setBackground(Color.RED);

        // Crear etiquetas
        JLabel etiqueta = new JLabel("Bienvenido a interfaces");
        JLabel etiqueta1 = new JLabel("SONRIE...");

        etiqueta.setFont(new Font("Arial", Font.BOLD, 16));
        etiqueta1.setFont(new Font("Arial", Font.BOLD, 16));
        etiqueta.setForeground(Color.WHITE);
        etiqueta1.setForeground(Color.YELLOW);

        // Panel negro que contendrá las dos frases
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(Color.BLACK);
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        // Centrar horizontalmente las etiquetas dentro del panel
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiqueta1.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(etiqueta);
        panelCentral.add(Box.createVerticalStrut(5)); // pequeña separación
        panelCentral.add(etiqueta1);
        //creamos el boton
        JButton boton = new JButton("clip");
        //agregar funcionalidad
        boton.addActionListener((new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                 //mostrar la ventana  con el metodo showMessageDialog
                JOptionPane.showMessageDialog(ventana,"en hora buena");
            }

        }));

        JPanel panelBoton = new JPanel();
        panelBoton.add(boton);
        ventana.getContentPane().add(panelBoton, BorderLayout.SOUTH);
        // Panel exterior que centrará todo vertical y horizontalmente
        JPanel panelExterior = new JPanel(new GridBagLayout());
        panelExterior.setBackground(Color.black);
        panelExterior.add(panelCentral); // GridBagLayout centra su contenido por defecto

        // Agregar el panel exterior al centro de la ventana
        ventana.getContentPane().add(panelExterior, BorderLayout.CENTER);

        // Centrar la ventana en pantalla
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}