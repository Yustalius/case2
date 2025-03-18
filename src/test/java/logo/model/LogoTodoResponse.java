package logo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LogoTodoResponse {
    @JsonProperty("todo_id")
    private int todoId;
    @JsonProperty("user_id")
    private int userId;
    private String title;
    private String completed;
}