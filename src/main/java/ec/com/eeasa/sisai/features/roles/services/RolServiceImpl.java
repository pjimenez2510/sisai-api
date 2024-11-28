package ec.com.eeasa.sisai.features.roles;

import ec.com.eeasa.sisai.features.roles.dtos.ActualizarRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.CrearRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.FiltroRolDto;
import ec.com.eeasa.sisai.features.roles.dtos.RolDto;
import ec.com.eeasa.sisai.features.roles.entities.Rol;
import ec.com.eeasa.sisai.features.roles.helpers.EspecificacionRol;
import ec.com.eeasa.sisai.features.roles.mappers.RolMapper;
import ec.com.eeasa.sisai.shared.excepciones.RecursoNoEncontrado;
import ec.com.eeasa.sisai.utils.PaginacionUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RolService {
    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Transactional(readOnly = true)
    public Page<RolDto> encontrarTodos(FiltroRolDto filtro) {
        Specification<Rol> spec = new EspecificacionRol(filtro);
        return rolRepository.findAll(spec, PaginacionUtils.crearPageRequest(filtro)).map(rolMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public RolDto encontrarPorId(Long id) {
        return rolMapper.toDTO(encontrarPorIdEntity(id));
    }

    @Transactional(readOnly = true)
    public Rol encontrarPorIdEntity(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Rol", "id", id.toString()));
    }

    @Transactional
    public RolDto crear(CrearRolDto crearRolDto) {
        Rol rol = rolMapper.toEntity(crearRolDto);
        return rolMapper.toDTO(rolRepository.save(rol));
    }

    @Transactional
    public RolDto actualizar(Long id, ActualizarRolDto actualizarRolDto) {
        Rol rol = encontrarPorIdEntity(id);
        rolMapper.updateEntity(rol, actualizarRolDto);
        return rolMapper.toDTO(rolRepository.save(rol));
    }

    @Transactional
    public boolean eliminar(Long id) {
        Rol rol = encontrarPorIdEntity(id);
        rolRepository.delete(rol);
        return true;
    }

}
