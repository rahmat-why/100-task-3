package id.co.astratech.Controller;

import id.co.astratech.Service.ImbdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imdb")
public class ImdbController {

    @Autowired
    private final ImbdService imbdService;

    public ImdbController(ImbdService imbdService){
        this.imbdService = imbdService;
    }

    @GetMapping("/getAll-film")
    public ResponseEntity<?> callImdbFilm(){
        return ResponseEntity.ok(imbdService.getAllImdbFilm());
    }

}
