package com.example.demo.github;

import java.util.List;

import lombok.Data;

@Data
public class GithubRoot {
	private int total_count;
	private boolean incomplete_results;
	private List<GithubItemDTO> items;
}
