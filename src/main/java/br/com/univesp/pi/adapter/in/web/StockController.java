package br.com.univesp.pi.adapter.in.web;

import br.com.univesp.pi.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class StockController {
    @GetMapping(path = "/api/products")
    public Iterable<Object> getProducts(){

        return null; //donorRepository.findAll();
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    @GetMapping(path = "/api/product/{productId}")
    public Iterable<Object> getProductById(){

        return null;
    }
=======
>>>>>>> 66680f7 (feat: First Commit)
=======
>>>>>>> 9dc0515 (feat: First Commit)
=======
    @GetMapping(path = "/api/product/{productId}")
    public Iterable<Object> getProductById(){

        return null;
    }
>>>>>>> 7cda6c6 (Merge remote-tracking branch 'origin/master')
}
