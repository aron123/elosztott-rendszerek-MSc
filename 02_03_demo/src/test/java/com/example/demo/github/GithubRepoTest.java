package com.example.demo.github;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GithubRepoTest {
	
	@Test
	void test() {
		// GIVEN
		String query = "asd";
		RestTemplate mockRestTemplate = mock(RestTemplate.class);

		GithubRoot ghResponse = new GithubRoot();
		List<GithubItemDTO> items = new ArrayList<>();
		GithubItemDTO githubItem = new GithubItemDTO();
		githubItem.setName(query);
		items.add(githubItem);
		ghResponse.setItems(items);
		
		when(mockRestTemplate.getForEntity(GithubRepo.baseUrl + "?q=" + query, GithubRoot.class))
			.thenReturn(new ResponseEntity(ghResponse, HttpStatus.OK));
		
		GithubRepo repo = new GithubRepo(mockRestTemplate);
		
		// WHEN
		List<String> response = repo.searchByText(query);
		
		// THEN
		verify(mockRestTemplate).getForEntity(GithubRepo.baseUrl + "?q=" + query, GithubRoot.class);
		assertThat(response, hasSize(1));
		assertThat(response.get(0), is(query));
	}
	
	@Test()
	void test_searchByText_404() {
		// GIVEN
		String query = "asd";
		RestTemplate mockRestTemplate = mock(RestTemplate.class);
		ResponseEntity responseEntity = new ResponseEntity(null, HttpStatus.NOT_FOUND);
		when(mockRestTemplate.getForEntity(GithubRepo.baseUrl + "?q=" + query, GithubRoot.class))
			.thenReturn(responseEntity);

		GithubRepo repo = new GithubRepo(mockRestTemplate);
		
		// WHEN
		assertThrows(RestCommunicationException.class, () -> repo.searchByText(query));

		// THEN
		verify(mockRestTemplate).getForEntity(GithubRepo.baseUrl + "?q=" + query, GithubRoot.class);
	}
}
