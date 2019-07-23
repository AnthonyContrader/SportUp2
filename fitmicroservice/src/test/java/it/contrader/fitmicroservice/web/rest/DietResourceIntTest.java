package it.contrader.fitmicroservice.web.rest;

import it.contrader.fitmicroservice.FitmicroserviceApp;

import it.contrader.fitmicroservice.domain.Diet;
import it.contrader.fitmicroservice.repository.DietRepository;
import it.contrader.fitmicroservice.service.DietService;
import it.contrader.fitmicroservice.service.dto.DietDTO;
import it.contrader.fitmicroservice.service.mapper.DietMapper;
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
 * Test class for the DietResource REST controller.
 *
 * @see DietResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FitmicroserviceApp.class)
public class DietResourceIntTest {

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
    private DietRepository dietRepository;


    @Autowired
    private DietMapper dietMapper;
    

    @Autowired
    private DietService dietService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restDietMockMvc;

    private Diet diet;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DietResource dietResource = new DietResource(dietService);
        this.restDietMockMvc = MockMvcBuilders.standaloneSetup(dietResource)
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
    public static Diet createEntity(EntityManager em) {
        Diet diet = new Diet()
            .monday(DEFAULT_MONDAY)
            .tuesday(DEFAULT_TUESDAY)
            .wednesday(DEFAULT_WEDNESDAY)
            .thursday(DEFAULT_THURSDAY)
            .friday(DEFAULT_FRIDAY)
            .saturday(DEFAULT_SATURDAY)
            .sunday(DEFAULT_SUNDAY)
            .idPlayer(DEFAULT_ID_PLAYER);
        return diet;
    }

    @Before
    public void initTest() {
        diet = createEntity(em);
    }

