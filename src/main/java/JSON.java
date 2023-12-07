import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSON {
    public String fetchData(String Key) throws IOException, ParseException {
        JSONParser jp = new JSONParser();
        FileReader reader = new FileReader("/Users/testvagrant/IdeaProjects/Capstone/src/test/resources/TestData.json");
        Object obj = jp.parse(reader);
        JSONObject datajson = (JSONObject) obj;
        String data = (String) datajson.get(Key);
        return data;
    }
}


