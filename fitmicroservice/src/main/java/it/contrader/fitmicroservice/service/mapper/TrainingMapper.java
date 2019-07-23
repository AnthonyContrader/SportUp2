package it.contrader.fitmicroservice.service.mapper;

import it.contrader.fitmicroservice.domain.*;
import it.contrader.fitmicroservice.service.dto.TrainingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Training and its DTO TrainingDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TrainingMapper extends EntityMapper<TrainingDTO, Training> {



    default Training fromId(Long id) {
        if (id == null) {
            return null;
        }
        Training training = new Training();
        training.setId(id);
        return training;
    }
}
