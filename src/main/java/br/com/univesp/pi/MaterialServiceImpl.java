package br.com.univesp.pi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Override
    public Material saveMaterial(Material product) {
        return materialRepository.save(product);
    }

    @Override
    public Material getMaterialById(Long id) {
        Optional<Material> result = materialRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException(String.valueOf(id));
        }
    }

    @Override
    public List<Material> getMaterialsByRegex(String regex) {


        return materialRepository.getMaterialByRegex(regex);
    }


}
