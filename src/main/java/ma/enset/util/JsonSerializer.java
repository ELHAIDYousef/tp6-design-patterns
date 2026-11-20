package ma.enset.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Yousef ELHAID
 */
public class JsonSerializer<T> {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String toJson(T data) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}