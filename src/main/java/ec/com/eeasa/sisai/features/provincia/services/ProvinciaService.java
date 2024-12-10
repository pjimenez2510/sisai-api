package ec.com.eeasa.sisai.features.provincia.services;

import ec.com.eeasa.sisai.features.provincia.dtos.ActualizarProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.dtos.CrearProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.dtos.FiltroProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.dtos.ProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.entities.Provincia;
import org.springframework.data.domain.Page;

public interface ProvinciaService {

    Page<ProvinciaDto> encontrarTodos(FiltroProvinciaDto filtro);

    ProvinciaDto encontrarPorId(Long id);

    Provincia encontrarPorIdEntity(Long id);

    ProvinciaDto crear(CrearProvinciaDto dto);

    ProvinciaDto actualizar(Long id, ActualizarProvinciaDto dto);

    boolean eliminar(Long id);}
