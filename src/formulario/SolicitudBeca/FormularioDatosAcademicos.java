package formulario.SolicitudBeca;

import javax.swing.*;
import java.awt.*;

public class FormularioDatosAcademicos extends Component {
    private JTextField CENTRODEESTUDIOSTextField;
    private JTextField TITULACIONTextField;
    private JTextField AÑOTextField;
    private JButton siguienteButton;
    public JPanel contenedor;
    public FormularioDatosAcademicos() {

        // Cargar datos si existen
        datos datos = formulario.SolicitudBeca.datos.getInstancia();

        siguienteButton.addActionListener(E-> {
                    datos.setCENTRO_DE_ESTUDIOS(CENTRODEESTUDIOSTextField.getText());
                    datos.setTITULACION(TITULACIONTextField.getText());
                    datos.setAÑO(AÑOTextField.getText());

                    // Abrir siguiente formulario
                    JFrame frame = new JFrame("Datos Financieros");
                    FormularioDatosFinancieros form2 = new FormularioDatosFinancieros();
                    frame.setContentPane(form2.contenedor);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                    // Cerrar frame actual
                    SwingUtilities.getWindowAncestor(contenedor).dispose();

                }
        );

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioDatosAcademicos form1 = new FormularioDatosAcademicos();
            form1.setVisible(true);
        });
    }
}
