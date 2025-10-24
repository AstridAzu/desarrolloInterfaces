package formulario;

import javax.swing.*;
import java.awt.*;

public class IngresarDatos extends Component {
    private JTextField nombreTextField;
    private JTextField apellidoTextField;
    private JButton limpiarButton;
    private JButton enviarButton;
    private JTextField emailTextField;
    private JTextField telefonoTextField;
    private JTextArea mensajeTextArea;
    private JPanel contenedor;

    public IngresarDatos() {
        enviarButton.addActionListener(e -> {
            String nombre = nombreTextField.getText();
            String apellido = apellidoTextField.getText();
            String email = emailTextField.getText();
            String telefono = telefonoTextField.getText();

            String dato;
            if(nombre.isEmpty() ) {
                dato="falta ingresar el nombre";
                mensajeTextArea.setText(dato);
                return;
            }
            if(apellido.isEmpty() ) {
                dato="falta ingresar el apellido";
                mensajeTextArea.setText(dato);
                return;
            }
            if(email.isEmpty() ) {
                dato="falta ingresar el email";
                mensajeTextArea.setText(dato);
                return;

            }if(telefono.isEmpty() ) {
                dato = "falta ingresar el telefono";
                mensajeTextArea.setText(dato);
                return;
            }
            if(!nombre.isEmpty() || !apellido.isEmpty() || !email.isEmpty() || !telefono.isEmpty()) {
                mensajeTextArea.setText("");
            }



        });
        limpiarButton.addActionListener(e -> {
            nombreTextField.setText("");
            apellidoTextField.setText("");
            emailTextField.setText("");
            telefonoTextField.setText("");
            mensajeTextArea.setText("");
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Ingresar Datos");
                IngresarDatos formulario = new IngresarDatos();
                frame.setContentPane(formulario.contenedor);
                //ajusto el tamaño de la ventana al contenido preferido
                frame.pack();
                //centro la ventana
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
