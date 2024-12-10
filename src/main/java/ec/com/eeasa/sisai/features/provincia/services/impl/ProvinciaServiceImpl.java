package ec.com.eeasa.sisai.features.provincia.services.impl;

import ec.com.eeasa.sisai.features.auditoria.anotaciones.Auditable;
import ec.com.eeasa.sisai.features.auditoria.constantes.Operaciones;
import ec.com.eeasa.sisai.features.auditoria.constantes.Tablas;
import ec.com.eeasa.sisai.features.provincia.dtos.ActualizarProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.dtos.CrearProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.dtos.FiltroProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.dtos.ProvinciaDto;
import ec.com.eeasa.sisai.features.provincia.entities.Provincia;
import ec.com.eeasa.sisai.features.provincia.mappers.ProvinciaMapper;
import ec.com.eeasa.sisai.features.provincia.repositories.EspecificacionProvincia;
import ec.com.eeasa.sisai.features.provincia.repositories.ProvinciaRepository;
import ec.com.eeasa.sisai.features.provincia.services.ProvinciaService;
import ec.com.eeasa.sisai.features.tipo_contrato.entities.TipoContrato;
import ec.com.eeasa.sisai.features.tipo_contrato.repositories.EspecificacionTipoContrato;
import ec.com.eeasa.sisai.shared.constantes.Estado;
import ec.com.eeasa.sisai.shared.excepciones.RecursoNoEncontrado;
import ec.com.eeasa.sisai.shared.utils.PaginacionUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProvinciaServiceImpl implements ProvinciaService {

    private final ProvinciaRepository provinciaRepository;
    private final ProvinciaMapper provinciaMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<ProvinciaDto> encontrarTodos(FiltroProvinciaDto filtro) {
        Specification<Provincia> spec = new EspecificacionProvincia(filtro);
        return provinciaRepository.findAll(spec, PaginacionUtils.crearPageRequest(filtro))
                .map(provinciaMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public ProvinciaDto encontrarPorId(Long id) {
        return provinciaMapper.toDTO(encontrarPorIdEntity(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Provincia encontrarPorIdEntity(Long id) {
        return provinciaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Provincia", "id", id.toString()));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.PROVINCIA, operacion = Operaciones.CREAR)
    public ProvinciaDto crear(CrearProvinciaDto dto) {
        Provincia provincia = provinciaMapper.toEntity(dto);
        return provinciaMapper.toDTO(provinciaRepository.save(provincia));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.PROVINCIA, operacion = Operaciones.ACTUALIZAR)
    public ProvinciaDto actualizar(Long id, ActualizarProvinciaDto dto) {
        Provincia provincia = encontrarPorIdEntity(id);
        provinciaMapper.updateEntity(provincia, dto);
        return provinciaMapper.toDTO(provinciaRepository.save(provincia));
    }

    @Override
    @Transactional
    @Auditable(tabla = Tablas.PROVINCIA, operacion = Operaciones.ELIMINAR)
    public boolean eliminar(Long id) {
        Provincia provincia = encontrarPorIdEntity(id);
        provincia.setActivo(Estado.INACTIVO);
        Provincia provinciaUpdate = provinciaRepository.save(provincia);
        return provinciaUpdate.getActivo().equals(Estado.INACTIVO);
    }
}
