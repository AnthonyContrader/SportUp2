package it.contrader.fitmicroservice.web.rest;

import it.contrader.fitmicroservice.FitmicroserviceApp;

import it.contrader.fitmicroservice.domain.Training;
import it.contrader.fitmicroservice.repository.TrainingRepository;
import it.contrader.fitmicroservice.service.TrainingService;
import it.contrader.fitmicroservice.service.dto.TrainingDTO;
import it.contrader.fitmicroservice.service.mapper.TrainingMapper;
import it.contrader.fitmicroservice.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static it.contrader.fitmicroservice.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the TrainingResource REST controller.
 *
 * @see TrainingResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FitmicroserviceApp.class)
public class TrainingResourceIntTest {

    private static final String DEFAULT_MONDAY = "AAAAAAAAAA";
    private static final String UPDATED_MONDAY = "BBBBBBBBBB";

    private static final String DEFAULT_TUESDAY = "AAAAAAAAAA";
    private static final String UPDATED_TUESDAY = "BBBBBBBBBB";

    private static final String DEFAULT_WEDNESDAY = "AAAAAAAAAA";
    private static final String UPDATED_WEDNESDAY = "BBBBBBBBBB";

    private static final String DEFAULT_THURSDAY = "AAAAAAAAAA";
    private static final String UPDATED_THURSDAY = "BBBBBBBBBB";

    private static final String DEFAULT_FRIDAY = "AAAAAAAAAA";
    private static final String UPDATED_FRIDAY = "BBBBBBBBBB";

    private static final String DEFAULT_SATURDAY = "AAAAAAAAAA";
    private static final String UPDATED_SATURDAY = "BBBBBBBBBB";

    private static final String DEFAULT_SUNDAY = "AAAAAAAAAA";
    private static final String UPDATED_SUNDAY = "BBBBBBBBBB";

    private static final Integer DEFAULT_ID_PLAYER = 1;
    private static final Integer UPDATED_ID_PLAYER = 2;

    @Autowired
    private TrainingRepository trainingRepository;


    @Autowired
    private TrainingMapper trainingMapper;
    

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restTrainingMockMvc;

