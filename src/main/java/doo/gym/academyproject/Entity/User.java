package doo.gym.academyproject.Entity;

/**
 * Classe que representa o usuario dentro do sistema
 */
public class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private PhysicalProfile physicalProfile;
    private Training training;

    private User(){}
    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.physicalProfile = builder.physicalProfile;
        this.training = builder.training;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PhysicalProfile getPhysicalProfile() {
        return physicalProfile;
    }

    public void setPhysicalProfile(PhysicalProfile physicalProfile) {
        this.physicalProfile = physicalProfile;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    /**
     * uso do padrao Builder com o objetivo de melhorar a instancia do Objeto
     */
    public static class UserBuilder {
        private long id;
        private String name;
        private String email;
        private String password;
        private PhysicalProfile physicalProfile;
        private Training training;

        public UserBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setPhysicalProfile(PhysicalProfile physicalProfile) {
            this.physicalProfile = physicalProfile;
            return this;
        }

        public UserBuilder setTraining(Training training) {
            this.training = training;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
