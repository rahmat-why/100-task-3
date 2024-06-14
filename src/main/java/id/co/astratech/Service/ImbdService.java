package id.co.astratech.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class ImbdService {

    private static final String url = "https://imdb8.p.rapidapi.com/auto-complete?q=game%20of%20thr";

    private static final String xRapidapiKey = "a86832c5c2msh471a4eaad8903d5p167130jsnedbd9697736f";

    private static final String getxRapidApiHost = "imdb8.p.rapidapi.com";

    @Autowired
    private RestTemplate restTemplate;

    public Object getAllImdbFilm() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", xRapidapiKey);
            headers.set("x-rapidapi-host", getxRapidApiHost);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(headers),String.class);
            log.info("Output API: {} ", response.getBody());

            return response.getBody();

        }catch (Exception e){
            log.error("Terjadi kesalahan dengan RapidAPI ", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exeception ketika memanggil API",
                    e
            );
        }
    }
}
