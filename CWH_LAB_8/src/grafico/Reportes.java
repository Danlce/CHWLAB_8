package grafico;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import main.Becas;
import main.Estudiantes;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reportes extends JFrame {

    private JPanel contentPane;
    private JTextArea textAreaBecados;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reportes frame = new Reportes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Reportes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 666, 483);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Reportes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(238, 10, 149, 46);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Estudiantes Becados:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(52, 106, 221, 35);
        contentPane.add(lblNewLabel_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(52, 151, 543, 220);
        contentPane.add(scrollPane);

        textAreaBecados = new JTextArea();
        scrollPane.setViewportView(textAreaBecados);

        JButton btnMostrarBecados = new JButton("Mostrar Becados");
        btnMostrarBecados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí se necesita un objeto Becas para mostrar los estudiantes becados
                // No puede funcionar sin este objeto
                // mostrarBecados();
            }
        });
        btnMostrarBecados.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnMostrarBecados.setBounds(413, 394, 182, 35);
        contentPane.add(btnMostrarBecados);
        
        JButton btnBusqueda = new JButton("Búsqueda");
        btnBusqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                // Abrir la ventana de búsqueda
                Busqueda busqueda = new Busqueda();
                busqueda.setVisible(true);
            }
        });
        btnBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBusqueda.setBounds(118, 394, 182, 35);
        contentPane.add(btnBusqueda);
    }
    private static Becas becas;
    
    // Método corregido para mostrar los estudiantes becados
    public void mostrarBecados(Becas becas) {
        ArrayList<Estudiantes> estudiantesBecados = becas.obtenerEstudiantesBecados();

        StringBuilder sb = new StringBuilder();
        sb.append("Nombres de los Estudiantes:\n");
        for (Estudiantes estudiante : estudiantesBecados) {
            sb.append(estudiante.getNombre()).append("\n");
        }

        textAreaBecados.setText(sb.toString());
    }
}
