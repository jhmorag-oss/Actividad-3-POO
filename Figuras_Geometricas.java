import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Ejercicio 8.3 - Figuras Geometricas
// Calcula el volumen y superficie del cilindro, esfera y piramide.

// Clase para todas las figuras geometricas
class Figura_Geometrica {
    private double volumen;
    private double superficie;
    public void set_volumen(double volumen) {
        this.volumen = volumen; }
    public void set_superficie(double superficie) {
        this.superficie = superficie; }
    public double get_volumen() {
        return this.volumen; }
    public double get_superficie() {
        return this.superficie; }
}
// Clase para Cilindro

class Cilindro extends Figura_Geometrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio  = radio;
        this.altura = altura;
        this.set_volumen(calcular_volumen());
        this.set_superficie(calcular_superficie()); }

    public double calcular_volumen() {
        return Math.PI * Math.pow(radio, 2.0) * altura;}

    public double calcular_superficie() {
        double area_lado_a = 2.0 * Math.PI * radio * altura;
        double area_lado_b = 2.0 * Math.PI * Math.pow(radio, 2.0);
        return area_lado_a + area_lado_b;}
}

//clase Esfera
class Esfera extends Figura_Geometrica {
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
        this.set_volumen(calcular_volumen());
        this.set_superficie(calcular_superficie()); }

    public double calcular_volumen() {
        return 1.333 * Math.PI * Math.pow(this.radio, 3.0);}
    public double calcular_superficie() {
        return 4.0 * Math.PI * Math.pow(this.radio, 2.0); }
}
//clase Piramide
class Piramide extends Figura_Geometrica {
    private double base;
    private double altura;
    private double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base    = base;
        this.altura  = altura;
        this.apotema = apotema;
        this.set_volumen(calcular_volumen());
        this.set_superficie(calcular_superficie());}

    public double calcular_volumen() {
        return (Math.pow(base, 2.0) * altura) / 3.0;}

    public double calcular_superficie() {
        double area_base = Math.pow(base, 2.0);
        double area_lado = 2.0 * base * apotema;
        return area_base + area_lado; }
}

//ventana unica con todas las pestanas
class Ventana_Unificada extends JFrame implements ActionListener {

// Pestana Cilindro
    private JTextField campo_cilindro_radio, campo_cilindro_altura;
    private JLabel     label_cilindro_volumen, label_cilindro_superficie;
    private JButton    boton_cilindro;

// Pestana Esfera
    private JTextField campo_esfera_radio;
    private JLabel     label_esfera_volumen, label_esfera_superficie;
    private JButton    boton_esfera;

// Pestana Piramide
    private JTextField campo_piramide_base, campo_piramide_altura, campo_piramide_apotema;
    private JLabel     label_piramide_volumen, label_piramide_superficie;
    private JButton    boton_piramide;

    public Ventana_Unificada() {
        setTitle("Figuras Geometricas - Jhmorag - EJ 8.3");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane pestanas = new JTabbedPane();
        pestanas.addTab("Cilindro", crear_panel_cilindro());
        pestanas.addTab("Esfera",   crear_panel_esfera());
        pestanas.addTab("Piramide", crear_panel_piramide());
        getContentPane().add(pestanas);
    }

    private JPanel crear_panel_cilindro() {
        JPanel ventana_principal = new JPanel(null);

        JLabel l_radio  = new JLabel("Radio (cms):");
        JLabel l_altura = new JLabel("Altura (cms):");
        label_cilindro_volumen    = new JLabel("Volumen (cm3):");
        label_cilindro_superficie = new JLabel("Superficie (cm2):");

        l_radio .setBounds(20,  20, 135, 23);
        l_altura.setBounds(20,  50, 135, 23);
        label_cilindro_volumen   .setBounds(20, 110, 300, 23);
        label_cilindro_superficie.setBounds(20, 140, 300, 23);
        campo_cilindro_radio  = new JTextField(); campo_cilindro_radio .setBounds(160, 20, 135, 23);
        campo_cilindro_altura = new JTextField(); campo_cilindro_altura.setBounds(160, 50, 135, 23);
        boton_cilindro = new JButton("Calcular");
        boton_cilindro.setBounds(160, 80, 135, 23);
        boton_cilindro.addActionListener(this);

        ventana_principal.add(l_radio);  ventana_principal.add(l_altura);
        ventana_principal.add(campo_cilindro_radio);  ventana_principal.add(campo_cilindro_altura);
        ventana_principal.add(boton_cilindro);
        ventana_principal.add(label_cilindro_volumen);  ventana_principal.add(label_cilindro_superficie);
        return ventana_principal;
    }

