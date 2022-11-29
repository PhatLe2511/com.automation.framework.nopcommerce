package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"file:environmentConfig/${env}.properties"})
public interface Environment extends Config {

    @Key("firstName")
    String firstName();

    @Key("lastName")
    String lastName();

    @Key("email")
    String email();

    @Key("password")
    String password();

    @Key("url")
    String url();
}
