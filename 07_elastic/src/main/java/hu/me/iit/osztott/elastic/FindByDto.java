package hu.me.iit.osztott.elastic;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindByDto {
    @NotBlank
    private String query;
}