    @Test
    @Transactional
    public void createDiet() throws Exception {
        int databaseSizeBeforeCreate = dietRepository.findAll().size();

        // Create the Diet
        DietDTO dietDTO = dietMapper.toDto(diet);
        restDietMockMvc.perform(post("/api/diets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dietDTO)))
            .andExpect(status().isCreated());

        // Validate the Diet in the database
        List<Diet> dietList = dietRepository.findAll();
        assertThat(dietList).hasSize(databaseSizeBeforeCreate + 1);
        Diet testDiet = dietList.get(dietList.size() - 1);
        assertThat(testDiet.getMonday()).isEqualTo(DEFAULT_MONDAY);
        assertThat(testDiet.getTuesday()).isEqualTo(DEFAULT_TUESDAY);
        assertThat(testDiet.getWednesday()).isEqualTo(DEFAULT_WEDNESDAY);
        assertThat(testDiet.getThursday()).isEqualTo(DEFAULT_THURSDAY);
        assertThat(testDiet.getFriday()).isEqualTo(DEFAULT_FRIDAY);
        assertThat(testDiet.getSaturday()).isEqualTo(DEFAULT_SATURDAY);
        assertThat(testDiet.getSunday()).isEqualTo(DEFAULT_SUNDAY);
        assertThat(testDiet.getIdPlayer()).isEqualTo(DEFAULT_ID_PLAYER);
    }

    @Test
    @Transactional
    public void createDietWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dietRepository.findAll().size();

        // Create the Diet with an existing ID
        diet.setId(1L);
        DietDTO dietDTO = dietMapper.toDto(diet);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDietMockMvc.perform(post("/api/diets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dietDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Diet in the database
        List<Diet> dietList = dietRepository.findAll();
        assertThat(dietList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllDiets() throws Exception {
        // Initialize the database
        dietRepository.saveAndFlush(diet);

        // Get all the dietList
        restDietMockMvc.perform(get("/api/diets?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(diet.getId().intValue())))
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
    public void getDiet() throws Exception {
        // Initialize the database
        dietRepository.saveAndFlush(diet);

        // Get the diet
        restDietMockMvc.perform(get("/api/diets/{id}", diet.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(diet.getId().intValue()))
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
    public void getNonExistingDiet() throws Exception {
        // Get the diet
        restDietMockMvc.perform(get("/api/diets/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDiet() throws Exception {
        // Initialize the database
        dietRepository.saveAndFlush(diet);

        int databaseSizeBeforeUpdate = dietRepository.findAll().size();

        // Update the diet
        Diet updatedDiet = dietRepository.findById(diet.getId()).get();
        // Disconnect from session so that the updates on updatedDiet are not directly saved in db
        em.detach(updatedDiet);
        updatedDiet
            .monday(UPDATED_MONDAY)
            .tuesday(UPDATED_TUESDAY)
            .wednesday(UPDATED_WEDNESDAY)
            .thursday(UPDATED_THURSDAY)
            .friday(UPDATED_FRIDAY)
            .saturday(UPDATED_SATURDAY)
            .sunday(UPDATED_SUNDAY)
            .idPlayer(UPDATED_ID_PLAYER);
        DietDTO dietDTO = dietMapper.toDto(updatedDiet);

        restDietMockMvc.perform(put("/api/diets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dietDTO)))
            .andExpect(status().isOk());

        // Validate the Diet in the database
        List<Diet> dietList = dietRepository.findAll();
        assertThat(dietList).hasSize(databaseSizeBeforeUpdate);
        Diet testDiet = dietList.get(dietList.size() - 1);
        assertThat(testDiet.getMonday()).isEqualTo(UPDATED_MONDAY);
        assertThat(testDiet.getTuesday()).isEqualTo(UPDATED_TUESDAY);
        assertThat(testDiet.getWednesday()).isEqualTo(UPDATED_WEDNESDAY);
        assertThat(testDiet.getThursday()).isEqualTo(UPDATED_THURSDAY);
        assertThat(testDiet.getFriday()).isEqualTo(UPDATED_FRIDAY);
        assertThat(testDiet.getSaturday()).isEqualTo(UPDATED_SATURDAY);
        assertThat(testDiet.getSunday()).isEqualTo(UPDATED_SUNDAY);
        assertThat(testDiet.getIdPlayer()).isEqualTo(UPDATED_ID_PLAYER);
    }

    @Test
    @Transactional
    public void updateNonExistingDiet() throws Exception {
        int databaseSizeBeforeUpdate = dietRepository.findAll().size();

        // Create the Diet
        DietDTO dietDTO = dietMapper.toDto(diet);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restDietMockMvc.perform(put("/api/diets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dietDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Diet in the database
        List<Diet> dietList = dietRepository.findAll();
        assertThat(dietList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDiet() throws Exception {
        // Initialize the database
        dietRepository.saveAndFlush(diet);

        int databaseSizeBeforeDelete = dietRepository.findAll().size();

        // Get the diet
        restDietMockMvc.perform(delete("/api/diets/{id}", diet.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Diet> dietList = dietRepository.findAll();
        assertThat(dietList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Diet.class);
        Diet diet1 = new Diet();
        diet1.setId(1L);
        Diet diet2 = new Diet();
        diet2.setId(diet1.getId());
        assertThat(diet1).isEqualTo(diet2);
        diet2.setId(2L);
        assertThat(diet1).isNotEqualTo(diet2);
        diet1.setId(null);
        assertThat(diet1).isNotEqualTo(diet2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DietDTO.class);
        DietDTO dietDTO1 = new DietDTO();
        dietDTO1.setId(1L);
        DietDTO dietDTO2 = new DietDTO();
        assertThat(dietDTO1).isNotEqualTo(dietDTO2);
        dietDTO2.setId(dietDTO1.getId());
        assertThat(dietDTO1).isEqualTo(dietDTO2);
        dietDTO2.setId(2L);
        assertThat(dietDTO1).isNotEqualTo(dietDTO2);
        dietDTO1.setId(null);
        assertThat(dietDTO1).isNotEqualTo(dietDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(dietMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(dietMapper.fromId(null)).isNull();
    }
}
