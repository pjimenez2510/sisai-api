package ec.com.eeasa.sisai.shared.interfaces;


import java.util.List;

public interface Mapper <Entity, ResponseDto, CreateDto, UpdateDto> {
    Entity toEntity(CreateDto dto);
    ResponseDto  toDTO(Entity entity);
    void updateEntity(Entity entity, UpdateDto dto);
    List<ResponseDto> toDTOList(List<Entity> entityList);
}
