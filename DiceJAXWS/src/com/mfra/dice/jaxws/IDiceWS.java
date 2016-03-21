package com.mfra.dice.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IDiceWS {

    @WebMethod
    public String rollDice(@WebParam(name = "faces") int faces,
            @WebParam(name = "name") String name,
            @WebParam(name = "repetitions") Integer repetitions,
            @WebParam(name = "modifier") int modifier);
    
    @WebMethod
    public String rollDice2(@WebParam(name = "request") MyRequest myRequest);

    @WebMethod
    public String rollDice3(@WebParam(name = "request") MyRequest myRequest);
}
