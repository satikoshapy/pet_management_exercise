package be.pxl.pets.api.request;
import jakarta.validation.constraints.*;

public class PetCreateRequest {
	@NotNull(message = "Name cannot be null")
	@Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
	private String name;
	@NotNull(message = "Type cannot be null")
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
