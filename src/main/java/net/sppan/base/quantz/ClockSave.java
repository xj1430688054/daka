package net.sppan.base.quantz;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@Service

public class ClockSave {

    Logger logger = LoggerFactory.getLogger("server");
	private String url = "https://address.yubo2.com/clock/save";
	private String charset = "utf-8";
//	private String map = "{\"speed\":-1,\"steps\":0,\"errMsg\":\"getLocation:ok\",\"provider\":\"gps\",\"buildingId\":\"\",\"longitude\":116.19233340347516,\"latitude\":39.9370797547567,\"verticalAccuracy\":10,\"floorName\":\"1000\",\"accuracy\":65,\"altitude\":72.99777317047119,\"direction\":-1,\"horizontalAccuracy\":65,\"timeLong\":20}";
//	private String openid  = "oOhAh0em_aU1EN172xVz-Cp20L9g";




	public String doPost(String openid) {
        Map<String, Double> stringStringMap = randomLonLat();
        StringBuffer strB = new StringBuffer();
        ReqDakaDto dto = new ReqDakaDto(stringStringMap.get("J"), stringStringMap.get("W"));

        //请求数据
        String map = JSON.toJSONString(dto);
        strB.append("请求数据是 ："  + map  );
        strB.append(" 请求开始时间是： " + new Date() );

        org.apache.http.client.HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            //设置参数

            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.addHeader("openid", openid);
            httpPost.addHeader("Connection", "keep-alive");
            httpPost.addHeader("session", "e3cc14686b7f4e05a6fed6cd0d746606");
            httpPost.addHeader("Host", "address.yubo2.com");
            httpPost.addHeader("Accept-Language", "zh-cn");
            
            StringEntity stringEntity = new StringEntity(map);
//            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                    strB.append("返回数据是" + result);
                    strB.append("返回时间是" + new Date() );
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            strB.append("请求失败 ， 错误信息:" + ex.getMessage());
        }
        finally {
            logger.info(strB.toString());
        }
        return result;
}

    /**
     * @Description: 在矩形内随机生成经纬度
     * @param MinLon：最小经度
     * @param MaxLon： 最大经度
     * @param MinLat：最小纬度
     * @param MaxLat：最大纬度
     * @return @throws
     */
    public static Map<String, Double> randomLonLat() {
//    public static Map<String, String> randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
       int temp =  (int) (Math.random()*(10)+1);
        double  MinLon = 0;
        double  MaxLon = 0;
        double  MinLat = 0;
        double  MaxLat = 0;
       //随机两套坐标
        if(true){
//        if(temp> 5){
              MinLon = 116.191218;
              MaxLon = 116.192452;
              MinLat = 39.936683;
              MaxLat = 39.937814;

        }else{

        }

        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(14, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(14, BigDecimal.ROUND_HALF_UP).toString();
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("J", Double.parseDouble(lon));
        map.put("W",  Double.parseDouble(lat));
        return map;
    }

	public static void main(String[] args) {
//		String doPost = new ClockSave().doPost();
//		System.out.println(doPost);
	}

}
