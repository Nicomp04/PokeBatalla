package org.example.Habilidades;
import org.example.Habilidades.Habilidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class RepositorioHabilidades {
    private Map<Integer, Habilidad> mapaHabilidades;

    public RepositorioHabilidades() {
        this.mapaHabilidades = new HashMap<>();
    }

    public void agregarHabilidad(Habilidad habilidad) {
        mapaHabilidades.put(habilidad.getId(), habilidad);
    }

    public Habilidad obtenerHabilidadPorId(int id) {
        return mapaHabilidades.get(id);
    }

    public List<Habilidad> cargarConjunto(List<Integer> habilidadesId) {
        List<Habilidad> habilidades = new ArrayList<>();

        for (Integer habilidadId : habilidadesId) {
            Habilidad habilidad = obtenerHabilidadPorId(habilidadId);
            habilidades.add(habilidad.clonar());
        }
        return  habilidades;
    }

    public void cargarMapa(Map<Integer, Habilidad> habilidadMap) {
        this.mapaHabilidades = habilidadMap;
    }
}