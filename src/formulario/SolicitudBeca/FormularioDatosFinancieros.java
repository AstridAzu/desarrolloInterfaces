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
    private JButton paso1Button;
    private JButton paso2Button;
    private JButton paso3Button;
    private JButton paso4Button;
    private JLabel title;
    private JPanel Header;
    private JPanel Contenedorpaso3;

    public FormularioDatosFinancieros() {
        title.setForeground(Color.white);
        Header.setBackground(new Color(220, 20, 60));
        Header.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        Header.putClientProperty("FlatClientProperties.STYLE", "arc: 30");
        Contenedorpaso3.setBackground(new Color(128, 128, 128));
        // 1. Quita el borde de línea exterior
        paso3Button.setBorderPainted(false);
        // 2. Quita el recuadro de puntos que aparece al hacer clic (enfoque)
        paso3Button.setFocusPainted(false);
        // 3. (Opcional) Quita el fondo por defecto si solo quieres ver el texto/icono
        paso3Button.setContentAreaFilled(false);
        // 4. Asegura que no haya márgenes internos residuales
        paso3Button.setBorder(BorderFactory.createEmptyBorder());
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
        paso1Button.addActionListener(E-> {
            // Abrir siguiente formulario
            JFrame frame = new JFrame("Formulario Datos personales");
            FormularioDatosPersonales form2 = new FormularioDatosPersonales();
            frame.setContentPane(form2.contenedor);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Cerrar frame actual
            SwingUtilities.getWindowAncestor(contenedor).dispose();

        });
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

}
