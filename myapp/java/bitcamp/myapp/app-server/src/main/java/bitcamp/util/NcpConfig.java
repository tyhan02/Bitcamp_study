package bitcamp.util;

public class NcpConfig   {
        private String endPoint = "https://kr.object.ncloudstorage.com";
        private String regionName = "kr-standard";
        private String accessKey = "FKkSRtwA8TohXtQhMKHD";
        private String secretKey = "2XmdALP0y7DsES8lTKwMYKcQoSlr6NuuIWXX4wOi";



    public NcpConfig(){
        System.out.println(System.getProperty("accesskey"));
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
