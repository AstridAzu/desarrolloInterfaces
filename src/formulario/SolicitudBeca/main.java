package formulario.SolicitudBeca;

import formulario.IngresarDatosTxt;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //creo un frame
                JFrame frame = new JFrame("Ingresar Datos");
                FormularioDatosPersonales formulario = new FormularioDatosPersonales();
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
