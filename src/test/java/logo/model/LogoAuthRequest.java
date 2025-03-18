package logo.model;

import lombok.Data;

@Data
public class LogoAuthRequest {
    private String email;
    private String password;
}
