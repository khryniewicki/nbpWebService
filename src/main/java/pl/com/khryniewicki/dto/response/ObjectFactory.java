//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.16 at 05:29:49 AM CEST 
//


package pl.com.khryniewicki.dto.response;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.com.khryniewicki.dto.response package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.com.khryniewicki.dto.response
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCurrencyRequest }
     * 
     */
    public GetCurrencyRequest createGetCurrencyRequest() {
        return new GetCurrencyRequest();
    }

    /**
     * Create an instance of {@link GetCurrencyResponse }
     * 
     */
    public GetCurrencyResponse createGetCurrencyResponse() {
        return new GetCurrencyResponse();
    }

    /**
     * Create an instance of {@link ExchangeRatesSeries }
     * 
     */
    public ExchangeRatesSeries createExchangeRatesSeries() {
        return new ExchangeRatesSeries();
    }

    /**
     * Create an instance of {@link Rates }
     * 
     */
    public Rates createRates() {
        return new Rates();
    }

    /**
     * Create an instance of {@link HighestBidRate }
     * 
     */
    public HighestBidRate createHighestBidRate() {
        return new HighestBidRate();
    }

    /**
     * Create an instance of {@link LowestAskRate }
     * 
     */
    public LowestAskRate createLowestAskRate() {
        return new LowestAskRate();
    }

}
