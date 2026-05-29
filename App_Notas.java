//librerias para graficas,manejo de eventos

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//clase para ventana principal
public class App_Notas {

    public static void main(String[] args) {
        Ventana_Principal mi_ventana = new Ventana_Principal();
        mi_ventana.setVisible(true); }
}

//guardar notas y hacer los calculos
class Calculo_Notas {

//lista para las 5 notas ingresadas
    double[] lista_notas;

// array para 5 notas
    public Calculo_Notas() {
        lista_notas = new double[5];}
//Calcular promedo
    double calcular_promedio() {
        double suma = 0;
        for (int i = 1; i < lista_notas.length; i++) {
            suma = suma + lista_notas[i];
        }
        return suma / lista_notas.length;}

    double calcular_desviacion() {
        double promedio = calcular_promedio();
        double suma_diferencias = 0;
        for (int i = 0; i < lista_notas.length; i++) {
            suma_diferencias += Math.pow(lista_notas[i] - promedio, 2);}
        return Math.sqrt(suma_diferencias / lista_notas.length); }

//calcular el mayor
    double calcular_mayor() {
        double mayor = lista_notas[0];
        for (int i = 1; i < lista_notas.length; i++) {
            if (lista_notas[i] > mayor) {
                mayor = lista_notas[i]; } }
        return mayor; }

//calcular el menor
    double calcular_menor() {
        double menor = lista_notas[0];
        for (int i = 1; i < lista_notas.length; i++) {
            if (lista_notas[i] < menor) {
                menor = lista_notas[i]; }}
        return menor; }}

// la clase Ventana_Principal muestra la interfaz gráfica y responde a los clicks del usuario.

class Ventana_Principal extends JFrame implements ActionListener {

