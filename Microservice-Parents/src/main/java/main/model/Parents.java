package main.model;

import java.time.LocalDate;


import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Parents")

public class Parents {

	@Id
	private String id;
	
	@Size(min=3,  message= "el nombre debe tener minimo 3 letras")
	private String fullname;
	
	@Size(min=1,  message= "el genero debe tener minimo 1 letra")
	private String gender;
	
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate birthday;
    
    @Size(min=3,  message= "el tipo de documento debe tener minimo 3 letras")
	private String typedoc;
   
    @Size(min=6, max= 6 ,message= " documento debe tener minimo 6 letras")
	private String document;
   
    @Size(min=1, max= 3 ,message= " idstudent debe tener minimo 1 digito")
	
    private String idstudent;
    @Size(min=5, message= " idfamily debe tener minimo 5 letras")
	private String idfamily;
}
