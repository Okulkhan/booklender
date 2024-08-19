package Booklender.backend.model;

import Booklender.backend.model.userDetails.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Entity
@Table(name = "Books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Transactional
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "name", nullable = false, unique = true)
    public String name;

    @Column(name = "author")
    public String author;

    @Column(name = "imageIRL")
    public String imageIRL;

    @Column(name = "quantity", nullable = false)
    public int quantity;

    @Column(name = "status", nullable = false)
    public boolean status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "owners",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> owners;

}
