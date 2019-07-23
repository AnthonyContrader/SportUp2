package it.contrader.fitmicroservice.service.impl;

import it.contrader.fitmicroservice.service.TrainingService;
import it.contrader.fitmicroservice.domain.Training;
import it.contrader.fitmicroservice.repository.TrainingRepository;
import it.contrader.fitmicroservice.service.dto.TrainingDTO;
import it.contrader.fitmicroservice.service.mapper.TrainingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Training.
 */
@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {

    private final Logger log = LoggerFactory.getLogger(TrainingServiceImpl.class);

    private final TrainingRepository trainingRepository;

    private final TrainingMapper trainingMapper;

    public TrainingServiceImpl(TrainingRepository trainingRepository, TrainingMapper trainingMapper) {
        this.trainingRepository = trainingRepository;
        this.trainingMapper = trainingMapper;
    }

    /**
     * Save a training.
     *
     * @param trainingDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TrainingDTO save(TrainingDTO trainingDTO) {
        log.debug("Request to save Training : {}", trainingDTO);
        Training training = trainingMapper.toEntity(trainingDTO);
        training = trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }

    /**
     * Get all the trainings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TrainingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Trainings");
        return trainingRepository.findAll(pageable)
            .map(trainingMapper::toDto);
    }


    /**
     * Get one training by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TrainingDTO> findOne(Long id) {
        log.debug("Request to get Training : {}", id);
        return trainingRepository.findById(id)
            .map(trainingMapper::toDto);
    }

    /**
     * Delete the training by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Training : {}", id);
        trainingRepository.deleteById(id);
    }
}
