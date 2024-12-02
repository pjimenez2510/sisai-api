package ec.com.eeasa.sisai.features.roles.services.impl;

import ec.com.eeasa.sisai.features.auditoria.anotaciones.Auditable;
import ec.com.eeasa.sisai.features.roles.dtos.ActualizarRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.CrearRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.FiltroRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.RolDto;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import ec.com.eeasa.sisai.features.roles.helpers.EspecificacionRol;
import ec.com.eeasa.sisai.features.roles.mappers.RolMapper;
import ec.com.eeasa.sisai.features.roles.repositories.RolRepository;
import ec.com.eeasa.sisai.features.roles.services.RolService;
import ec.com.eeasa.sisai.shared.excepciones.RecursoNoEncontrado;
import ec.com.eeasa.sisai.utils.PaginacionUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<RolDto> encontrarTodos(FiltroRolDto filtro) {
        Specification<Rol> spec = new EspecificacionRol(filtro);
        return rolRepository.findAll(spec, PaginacionUtils.crearPageRequest(filtro)).map(rolMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public RolDto encontrarPorId(Long id) {
        return rolMapper.toDTO(encontrarPorIdEntity(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Rol encontrarPorIdEntity(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Rol", "id", id.toString()));
    }

    @Override
    @Transactional
    @Auditable(tabla = "DIST_USU_ROL", operacion = "CREAR")
    public RolDto crear(CrearRolDto dto) {
        Rol rol = rolMapper.toEntity(dto);
        return rolMapper.toDTO(rolRepository.save(rol));
    }

    @Override
    @Transactional
    @Auditable(tabla = "DIST_USU_ROL", operacion = "ACTUALIZAR")
    public RolDto actualizar(Long id, ActualizarRolDto dto) {
        Rol rol = encontrarPorIdEntity(id);
        rolMapper.updateEntity(rol, dto);
        return rolMapper.toDTO(rolRepository.save(rol));
    }

    @Override
    @Transactional
    @Auditable(tabla = "DIST_USU_ROL", operacion = "ELIMINAR")
    public boolean eliminar(Long id) {
        Rol rol = encontrarPorIdEntity(id);
        rolRepository.delete(rol);
        return true;
    }

}