    private JLabel etiqueta_nota1, etiqueta_nota2, etiqueta_nota3,
                   etiqueta_nota4, etiqueta_nota5;
    private JTextField campo_nota1, campo_nota2, campo_nota3,
                       campo_nota4, campo_nota5;
//imprime resultados
    private JLabel resultado_promedio, resultado_desviacion,
                   resultado_mayor,    resultado_menor;
//botones para calculo y limpiar
    private JButton boton_calcular, boton_limpiar;
    private Container contenedor;
//construccion y configuraciones de la ventana
    public Ventana_Principal() {
        construir_ventana();
//titulo de la ventana
        setTitle("Ej 8.2 Jhmorag");
// Tamano de Ancho x Alto en pixeles  
        setSize(500, 500);                            
// Cierra la ventana al salir     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); }
//set de la ventana
    private void construir_ventana() {
        contenedor = getContentPane();
        contenedor.setLayout(null);    
//nota1
        etiqueta_nota1 = new JLabel("Nota 1:");
        etiqueta_nota1.setBounds(20, 20, 80, 25);
        campo_nota1 = new JTextField();
        campo_nota1.setBounds(115, 20, 145, 25);
//nota2
        etiqueta_nota2 = new JLabel("Nota 2:");
        etiqueta_nota2.setBounds(20, 57, 80, 25);
        campo_nota2 = new JTextField();
        campo_nota2.setBounds(115, 57, 145, 25);

//nota3
        etiqueta_nota3 = new JLabel("Nota 3:");
        etiqueta_nota3.setBounds(20, 94, 80, 25);
        campo_nota3 = new JTextField();
        campo_nota3.setBounds(115, 94, 145, 25);
//nota4
        etiqueta_nota4 = new JLabel("Nota 4:");
        etiqueta_nota4.setBounds(20, 131, 80, 25);
        campo_nota4 = new JTextField();
        campo_nota4.setBounds(115, 131, 145, 25);
//nota5
        etiqueta_nota5 = new JLabel("Nota 5:");
        etiqueta_nota5.setBounds(20, 168, 80, 25);
        campo_nota5 = new JTextField();
        campo_nota5.setBounds(115, 168, 145, 25);

//botones 
        boton_calcular = new JButton("Calcular");
        boton_calcular.setBounds(20, 210, 115, 30);
        boton_calcular.addActionListener(this);   

        boton_limpiar = new JButton("Limpiar");
        boton_limpiar.setBounds(150, 210, 115, 30);
        boton_limpiar.addActionListener(this);    

//regristro de resultados
        resultado_promedio   = new JLabel("Promedio = ");
        resultado_promedio.setBounds(20, 260, 260, 25);
        resultado_desviacion = new JLabel("Desviación estándar = ");
        resultado_desviacion.setBounds(20, 295, 260, 25);
        resultado_mayor      = new JLabel("Nota mayor = ");
        resultado_mayor.setBounds(20, 330, 260, 25);
        resultado_menor      = new JLabel("Nota menor = ");
        resultado_menor.setBounds(20, 365, 260, 25);

//agrega todos los componentes a la interfaz
        contenedor.add(etiqueta_nota1);   contenedor.add(campo_nota1);
        contenedor.add(etiqueta_nota2);   contenedor.add(campo_nota2);
        contenedor.add(etiqueta_nota3);   contenedor.add(campo_nota3);
        contenedor.add(etiqueta_nota4);   contenedor.add(campo_nota4);
        contenedor.add(etiqueta_nota5);   contenedor.add(campo_nota5);
        contenedor.add(boton_calcular);
        contenedor.add(boton_limpiar);
        contenedor.add(resultado_promedio);
        contenedor.add(resultado_desviacion);
        contenedor.add(resultado_mayor);
        contenedor.add(resultado_menor); }

// desarrollo ejercicios propuestos
    public void actionPerformed(ActionEvent evento) {


        if (evento.getSource() == boton_calcular) {

//1 Ningun espacio puede estar vacio
            if (campo_nota1.getText().isEmpty() || campo_nota2.getText().isEmpty() ||
                campo_nota3.getText().isEmpty() || campo_nota4.getText().isEmpty() ||
                campo_nota5.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Todos los espacios deben tener un numero",
                    "Hay espacios vacios", JOptionPane.WARNING_MESSAGE);
                return;   }

//2 Solo se reciben numeros e imprimir un mensaje de error 
            try {
                Calculo_Notas mis_notas = new Calculo_Notas();
                mis_notas.lista_notas[0] = Double.parseDouble(campo_nota1.getText());
                mis_notas.lista_notas[1] = Double.parseDouble(campo_nota2.getText());
                mis_notas.lista_notas[2] = Double.parseDouble(campo_nota3.getText());
                mis_notas.lista_notas[3] = Double.parseDouble(campo_nota4.getText());
                mis_notas.lista_notas[4] = Double.parseDouble(campo_nota5.getText());
                resultado_promedio.setText(
                    "Promedio = " + String.format("%.2f", mis_notas.calcular_promedio()));
                resultado_desviacion.setText(
                    "Desviacion estandar = " + String.format("%.2f", mis_notas.calcular_desviacion()));
                resultado_mayor.setText(
                    "Nota mayor = " + String.format("%.2f", mis_notas.calcular_mayor()));
                resultado_menor.setText(
                    "Nota menor = " + String.format("%.2f", mis_notas.calcular_menor()));
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(this,
                    "Solo se permiten numeros",
                    "Dato NO valido", JOptionPane.ERROR_MESSAGE);  }}

        if (evento.getSource() == boton_limpiar) {
//limpiar interfaz grafica
            campo_nota1.setText("");
            campo_nota2.setText("");
            campo_nota3.setText("");
            campo_nota4.setText("");
            campo_nota5.setText("");
            resultado_promedio.setText("Promedio = ");
            resultado_desviacion.setText("Desviacion estándar = ");
            resultado_mayor.setText("Nota mayor = ");
            resultado_menor.setText("Nota menor = ");  } }
}
