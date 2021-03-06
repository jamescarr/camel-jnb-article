package com.ociweb.example.routes;
import com.ociweb.example.domain.ShippingOrder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;

public class WarehouseRoute extends RouteBuilder{
    @Override
    public void configure(){
        from("warehouse").
            choice().
                when(quantityIsGreaterThan(200)).
                    to("bean:bulkOrderWarehouse").
                otherwise().
                    to("bean:sprocketWarehouse");                    
    }

    private Predicate quantityIsGreaterThan(final int bulkQuantity){
        return new Predicate(){
            public boolean matches(Exchange exchange) {
		        return exchange.getIn().getBody(ShippingOrder.class).getQuantity() >= bulkQuantity;
	        }
        };
    }
}
