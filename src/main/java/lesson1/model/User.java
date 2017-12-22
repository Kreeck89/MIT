package lesson1.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "id")
public class User {
    private Long id;
    @Getter
    @Setter
    private String name;
}
