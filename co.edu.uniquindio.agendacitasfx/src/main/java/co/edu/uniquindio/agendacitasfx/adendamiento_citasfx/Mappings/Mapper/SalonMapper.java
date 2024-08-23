package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.ClienteDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalonMapper {
    SalonMapper INSTANCE = Mappers.getMapper(SalonMapper.class);

    @Named("clienteDtoToCliente")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "cedula", source = "cedula")
    @Mapping(target = "telefono", source = "telefono")
    Cliente ClienteDtoToCliente(ClienteDto clienteDto);
}
