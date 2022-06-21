package dbEntities;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FirstName")
    public String firstName;

    @Column(name = "LastName")
    public String lastName;

    @Column(name = "EmailName")
    public String emailName;

    @Column(name = "AgeName")
    public int age;

    public Customer() {

    }

    public Customer(String firstName, String lastName, String emailName, int ageName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailName = emailName;
        this.age = ageName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailName() {
        return emailName;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailName='" + emailName + '\'' +
                ", ageName='" + age + '\'' +
                '}';
    }
}
