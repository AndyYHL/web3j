package com.hx.eplate.trafficdata.query.chain;

/**
 * Created by Administrator on 2018-03-23.
 */
public class Test {
    //运行测试
    public static void main(String[] args) throws Exception{
        BallotContract.create(getCtx("sender"),new String[]{"提案1","提案2","提案3","提案4"});
        String address001 = "voter_0x001";
        boolean result = BallotContract.getDefault(getCtx(address001)).giveVoteRight(address001);
        log("giveVoteRight result = "+result);
    }
    private static Ctx getCtx(String sender){
        return new Ctx(new Ctx.Msg(sender));
    }

    private static void log(String msg){
        System.out.println(msg);
    }
}
