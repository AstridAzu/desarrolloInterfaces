package formulario;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IngresarDatosTxt extends Component {
    private JPanel contenedor;
    private JTextField nombreTextField;
    private JTextField apellidoTextField;
    private JTextField emailTextField;
    private JTextField telefonoTextField;
    private JTextArea mensajeTextArea;
    private JButton limpiarButton;
    private JButton grabarButton;
    public IngresarDatosTxt() {
        //codigo para el boton enviar
        grabarButton.addActionListener(e -> {
            String nombre = nombreTextField.getText();
            String apellido = apellidoTextField.getText();
            String email = emailTextField.getText();
            String telefono = telefonoTextField.getText();
            //variable para el mensaje de error
            String dato;
            //ifs para cada campo de texto
            //si el JTextField esta vacio se envia el mensaje de error
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
                mensajeTextArea.setText("Datos introducidos correctamente");
            }
            //ruta proyecto
            String ruta = System.getProperty("user.dir");
            String archivoTXT=ruta+"\\src\\formulario\\"+"txt.txt";
            File archivoTXTFile = new File(archivoTXT);
            if(!archivoTXTFile.exists()) {
                try {
                    archivoTXTFile.createNewFile();
                } catch (IOException ex) {}
            }

            try (FileWriter writer = new FileWriter(archivoTXT, true)) {
                writer.write("Nombre: " + nombre + "\n");
                writer.write("Apellidos: " + apellido+ "\n");
                writer.write("Email: " + email + "\n");
                writer.write("Telefono: " + telefono + "\n");

                writer.write("--------------------------\n");
                JOptionPane.showMessageDialog(this,
                        "Datos guardados correctamente en " + archivoTXT,
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error al guardar los datos:\n" + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }


        });
        //acciones del boton limpiar
        limpiarButton.addActionListener(e -> {
            //pone inputs en blanco
            limpiarCampos();
        });
    }
    public void limpiarCampos(){
        //pone inputs en blanco
        nombreTextField.setText("");
        apellidoTextField.setText("");
        emailTextField.setText("");
        telefonoTextField.setText("");
        mensajeTextArea.setText("");
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //creo un frame
                JFrame frame = new JFrame("Ingresar Datos");
                IngresarDatosTxt formulario = new IngresarDatosTxt();
                //al frame le doy el formulario que hice
                frame.setContentPane(formulario.contenedor);
                //ajusto el tamaño de la ventana al contenido preferido
                frame.pack();
                //centro la ventana
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
