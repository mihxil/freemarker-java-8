package no.api.freemarker.java8.time;

import freemarker.template.AdapterTemplateModel;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static no.api.freemarker.java8.time.DateTimeTools.METHOD_FORMAT;
import static no.api.freemarker.java8.time.DateTimeTools.METHOD_UNKNOWN_MSG;
import static no.api.freemarker.java8.time.DateTimeTools.createDateTimeFormatter;

public class OffsetDateTimeAdapter  extends AbstractAdapter<OffsetDateTime> implements AdapterTemplateModel,
        TemplateScalarModel, TemplateHashModel {

    public OffsetDateTimeAdapter(OffsetDateTime obj) {
        super(obj);
    }

    @Override
    public TemplateModel get(String s) throws TemplateModelException {
        if (METHOD_FORMAT.equals(s)) {
            return new OffsetDateTimeFormatter(getObject());
        }
        throw new TemplateModelException(METHOD_UNKNOWN_MSG + s);
    }

    public class OffsetDateTimeFormatter extends AbstractFormatter<OffsetDateTime> implements TemplateMethodModelEx {

        public OffsetDateTimeFormatter(OffsetDateTime obj) {
            super(obj);
        }

        @Override
        public Object exec(List list) throws TemplateModelException {
            return getObject().format(createDateTimeFormatter(list, 0, DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        }
    }
}
