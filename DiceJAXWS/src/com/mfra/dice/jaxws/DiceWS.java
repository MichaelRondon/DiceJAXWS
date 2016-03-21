package com.mfra.dice.jaxws;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.mfra.dice.Dice;

/**
 * 
 * @author Michael Felipe Rondón Acosta
 * 
 */
@WebService(endpointInterface = "com.mfra.dice.jaxws.IDiceWS")
public class DiceWS implements IDiceWS {

    @Resource
    WebServiceContext wsctx;

    /**
     * 
     * @param faces
     * @param name
     * @param repetitions
     * @param modifier
     * @return 5
     */
    @Override
    public String rollDice(int faces, String name, Integer repetitions,
            int modifier) {

        return ""
                + (Dice.getDice(faces)).rollDice(name, repetitions, modifier)
                        .getStringFromBuilder().toString();
    }

    @Override
    public String rollDice2(MyRequest myRequest) {
        return rollDice(myRequest.getFaces(), myRequest.getName(),
                myRequest.getRepetitions(), myRequest.getModifier());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String rollDice3(MyRequest myRequest) {
        String rollDice = rollDice(myRequest.getFaces(), myRequest.getName(),
                myRequest.getRepetitions(), myRequest.getModifier());

        MessageContext mctx = wsctx.getMessageContext();

        Map httpHeaders = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) httpHeaders.get("Username");
        List passList = (List) httpHeaders.get("Password");

        String username = "";
        String password = "";

        if (userList != null) {
            // get username
            username = userList.get(0).toString();
        }

        if (passList != null) {
            // get password
            password = passList.get(0).toString();
        }
        String message;
        // Should validate username and password with database
        if (username.equals("username") && password.equals("password")) {
            message = "Hello World JAX-WS - Valid User!";
        } else {
            message = "Unknown User!";
        }

        return String.format("%1$s:%n%2$s", message, rollDice);
    }
}
