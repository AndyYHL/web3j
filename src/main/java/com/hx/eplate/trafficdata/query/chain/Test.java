package com.hx.eplate.trafficdata.query.chain;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Administrator on 2018-03-23.
 */
public class Test {
    //运行测试
    public static void main(String[] args) throws Exception {
        //测试 链接钱包地址
        String money = "https://kovan.infura.io/yXDUNwlNOcx0UJCWjzNr";
        Web3j web3j = Web3JClient.getClient();
        //非常简单，测试节点是否链接成功
        Web3ClientVersion web3ClientVersion;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            System.out.println("版本：" + clientVersion);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //创建用户凭证
        String filePath = "E:/pictures";
        String fileName;
        //ALICE alice = new ALICE();
        //alice.setAddress("");
        EcKeyPair ecKeyPair = new EcKeyPair();
        //alice.setEcKeyPair(ecKeyPair);
        // 创建钱包地址
        //eth-密码需要自己管理，自己设置哦！
        fileName = WalletUtils.generateNewWalletFile("设置你的密码", new File(filePath), false);
        System.out.println(fileName);//保存你的加密文件信息
        //System.out.println(alice.getAddress());//钱包地址
        //System.out.println(alice.getEcKeyPair().getPrivateKey());//私钥
        //System.out.println(alice.getEcKeyPair().getPublicKey());//公钥

        //加载钱包
        String path = "钱包加密文件地址";
        Credentials credentials = WalletUtils.loadCredentials("你的密码", path);
        String myAddress = credentials.getAddress();
        //这样就请求到一个钱包信息对象！
        BigInteger nonce = getNonce(web3j, "发送钱包地址");

        //发送钱包
        RawTransaction rawTransaction = createEtherTransaction(nonce, "mubia钱包地址");
        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        //交易订单号
        String hexValue = Numeric.toHexString(signedMessage);

        // //获取余额
        EthGetBalance ethGetBalance1 = web3j.ethGetBalance("0xb86d57174bf8c53f1084be7f565f9fd9dabd87d0", DefaultBlockParameter.valueOf("latest")).send();
        //eth默认会部18个0这里处理比较随意，大家可以随便处理哈
        BigDecimal balance = new BigDecimal(ethGetBalance1.getBalance().divide(new BigInteger("10000000000000")).toString());
        BigDecimal nbalance = balance.divide(new BigDecimal("100000"), 8, BigDecimal.ROUND_DOWN);
        System.out.println(nbalance);
    }

    /**
     * 获取钱包
     *
     * @param web3    上下文
     * @param address 地址
     * @return
     * @throws Exception
     */
    private static BigInteger getNonce(Web3j web3, String address) throws Exception {
        EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();
        return ethGetTransactionCount.getTransactionCount();
    }

    /**
     * 影响的结果就是自定义手续费会影响到账时间，手续费过低矿机会最后才处理你的！使用系统的话，手续费可能会很高，系统
     * 是获取当前最新成交的一笔手续来计算的。可能一笔需要几百人民币
     * 发送金额
     * @param nonce
     * @param toAddress
     * @return
     */
    private static RawTransaction createEtherTransaction(BigInteger nonce, String toAddress) {
        ////交易手续费由price*limit来决定，所有这两个值你可以自定义，也可以使用系统参数获取当前两个值
        BigInteger price =new BigInteger("1");
        BigInteger limit =new BigInteger("1");
        BigInteger value = Convert.toWei("数量", Convert.Unit.ETHER).toBigInteger();
        return RawTransaction.createEtherTransaction(nonce, price,limit , toAddress, value);
    }

}
