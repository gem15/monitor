package com.sevtrans.monitor.service;

import com.sevtrans.monitor.dto.Order;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class Report {

    private byte[] orderPdfReport(Order order) throws JRException {
        // Fetching the .jrxml file from the resources folder.
        final InputStream stream = this.getClass().getResourceAsStream("/report.jrxml");

        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);

        // Fetching the employees from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(order.getLineItem());

        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("orderNo", order.getOrderNo());

        // Filling the report with the employee data and additional parameters information.
        final JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, source);


//       final byte[] data;
//        data = JasperExportManager.exportReportToPdf(jasperPrint);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint,buffer);
       return buffer.toByteArray();
    }

    // Method to create the pdf file using the employee list datasource.
    private void createPdfReport(Order order) throws JRException {
//    private void createPdfReport(final List<Employee> employees) throws JRException {

        // Fetching the .jrxml file from the resources folder.
        final InputStream stream = this.getClass().getResourceAsStream("/report.jrxml");

        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);

        // Fetching the employees from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(order.getLineItem());

        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("orderNo", order.getOrderNo());

        // Filling the report with the employee data and additional parameters information.
        final JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, source);


        final byte[] data;
        data = JasperExportManager.exportReportToPdf(jasperPrint);

        // Users can change as per their project requrirements or can take it as request input requirement.
        // For simplicity, this tutorial will automatically place the file under the "c:" drive.
        // If users want to download the pdf file on the browser, then they need to use the "Content-Disposition" technique.
        final String filePath = "D:\\";
/*
		// Export the report to a PDF file.
		JasperExportManager.exportReportToPdfFile(print, filePath + "Employee_report.pdf");
*/
        //далее из
        //https://medium.com/@isurunuwanthilaka/jasper-reporting-java-d6764cfa8e42
        JRPdfExporter exporterPDF = new JRPdfExporter();
        exporterPDF.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporterPDF.setExporterOutput(new SimpleOutputStreamExporterOutput(filePath + "Employee_report.pdf"));

        SimplePdfReportConfiguration reportConfigPDF = new SimplePdfReportConfiguration();
        reportConfigPDF.setSizePageToContent(true);
        reportConfigPDF.setForceLineBreakPolicy(false);
//....
        //TODO saving file in the back end
        ////exporterPDF.exportReport();
        log.info("REPORT : PDF File sent to Report Folder");
        //exporting data to web browser at the end we push it...
//check last code snippet
//        final byte[] data;
//        data = JasperExportManager.exportReportToPdf(jasperPrint);
//
//        header.setContentType(MediaType.APPLICATION_PDF);
//        header.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + "Employee_report.pdf");
//        header.setContentLength(data.length);

        log.info("REPORT : " + "Employee_report.pdf" + " PDF File sent to web browser");

//exporting data to web browser at the end we push it...
//check last code snippetdata = JasperExportManager.exportReportToPdf(jasperPrint);
    }

    public JRDataSource getJRDataSourceFromXml(String filePath) throws ReportingException {
        JRXmlDataSource jrXmlDataSource;
        try {
            InputStream inputStream = new FileInputStream(new File(filePath));
            jrXmlDataSource = new JRXmlDataSource(inputStream);
        } catch (FileNotFoundException e) {
            throw new ReportingException(filePath + " file could not found");
        } catch (JRException e) {
            throw new ReportingException("could not create JRXmlDataSource from " + filePath);
        }
        return jrXmlDataSource;
    }
}
