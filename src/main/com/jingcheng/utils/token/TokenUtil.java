package jingcheng.utils.token;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Pattern;

public class TokenUtil {

    //定义ID位移量
    private static Integer shiftAmount = 2;
    //定义横向参数
    private static Long crossrangeAmount = 3L;
    //定义纵向参数
    private static Long portraitAmount = 21L;
    //定义前随机数位数
    private static Integer Y_Random = 4;
    //定义后随机数位数
    private static Integer Q_Random = 3;
    //117:H130NA==14P
    public static void main(String[] args) {
        Long userId = 5L;
        System.out.println(getToken(userId));
        System.out.println(JudgementToken("120:FJ19NQ==6H0"));
        /*System.out.println("原始ID加密："+getUseridOnBase(userId));
        String userID = getUseridOnBase(userId);
        System.out.println("ID解密："+getBaseOnUserid(userID));
        System.out.println("Id移位："+changeForId(userId));
        Long restoreForIdNum = changeForId(userId);
        System.out.println("Id归位："+restoreForId(restoreForIdNum));
        Long confusionOperationIdNum = restoreForId(restoreForIdNum);
        System.out.println("Id混淆："+confusionOperationId(restoreForIdNum));
        Long confusionId = confusionOperationId(restoreForIdNum);
        System.out.println("Id还原："+reductionOperationId(confusionId));
        System.out.println("Y随机数："+getYRandomString(Y_Random));
        System.out.println("Q随机数："+getQRandomString(Q_Random));
        System.out.println("token：117:VYX0NA==4T9 的用户ID是："+JudgementToken("117:VYX0NA==4T9"));
        Long begin = System.currentTimeMillis();
        for(int num = 0;num<3000000;num++){
            getToken(userId);
        }
        Long end = System.currentTimeMillis();
        Long time = end - begin;
        System.out.println("time:"+time);
        Long V = 3000000L/time;
        System.out.println("token---"+getToken(userId)+"---V:"+V*1000L);*/
    }

    //通过Id生成Token串
    public static String getToken(Long userId){
        //定义一个Buffer的Token串
        StringBuffer Token = new StringBuffer();
        //先位移
        Long restoreForIdNum = changeForId(userId);
        //再混淆
        Long confusionId = confusionOperationId(restoreForIdNum);
        Token.append(confusionId);
        //分割符
        Token.append(":");
        //加入Y随机数
        Token.append(getYRandomString(Y_Random));
        //加入用户ID
        Token.append(getUseridOnBase(userId));
        //加入Q随机数
        Token.append(getQRandomString(Q_Random));
        //返回Token
        return Token.toString();
    }

    //Id移位
    public static Long changeForId(Long userId){
        String number = userId.toString();
        String[] array = number.split("");
        StringBuffer newNumber = new StringBuffer();
        //如果满足位移量，则按照位移量位移，如果不满足，则按照最低位移量位移
        if(array.length>shiftAmount){
            for(int run=shiftAmount;run<array.length;run++){
                newNumber.append(array[run]);
            }
            for(int run=0;run<shiftAmount;run++){
                newNumber.append(array[run]);
            }
        }else{
            if(array.length>1){
                for(int run=1;run<array.length;run++){
                    newNumber.append(array[run]);
                }
                newNumber.append(array[0]);
            }else{
                newNumber.append(array[0]);
            }
        }
        Long newNumberInt = Long.valueOf(newNumber.toString());
        return newNumberInt;
    }

    //Id归位
    public static Long restoreForId(Long newUserId){ String number = newUserId.toString();
        String[] array = number.split("");
        StringBuffer newNumber = new StringBuffer();
        //如果满足位移量，则按照位移量位移，如果不满足，则按照最低位移量位移
        if(array.length>shiftAmount){
            for(int run=array.length-shiftAmount;run<array.length;run++){
                newNumber.append(array[run]);
            }
            for(int run=0;run<array.length-shiftAmount;run++){
                newNumber.append(array[run]);
            }
        }else{
            if(array.length>1){
                newNumber.append(array[array.length-1]);
                for(int run=0;run<array.length-1;run++){
                    newNumber.append(array[run]);
                }
            }else{
                newNumber.append(array[0]);
            }
        }
        Long newNumberInt = Long.valueOf(newNumber.toString());
        return newNumberInt;
    }

    //id混淆计算
    public static Long confusionOperationId(Long newId){
        //公式：aX+2ab-b = y
        return newId*crossrangeAmount+2*portraitAmount*crossrangeAmount-portraitAmount;
    }

    //id还原计算
    public static Long reductionOperationId(Long confusionId){
        //公式：(y+b-2ab)/a = x
        return (confusionId+portraitAmount-2*portraitAmount*crossrangeAmount)/crossrangeAmount;
    }

    //Y随机数，末尾为数字
    public static String getYRandomString(Integer length){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String strNext="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length-1;i++){
            int number=random.nextInt(36);
            sb.append(str.charAt(number));
        }
        int numberNext=random.nextInt(10);
        sb.append(strNext.charAt(numberNext));
        return sb.toString();
    }

    //Q随机数，第一位为数字
    public static String getQRandomString(Integer length){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String strNext="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        int numberNext=random.nextInt(10);
        sb.append(strNext.charAt(numberNext));
        for(int i=1;i<length;i++){
            int number=random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    //userId的Base64位算法
    public static String getUseridOnBase(Long userId){
        Base64.Decoder decoder = Base64.getDecoder();
        Base64.Encoder encoder = Base64.getEncoder();
        String text = userId.toString();
        String encodedText = "";
        try {
            final byte[] textByte = text.getBytes("UTF-8");
            encodedText = encoder.encodeToString(textByte);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedText;
    }

    //ID解密
    public static String getBaseOnUserid(String userId){
        Base64.Decoder decoder = Base64.getDecoder();
        String userID = "";
        try {
            userID = new String(decoder.decode(userId), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return userID;
    }

    //token校验及userID解析(防止token篡改)
    public static String JudgementToken(String token){
        //判断格式是否正确
        String pattern = ".*:.*";
        boolean isMatch = Pattern.matches(pattern, token);
        if(isMatch){ //拆分
            String[] array = token.split(":");
            //ID算法串
            String truesIDStr = array[0];
            //用户ID串
            String userIdStr = array[1];
            if(truesIDStr.equals("") || userIdStr.equals("")){
                return "error";
            }
            //算法Id还原
            Long reductionId = reductionOperationId(Long.valueOf(truesIDStr));
            //算法Id归位
            Long truesID = restoreForId(reductionId);
            //切分用户ID串
            String BaseID = userIdStr.substring(Y_Random,userIdStr.length()-Q_Random);
            String BaseIDStr = getBaseOnUserid(BaseID);
            Long userId = Long.valueOf(BaseIDStr);
            if(truesID.equals(userId)){
                return truesID.toString();
            }else{
                return "error";
            }
        }else{
            return "error";
        }
    }
}
