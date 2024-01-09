package cap.tp.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ObjectUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;


public class ZipCodeClient {

    public String getCommune(String codePostal) {
        var apiUrl = "https://apicarto.ign.fr/api/codes-postaux/communes/"+codePostal;
        var commune = codePostal;
        try {

            if(!ObjectUtils.isEmpty(commune)) {
                var url = new URI(apiUrl).toURL();
                var con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                var in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                var content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                var contentString = content.toString();
                var mapper = new ObjectMapper();
                if(!ObjectUtils.isEmpty(contentString) && !contentString.equals("Not Found")){
                    commune = mapper.readTree(content.toString()).get(0).get("nomCommune").asText();
                }
            }
        }  catch (IOException |NullPointerException | URISyntaxException  e) {
            return commune;
        }
        return commune;
    }
}
