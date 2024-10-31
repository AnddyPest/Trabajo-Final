package Utilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExportarPDF {

    public static void exportarJTextAreaAPdf(JTextArea textArea) {
        Document documento = new Document();

        //Creamos la ventana para elegir el destino del archivo PDF generado.
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setSelectedFile(new File(""));

        // Mmostramos la ventanita de seleccion de capeta.
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return; // Si llega a cancelar, sale de la ventana.
        }

        // Obtenemos el archivo seleccionado.
        File fileToSave = fileChooser.getSelectedFile();

        // Verificamos que sea un pdf
        String filePath = fileToSave.getAbsolutePath();
        if (!filePath.endsWith(".pdf")) {
            filePath += ".pdf"; // Agregar .pdf si no está presente
        }

        try {
            // Crear PDF
            PdfWriter.getInstance(documento, new FileOutputStream(filePath));

            // Abre el pdf para escrib irle, pero no lo muestra jeje
            documento.open();

            // Obtener el contenido del JTextArea y añadirlo al documento de texto a exportar wacho
            String contenido = textArea.getText();
            documento.add(new Paragraph(contenido));

            // Aca cierra el pdf, asi que esta perfecto. El tema del forrmato del pdf te lo debo jeje
            documento.close();

            JOptionPane.showMessageDialog(null, "PDF generado exitosamente en: " + filePath);
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
