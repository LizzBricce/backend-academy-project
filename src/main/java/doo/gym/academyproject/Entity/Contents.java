package doo.gym.academyproject.Entity;

/**
 * Contens faz parte do corpo da requisição que vai ser enviada para a API
 * - como ela pode ser usada para enviar requsições para diferentes APIS e o projeto gira em torno de uma IA ela esta na camada entities
 */
public class Contents {
    private String role;
    private Parts parts;

    public Contents(String role, String text) {
        this.role = role;
        this.parts = new Parts(text);
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    class Parts {
        private String text;

        public Parts(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}