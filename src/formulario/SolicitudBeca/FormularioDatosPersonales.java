package formulario.SolicitudBeca;

import javax.swing.*;
import java.awt.*;

public class FormularioDatosPersonales extends Component {
    private JTextField NOMBRETextField;
    private JTextField APELLIDOSTextField;
    private JTextField DNITextField;
    private JTextField DIRECCIONTextField;
    private JTextField CORREOELECTRONICOTextField;
    private JTextField FECHANACIMIENTOTextField;
    private JButton siguienteButton;
    public JPanel contenedor;
    public FormularioDatosPersonales() {

        // Cargar datos si existen
        datos datos = formulario.SolicitudBeca.datos.getInstancia();

        siguienteButton.addActionListener(E-> {
                    datos.setNOMBRE(NOMBRETextField.getText());
                    datos.setAPELLIDOS(APELLIDOSTextField.getText());
                    datos.setDNI(DNITextField.getText());
                    datos.setDIRECCION(DIRECCIONTextField.getText());
                    datos.setCORREO_ELECTRONICO(CORREOELECTRONICOTextField.getText());
                    datos.setFECHA_NACIMIENTO(FECHANACIMIENTOTextField.getText());

                    // Abrir siguiente formulario
                    JFrame frame = new JFrame("Datos Académicos");
                    FormularioDatosAcademicos form2 = new FormularioDatosAcademicos();
                    frame.setContentPane(form2.contenedor);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                    // Cerrar frame actual
                    SwingUtilities.getWindowAncestor(contenedor).dispose();

                }
        );

    }

}
