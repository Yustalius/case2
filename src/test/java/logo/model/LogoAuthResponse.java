package logo.model;

import lombok.Data;

@Data
public class LogoAuthResponse {
    private String accessToken;
    private String refreshToken;
    private User user;

    @Data
    public static class User {
        private String email;
        private int id;
    }
}
