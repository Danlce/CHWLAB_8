package grafico;
//Integrantes: William Concepcion, Wilson Wang, Emmanuel Hernandez
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Estudiantes;
import main.Becas;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombre;
    private JTextField textIndice;
    private JTextField textCedula;
    private JComboBox<String> comboBoxCarreras;
    private JComboBox<String> comboBoxSexo;

    public static ArrayList<Estudiantes> estudiantes;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Formulario frame = new Formulario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Formulario() {
        estudiantes = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 932, 552);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Información de estudiantes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel.setBounds(277, 10, 271, 62);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(21, 97, 95, 22);
        contentPane.add(lblNewLabel_1);

        textNombre = new JTextField();
        textNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textNombre.setBounds(141, 102, 153, 19);
        contentPane.add(textNombre);
        textNombre.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Indice:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(21, 239, 95, 22);
        contentPane.add(lblNewLabel_1_1);

        textIndice = new JTextField();
        textIndice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textIndice.setColumns(10);
        textIndice.setBounds(141, 240, 153, 19);
        contentPane.add(textIndice);

        JLabel lblNewLabel_1_1_1 = new JLabel("Cédula:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(21, 166, 95, 22);
        contentPane.add(lblNewLabel_1_1_1);

        textCedula = new JTextField();
        textCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textCedula.setColumns(10);
        textCedula.setBounds(141, 167, 153, 19);
        contentPane.add(textCedula);

        JLabel lblNewLabel_1_1_2 = new JLabel("Carrera:");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_2.setBounds(21, 308, 95, 22);
        contentPane.add(lblNewLabel_1_1_2);

        comboBoxCarreras = new JComboBox<>();
        comboBoxCarreras.setModel(new DefaultComboBoxModel<>(new String[] { "Ingeniería Civil", "Ingeniería Eléctrica",
                "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima" }));
        comboBoxCarreras.setBounds(141, 312, 153, 21);
        comboBoxCarreras.setSelectedIndex(-1);
        contentPane.add(comboBoxCarreras);

        JLabel lblNewLabel_1_1_3 = new JLabel("Sexo:");
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_3.setBounds(21, 376, 95, 22);
        contentPane.add(lblNewLabel_1_1_3);

        comboBoxSexo = new JComboBox<>();
        comboBoxSexo.setModel(new DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        comboBoxSexo.setBounds(141, 376, 153, 21);
        comboBoxSexo.setSelectedIndex(-1);
        contentPane.add(comboBoxSexo);

        JButton btnGuardar = new JButton("Guardar Datos");
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnGuardar.setBounds(460, 163, 184, 34);
        contentPane.add(btnGuardar);

        JButton btnReportes = new JButton("Mostrar Reportes");
        btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnReportes.setBounds(700, 361, 184, 34);
        contentPane.add(btnReportes);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });

        btnReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Becas becas = new Becas();
                for (Estudiantes estudiante : estudiantes) {
                    becas.agregarEstudiante(estudiante);
                }
                Reportes reportes = new Reportes();
                reportes.setVisible(true);
                reportes.mostrarBecados(becas);
            }
        });
    }

    private void guardarDatos() {
        try {
            String nombre = textNombre.getText();
            String cedula = textCedula.getText();
            double indice = Double.parseDouble(textIndice.getText());
            String carrera = (String) comboBoxCarreras.getSelectedItem();
            String sexo = (String) comboBoxSexo.getSelectedItem();

            // Validar que el índice esté entre 0 y 3
            if (indice < 0 || indice > 3) {
                throw new NumberFormatException();
            }

            Estudiantes estudiante = new Estudiantes(nombre, cedula, carrera, indice, sexo);
            estudiantes.add(estudiante);

            JOptionPane.showMessageDialog(this, "Información guardada correctamente", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            textNombre.setText("");
            textCedula.setText("");
            textIndice.setText("");
            comboBoxCarreras.setSelectedIndex(-1);
            comboBoxSexo.setSelectedIndex(-1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}