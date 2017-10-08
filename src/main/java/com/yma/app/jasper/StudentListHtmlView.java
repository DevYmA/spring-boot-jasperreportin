package com.yma.app.jasper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.yma.app.model.CurrencyRate;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;

@Component("employeeDetails")
public class StudentListHtmlView extends AbstractView{

	private JasperReport currencyRatesReport;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html");
		List<CurrencyRate> rates = (List<CurrencyRate>) model.get("employeeList");
		JRDataSource dataSource = getDataSource(rates);
		JasperReport 	report = getReport();
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, dataSource);
		HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
		exporter.exportReport();
	}
	
	private JRDataSource getDataSource(List<CurrencyRate> rates) {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(rates);
		return dataSource;
	}
	
	private JasperReport getReport() throws JRException {
		if(currencyRatesReport == null) {
			InputStream inputStream = getClass().getResourceAsStream("/list.jrxml");
			currencyRatesReport = JasperCompileManager.compileReport(inputStream);
		}
		return currencyRatesReport;
	}

}
