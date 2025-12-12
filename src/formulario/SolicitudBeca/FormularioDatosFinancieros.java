package formulario.SolicitudBeca;

import javax.swing.*;
import java.awt.*;

public class FormularioDatosFinancieros extends Component {
    private JTextField NOMBREPADRETextField;
    private JTextField NOMBREMADRETextField;
    private JTextField DNIPADRETextField;
    private JTextField DNIMADRETextField;
    private JButton siguienteButton;
    private JTextField RENTATOTALUNIDADFAMILIARTextField;
    private JTextField NUMEROCOMPONENTESUNIDADTextField;
    public JPanel contenedor;
    private JButton atrasButton;

    public FormularioDatosFinancieros() {

        // Cargar datos si existen
        datos datos = formulario.SolicitudBeca.datos.getInstancia();

        siguienteButton.addActionListener(E-> {
                    datos.setNOMBRE_PADRE(NOMBREPADRETextField.getText());
                    datos.setNOMBRE_MADRE(NOMBREMADRETextField.getText());
                    datos.setDNI_PADRE(DNIPADRETextField.getText());
                    datos.setDNI_MADRE(DNIMADRETextField.getText());
                    datos.setRENTA_TOTAL(RENTATOTALUNIDADFAMILIARTextField.getText());
                    datos.setNUMERO_COMPONENTES_UNIDAD_FAMILIAR(NUMEROCOMPONENTESUNIDADTextField.getText());

                    // Abrir siguiente formulario
                    JFrame frame = new JFrame("Resumen y Confirmación");
                    FormularioResumenConfirmacion form2 = new FormularioResumenConfirmacion();
                    frame.setContentPane(form2.contenedor);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                    // Cerrar frame actual
                    SwingUtilities.getWindowAncestor(contenedor).dispose();

                }
        );
        atrasButton.addActionListener(E-> {
            // Abrir Anterior formulario
            JFrame frame = new JFrame("Datos Académicos");
            FormularioDatosAcademicos form2 = new FormularioDatosAcademicos();
            frame.setContentPane(form2.contenedor);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Cerrar frame actual
            SwingUtilities.getWindowAncestor(contenedor).dispose();
        });


    }

}
