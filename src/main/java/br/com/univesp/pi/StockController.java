package br.com.univesp.pi;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class StockController {

    @Autowired
    MaterialService materialService;

    @Autowired
    private ModelMapper modelMapper;
    @CrossOrigin
    @PostMapping(path = "/api/materials")
    public ResponseEntity<MaterialDTO> saveMaterial(@RequestBody MaterialDTO materialDTO){

        // Convert DTO to Entity
        Material materialRequest = modelMapper.map(materialDTO, Material.class);

        // Save Product to MySQL
        Material material = materialService.saveMaterial(materialRequest);

        // Convert Entity to DTO
        MaterialDTO materialResponse = modelMapper.map(material, MaterialDTO.class);

        return new ResponseEntity<MaterialDTO>(materialResponse, HttpStatus.CREATED);
    }
    @CrossOrigin
    @DeleteMapping("/api/material/id/{id}")
    public ResponseEntity<String> deleteMaterialById(@PathVariable(name = "id") Long id) {

        // Delete Material from MySQL
        materialService.deleteMaterialById(id);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/api/material/id/{id}")
    public ResponseEntity<MaterialDTO> getMaterialById(@PathVariable(name = "id") Long id) {

        // Get Product from MySQL
        Material material = materialService.getMaterialById(id);

        // Convert Entity to DTO
        MaterialDTO materialResponse = modelMapper.map(material, MaterialDTO.class);

        return ResponseEntity.ok().body(materialResponse);
    }

    @CrossOrigin
    @GetMapping("/api/material/{name}")
    public ResponseEntity<List<Material>> getMaterialByRegex(@PathVariable(name = "name") String name) {

        // Get Product from MySQL
        List<Material> materials = materialService.getMaterialsByRegex(name);

        return ResponseEntity.ok().body(materials);
    }



}