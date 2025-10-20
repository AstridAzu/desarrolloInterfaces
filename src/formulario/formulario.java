package formulario;

import javax.swing.*;
import java.awt.*;

public class formulario  extends Component {
    private JTextField nombreTextField;
    private JTextField emailTextField;
    private JTextArea mensajeTextArea;
    private JPanel panelContenedor;
    private JButton enviarButton;

    public formulario() {
        enviarButton.addActionListener(e -> {
            String nombre = nombreTextField.getText();
            String email = emailTextField.getText();

            JOptionPane.showMessageDialog(formulario.this,
                    "Mensaje enviado por: " + nombre +" email: "+email,
                    "mensage",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //titulo de la ventana
                JFrame frame = new JFrame("Formulario Contacto");
                //instancio la clase FormularioContacto
                formulario Formulario= new formulario();
                //le doy a frame el formulario que creamos
                frame.setContentPane(Formulario.panelContenedor);
                //ajusto el tamaño de la ventana al contenido preferido
                frame.pack();
                //centro la ventana
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
