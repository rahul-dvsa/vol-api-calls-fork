package apiCalls.Utils.eupaBuilders.deserialiser;

import activesupport.string.Str;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateISO8601Deserialiser extends StdDeserializer<LocalDateTime> {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public DateISO8601Deserialiser() {
        this(null);
    }

    public DateISO8601Deserialiser(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
        String dateRegex = "[\\d\\-]+(?=T)";
        String timeRegex = "[\\d:]+(?=\\+)";

        String dateTime = jsonparser.getText();

        String date = Str.find(dateRegex, dateTime)
                .orElseThrow(()-> new IllegalArgumentException("Unable to parse for date in subject:" + dateTime + " with REGEX:" + dateRegex));
        String time = Str.find(timeRegex, dateTime)
                .orElseThrow(() -> new IllegalArgumentException("Unable to parse for time in subject:" + dateTime + " with REGEX:"  + timeRegex));

        return LocalDateTime.parse(date + " " + time, formatter);
    }

}
