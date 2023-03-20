package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface DriverConfig extends Config {

    @Key("base.url")
    String getBaseUrl();

    @Key("device.name")
    String getDevice();

    @Key("device.version")
    String getOsVersion();

    @Key("key")
    String getKey();

    @Key("user")
    String getUser();

    @Key("app")
    String getApp();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();
}
