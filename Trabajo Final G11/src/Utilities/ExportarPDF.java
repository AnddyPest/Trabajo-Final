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

        // Crear el JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setSelectedFile(new File("ejemplo_textarea.pdf")); // Nombre predeterminado

        // Mostrar el diálogo para seleccionar la ubicación
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return; // Si el usuario cancela, salir del método
        }

        // Obtener el archivo seleccionado
        File fileToSave = fileChooser.getSelectedFile();

        // Asegurarse de que la extensión del archivo sea .pdf
        String filePath = fileToSave.getAbsolutePath();
        if (!filePath.endsWith(".pdf")) {
            filePath += ".pdf"; // Agregar .pdf si no está presente
        }

        try {
            // Crear el escritor de PDF
            PdfWriter.getInstance(documento, new FileOutputStream(filePath));

            // Abrir el documento para escribir
            documento.open();

            // Obtener el contenido del JTextArea y añadirlo al documento
            String contenido = textArea.getText();
            documento.add(new Paragraph(contenido));

            // Cerrar el documento
            documento.close();

            JOptionPane.showMessageDialog(null, "PDF generado exitosamente en: " + filePath);
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
