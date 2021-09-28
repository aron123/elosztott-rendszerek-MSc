package com.example.demo.github;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Repo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GithubRepo implements Repo {
	
	public final static String baseUrl = "https://api.github.com/search/repositories";
	
	private final RestTemplate restTemplate;
	
	public List<String> searchByText(String query) {
		String requestUrl = baseUrl + "?q=" + query;
		
		ResponseEntity<GithubRoot> res = restTemplate.getForEntity(requestUrl, GithubRoot.class);
		
		if (res.getStatusCode() == HttpStatus.OK) {
			return res.getBody().getItems().stream()
				.map(item -> item.getName())
				.collect(Collectors.toList());
		} else {
			throw new RestCommunicationException();
		}
	}
}
