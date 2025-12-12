package formulario.SolicitudBeca;

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
import java.io.File;

public class FormularioResumenConfirmacion extends Component {
    private JButton grabarUnXMLButton;
    private JTextField NOMBRETextField;
    private JTextField APELLIDOSTextField;
    private JTextField DNITextField;
    private JTextField TITULACIONTextField;
    private JTextField AÑOTextField;
    private JTextField RENTATOTALUFTextField;
    private JTextField NUMEROCOMPONENTESUTextField;
    public JPanel contenedor;

    public FormularioResumenConfirmacion() {

        // Cargar datos si existen
        datos datos = formulario.SolicitudBeca.datos.getInstancia();
        NOMBRETextField.setText(datos.getNOMBRE());
        APELLIDOSTextField.setText(datos.getAPELLIDOS());
        DNITextField.setText(datos.getDNI());
        TITULACIONTextField.setText(datos.getTITULACION());
        AÑOTextField.setText(datos.getAÑO());
        RENTATOTALUFTextField.setText(datos.getRENTA_TOTAL());
        NUMEROCOMPONENTESUTextField.setText(datos.getNUMERO_COMPONENTES_UNIDAD_FAMILIAR());

        // Configurar el botón para grabar XML
        grabarUnXMLButton.addActionListener(e -> {
            try {
                guardarDatosEnXML(datos);
                JOptionPane.showMessageDialog(contenedor, 
                    "Datos guardados exitosamente en solicitud_beca.xml", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(contenedor, 
                    "Error al guardar: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });

    }

    private void guardarDatosEnXML(datos datos) throws Exception {
        // Crear el documento XML
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        // Elemento raíz
        Element rootElement = doc.createElement("solicitudBeca");
        doc.appendChild(rootElement);

        // Datos Personales
        Element datosPersonales = doc.createElement("datosPersonales");
        rootElement.appendChild(datosPersonales);

        agregarElemento(doc, datosPersonales, "nombre", datos.getNOMBRE());
        agregarElemento(doc, datosPersonales, "apellidos", datos.getAPELLIDOS());
        agregarElemento(doc, datosPersonales, "dni", datos.getDNI());
        agregarElemento(doc, datosPersonales, "direccion", datos.getDIRECCION());
        agregarElemento(doc, datosPersonales, "correoElectronico", datos.getCORREO_ELECTRONICO());
        agregarElemento(doc, datosPersonales, "fechaNacimiento", datos.getFECHA_NACIMIENTO());

        // Datos Académicos
        Element datosAcademicos = doc.createElement("datosAcademicos");
        rootElement.appendChild(datosAcademicos);

        agregarElemento(doc, datosAcademicos, "centroEstudios", datos.getCENTRO_DE_ESTUDIOS());
        agregarElemento(doc, datosAcademicos, "titulacion", datos.getTITULACION());
        agregarElemento(doc, datosAcademicos, "año", datos.getAÑO());

        // Datos Financieros
        Element datosFinancieros = doc.createElement("datosFinancieros");
        rootElement.appendChild(datosFinancieros);

        agregarElemento(doc, datosFinancieros, "nombrePadre", datos.getNOMBRE_PADRE());
        agregarElemento(doc, datosFinancieros, "dniPadre", datos.getDNI_PADRE());
        agregarElemento(doc, datosFinancieros, "nombreMadre", datos.getNOMBRE_MADRE());
        agregarElemento(doc, datosFinancieros, "dniMadre", datos.getDNI_MADRE());
        agregarElemento(doc, datosFinancieros, "rentaTotal", datos.getRENTA_TOTAL());
        agregarElemento(doc, datosFinancieros, "numeroComponentesUF", datos.getNUMERO_COMPONENTES_UNIDAD_FAMILIAR());

        // Escribir el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        DOMSource source = new DOMSource(doc);
        File archivoXML = new File("solicitud_beca.xml");
        StreamResult result = new StreamResult(archivoXML);
        
        transformer.transform(source, result);
    }

    private void agregarElemento(Document doc, Element padre, String nombreTag, String valor) {
        Element elemento = doc.createElement(nombreTag);
        elemento.appendChild(doc.createTextNode(valor != null ? valor : ""));
        padre.appendChild(elemento);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioDatosAcademicos form1 = new FormularioDatosAcademicos();
            form1.setVisible(true);
        });
    }
}
