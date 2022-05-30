package com.bnta.nandos;

import com.bnta.nandos.models.Feedback;
import com.bnta.nandos.models.Nandoca;
import com.bnta.nandos.repositories.FeedbackRepository;
import com.bnta.nandos.repositories.NandocaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

@SpringBootTest
class NandosApplicationTests {

	@Autowired
	private NandocaRepository nandocaRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Test
	void contextLoads() {
	}

	//------------------------------------------Nandoca Query Tests-----------------------------------------------
	@Test
	public void canFindNandocaByNameContainingSandra() {
		List<Nandoca> found = nandocaRepository.findNandocaByNameContainingIgnoreCase("SaNdra");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canfindNandocaByYearsExperienceGreaterThan () {
		List<Nandoca> found = nandocaRepository.findNandocaByYearsExperienceGreaterThan (2);
		assertThat(found.size()).isEqualTo(10);
	}

	//------------------------------------------Feedback Query Tests-----------------------------------------------
	@Test
	public void canFindFeedbackByNameContainingMelissa() {
		List<Feedback> found = feedbackRepository.findFeedbackByNameContainingIgnoreCase("melIssA");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void candfindFeedbackByRatingGreaterThan3() {
		List<Feedback> found = feedbackRepository.findFeedbackByRatingGreaterThan(3);
		assertThat(found.size()).isEqualTo(11);
	}

}
