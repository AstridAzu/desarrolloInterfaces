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
    private JPanel contenedor;
    private JTextField nombreTextField;
    private JTextField apellidoTextField;
    private JTextField TelefonoTextField;
    private JTextField DniTextField;
    private JTextArea mensajeTextArea;
    private JButton limpiarButton;
    private JButton grabarButton;
    private JButton guardarEnXmlButton;
    private JTextField direccionTextField;

    public IngresarDatosTxt() {
        //codigo para el boton enviar
        grabarButton.addActionListener(e -> {
            String nombre = nombreTextField.getText();
            String apellido = apellidoTextField.getText();
            String telefono = TelefonoTextField.getText();
            String dni = DniTextField.getText();
            String direccion = direccionTextField.getText();
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
            if(!nombre.isEmpty() || !apellido.isEmpty() || !dni.isEmpty() || !telefono.isEmpty()|| !direccion.isEmpty() ) {
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
            String archivoXML=crearXML();
            String archivoTXT = ruta+"\\src\\formulario\\txt.txt";


            try {
                //reviso si existe el txt
                File fileTXT = new File(archivoTXT);
                if (!fileTXT.exists()) {
                    System.out.println("El archivo " + archivoTXT + " no existe.");
                    return;
                }
                //uso el bufferreader para leer el txt
                BufferedReader reader = new BufferedReader(new FileReader(fileTXT));
                String linea;
                String nombre = "", apellidos = "", telefono = "", dni = "", direccion = "";//creo mis variables para los datos del txt
                //leo las lineas una a una y guardo la informacion
                while ((linea = reader.readLine()) != null) {
                    if (linea.startsWith("Nombre:")) {
                        nombre = linea.substring(7).trim();
                    } else if (linea.startsWith("Apellidos:")) {
                        apellidos = linea.substring(10).trim();
                    }else if (linea.startsWith("Telefono:")) {
                        telefono = linea.substring(9).trim();
                    }else if (linea.startsWith("Dni:")) {
                        dni = linea.substring(4).trim();
                    }else if (linea.startsWith("Direccion:")) {
                        direccion = linea.substring(10).trim();
                    }
                }

                //escribo el xml
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.newDocument();

                Element root = doc.createElement("usuarios");
                doc.appendChild(root);
                // 4. Crear un elemento hijo
                Element usuario = doc.createElement("usuario");

                Element nombrexml = doc.createElement("nombre");
                //asigo el nombre del txt al xml
                nombrexml.appendChild(doc.createTextNode(nombre));

                Element apellidoxml = doc.createElement("apellido");
                //asigno el apellido del txt al xml
                apellidoxml.appendChild(doc.createTextNode(apellidos));

                Element telefonoxml = doc.createElement("telefono");
                //asigno el telefono del txt al xml
                telefonoxml.appendChild(doc.createTextNode(telefono));

                Element dnixml = doc.createElement("dni");
                //asigno el dni del txt al xml
                dnixml.appendChild(doc.createTextNode(dni));

                Element direccionxml = doc.createElement("direccion");
                //asigno el direccion del txt al xml
                direccionxml.appendChild(doc.createTextNode(direccion));

                //le asigno sus variables a el usuario
                usuario.appendChild(nombrexml);
                usuario.appendChild(apellidoxml);
                usuario.appendChild(telefonoxml);
                usuario.appendChild(dnixml);
                usuario.appendChild(direccionxml);

                //asigno usuario a usuarios
                root.appendChild(usuario);
                //  Configurar el Transformer para escribir el XML en un archivo
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Para que tenga sangría

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(archivoXML));

                // 8. Escribir el XML al archivo
                transformer.transform(source, result);
                //archivo xml escrito
                System.out.println("Archivo guardado correctamente");



            }catch (Exception f){}
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
