package com.integrador.ecenario.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.ecenario.model.Venta;
import com.integrador.ecenario.service.IPdfGenerator;
import com.integrador.ecenario.service.IVentaService;
import com.lowagie.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
@RestController
public class PdfController {
	  private final IPdfGenerator pdfGenerator;
	  @Autowired
      private IVentaService ventas;
	    
	    public PdfController(IPdfGenerator pdfGenerator) {
	        this.pdfGenerator = pdfGenerator;
	    }

	    @GetMapping("/ventas")
	    public ResponseEntity<byte[]> generarPdfVentas() throws IOException, DocumentException {
	    	
	        List<Venta> ventas = obtenerListaDeVentas();  // Reemplaza con tu lógica para obtener la lista de ventas

	        byte[] pdfBytes = pdfGenerator.generatePdf(ventas);

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("attachment", "ventas.pdf");

	        return ResponseEntity.ok().headers(headers).body(pdfBytes);
	    }

	    private List<Venta> obtenerListaDeVentas() {
	        
	        return ventas.getVentas();
	    }
}
