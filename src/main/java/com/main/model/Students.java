package com.main.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document
public class Students {

	
	@Id
    private String id;
    
	@NotEmpty
    private String fullname;
    
    @NotEmpty
    private String gender;
    
    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate birthdate;
   
    @NotEmpty
    private String typedoc;
    @NotEmpty
    private String document;
	
}
