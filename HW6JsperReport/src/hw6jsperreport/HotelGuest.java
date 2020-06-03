/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6jsperreport;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ashraf Habromman
 */
@Entity
@Table(name = "HOTEL_GUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotelGuest.findAll", query = "SELECT h FROM HotelGuest h"),
    @NamedQuery(name = "HotelGuest.findByGuestSsn", query = "SELECT h FROM HotelGuest h WHERE h.guestSsn = :guestSsn"),
    @NamedQuery(name = "HotelGuest.findByHaveCovid19", query = "SELECT h FROM HotelGuest h WHERE h.haveCovid19 = :haveCovid19"),
    @NamedQuery(name = "HotelGuest.findByAge", query = "SELECT h FROM HotelGuest h WHERE h.age = :age"),
    @NamedQuery(name = "HotelGuest.findByGuestName", query = "SELECT h FROM HotelGuest h WHERE h.guestName = :guestName")})
public class HotelGuest implements Serializable {
    @Column(name = "HAVE_COVID19")
    private String haveCovid19;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="ssn_genetator")
    @SequenceGenerator(name="ssn_genetator",sequenceName="GUEST_SSN_SEQ", allocationSize=1)
    @Basic(optional = false)
    @Column(name = "GUEST_SSN")
    private Integer guestSsn;
    @Basic(optional = false)
    @Column(name = "AGE")
    private BigInteger age;
    @Basic(optional = false)
    @Column(name = "GUEST_NAME")
    private String guestName;

    public HotelGuest() {
    }

    public HotelGuest(Integer guestSsn) {
        this.guestSsn = guestSsn;
    }

    public HotelGuest(Integer guestSsn, String haveCovid19, BigInteger age, String guestName) {
        this.guestSsn = guestSsn;
        this.haveCovid19 = haveCovid19;
        this.age = age;
        this.guestName = guestName;
    }

    public Integer getGuestSsn() {
        return guestSsn;
    }

    public void setGuestSsn(Integer guestSsn) {
        this.guestSsn = guestSsn;
    }


    public BigInteger getAge() {
        return age;
    }

    public void setAge(BigInteger age) {
        this.age = age;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestSsn != null ? guestSsn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelGuest)) {
            return false;
        }
        HotelGuest other = (HotelGuest) object;
        if ((this.guestSsn == null && other.guestSsn != null) || (this.guestSsn != null && !this.guestSsn.equals(other.guestSsn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hw6jsperreport.HotelGuest[ guestSsn=" + guestSsn + " ]";
    }

    public String getHaveCovid19() {
        return haveCovid19;
    }

    public void setHaveCovid19(String haveCovid19) {
        this.haveCovid19 = haveCovid19;
    }
    
}
