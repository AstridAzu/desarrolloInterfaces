package formulario;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.*;

public class IngresarDatosTxt extends Component {
    public JPanel contenedor;
    private JTextField nombreTextField;
    private JTextField apellidoTextField;
    private JTextField TelefonoTextField;
    private JTextField DniTextField;
    private JTextArea mensajeTextArea;
    private JButton limpiarButton;
    private JButton grabarButton;
    private JButton guardarEnXmlButton;
    private JTextField direccionTextField;
    private JTextField emailTextField;

    public IngresarDatosTxt() {
        //codigo para el boton enviar
        grabarButton.addActionListener(e -> {
            String nombre = nombreTextField.getText();
            String apellido = apellidoTextField.getText();
            String telefono = TelefonoTextField.getText();
            String dni = DniTextField.getText();
            String direccion = direccionTextField.getText();
            String email = emailTextField.getText();
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
            if(telefono.isEmpty() ) {
                dato="falta ingresar el telefono";
                mensajeTextArea.setText(dato);
                return;

            }if(dni.isEmpty() ) {
                dato = "falta ingresar el dni";
                mensajeTextArea.setText(dato);
                return;
            }
            if(direccion.isEmpty() ) {
                dato="falta ingresar el direccion";
                mensajeTextArea.setText(dato);
                return;

            }
            if(email.isEmpty() ) {
                dato="falta ingresar el email";
                mensajeTextArea.setText(dato);
                return;
            }
            if(!nombre.isEmpty() || !apellido.isEmpty() || !dni.isEmpty() || !telefono.isEmpty()|| !direccion.isEmpty()|| !email.isEmpty() ) {
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
                writer.write("Telefono: " + telefono + "\n");
                writer.write("Dni: " + dni + "\n");
                writer.write("Direccion: " + direccion + "\n");
                writer.write("Email: " + email + "\n");
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

        guardarEnXmlButton.addActionListener(e->{
            String ruta = System.getProperty("user.dir");
            String archivoXML = crearXML();
            String archivoTXT = ruta + "\\src\\formulario\\txt.txt";

            try {
                // Reviso si existe el txt
                File fileTXT = new File(archivoTXT);
                if (!fileTXT.exists()) {
                    System.out.println("El archivo " + archivoTXT + " no existe.");
                    return;
                }

                // Preparo el documento XML
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.newDocument();

                Element root = doc.createElement("usuarios");
                doc.appendChild(root);

                // Uso BufferedReader para leer el txt
                BufferedReader reader = new BufferedReader(new FileReader(fileTXT));
                String linea;
                String nombre = "", apellidos = "", telefono = "", dni = "", direccion = "", email = "";
                // Leo línea por línea

                while ((linea = reader.readLine()) != null) {
                    if (linea.startsWith("Nombre:")) {
                        nombre = linea.substring(7).trim();
                    } else if (linea.startsWith("Apellidos:")) {
                        apellidos = linea.substring(10).trim();
                    } else if (linea.startsWith("Telefono:")) {
                        telefono = linea.substring(9).trim();
                    } else if (linea.startsWith("Dni:")) {
                        dni = linea.substring(4).trim();
                    } else if (linea.startsWith("Direccion:")) {
                        direccion = linea.substring(10).trim();
                    } else if (linea.startsWith("Email:")) {
                        email = linea.substring(5).trim();

                        // AQUÍ ESTÁ EL CAMBIO: Cuando leo la dirección (último dato),
                        // creo el elemento usuario con todos los datos
                        Element usuario = doc.createElement("usuario");

                        Element nombrexml = doc.createElement("nombre");
                        nombrexml.appendChild(doc.createTextNode(nombre));

                        Element apellidoxml = doc.createElement("apellido");
                        apellidoxml.appendChild(doc.createTextNode(apellidos));

                        Element telefonoxml = doc.createElement("telefono");
                        telefonoxml.appendChild(doc.createTextNode(telefono));

                        Element dnixml = doc.createElement("dni");
                        dnixml.appendChild(doc.createTextNode(dni));

                        Element direccionxml = doc.createElement("direccion");
                        direccionxml.appendChild(doc.createTextNode(direccion));

                        Element emailxml = doc.createElement("email");
                        emailxml.appendChild(doc.createTextNode(email));



                        // Agrego todos los elementos al usuario
                        usuario.appendChild(nombrexml);
                        usuario.appendChild(apellidoxml);
                        usuario.appendChild(telefonoxml);
                        usuario.appendChild(dnixml);
                        usuario.appendChild(direccionxml);
                        usuario.appendChild(emailxml);

                        // Agrego el usuario completo al root
                        root.appendChild(usuario);

                        // Limpio las variables para el siguiente usuario
                        nombre = "";
                        apellidos = "";
                        telefono = "";
                        dni = "";
                        direccion = "";
                        email = "";
                    }
                }

                reader.close();

                // Configurar el Transformer para escribir el XML
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(archivoXML));

                // Escribir el XML al archivo
                transformer.transform(source, result);

                JOptionPane.showMessageDialog(this,
                        "XML guardado correctamente en " + archivoXML,
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);

                System.out.println("Archivo guardado correctamente");

            } catch (Exception f) {
                JOptionPane.showMessageDialog(this,
                        "Error al guardar XML:\n" + f.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                f.printStackTrace();
            }
        });
    }
    public String crearXML(){
        String ruta = System.getProperty("user.dir");
        String RutaXMLTxt=ruta+"\\src\\formulario\\"+"usuarios_desde_txt.xml";
        File RutaTxtFile = new File(RutaXMLTxt);
        if(!RutaTxtFile.exists())
        {
            try {
                RutaTxtFile.createNewFile();
            } catch (IOException ex) {}
        }
        return RutaXMLTxt;
    }
    public void limpiarCampos(){
        //pone inputs en blanco
        nombreTextField.setText("");
        apellidoTextField.setText("");
        TelefonoTextField.setText("");
        DniTextField.setText("");
        mensajeTextArea.setText("");
        direccionTextField.setText("");
        emailTextField.setText("");
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
