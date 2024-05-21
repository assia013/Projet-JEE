package ma.xproce.ecommerce.dao.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String image;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;
    private int quantity;
    private double price;
    private String description;
    @Override
    public String toString(){
        return name;
    }

}
