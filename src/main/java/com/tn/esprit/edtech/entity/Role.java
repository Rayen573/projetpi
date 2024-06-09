    package com.tn.esprit.edtech.entity;

    import jakarta.persistence.*;
    import lombok.Data;

    import java.util.HashSet;
    import java.util.Set;

    @Entity
    @Data
    public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(EnumType.STRING)
        private RoleName name;

        @OneToMany(mappedBy = "role") // mapped by the "role" attribute in the User class
        private Set<User> users = new HashSet<>();
    }
