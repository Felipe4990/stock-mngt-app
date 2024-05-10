package br.com.univesp.pi;

import java.util.List;

public interface MaterialService {
    Material saveMaterial(Material material);

    Material getMaterialById(Long id);

    List<Material> getMaterialsByRegex(String regex);

    void deleteMaterialById(Long id);
}
