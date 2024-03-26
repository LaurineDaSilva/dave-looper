package co.simplon.davelooper.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    BaseEntity() {
	//
    }

    public Long getId() {
	return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
	// Managed by db
	throw new UnsupportedOperationException();
    }
}
