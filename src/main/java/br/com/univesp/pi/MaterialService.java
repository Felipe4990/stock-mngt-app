package br.com.univesp.pi;

import java.util.List;

public interface MaterialService {
    Material saveMaterial(Material product);

    Material getMaterialById(Long id);

    List<Material> getMaterialsByRegex(String regex);

}
