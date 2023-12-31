package vn.edu.iuh.lab_02.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
    final ObjectMapper mapper = new ObjectMapper();


    public ObjectMapperContextResolver() {
        mapper.registerModule(new JodaModule());
    }

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return mapper;
    }
}