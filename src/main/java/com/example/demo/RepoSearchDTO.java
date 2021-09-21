package com.example.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RepoSearchDTO {
	@NotNull
	@Size(min=3)
	private String query;
}
