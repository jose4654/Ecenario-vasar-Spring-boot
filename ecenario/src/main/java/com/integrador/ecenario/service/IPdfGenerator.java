package com.integrador.ecenario.service;

import java.util.List;

import org.w3c.dom.Document;

import com.integrador.ecenario.model.Venta;
import com.lowagie.text.DocumentException;

public interface IPdfGenerator {
	byte[] generatePdf(List<Venta> ventas) throws DocumentException;
	
     
}
