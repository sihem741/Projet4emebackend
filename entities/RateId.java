package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RateId implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    User user;
    @ManyToOne(fetch = FetchType.EAGER)
    Post post;

}
