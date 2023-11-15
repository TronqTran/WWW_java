package vn.edu.iuh.lab_02.converters;

import jakarta.persistence.AttributeConverter;
import org.joda.time.DateTime;

import java.util.Date;

public class DateTimeConverter implements AttributeConverter<DateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(DateTime attribute) {
        if (attribute != null)
            return attribute.toDate();
        return null;
    }

    @Override
    public DateTime convertToEntityAttribute(Date dbData) {
        if (dbData != null)
            return new DateTime(dbData);
        return null;
    }
}