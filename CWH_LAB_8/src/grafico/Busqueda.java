package grafico;
//Integrantes: William Concepcion, Wilson Wang, Emmanuel Hernandez
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import main.Estudiantes;

public class Busqueda extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textAreaBecados;
    private JLabel lblBsquedaPorCedula;
    private JComboBox<String> comboBoxCarreras;
    private JComboBox<String> comboBoxSexo;
    private JButton btnBsquedaDeBecados;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Busqueda frame = new Busqueda();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Busqueda() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 536, 378);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBusqueda = new JLabel("Búsqueda");
        lblBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblBusqueda.setBounds(184, 11, 149, 46);
        contentPane.add(lblBusqueda);

        JLabel lblNewLabel_1_1_1 = new JLabel("Cédula:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(10, 102, 95, 22);
        contentPane.add(lblNewLabel_1_1_1);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setColumns(10);
        textField.setBounds(72, 103, 153, 19);
        contentPane.add(textField);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 207, 500, 121); // Adjusted size to fit the area properly
        contentPane.add(scrollPane);

        textAreaBecados = new JTextArea();
        scrollPane.setViewportView(textAreaBecados);

        JButton btnMostrarB = new JButton("Mostrar Búsqueda");
        btnMostrarB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = textField.getText().trim();
                Estudiantes encontrado = buscarEstudiantePorCedula(cedula);
                if (encontrado != null) {
                    textAreaBecados.setText("Nombre: " + encontrado.getNombre() + "\n"
                            + "Cédula: " + encontrado.getCedula() + "\n"
                            + "Carrera: " + encontrado.getCarrera() + "\n"
                            + "Índice Académico: " + encontrado.getIndiceAcademico() + "\n"
                            + "Sexo: " + encontrado.getSexo());
                } else {
                    textAreaBecados.setText("No se encontró ningún estudiante con esa cédula.");
                }
            }
        });
        btnMostrarB.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnMostrarB.setBounds(37, 162, 184, 34);
        contentPane.add(btnMostrarB);

        lblBsquedaPorCedula = new JLabel("Búsqueda por cedula");
        lblBsquedaPorCedula.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblBsquedaPorCedula.setBounds(37, 55, 165, 22);
        contentPane.add(lblBsquedaPorCedula);

        comboBoxCarreras = new JComboBox<String>();
        comboBoxCarreras.setModel(new DefaultComboBoxModel<String>(new String[] { "Ingeniería Civil", "Ingeniería Eléctrica",
                "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima" }));
        comboBoxCarreras.setSelectedIndex(-1);
        comboBoxCarreras.setBounds(357, 91, 153, 21);
        contentPane.add(comboBoxCarreras);

        JLabel lblNewLabel_1_1 = new JLabel("Carrera:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(283, 90, 95, 22);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Sexo:");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_2.setBounds(293, 119, 95, 22);
        contentPane.add(lblNewLabel_1_1_2);

        comboBoxSexo = new JComboBox<String>();
        comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] { "Masculino", "Femenino" }));
        comboBoxSexo.setSelectedIndex(-1);
        comboBoxSexo.setBounds(357, 119, 153, 21);
        contentPane.add(comboBoxSexo);

        btnBsquedaDeBecados = new JButton("Búsqueda de becados");
        btnBsquedaDeBecados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String carrera = (String) comboBoxCarreras.getSelectedItem();
                String sexo = (String) comboBoxSexo.getSelectedItem();
                ArrayList<Estudiantes> estudiantesBecados = buscarEstudiantesPorCarreraYSexo(carrera, sexo);
                mostrarEstudiantesBecados(estudiantesBecados);
            }
        });
        btnBsquedaDeBecados.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBsquedaDeBecados.setBounds(303, 162, 207, 34);
        contentPane.add(btnBsquedaDeBecados);
        
        JLabel lblBsquedaDeBecados = new JLabel("Búsqueda de becados");
        lblBsquedaDeBecados.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblBsquedaDeBecados.setBounds(303, 55, 165, 22);
        contentPane.add(lblBsquedaDeBecados);
    }

    private Estudiantes buscarEstudiantePorCedula(String cedula) {
        for (Estudiantes estudiante : Formulario.estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    private ArrayList<Estudiantes> buscarEstudiantesPorCarreraYSexo(String carrera, String sexo) {
        ArrayList<Estudiantes> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : Formulario.estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0 && estudiante.getCarrera().equals(carrera)
                    && estudiante.getSexo().equals(sexo)) {
                estudiantesBecados.add(estudiante);
            }
        }

        return estudiantesBecados;
    }

    private void mostrarEstudiantesBecados(ArrayList<Estudiantes> estudiantes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiantes Becados:\n");
        for (Estudiantes estudiante : estudiantes) {
            sb.append("Nombre: ").append(estudiante.getNombre()).append("\n")
                    .append("Cédula: ").append(estudiante.getCedula()).append("\n")
                    .append("Carrera: ").append(estudiante.getCarrera()).append("\n")
                    .append("Índice Académico: ").append(estudiante.getIndiceAcademico()).append("\n")
                    .append("Sexo: ").append(estudiante.getSexo()).append("\n\n");
        }
        textAreaBecados.setText(sb.toString());
    }
}
