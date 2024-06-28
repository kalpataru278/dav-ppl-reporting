package com.dav.reporting;

import com.dav.reporting.model.PaySlipEmpDetail;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
public class ReportTesting {

    @Test
    void test() throws FileNotFoundException, JRException {
        // read jasper report template
        //File file = ResourceUtils.getFile("classpath:jasper/DavPayslip.jrxml");
        File file = ResourceUtils.getFile("classpath:jasper/Blank_A4_Landscape.jrxml");
        // define the out put file
        String outFilePath=file.toPath().getParent()+"/samplev18.pdf";
        System.out.println(outFilePath);
        // compile the report
        /*List<PaySlipEmpDetail> paySlipEmpDetails = List.of(PaySlipEmpDetail.builder().c1Key("Employee Code").c1Value("123").c2Key("Employee Name").c2Value("John Paul").build(),
                PaySlipEmpDetail.builder().c1Key("Location").c1Value("PPL").c2Key("Date Of Joining").c2Value("12/07/2012").build(),
                PaySlipEmpDetail.builder().c1Key("PAN").c1Value("BZXPM1244K").c2Key("Designation").c2Value("PRINCIPAL").build(),
                PaySlipEmpDetail.builder().c1Key("PF No").c1Value("213413414").c2Key("UAN").c2Value("123141515").build(),
                PaySlipEmpDetail.builder().c1Key("Bank Name").c1Value("AXIS").c2Key("Account Number").c2Value("33007783").build(),
                PaySlipEmpDetail.builder().c1Key("Work Days").c1Value("31").c2Key("7th Pay Matrix Level").c2Value("12").build());*/

        List<PaySlipEmpDetail> paySlipEmpDetails = List.of(new PaySlipEmpDetail("Employee Code", "123", "Employee Name", "John Paul"));
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paySlipEmpDetails);

        JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
        // fill the report
        Map<String, Object> params=new HashMap<>();

        params.put("tbData", dataSource);

        //params.put("month", "JAN - 2024");

        //params.put("generatedon", "Jan 3 2022 at 10:23AM UTC");

        //params.put("dateRange", "May 01, 2022 May 29, 2022");

        //params.put("Logo", getClass().getResourceAsStream("jasper/logo.png"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, new JREmptyDataSource());

        // export the pdf
        JasperExportManager.exportReportToPdfFile(jasperPrint, outFilePath);

        /*JRPdfExporter pdfExporter=new JRPdfExporter();
        pdfExporter.setExporterInput(now SimpleExporterInput(jasperPrint));
        pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outFilePath));
        pdfExporter.exportReport();*/



    }
}
