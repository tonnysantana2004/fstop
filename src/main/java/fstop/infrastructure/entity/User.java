package fstop.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true)
    private String username;
    
    @Column(unique = true) @NonNull
    private String email;
    
    private Integer phone;
    
    private String password;
    
    public static ArrayList<String> fillable = new ArrayList<>();
    {
        fillable.add("username");
        fillable.add("email");
        fillable.add("phone");
    }

}
