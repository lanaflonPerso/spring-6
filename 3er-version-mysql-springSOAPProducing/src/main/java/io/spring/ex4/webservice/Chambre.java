//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.08 at 12:22:06 AM CET 
//


package io.spring.ex4.webservice;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Chambre complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Chambre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="typeLit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="disponible" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hotel" type="{http://spring.io/ex4/webservice}hotel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Chambre", propOrder = {
    "id",
    "numero",
    "typeLit",
    "prix",
    "disponible",
    "hotel"
})
@Entity
public class Chambre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id;
    protected int numero;
    @XmlElement(required = true)
    protected String typeLit;
    protected double prix;
    @XmlElement(required = true)
    protected String disponible;
    @XmlElement(required = true)
    @ManyToOne(fetch = FetchType.EAGER)
    protected Hotel hotel;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     */
    public void setNumero(int value) {
        this.numero = value;
    }

    /**
     * Gets the value of the typeLit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeLit() {
        return typeLit;
    }

    /**
     * Sets the value of the typeLit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeLit(String value) {
        this.typeLit = value;
    }

    /**
     * Gets the value of the prix property.
     * 
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Sets the value of the prix property.
     * 
     */
    public void setPrix(double value) {
        this.prix = value;
    }

    /**
     * Gets the value of the disponible property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisponible() {
        return disponible;
    }

    /**
     * Sets the value of the disponible property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisponible(String value) {
        this.disponible = value;
    }

    /**
     * Gets the value of the hotel property.
     * 
     * @return
     *     possible object is
     *     {@link Hotel }
     *     
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets the value of the hotel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hotel }
     *     
     */
    public void setHotel(Hotel value) {
        this.hotel = value;
    }

}
