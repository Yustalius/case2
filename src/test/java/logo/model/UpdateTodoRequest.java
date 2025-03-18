package logo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateTodoRequest {
    @JsonProperty("user_id")
    private int userId;
    private String title;
    private boolean completed;
}
