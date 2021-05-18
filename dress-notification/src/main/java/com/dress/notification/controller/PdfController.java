package com.dress.notification.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.dress.notification.helper.OrderHelper;
import com.dress.notification.model.Order;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

@RestController
public class PdfController {
	
    private TemplateEngine templateEngine;

	public PdfController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

	@RequestMapping(path = "pdf")
	public ResponseEntity<?> getPDF() throws IOException {

		/* Do Business Logic */

		Order order = OrderHelper.getOrder();

		/* Create HTML using Thymeleaf template Engine */
		Context context = new Context();
		context.setVariable("orderEntry", order);

		String orderHtml = templateEngine.process("invoices/order", context);

		/* Setup Source and target I/O streams */

		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8200");
		/* Call convert method */
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);

		/* extract output as bytes */
		byte[] bytes = target.toByteArray();

		/* Send the response as downloadable PDF */

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=order.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);

	}
}
