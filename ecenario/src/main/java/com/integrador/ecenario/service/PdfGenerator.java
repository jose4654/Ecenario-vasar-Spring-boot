package com.integrador.ecenario.service;


import org.springframework.stereotype.Service;
import com.integrador.ecenario.model.Venta;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

import java.util.List;

@Service
public class PdfGenerator implements IPdfGenerator{



	// Método para generar un PDF a partir de una lista de ventas
@Override
public byte[] generatePdf(List<Venta> ventas) throws DocumentException {
	  Document document = new Document();
   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
   PdfWriter.getInstance(document, outputStream);

   document.open();
   addContent(document, ventas);
    document.close();

    return outputStream.toByteArray();
}

private void addContent(Document document, List<Venta> ventas) throws DocumentException {
    for (Venta venta : ventas) {
        document.add(new Paragraph("ID: " + venta.getId()));
        document.add(new Paragraph("Fecha: " + venta.getFecha()));
        document.add(new Paragraph("total: " + venta.getTotal()));
        // Agregar más detalles según tu modelo de datos
        document.add(new Paragraph("\n"));  // Separador entre ventas
    }
}
}
