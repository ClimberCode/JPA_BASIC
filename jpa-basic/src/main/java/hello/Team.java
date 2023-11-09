package hello;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name="team_seq_generator",
        sequenceName = "team_seq",
        initialValue = 1, allocationSize = 50)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_generator")
    private Long id;

    @Column(nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @OneToMany
    @JoinColumn(name = "team", referencedColumnName = "id")
    private List<Member> members;
}
