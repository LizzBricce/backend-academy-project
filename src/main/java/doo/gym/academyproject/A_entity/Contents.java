package doo.gym.academyproject.A_entity;
public class Contents {
    private String role;
    private Parts parts;

    public Contents(String role, String text) {
        this.role = role;
        this.parts = new Parts(text);
    }

    class Parts {
        private String text;

        public Parts(String text) {
            this.text = text;
        }

    }
}
