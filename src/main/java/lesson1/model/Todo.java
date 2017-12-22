package lesson1.model;

import lesson1.util.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private String name;
    private LocalDateTime localDateTime;
    private Status status;
    private User performer;
}
