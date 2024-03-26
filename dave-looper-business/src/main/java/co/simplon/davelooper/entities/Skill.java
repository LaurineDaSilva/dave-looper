package co.simplon.davelooper.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_skills")
public class Skill extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "developer_id")
    @JsonBackReference
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;

    public Skill() {
	// Default no-arg constructor
    }

    public Developer getDeveloper() {
	return developer;
    }

    public void setDeveloper(Developer developer) {
	this.developer = developer;
    }

    public Language getLanguage() {
	return language;
    }

    public void setLanguage(Language language) {
	this.language = language;
    }

    public Level getLevel() {
	return level;
    }

    public void setLevel(Level level) {
	this.level = level;
    }

    @Override
    public String toString() {
	return "{developer=" + developer + ", language=" + language + ", level="
		+ level + "}";
    }

    /**
     * Enumeration of skill levels.
     * <p>
     * Enumeration order is meaningful, or not -;).
     */
    public static enum Level {
	NOOB, APPRENTICE, MOUNT_STUPID, NORMAL
    }
}
