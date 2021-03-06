package pl.com.khryniewicki.service.responseService.responseMarshaller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.khryniewicki.dto.request.ExchangeRatesRequest;
import pl.com.khryniewicki.dto.request.RateRequest;
import pl.com.khryniewicki.dto.response.ExchangeRatesSeries;
import pl.com.khryniewicki.dto.response.HighestBidRate;
import pl.com.khryniewicki.dto.response.LowestAskRate;
import pl.com.khryniewicki.dto.response.Rates;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRatesMarshaller {


    public ExchangeRatesSeries exchangeRatesMarshaller(ExchangeRatesRequest exchangeObject) {
        List<RateRequest> rateRequests = exchangeObject.getRateRequests();

        RateRequest rateWithMaxBid = getRateRequestWithMaxBid(rateRequests);
        RateRequest rateWithMinAsk = getRateRequestWithMinAsk(rateRequests);

        HighestBidRate highestBidRate = highestBidRateAdapter(rateWithMaxBid);
        LowestAskRate lowestAskRate = lowestAskRateAdapter(rateWithMinAsk);

        return (ExchangeRatesSeriesAdapter(exchangeObject, highestBidRate, lowestAskRate));
    }

    private ExchangeRatesSeries ExchangeRatesSeriesAdapter(ExchangeRatesRequest exchangeObject, HighestBidRate highestBidRate, LowestAskRate lowestAskRate) {
        ExchangeRatesSeries exchange = new ExchangeRatesSeries();
        Rates rates = new Rates();

        exchange.setCurrency(exchangeObject.getCurrency());
        exchange.setCode(exchangeObject.getCode());
        exchange.setTable(exchangeObject.getTable());

        rates.setHighestBidRate(highestBidRate);
        rates.setLowestAskRate(lowestAskRate);
        exchange.setRates(rates);

        return exchange;
    }


    private RateRequest getRateRequestWithMinAsk(List<RateRequest> rateRequests) {
        return rateRequests.stream()
                .min(Comparator.comparing(rate -> rate.getAsk()))
                .get();
    }

    private RateRequest getRateRequestWithMaxBid(List<RateRequest> rateRequests) {
        return rateRequests.stream()
                .max(Comparator.comparing(rate -> rate.getBid()))
                .get();
    }

    private LowestAskRate lowestAskRateAdapter(RateRequest rateWithMinAsk) {
        LowestAskRate lowestAskRate = new LowestAskRate();
        lowestAskRate.setAsk(rateWithMinAsk.getAsk());
        lowestAskRate.setEffectiveDate(rateWithMinAsk.getEffectiveDate().toZonedDateTime().toLocalDate().toString());
        lowestAskRate.setNo(rateWithMinAsk.getNo());
        return lowestAskRate;
    }

    private HighestBidRate highestBidRateAdapter(RateRequest rateWithMaxBid) {
        HighestBidRate highestBidRate = new HighestBidRate();
        highestBidRate.setBid(rateWithMaxBid.getBid());
        highestBidRate.setEffectiveDate(rateWithMaxBid.getEffectiveDate().toZonedDateTime().toLocalDate().toString());
        highestBidRate.setNo(rateWithMaxBid.getNo());
        return highestBidRate;
    }
}
