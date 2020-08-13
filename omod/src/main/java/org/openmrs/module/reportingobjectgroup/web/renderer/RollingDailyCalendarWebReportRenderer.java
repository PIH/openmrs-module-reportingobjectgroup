package org.openmrs.module.reportingobjectgroup.web.renderer;

import java.util.Collection;
import java.util.Collections;

import org.openmrs.annotation.Handler;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.openmrs.module.reporting.report.renderer.RenderingMode;
import org.openmrs.module.reporting.web.renderers.AbstractWebReportRenderer;
import org.openmrs.module.reportingobjectgroup.dataset.RollingDailyIndicatorDataSetDefinition;

@Handler
public class RollingDailyCalendarWebReportRenderer extends AbstractWebReportRenderer {
	
	/**
     * @see org.openmrs.module.reporting.report.renderer.ReportRenderer#canRender(org.openmrs.module.reporting.report.definition.ReportDefinition)
     */
    public boolean canRender(ReportDefinition reportDefinition) {
    	for (Mapped<? extends DataSetDefinition> def : reportDefinition.getDataSetDefinitions().values()) {
	    	if (def.getParameterizable() instanceof RollingDailyIndicatorDataSetDefinition) {
	    		return true;
	    	}    	
	    }
	    return false;
    }

    public String getLabel() {
    	return "Web Indicator Renderer";
    }

	public String getLinkUrl(ReportDefinition reportDefinition) {
		return "module/reporting/reports/renderDefaultReport.form";
	}

	public Collection<RenderingMode> getRenderingModes(ReportDefinition schema) {
		return Collections.singleton(new RenderingMode(this, this.getLabel(), null, Integer.MAX_VALUE - 10));
	}
	
}
