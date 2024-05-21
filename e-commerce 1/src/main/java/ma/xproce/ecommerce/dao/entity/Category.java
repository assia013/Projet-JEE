package ma.xproce.ecommerce.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Collection<Product> products;
    @OneToMany(mappedBy = "category")
    private Collection<Cart> carts;

    public Category(Integer id, String name) {
        this.id=id;
        this.name=name;
    }
    @Override
    public String toString(){
        return name;
    }

}
