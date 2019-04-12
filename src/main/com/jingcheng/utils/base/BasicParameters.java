package jingcheng.utils.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value="基础公共参数对象",description="基础公共参数对象")
public class BasicParameters implements Serializable {

    private static final long serialVersionUID = -1L;

    //设备类型（1：Android，2：IOS，3：微信小程序）：device_type
    @ApiModelProperty(value="设备类型（1：Android，2：IOS）",name="device_type",required=true,example="1")
    private String device_type;
    //API协议版本（示例：1.0.0）：version
    @ApiModelProperty(value="API协议版本",name="version",required=true,example="1.0.0")
    private String version;
    //时间戳(格式为yyyy-MM-dd HH:mm:ss)：timestamp
    @ApiModelProperty(value="时间戳(格式为yyyy-MM-dd HH:mm:ss)",name="timestamp",required=true,example="2018-6-5 15:32:10")
    private String timestamp;
    //签名：sign   (暂传非空字符串)
    @ApiModelProperty(value="签名(暂传非空字符串)",name="sign",required=true,example="")
    private String sign;


    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "BasicParameters{" +
                "device_type='" + device_type + '\'' +
                ", version='" + version + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
