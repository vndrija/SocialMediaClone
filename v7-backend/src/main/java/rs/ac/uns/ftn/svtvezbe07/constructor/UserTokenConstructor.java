package rs.ac.uns.ftn.svtvezbe07.constructor;

public class UserTokenConstructor {
    private String accessToken;
    private Long expiresIn;

    public UserTokenConstructor() {
        this.accessToken = null;
        this.expiresIn = null;
    }

    public UserTokenConstructor(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

}


