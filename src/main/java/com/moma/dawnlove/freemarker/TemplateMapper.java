package com.moma.dawnlove.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class TemplateMapper {

	public Configuration get(File templateDir) throws IOException {

		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(templateDir);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

		return cfg;

	}

	public Template getTemplate(File templateDir, String template) throws IOException {

		Configuration cfg = this.get(templateDir);
		Template temp = cfg.getTemplate(template);

		return temp;

	}

	public String getTemplateMapping(File templateDir, String template, Object root)
			throws TemplateException, IOException {

		Writer writer = new StringWriter();
		Template temp = getTemplate(templateDir, template);
		temp.process(root, writer);

		return writer.toString();
	}

}