    private JPanel crear_panel_esfera() {
        JPanel ventana_principal = new JPanel(null);

        JLabel l_radio = new JLabel("Radio (cms):");
        label_esfera_volumen    = new JLabel("Volumen (cm3):");
        label_esfera_superficie = new JLabel("Superficie (cm2):");

        l_radio.setBounds(20, 20, 135, 23);
        label_esfera_volumen   .setBounds(20,  90, 300, 23);
        label_esfera_superficie.setBounds(20, 120, 300, 23);

        campo_esfera_radio = new JTextField(); campo_esfera_radio.setBounds(160, 20, 135, 23);

        boton_esfera = new JButton("Calcular");
        boton_esfera.setBounds(160, 50, 135, 23);
        boton_esfera.addActionListener(this);

        ventana_principal.add(l_radio);  ventana_principal.add(campo_esfera_radio);
        ventana_principal.add(boton_esfera);
        ventana_principal.add(label_esfera_volumen);  ventana_principal.add(label_esfera_superficie);
        return ventana_principal;  }

    private JPanel crear_panel_piramide() {
        JPanel ventana_principal = new JPanel(null);

        JLabel l_base    = new JLabel("Base (cms):");
        JLabel l_altura  = new JLabel("Altura (cms):");
        JLabel l_apotema = new JLabel("Apotema (cms):");
        label_piramide_volumen    = new JLabel("Volumen (cm3):");
        label_piramide_superficie = new JLabel("Superficie (cm2):");

        l_base   .setBounds(20, 20, 135, 23);
        l_altura .setBounds(20,50, 135, 23);
        l_apotema.setBounds(20,80, 135, 23);
        label_piramide_volumen   .setBounds(20, 140, 300, 23);
        label_piramide_superficie.setBounds(20, 165, 300, 23);

        campo_piramide_base    = new JTextField(); campo_piramide_base   .setBounds(160,  20, 135, 23);
        campo_piramide_altura  = new JTextField(); campo_piramide_altura .setBounds(160,  50, 135, 23);
        campo_piramide_apotema = new JTextField(); campo_piramide_apotema.setBounds(160,  80, 135, 23);

        boton_piramide = new JButton("Calcular");
        boton_piramide.setBounds(160, 110, 135, 23);
        boton_piramide.addActionListener(this);

        ventana_principal.add(l_base);  ventana_principal.add(l_altura);  ventana_principal.add(l_apotema);
        ventana_principal.add(campo_piramide_base);  ventana_principal.add(campo_piramide_altura);  ventana_principal.add(campo_piramide_apotema);
        ventana_principal.add(boton_piramide);
        ventana_principal.add(label_piramide_volumen);  ventana_principal.add(label_piramide_superficie);
        return ventana_principal;  }

//eventos
    public void actionPerformed(ActionEvent evento) {
        Object fuente = evento.getSource();

        if (fuente == boton_cilindro) {
            double radio  = leer_double(campo_cilindro_radio);
            double altura = leer_double(campo_cilindro_altura);
            if (radio < 0 || altura < 0) return;
            Cilindro c = new Cilindro(radio, altura);
            label_cilindro_volumen   .setText("Volumen (cm3): " + String.format("%.2f",c.calcular_volumen()));
            label_cilindro_superficie.setText("Superficie (cm2): "+ String.format("%.2f",c.calcular_superficie())); }  

            else if (fuente == boton_esfera) {
            double radio = leer_double(campo_esfera_radio);
            if (radio < 0) return;
            Esfera esferita = new Esfera(radio);
            label_esfera_volumen   .setText("Volumen (cm3): "+ String.format("%.2f",esferita.calcular_volumen()));
            label_esfera_superficie.setText("Superficie (cm2): " + String.format("%.2f", esferita.calcular_superficie()));   } 
           
            else if (fuente == boton_piramide) {
            double base    = leer_double(campo_piramide_base);
            double altura  = leer_double(campo_piramide_altura);
            double apotema = leer_double(campo_piramide_apotema);
            if (base < 0 || altura < 0 || apotema < 0) return;
            Piramide pi = new Piramide(base, altura, apotema);
            label_piramide_volumen   .setText("Volumen (cm3): " + String.format("%.2f", pi.calcular_volumen()));
            label_piramide_superficie.setText("Superficie (cm2): "  + String.format("%.2f", pi.calcular_superficie()));
        }  }
//metodo mensaje de error para JTextfield, solo recibe numeros 
    private double leer_double(JTextField campo) {
        try {
            return Double.parseDouble(campo.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Solo Ingresar numeros en todos los campos", "Error",
                JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}

// Clase principal
public class Figuras_Geometricas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Ventana_Unificada ventana = new Ventana_Unificada();
                ventana.setVisible(true);
            }
        });
    }
}
