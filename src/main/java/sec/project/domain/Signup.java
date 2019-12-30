package sec.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "signup")
public class Signup extends AbstractPersistable<Long> {
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "credit")
    private String credit;

    public Signup() {
        super();
    }

    public Signup(String name, String address, String credit) {
        this();
        this.name = name;
        this.address = address;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

}
