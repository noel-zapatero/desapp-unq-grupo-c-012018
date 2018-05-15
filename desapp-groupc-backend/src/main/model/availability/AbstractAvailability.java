package main.model.availability;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "abstract_availability")
public abstract class AbstractAvailability {
  @Id @GeneratedValue(strategy = GenerationType.TABLE)
  private Long availabilityId;
}
