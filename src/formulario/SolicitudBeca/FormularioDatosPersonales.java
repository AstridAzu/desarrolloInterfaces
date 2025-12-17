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
    private JPanel contenedorPaso1;
    private JPanel Header;
    private JLabel paso1;
    private JLabel title;
    private JButton paso1Button;
    private JButton paso2Button;
    private JButton paso3Button;
    private JButton paso4Button;

    public FormularioDatosPersonales() {


        title.setForeground(Color.white);
        Header.setBackground(new Color(220, 20, 60));
        Header.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        Header.putClientProperty("FlatClientProperties.STYLE", "arc: 30");
        contenedorPaso1.setBackground(new Color(128, 128, 128));


        // 1. Quita el borde de línea exterior
        paso1Button.setBorderPainted(false);
        // 2. Quita el recuadro de puntos que aparece al hacer clic (enfoque)
        paso1Button.setFocusPainted(false);
        // 3. (Opcional) Quita el fondo por defecto si solo quieres ver el texto/icono
        paso1Button.setContentAreaFilled(false);
        // 4. Asegura que no haya márgenes internos residuales
        paso1Button.setBorder(BorderFactory.createEmptyBorder());


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
        paso2Button.addActionListener(E-> {
            // Abrir siguiente formulario
            JFrame frame = new JFrame("Datos Academicos");
            FormularioDatosAcademicos form2 = new FormularioDatosAcademicos();
            frame.setContentPane(form2.contenedor);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Cerrar frame actual
            SwingUtilities.getWindowAncestor(contenedor).dispose();

        });
        paso3Button.addActionListener(E-> {
            // Abrir siguiente formulario
            JFrame frame = new JFrame("Datos Financieros");
            FormularioDatosFinancieros form2 = new FormularioDatosFinancieros();
            frame.setContentPane(form2.contenedor);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Cerrar frame actual
            SwingUtilities.getWindowAncestor(contenedor).dispose();

        });
        paso4Button.addActionListener(E-> {
            // Abrir siguiente formulario
            JFrame frame = new JFrame("Resumen Confirmacion");
            FormularioResumenConfirmacion form2 = new FormularioResumenConfirmacion();
            frame.setContentPane(form2.contenedor);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Cerrar frame actual
            SwingUtilities.getWindowAncestor(contenedor).dispose();

        });




    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
