package formulario.SolicitudBeca;

import javax.swing.*;
import java.awt.*;

public class FormularioDatosAcademicos extends Component {
    private JTextField CENTRODEESTUDIOSTextField;
    private JTextField TITULACIONTextField;
    private JTextField AÑOTextField;
    private JButton siguienteButton;
    public JPanel contenedor;
    private JButton atrasButton;
    private JButton paso1Button;
    private JButton paso2Button;
    private JButton paso3Button;
    private JButton paso4Button;
    private JLabel title;
    private JPanel header;
    private JPanel contenedorPaso2;

    public FormularioDatosAcademicos() {
        title.setForeground(Color.white);
        header.setBackground(new Color(220, 20, 60));
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        header.putClientProperty("FlatClientProperties.STYLE", "arc: 30");
        contenedorPaso2.setBackground(new Color(128, 128, 128));



        // 1. Quita el borde de línea exterior
        paso2Button.setBorderPainted(false);
        // 2. Quita el recuadro de puntos que aparece al hacer clic (enfoque)
        paso2Button.setFocusPainted(false);
        // 3. (Opcional) Quita el fondo por defecto si solo quieres ver el texto/icono
        paso2Button.setContentAreaFilled(false);
        // 4. Asegura que no haya márgenes internos residuales
        paso2Button.setBorder(BorderFactory.createEmptyBorder());

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
        atrasButton.addActionListener(E-> {
            // Abrir Anterior formulario
            JFrame frame = new JFrame("Datos personales");
            FormularioDatosPersonales form2 = new FormularioDatosPersonales();
            frame.setContentPane(form2.contenedor);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Cerrar frame actual
            SwingUtilities.getWindowAncestor(contenedor).dispose();
        });
        paso1Button.addActionListener(E-> {
            // Abrir siguiente formulario
            JFrame frame = new JFrame("Formulario Datos personales ");
            FormularioDatosPersonales form2 = new FormularioDatosPersonales();
            frame.setContentPane(form2.contenedor);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Cerrar frame actual
            SwingUtilities.getWindowAncestor(contenedor).dispose();

        });
        paso3Button.addActionListener(E-> {
            // Abrir siguiente formulario
            JFrame frame = new JFrame("Datos financieros");
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
            JFrame frame = new JFrame("Resumen confirmacion");
            FormularioResumenConfirmacion form2 = new FormularioResumenConfirmacion();
            frame.setContentPane(form2.contenedor);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Cerrar frame actual
            SwingUtilities.getWindowAncestor(contenedor).dispose();

        });




    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioDatosAcademicos form1 = new FormularioDatosAcademicos();
            form1.setVisible(true);
        });
    }
}
