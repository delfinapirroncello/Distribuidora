
    @Entity
    public class Cliente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String email;
        private String telefono;

        // Getters y Setters
    }

}