    private Training training;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TrainingResource trainingResource = new TrainingResource(trainingService);
        this.restTrainingMockMvc = MockMvcBuilders.standaloneSetup(trainingResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Training createEntity(EntityManager em) {
        Training training = new Training()
            .monday(DEFAULT_MONDAY)
            .tuesday(DEFAULT_TUESDAY)
            .wednesday(DEFAULT_WEDNESDAY)
            .thursday(DEFAULT_THURSDAY)
            .friday(DEFAULT_FRIDAY)
            .saturday(DEFAULT_SATURDAY)
            .sunday(DEFAULT_SUNDAY)
            .idPlayer(DEFAULT_ID_PLAYER);
        return training;
    }

    @Before
    public void initTest() {
        training = createEntity(em);
    }

    @Test
    @Transactional
    public void createTraining() throws Exception {
        int databaseSizeBeforeCreate = trainingRepository.findAll().size();

        // Create the Training
        TrainingDTO trainingDTO = trainingMapper.toDto(training);
        restTrainingMockMvc.perform(post("/api/trainings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trainingDTO)))
            .andExpect(status().isCreated());

        // Validate the Training in the database
        List<Training> trainingList = trainingRepository.findAll();
        assertThat(trainingList).hasSize(databaseSizeBeforeCreate + 1);
        Training testTraining = trainingList.get(trainingList.size() - 1);
        assertThat(testTraining.getMonday()).isEqualTo(DEFAULT_MONDAY);
        assertThat(testTraining.getTuesday()).isEqualTo(DEFAULT_TUESDAY);
        assertThat(testTraining.getWednesday()).isEqualTo(DEFAULT_WEDNESDAY);
        assertThat(testTraining.getThursday()).isEqualTo(DEFAULT_THURSDAY);
        assertThat(testTraining.getFriday()).isEqualTo(DEFAULT_FRIDAY);
        assertThat(testTraining.getSaturday()).isEqualTo(DEFAULT_SATURDAY);
        assertThat(testTraining.getSunday()).isEqualTo(DEFAULT_SUNDAY);
        assertThat(testTraining.getIdPlayer()).isEqualTo(DEFAULT_ID_PLAYER);
    }

    @Test
    @Transactional
    public void createTrainingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = trainingRepository.findAll().size();

        // Create the Training with an existing ID
        training.setId(1L);
        TrainingDTO trainingDTO = trainingMapper.toDto(training);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTrainingMockMvc.perform(post("/api/trainings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trainingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Training in the database
        List<Training> trainingList = trainingRepository.findAll();
        assertThat(trainingList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllTrainings() throws Exception {
        // Initialize the database
        trainingRepository.saveAndFlush(training);

        // Get all the trainingList
        restTrainingMockMvc.perform(get("/api/trainings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(training.getId().intValue())))
            .andExpect(jsonPath("$.[*].monday").value(hasItem(DEFAULT_MONDAY.toString())))
            .andExpect(jsonPath("$.[*].tuesday").value(hasItem(DEFAULT_TUESDAY.toString())))
            .andExpect(jsonPath("$.[*].wednesday").value(hasItem(DEFAULT_WEDNESDAY.toString())))
            .andExpect(jsonPath("$.[*].thursday").value(hasItem(DEFAULT_THURSDAY.toString())))
            .andExpect(jsonPath("$.[*].friday").value(hasItem(DEFAULT_FRIDAY.toString())))
            .andExpect(jsonPath("$.[*].saturday").value(hasItem(DEFAULT_SATURDAY.toString())))
            .andExpect(jsonPath("$.[*].sunday").value(hasItem(DEFAULT_SUNDAY.toString())))
            .andExpect(jsonPath("$.[*].idPlayer").value(hasItem(DEFAULT_ID_PLAYER)));
    }
    

    @Test
    @Transactional
    public void getTraining() throws Exception {
        // Initialize the database
        trainingRepository.saveAndFlush(training);

        // Get the training
        restTrainingMockMvc.perform(get("/api/trainings/{id}", training.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(training.getId().intValue()))
            .andExpect(jsonPath("$.monday").value(DEFAULT_MONDAY.toString()))
            .andExpect(jsonPath("$.tuesday").value(DEFAULT_TUESDAY.toString()))
            .andExpect(jsonPath("$.wednesday").value(DEFAULT_WEDNESDAY.toString()))
            .andExpect(jsonPath("$.thursday").value(DEFAULT_THURSDAY.toString()))
            .andExpect(jsonPath("$.friday").value(DEFAULT_FRIDAY.toString()))
            .andExpect(jsonPath("$.saturday").value(DEFAULT_SATURDAY.toString()))
            .andExpect(jsonPath("$.sunday").value(DEFAULT_SUNDAY.toString()))
            .andExpect(jsonPath("$.idPlayer").value(DEFAULT_ID_PLAYER));
    }
    @Test
    @Transactional
    public void getNonExistingTraining() throws Exception {
        // Get the training
        restTrainingMockMvc.perform(get("/api/trainings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTraining() throws Exception {
        // Initialize the database
        trainingRepository.saveAndFlush(training);

        int databaseSizeBeforeUpdate = trainingRepository.findAll().size();

        // Update the training
        Training updatedTraining = trainingRepository.findById(training.getId()).get();
        // Disconnect from session so that the updates on updatedTraining are not directly saved in db
        em.detach(updatedTraining);
        updatedTraining
            .monday(UPDATED_MONDAY)
            .tuesday(UPDATED_TUESDAY)
            .wednesday(UPDATED_WEDNESDAY)
            .thursday(UPDATED_THURSDAY)
            .friday(UPDATED_FRIDAY)
            .saturday(UPDATED_SATURDAY)
            .sunday(UPDATED_SUNDAY)
            .idPlayer(UPDATED_ID_PLAYER);
        TrainingDTO trainingDTO = trainingMapper.toDto(updatedTraining);

        restTrainingMockMvc.perform(put("/api/trainings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trainingDTO)))
            .andExpect(status().isOk());

        // Validate the Training in the database
        List<Training> trainingList = trainingRepository.findAll();
        assertThat(trainingList).hasSize(databaseSizeBeforeUpdate);
        Training testTraining = trainingList.get(trainingList.size() - 1);
        assertThat(testTraining.getMonday()).isEqualTo(UPDATED_MONDAY);
        assertThat(testTraining.getTuesday()).isEqualTo(UPDATED_TUESDAY);
        assertThat(testTraining.getWednesday()).isEqualTo(UPDATED_WEDNESDAY);
        assertThat(testTraining.getThursday()).isEqualTo(UPDATED_THURSDAY);
        assertThat(testTraining.getFriday()).isEqualTo(UPDATED_FRIDAY);
        assertThat(testTraining.getSaturday()).isEqualTo(UPDATED_SATURDAY);
        assertThat(testTraining.getSunday()).isEqualTo(UPDATED_SUNDAY);
        assertThat(testTraining.getIdPlayer()).isEqualTo(UPDATED_ID_PLAYER);
    }

    @Test
    @Transactional
    public void updateNonExistingTraining() throws Exception {
        int databaseSizeBeforeUpdate = trainingRepository.findAll().size();

        // Create the Training
        TrainingDTO trainingDTO = trainingMapper.toDto(training);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restTrainingMockMvc.perform(put("/api/trainings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trainingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Training in the database
        List<Training> trainingList = trainingRepository.findAll();
        assertThat(trainingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTraining() throws Exception {
        // Initialize the database
        trainingRepository.saveAndFlush(training);

        int databaseSizeBeforeDelete = trainingRepository.findAll().size();

        // Get the training
        restTrainingMockMvc.perform(delete("/api/trainings/{id}", training.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Training> trainingList = trainingRepository.findAll();
        assertThat(trainingList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Training.class);
        Training training1 = new Training();
        training1.setId(1L);
        Training training2 = new Training();
        training2.setId(training1.getId());
        assertThat(training1).isEqualTo(training2);
        training2.setId(2L);
        assertThat(training1).isNotEqualTo(training2);
        training1.setId(null);
        assertThat(training1).isNotEqualTo(training2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TrainingDTO.class);
        TrainingDTO trainingDTO1 = new TrainingDTO();
        trainingDTO1.setId(1L);
        TrainingDTO trainingDTO2 = new TrainingDTO();
        assertThat(trainingDTO1).isNotEqualTo(trainingDTO2);
        trainingDTO2.setId(trainingDTO1.getId());
        assertThat(trainingDTO1).isEqualTo(trainingDTO2);
        trainingDTO2.setId(2L);
        assertThat(trainingDTO1).isNotEqualTo(trainingDTO2);
        trainingDTO1.setId(null);
        assertThat(trainingDTO1).isNotEqualTo(trainingDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(trainingMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(trainingMapper.fromId(null)).isNull();
    }
}
