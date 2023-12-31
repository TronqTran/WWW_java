package vn.edu.iuh.lab_02.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.joda.time.LocalDateTime;

import java.util.Date;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        if(localDateTime != null){
            return localDateTime.toDate();
        }
        return null;
    }
    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        if(date != null){
            return new LocalDateTime(date);
        }
        return null;
    }
}
