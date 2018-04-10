package com.hx.eplate.trafficdata.query.chain;

import com.hx.eplate.trafficdata.query.state.FinalJson;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;

/**
 * 钱包通过parity链接
 *
 */
public class ParityClient {

    
    //private static String ip = PropertiesUtils.getValueByPropertyKey("walletServerUrl");

    private ParityClient(){}

    private static class ClientHolder{
        private static final Parity parity = Parity.build(new HttpService(FinalJson.walletServerUrl));
    }

    public static final  Parity getParity(){
        return ClientHolder.parity;
    }
}
